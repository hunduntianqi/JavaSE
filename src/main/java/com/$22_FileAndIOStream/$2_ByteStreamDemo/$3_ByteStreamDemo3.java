package com.$22_FileAndIOStream.$2_ByteStreamDemo;

/*
    文件拷贝
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class $3_ByteStreamDemo3 {
    public static void main(String[] args) throws Exception {
        // 1. 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        // 2. 定义源文件夹路径
        System.out.println("请输入源文件路径:");
        String sourcePath = sc.next();
        // 3. 定义目标文件夹路径
        System.out.println("请输入目标文件夹路径: ");
        String resultPath = sc.next();
        // 4. 创建源文件对象
        File fileSource = new File(sourcePath);
        // 5. 创建目标文件夹对象并创建目标文件夹
        File fileResult = new File(resultPath);
        try {
            fileResult.mkdirs();
        } catch (Exception e) {
            System.out.println("文件夹已存在！！");
        }
        if (fileSource.isDirectory()) {
            // 6. 获取原文件件所有文件对象数组
            File[] fileSourceArray = fileSource.listFiles();
            // 7. 遍历文件数组
            for (File file : fileSourceArray) {
                // 获取文件名
                String fileName = file.getName();
                // 创建字节输入流对象
                FileInputStream fileInputStream = new FileInputStream(file);
                // 读取文件数据到字节数组
                byte[] byteDateArray = fileInputStream.readAllBytes();
                // 关闭字节输入流对象
                fileInputStream.close();
                // 拼接拷贝文件路径
                String resultFilePath = resultPath + "\\" + fileName;
                // 创建字节输出流对象
                FileOutputStream fileOutputStream = new FileOutputStream(resultFilePath);
                // 写数据到目标文件
                fileOutputStream.write(byteDateArray);
                // 刷新并关闭文件
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } else {
            // 获取源文件名
            String fileName = fileSource.getName();
            // 拼接复制后文件路径
            String fileResultPath = resultPath + "\\[备份]" + fileName;
            // 创建字节输入流对象
            FileInputStream fileInputStream = new FileInputStream(fileSource);
            // 读取文件数据
            byte[] sourceDate = fileInputStream.readAllBytes();
            // 关闭字节输入流
            fileInputStream.close();
            // 创建字节输出流对象
            FileOutputStream fileOutputStream = new FileOutputStream(fileResultPath);
            // 向目标文件写入数据
            fileOutputStream.write(sourceDate);
            // 关闭字节输出流
            fileOutputStream.close();
        }
    }
}
