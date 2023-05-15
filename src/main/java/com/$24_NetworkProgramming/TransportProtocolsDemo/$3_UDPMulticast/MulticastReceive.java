package com.$24_NetworkProgramming.TransportProtocolsDemo.$3_UDPMulticast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;

public class MulticastReceive {
    // 组播模式接收端
    public static void main(String[] args) throws Exception{
        // 1. 创建接收端组播Socket对象
        MulticastSocket multicastSocket = new MulticastSocket(10086);
        // 将接收端主机加入组播地址
        InetAddress address = InetAddress.getByName("224.0.0.1");
        multicastSocket.joinGroup(address);
        // 2. 接收数据准备
        // 2.1 创建字节数组存储接收的数据
        byte[] byteArray = new byte[1024 * 8];
        // 2.2 创建接收数据数据包对象
        DatagramPacket datagramPacket = new DatagramPacket(byteArray, byteArray.length);
        // 2.3 接收数据
        multicastSocket.receive(datagramPacket);
        // 3. 接收数据处理
        // 3.1 获取接收数据字节大小
        int size = datagramPacket.getLength();
        // 3.2 接收字节数据解码
        String data = new String(byteArray, 0, size, StandardCharsets.UTF_8);
        // 3.3 获取发送端主机地址和主机名、主机端口
        InetAddress ipObject = datagramPacket.getAddress();  // 获取IP对象
        String sendAddress = ipObject.getHostAddress();  // 发送端ip地址
        String name = ipObject.getHostName(); // 发送端主机名
        int port = datagramPacket.getPort();  // 发送端端口号
        System.out.println("接收到ip为: " + sendAddress + ", 主机名为: " + name + ", 发送端口为: " + port + "的数据: " + data);
    }
}