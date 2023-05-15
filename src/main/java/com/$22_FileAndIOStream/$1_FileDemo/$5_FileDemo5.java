package com.$22_FileAndIOStream.$1_FileDemo;

/*
    需求:
        获取目标文件夹中所有数据的总大小, 需要考虑多级文件夹
 */

import java.io.File;
import java.util.Scanner;

public class $5_FileDemo5 {
    public static void main(String[] args) {
        // 1. 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入目标文件夹路径: ");
        String path = sc.next();
        File file = new File(path);
        long fileSize = fileSize(file);
        System.out.println("文件夹" + file.getName() + "的总大小为: " + fileSize + "字节");
    }

    public static long fileSize(File sourceFile) {
        // 1. 定义变量, 记录文件夹数据的大小
        long fileSize = 0L;
        // 2. 获取文件夹对象中所有文件对象的数组
        File[] fileArray = sourceFile.listFiles();
        if (fileArray != null && fileArray.length != 0) {
            for (File file : fileArray) {
                if (file.isFile()) {
                    fileSize += file.length();
                } else {
                    fileSize += fileSize(file);
                }
            }
        }
        return fileSize;
    }
}
