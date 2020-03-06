package com.example.demo.socket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("C:\\Users\\bec\\Desktop\\aaa.txt");
        FileOutputStream out = new FileOutputStream("C:\\Users\\bec\\Desktop\\bbb.txt");

        byte[] bytes = new byte[1024];
        int len ;
        while ((len = in.read(bytes)) != -1) {
            out.write(bytes,0,len);
        }
        out.close();
        in.close();
    }
}
