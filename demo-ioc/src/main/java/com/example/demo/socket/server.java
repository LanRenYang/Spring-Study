package com.example.demo.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 服务端
 */
public class server {


    static int capacity = 1024 * 1024;


    public static void main(String[] args) throws IOException {


        int i = 1;
        ServerSocket serverSocket = new ServerSocket(1021);
        while (true) {
            socketHandle(serverSocket.accept());
            //serverSocket.close();

        }

//        while (true) {
//            Util.threadPoolExecutor.execute(() -> {
//                try {
//                    socketHandle(serverSocket.accept());
//                    //serverSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//        }



    }


    public static void socketHandle(Socket socket) throws IOException {
        int len;
        byte[] bytes = new byte[capacity];
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\bec\\Desktop\\data\\" + Util.getFileName() + ".png");
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        fileOutputStream.close();
        inputStream.close();
        socket.close();
    }


}
