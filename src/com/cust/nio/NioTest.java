package com.cust.nio;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    public static void main(String[] args) throws IOException {
        String origin="D:\\迅雷下载\\cn_office_professional_plus_2019_x86_x64_dvd_5e5be643.iso";
        String target="D:\\target.iso";

        FileInputStream fileInputStream=new FileInputStream(origin);
        FileOutputStream fileOutputStream=new FileOutputStream(target);

        //创建通道
        FileChannel iChannel=fileInputStream.getChannel();
        FileChannel oChannel=fileOutputStream.getChannel();

        //创建缓冲区
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(1024);
        long start=System.currentTimeMillis();
        while (true){
            byteBuffer.clear();
            int i=iChannel.read(byteBuffer);
            if (i==-1)
                break;
            byteBuffer.flip();

            oChannel.write(byteBuffer);
        }

        long end=System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
        fileInputStream.close();
        fileOutputStream.close();
        iChannel.close();
        oChannel.close();



    }
}
