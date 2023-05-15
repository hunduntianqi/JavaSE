package com.$22_FileAndIOStream.$3_CharStreamDemo;

/*
    字符输入流FileReader简单使用
 */

import java.io.File;
import java.io.FileReader;

public class $1_CharStreamDemo1 {
    public static void main(String[] args) throws Exception {
        // 创建文件对象
        File file = new File("D:\\Users\\Administrator\\Desktop\\新建文本文档.txt");
        // 1. 创建字符输入流对象
        FileReader fileCharInput = new FileReader(file);
        // 2. 读取文件数据
        char[] dateArray = new char[(int) file.length()];
        fileCharInput.read(dateArray);
        System.out.println(new String(dateArray));
        fileCharInput.close();
    }
}
