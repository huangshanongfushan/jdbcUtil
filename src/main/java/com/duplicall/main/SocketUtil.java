package com.duplicall.main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by raymond on 2016/2/14.
 */
public class SocketUtil {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket client = null;
            System.out.println("启动.....");
            while (true) {
                client = serverSocket.accept();
                System.out.println("接受一个请求，访问页面....");
                PrintStream ps = new PrintStream(client.getOutputStream(),true,"utf-8");

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("d:\\hello.html"),"utf-8"));
                String html = "";
                while (html != null) {
                    html = br.readLine();
                    if (html != null) {
                        ps.println(html);
                    }
                }
                ps.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
