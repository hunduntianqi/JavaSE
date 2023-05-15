package com.$24_NetworkProgramming.TransportProtocolsDemo.$4_TCPDemo;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClient {
    // TCP协议, 发送数据
    public static void main(String[] args) throws Exception {
        // 1. 创建Socket对象
        // 细节: 在创建对象时会连接服务端, 连接失败会报错
        Socket socket = new Socket("127.0.0.1", 10086);
        // 2. 从连接通道中获取输出流对象
        OutputStream outputStream = socket.getOutputStream();
        // 3. 使用字节输出流对象写出数据
        outputStream.write("你好, 我是TCP测试程序的发送端".getBytes(StandardCharsets.UTF_8));
        // 4. 释放资源
        outputStream.close();
        socket.close();
    }
}
