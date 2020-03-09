package com.example.demo.socket;


import java.io.IOException;
import java.net.Socket;

/**
 * 客户端
 */
public class client {

    public static void main(String[] args) throws InterruptedException, IOException {

        int num = 1;
        int capacity = 1024 * 1024;
        byte[] bytes = new byte[capacity];
        int len;
        while (true) {
            Socket socket = new Socket("localhost", 1021);
            // FileInputStream fileInputStream = new FileInputStream("C:\\Users\\bec\\Desktop\\笔记\\DefaultListableBeanFactory.png");
            //while ((len = fileInputStream.read(bytes)) != -1) {
            socket.getOutputStream().write("出来啊，你大几看你们".getBytes());
//            }
//            fileInputStream.close();
            socket.close();
            System.out.println(num++ + "个---------------》》》》》》》》");
            Thread.sleep(500);

        }


    }


}
