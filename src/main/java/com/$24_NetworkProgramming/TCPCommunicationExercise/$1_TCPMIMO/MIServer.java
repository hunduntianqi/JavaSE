package com.$24_NetworkProgramming.TCPCommunicationExercise.$1_TCPMIMO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MIServer {
    // 服务端, 多次接收信息并打印
    public static void main(String[] args) throws Exception{
        System.out.println("====服务端启动====");
        // 创建ServerSocket对象
        ServerSocket server = new ServerSocket(8080);
        // 监听客户端连接, 获取客户端Socket对象
        Socket client = server.accept();
        System.out.println("接收到客户端连接 ==> " + client.getRemoteSocketAddress().toString());
        // 获取Socket通道字节输入流包装缓冲字符输入流
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        // 按行读取信息
        String msg;
        while ((msg = bufReader.readLine()) != null) {
            System.out.println(client.getRemoteSocketAddress().toString() + ": " + msg);
        }
        server.close();
    }
}
