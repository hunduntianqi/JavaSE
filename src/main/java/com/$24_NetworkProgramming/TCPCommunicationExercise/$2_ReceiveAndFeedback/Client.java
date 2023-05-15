package com.$24_NetworkProgramming.TCPCommunicationExercise.$2_ReceiveAndFeedback;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    // 客户端
    // 1. 发送数据
    // 2. 接收服务器反馈
    public static void main(String[] args) throws Exception {
        System.out.println("====客户端启动====");
        // 1. 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        // 2. 创建Socket对象
        Socket socket = new Socket("127.0.0.1", 8080);
        // 3. 获取Socket通道字节输出流包装打印流
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        // 4. 准备发送数据
        System.out.print("请输入: ");
        String msg = sc.nextLine();
        printStream.println(msg);
        printStream.flush();
        socket.shutdownOutput();
        // 5. 获取Socket通道字节输入流包装字符缓冲流
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 6. 读取服务端反馈数据
        String msgServer;
        while ((msgServer = bufReader.readLine()) != null) {
            System.out.println("服务端: " + msgServer);
        }
        // 7. 释放资源
        socket.close();
    }

}
