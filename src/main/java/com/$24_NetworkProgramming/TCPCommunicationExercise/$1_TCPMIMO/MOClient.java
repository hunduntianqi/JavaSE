package com.$24_NetworkProgramming.TCPCommunicationExercise.$1_TCPMIMO;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MOClient {
    // 客户端多次发送信息
    public static void main(String[] args) throws Exception {
        System.out.println("====客户端启动====");
        // 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        // 创建Socket对象
        Socket client = new Socket("127.0.0.1", 8080);
        // 获取Socket通道的字节输出流
        OutputStream output = client.getOutputStream();
        // 包装打印流
        PrintStream printStream = new PrintStream(output);
        // 循环保证多次发送数据
        while (true) {
            System.out.print("请输入你要发送的信息: ");
            String data = sc.nextLine();
            // 判断是否退出客户端
            if (data.equals("exit")) {
                System.out.println("客户端关闭...");
                client.close();
                break;
            }
            // 发送数据到服务端
            printStream.println(data);
            printStream.flush();
        }
    }
}
