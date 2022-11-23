package com.atguigu.demo;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputStream5 {

    public static void main(String[] args) {
        try {
            //绝对路径
            InputStream is = Files.newInputStream(Paths.get("C:\\testsucai\\test1.txt"));

            Scanner scanner = new Scanner(is);



            while (scanner.hasNext()){


                String s = scanner.next();

                System.out.println("--");

                System.out.println(s);

                System.out.println("--");
            }

//            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

