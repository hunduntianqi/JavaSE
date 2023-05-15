package com.$22_FileAndIOStream.$2_ByteStreamDemo;

import java.io.File;
import java.io.FileOutputStream;

/*
    字节输出流FileOutputStream简单使用
 */

public class $1_ByteStreamDemo1 {
    public static void main(String[] args) throws Exception {
        /* 实现需求: 写一段文字到本地文件中(暂时不写中文) */
        // 1. 创建文件对象
        File file = new File("./test.txt");
        file.createNewFile();  // 创建文件
        // 2. 创建FileOutputStream对象
        FileOutputStream fileOutput = new FileOutputStream(file);
        // 3. 向文件写入数据
        byte[] byteArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ\n".getBytes();
        fileOutput.write(byteArray);
        fileOutput.write("666".getBytes());
        // 4. 刷新文件, 写入数据并关闭文件
        fileOutput.flush();
        fileOutput.close();
    }
}
