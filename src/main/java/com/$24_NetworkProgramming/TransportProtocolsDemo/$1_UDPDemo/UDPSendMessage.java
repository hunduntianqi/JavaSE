package com.$24_NetworkProgramming.TransportProtocolsDemo.$1_UDPDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPSendMessage {
    // UDP传输协议发送数据
    public static void main(String[] args) throws Exception {
        // 发送数据
        // 1. 创建发送端对象
        DatagramSocket datagramSocket = new DatagramSocket();
        // 2. 打包数据
        // 2.1 准备数据
        String str = "你好啊";
        // 2.2 字符串转换为字节数组
        byte[] bArray = str.getBytes(StandardCharsets.UTF_8);
        // 2.3 指定接收端IP地址
        InetAddress address = InetAddress.getByName("127.0.0.1");
        // 2.4 指定接收端口
        int port = 10086;
        // 2.5 创建发送端数据包对象
        DatagramPacket datagramPacket = new DatagramPacket(bArray, bArray.length, address, port);
        // 3. 发送数据
        System.out.println("开始发送数据...");
        datagramSocket.send(datagramPacket);
        // 4. 释放资源
        datagramSocket.close();
    }
}
