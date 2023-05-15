package com.$22_FileAndIOStream.$2_ByteStreamDemo;

import java.io.File;
import java.io.FileInputStream;

/*
    字节输入流FileInputStream简单使用
 */

public class $2_ByteStreamDemo2 {
    public static void main(String[] args) throws Exception {
        // 1. 定义读取文件路径, 创建文件对象
        String path = "D:\\Users\\Administrator\\Desktop\\新建文本文档.txt";
        File file = new File(path);
        // 2. 创建字节输入流对象
        FileInputStream fileInput = new FileInputStream(file);
        // 3. 读取文件数据
        byte[] readData = fileInput.readAllBytes();
        System.out.println(new String(readData));
        // 4. 释放资源
        fileInput.close();
    }
}
