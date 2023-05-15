package com.$24_NetworkProgramming.TransportProtocolsDemo.$2_UDPChatRoom;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatRoomReceive {
    // UDP聊天室接收端
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动...");
        // 创建接收端Socket对象
        DatagramSocket receive = new DatagramSocket(10086);
        // 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        // 死循环保证不断接收数据
        while(true) {
//            System.out.println("等待接收数据...");
            // 创建接收数据的字节数组
            byte[] byteArray = new byte[1024 * 8];
            // 创建接收数据的数据包对象
            DatagramPacket datagramPacket = new DatagramPacket(byteArray, byteArray.length);
            // 接收发送端数据
            receive.receive(datagramPacket);
            // 获取接收数据的字节大小
            int size = datagramPacket.getLength();
            // 获取发送端ip
            InetAddress ipSend = datagramPacket.getAddress();
            // 获取发送端端口号
            int port = datagramPacket.getPort();
            // 接收数据解码
            String data = new String(byteArray, 0, size, StandardCharsets.UTF_8);
            System.out.println("接收到发送端: " + ipSend.toString() + ": " + port + " 端口发送的数据:" + data);
//            if (data.equals("quit")) {
//                System.out.println("发送端已关闭, 结束聊天...");
//                break;
//            }
//            // 准备向发送端回复的数据
//            String dataReceive = sc.nextLine();
//            // 创建对应字节数组
//            byte[] receiveArray = dataReceive.getBytes(StandardCharsets.UTF_8);
//            // 创建数据包对象
//            DatagramPacket receiveData = new DatagramPacket(receiveArray, receiveArray.length, ipSend, port);
//            receive.send(receiveData);
        }
        // 释放资源
//        receive.close();
    }
}
