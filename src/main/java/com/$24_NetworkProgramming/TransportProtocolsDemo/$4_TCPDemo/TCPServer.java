package com.$24_NetworkProgramming.TransportProtocolsDemo.$4_TCPDemo;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServer {
    // TCP协议, 接收数据
    public static void main(String[] args) throws Exception{
        // 1. 创建ServerSocket对象, 并指定端口, 端口要与发送端保持一致
        ServerSocket socket = new ServerSocket(10086);
        // 2. 监听客户端连接, 获取客户端Socket对象, 会阻塞程序执行, 直到有客户端与之连接
        Socket clientSocket = socket.accept();
        // 3. 获取字节输入流对象, 读取数据
        InputStream inputStream = clientSocket.getInputStream();
        String data = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        System.out.println("客户端发送的数据为: " + data);
        // 4. 释放资源
        inputStream.close();
        clientSocket.close();
        socket.close();
    }
}
