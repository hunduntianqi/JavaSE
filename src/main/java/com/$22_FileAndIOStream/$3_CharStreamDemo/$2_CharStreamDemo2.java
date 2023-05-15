package com.$22_FileAndIOStream.$3_CharStreamDemo;

/*
    字符输出流FileWriter简单使用
 */

import java.io.FileWriter;

public class $2_CharStreamDemo2 {
    public static void main(String[] args) throws Exception {
        // 1. 创建字符输出流对象
        FileWriter fileWriter = new FileWriter("./test.txt");
        // 2. 写数据到文件中
        fileWriter.write("这是一个测试字符输出流的小文件！！");
        // 3. 关闭字符输出流对象
        fileWriter.close();
    }
}
