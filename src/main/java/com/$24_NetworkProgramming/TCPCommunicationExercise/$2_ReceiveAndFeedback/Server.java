package com.$24_NetworkProgramming.TCPCommunicationExercise.$2_ReceiveAndFeedback;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // 服务端
    // 1. 接收客户端数据
    // 2. 给客户端作出反馈
    public static void main(String[] args) throws Exception{
        System.out.println("====服务端启动====");
        // 1. 创建ServerSocket对象
        ServerSocket server = new ServerSocket(8080);
        // 2. 监听客户端连接, 获取客户端Socket对象
        Socket client = server.accept();
        System.out.println("接收到客户端连接 ==> " + client.getRemoteSocketAddress().toString());
        // 3. 获取Socket通道字节输入流包装字符缓冲流
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        // 4. 读取客户端数据
        String msg;
        while ((msg = bufReader.readLine()) != null) {
            System.out.println(client.getRemoteSocketAddress().toString() + ": " + msg);
        }
        // 5. 获取Socket通道字节输出流包装打印流
        PrintStream printStream = new PrintStream(client.getOutputStream());
        // 6. 写出数据, 反馈客户端
        printStream.println("已收到您的信息...");
        printStream.flush();
        // 7. 释放资源
        client.close();
        server.close();
    }
}
