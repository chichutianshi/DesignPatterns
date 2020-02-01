package com.cust.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Calendar;
import java.util.Iterator;

public class Service {

    public static void main(String[] args) throws IOException {
        //服务器初始化
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost",9999));
        Selector selector=Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端开启了");
        System.out.println("=========================================================");
        Calendar ca=Calendar.getInstance();
        while (true){
            selector.select();
            Iterator<SelectionKey> selectionKeyIterator=selector.selectedKeys().iterator();
            while (selectionKeyIterator.hasNext()){
                SelectionKey selectionKey=selectionKeyIterator.next();
                selectionKeyIterator.remove();

                if (selectionKey.isAcceptable()){
                    SocketChannel socketChannel=serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                    String message = "连接成功 你是第" + (selector.keys().size() - 1) + "个用户";
                    //向客户端发信息
                    socketChannel.write(ByteBuffer.wrap(message.getBytes()));
                    InetSocketAddress inetSocketAddress= (InetSocketAddress) socketChannel.getRemoteAddress();
                    //输出客户端地址
                    System.out.println(ca.getTime() + "\t" + inetSocketAddress.getHostString() +
                            ":" + inetSocketAddress.getPort() + "\t");
                    System.out.println("客戶端已连接");
                    System.out.println("=========================================================");
                }

                if (selectionKey.isReadable()){
                    SocketChannel socketChannel= (SocketChannel) selectionKey.channel();
                    InetSocketAddress inetSocketAddress= (InetSocketAddress) socketChannel.getRemoteAddress();
                    System.out.println(ca.getTime() + "\t" + inetSocketAddress.getHostString() +
                            ":" + inetSocketAddress.getPort() + "\t");

                    ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
                    //byte[] res = new byte[1024];
                    int len=0;
                    try {
                    while ((len=socketChannel.read(byteBuffer))!=0){
                        byteBuffer.flip();
                        //byteBuffer.get(res,0,len);
                        //System.out.println(new String(res, 0, len));
                        System.out.println(new String(byteBuffer.array(),0,len));
                        byteBuffer.clear();
                    }
                    }catch (IOException e){
                        //客户端关闭了
                        selectionKey.cancel();
                        socketChannel.close();
                        System.out.println("客戶端已断开");
                        System.out.println("=========================================================");
                    }
                }
            }
        }
    }
}
