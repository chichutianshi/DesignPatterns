package com.cust.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Client {

    public static void main(String[] args) {
        try {
            //初始化客户端
            SocketChannel socketChannel=SocketChannel.open();
            socketChannel.configureBlocking(false);//设置为非阻塞
            Selector selector=Selector.open();
            //注册链接事件
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            //发起连接
            socketChannel.connect(new InetSocketAddress("localhost",9999));
            new ChatThread(selector,socketChannel).start();
            //处理准备就绪的事件

            while (true){
                if (socketChannel.isOpen()){
                    selector.select();//在注册的键中选择已准备就绪的事件
                    //已选择键集
                    Set<SelectionKey> keys=selector.selectedKeys();
                    Iterator<SelectionKey> iterator=keys.iterator();
                    //遍历信息
                    while (iterator.hasNext()){//hashNext 移动position
                        SelectionKey selectionKey=iterator.next();
                        iterator.remove();//删除当前键，避免重复消费

                        //链接
                        if (selectionKey.isConnectable()){
                            while (!socketChannel.finishConnect())
                                System.out.println("链接中");
                            socketChannel.register(selector,SelectionKey.OP_READ);//改为读模式
                        }

                        //监听到控制台有输入
                        if (selectionKey.isWritable()){
                            socketChannel.write((ByteBuffer)selectionKey.attachment());


                            socketChannel.register(selector,SelectionKey.OP_READ);
                        }

                        //接受服务器信息
                        if (selectionKey.isReadable()){
                            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
                            int len=0;
                            try {
                                if ((len = socketChannel.read(byteBuffer)) > 0) {
                                    System.out.println("服务器信息：  " + new String(byteBuffer.array(), 0, len));
                                }
                                System.out.println("=========================================================");
                            }catch (Exception e){
                                System.out.println("服务器异常，请联系客服人员!正在关闭客户端.........");
                                selectionKey.cancel();
                                socketChannel.close();
                            }
                        }
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

class ChatThread extends Thread{
    private Selector selector;
    private SocketChannel socketChannel;

    public ChatThread(Selector selector, SocketChannel socketChannel) {
        this.selector = selector;
        this.socketChannel = socketChannel;
    }

    public void run(){
        try {
            //等待连接建立
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您要发送给服务端的消息");
        System.out.println("=========================================================");
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            try {
                socketChannel.register(selector,SelectionKey.OP_WRITE,ByteBuffer.wrap(s.getBytes()));
                selector.wakeup();//唤醒之前因为监听OP_READ而阻塞的select()
            } catch (ClosedChannelException e) {
                e.printStackTrace();
            }

        }
    }

}
