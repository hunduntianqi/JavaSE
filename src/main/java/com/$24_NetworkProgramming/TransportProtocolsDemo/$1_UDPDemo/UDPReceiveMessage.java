package com.$24_NetworkProgramming.TransportProtocolsDemo.$1_UDPDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class UDPReceiveMessage {
    // UDP传输协议接收数据
    public static void main(String[] args) throws Exception{
        // 1. 创建接收端对象
        // 1.1 指定接收端端口, 与发送端发送数据包指定的端口一致
        int port = 10086;
        // 1.2 创建对象
        DatagramSocket datagramSocket = new DatagramSocket(port);
        // 2. 创建接收端数据包对象
        // 2.1 准备接收数据的字节数组
        byte[] bArray = new byte[1024];
        // 2.2 创建数据包对象
        DatagramPacket datagramPacket = new DatagramPacket(bArray, bArray.length);
        // 3. 接收数据
        System.out.println("等待接收数据...");
        datagramSocket.receive(datagramPacket);
        // 4. 打印接收到的数据
        System.out.printf("接收到的数据字节大小为: %s, 接受到的数据内容为: '%s'\n", datagramPacket.getLength(), new String(bArray, 0, datagramPacket.getLength(), StandardCharsets.UTF_8));
        // 获取发送端ip
        System.out.println("发送端ip地址为: " + datagramPacket.getAddress().toString());
        // 获取发送端端口号
        System.out.println("发送端端口号为: " + datagramPacket.getPort());
        // 5. 释放资源
        datagramSocket.close();
    }
}
