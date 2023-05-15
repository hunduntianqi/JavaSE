package com.$24_NetworkProgramming.TransportProtocolsDemo.$2_UDPChatRoom;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatRoomSend {
    // UDP协议聊天室发送端
    public static void main(String[] args) throws Exception{
        // 1. 创建发送端Socket对象
        DatagramSocket send = new DatagramSocket();
        // 2. 创建Scanner对象, 用来接收键盘录入数据
        Scanner sc = new Scanner(System.in);
        // 3. 死循环实现不断发送数据
        while (true) {
            System.out.println("准备发送数据...");
            // 4. 包装数据
            // 4.1 准备数据
            String data = sc.nextLine();
            // 4.2 创建用来发送数据的字节数组
            byte[] byteArray = data.getBytes(StandardCharsets.UTF_8);
            // 定义接收端地址
            InetAddress address = InetAddress.getByName("127.0.0.1");
            // 定义接收端端口号
            int port = 10086;
            // 4.3 创建发送数据包对象
            DatagramPacket datagramPacket = new DatagramPacket(byteArray, byteArray.length, address, port);
            // 5. 发送数据
            send.send(datagramPacket);
            // 6. 判断循环结束条件
            if (data.equals("quit")) {
                System.out.println("发送端关闭, 再见...");
                break;
            }
//            // 创建字节数组, 存储接收端回复的数据
//            byte[] receiveArray = new byte[1024 * 8];
//            // 创建接收数据的数据包对象
//            DatagramPacket receiveDataPackage = new DatagramPacket(receiveArray, receiveArray.length);
//            // 接收接收端回复的数据
//            send.receive(receiveDataPackage);
//            // 获取接收数据的字节大小
//            int size = receiveDataPackage.getLength();
//            // 接收数据解码
//            String receiveData = new String(receiveArray, 0, size, StandardCharsets.UTF_8);
//            System.out.println("接收到发送端: " + address.toString() + ": " + port + " 端口发送的数据:\n" + receiveData);
        }
        // 释放资源
        send.close();
    }
}
