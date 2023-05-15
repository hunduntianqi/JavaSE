package com.$24_NetworkProgramming.TCPCommunicationExercise.$3_UploadFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client_SendFile {
    // 将本地文件上传到服务器, 接收服务器的反馈
    public static void main(String[] args) throws Exception{
        // 1. 创建Socket对象
        Socket socket = new Socket("127.0.0.1", 8080);
        // 2. 获取Socket通道字节输出流
        OutputStream socketOut = socket.getOutputStream();
        // 3. 创建字节输入流读取本地文件数据
        FileInputStream fileInput = new FileInputStream("../JavaSeNewStudy/src/com/$24_NetworkProgramming/TCPCommunicationExercise/$3_UploadFile/ClientDir/62298c217d0c91d1cecbecb0b26646c5.jpg");
        // 4. 包装字节缓冲流
        BufferedInputStream  bufferInput = new BufferedInputStream(fileInput);
        // 5. 读取文件信息并发送到服务器
        byte[] dataArray = new byte[1024];
        int len;
        while ((len = bufferInput.read(dataArray)) != -1) {
            socketOut.write(dataArray, 0, len);
        }
        socketOut.flush();
        // 6. 写出结束标记
        socket.shutdownOutput();
        // 接收服务器反馈
        // 获取Socket字节输入流对象
        InputStream socketInput = socket.getInputStream();
        // 读取服务器反馈数据
        String data = new String(socketInput.readAllBytes());
        System.out.println("服务端反馈:" + socket.getRemoteSocketAddress() + " >> " + data);
        // 7. 释放资源
        bufferInput.close();
        socket.close();
    }
}
