package com.$24_NetworkProgramming.TCPCommunicationExercise.$3_UploadFile;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class SaveFileThread implements Runnable {
    // 1. 定义Socket类型成员变量
    public Socket client;

    // 2. 定义带参数构造器
    public SaveFileThread(Socket client) {
        this.client = client;
    }

    // 3. 定义无参构造
    public SaveFileThread() {
    }

    @Override
    public void run() {
        try {
            // 3. 获取Socket通道字节输入流对象
            InputStream input = this.client.getInputStream();
            // 包装字节输入缓冲流
            BufferedInputStream bufInput = new BufferedInputStream(input);
            // 4. 创建字节输出流管道与本地文件相通
            // 使用UUID类, 保证文件名不重复
            String fileName = UUID.randomUUID().toString().replace("-", "");
            FileOutputStream fileOut = new FileOutputStream("../JavaSeNewStudy/src/com/$24_NetworkProgramming/TCPCommunicationExercise/$3_UploadFile/ServerDir/" + fileName + ".jpg");
            // 包装缓冲流
            BufferedOutputStream bufOutput = new BufferedOutputStream(fileOut);
            // 读取客户端文件数据
            byte[] dataArray = new byte[1024];
            int len;
            while ((len = bufInput.read(dataArray)) != -1) {
                fileOut.write(dataArray, 0, len);
            }
            fileOut.flush();
            // 反馈客户端
            // 获取Socket字节输出流对象
            OutputStream outputStream = this.client.getOutputStream();
            // 包装打印流
            PrintStream printStream = new PrintStream(outputStream);
            // 向客户端发送数据
            printStream.println("已收到文件并保存！！");
            // 5. 释放资源
            bufOutput.close();
            this.client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
