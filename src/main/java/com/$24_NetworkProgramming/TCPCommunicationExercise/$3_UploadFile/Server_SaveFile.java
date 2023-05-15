package com.$24_NetworkProgramming.TCPCommunicationExercise.$3_UploadFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server_SaveFile {
    // 接受客户端上传的文件, 上传完毕后给出反馈
    public static void main(String[] args) throws Exception{
        // 1. 创建ServerSocket对象
        ServerSocket server = new ServerSocket(8080);
        // 2. 监听客户端连接, 获取Socket对象
        Socket client = server.accept();
        // 3. 获取Socket通道字节输入流对象
        InputStream input = client.getInputStream();
        // 包装字节输入缓冲流
        BufferedInputStream bufInput = new BufferedInputStream(input);
        // 4. 创建字节输出流管道与本地文件相通
        // 使用UUID类, 保证文件名不重复
        String fileName = UUID.randomUUID().toString().replace("-", "");
        FileOutputStream fileOut = new FileOutputStream("../JavaSeNewStudy/src/com/$24_NetworkProgramming/TCPCommunicationExercise/$3_UploadFile/ServerDir/" + fileName +".jpg");
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
        OutputStream outputStream = client.getOutputStream();
        // 包装打印流
        PrintStream printStream = new PrintStream(outputStream);
        // 向客户端发送数据
        printStream.println("已收到文件并保存！！");
        // 5. 释放资源
        bufOutput.close();
        client.close();
        server.close();
    }
}
