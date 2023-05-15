package com.$24_NetworkProgramming.TransportProtocolsDemo.$3_UDPMulticast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;

public class MulticastSend {
    // 组播模式发送端
    public static void main(String[] args) throws Exception {
        // 1. 创建发送端组播Socket对象
        MulticastSocket multicastSocket = new MulticastSocket();
        // 2. 包装发送数据
        // 2.1 准备数据
        String data = "这是一个组播发送程序, 这一段文字是测试数据";
        // 2.2 创建字节数组
        byte[] byteArray = data.getBytes(StandardCharsets.UTF_8);
        // 2.3 指定组播发送地址
        InetAddress address = InetAddress.getByName("224.0.0.1");
        // 2.4 指定组播接收端口
        int port = 10086;
        // 2.5 创建发送端数据包对象
        DatagramPacket datagramPacket = new DatagramPacket(byteArray, byteArray.length, address, port);
        // 3. 发送数据
        multicastSocket.send(datagramPacket);
        // 4. 释放资源
        multicastSocket.close();
    }
}
