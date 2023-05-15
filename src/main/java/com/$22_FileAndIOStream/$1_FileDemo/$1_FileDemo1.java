package com.$22_FileAndIOStream.$1_FileDemo;

/*
    需求:
        创建一个.txt的文件
 */

import java.io.File;

public class $1_FileDemo1 {
    public static void main(String[] args) throws Exception {
        // 1. 创建文件对象
        File file = new File("D:\\Users\\Administrator\\Desktop\\javaTest.txt");
        // 2. 创建文件
        boolean result = file.createNewFile();
        System.out.println("创建文件的结果是: " + result);
    }
}
