package com.$22_FileAndIOStream.$7_ZipCompressiveDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
    需求:
        将文件夹压缩成一个压缩包
    注意:
        ZipEntry(path) ==> path表示压缩包中文件和文件夹的子级路径
 */
public class $3_ZipFolder {
    public static void main(String[] args) throws Exception {
        // 创建Scanner对象, 输入源文件 / 文件夹路径
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要压缩文件夹的路径: ");
        String path = sc.next();
        // 1. 创建文件对象表示要压缩的文件夹
        File fileFolder = new File(path);
        // 2. 创建文件对象表示压缩包放在哪里
        File zipParent = fileFolder.getParentFile(); // 获取要压缩文件夹的父级文件夹对象
        // 3. 创建文件对象表示压缩包路径
        File fileZip = new File(zipParent, fileFolder.getName() + ".zip");
        // 4. 创建压缩流, 关联压缩包
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(fileZip));
        // 5. 获取要压缩的压缩包中的每一个文件对象, 变成ZipEntry对象, 放入到压缩包中
        ArrayList<File> fileList = getAllFile(fileFolder);
        for (File file : fileList) {
            try {
                if (file.isFile()) {
                    // 5.1 创建与文件对象名相同的ZipEntry对象, 并放入压缩包中
                    String pathZip = fileFolder.getName() + file.getAbsolutePath().split(fileFolder.getName())[1];
                    System.out.println(pathZip);
                    ZipEntry zipEntry = new ZipEntry(pathZip);
                    zipOutputStream.putNextEntry(zipEntry);
                    // 5.2 创建字节输入流, 将源文件数据写入压缩包
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bytesArray = fileInputStream.readAllBytes();
                    zipOutputStream.write(bytesArray);
                    zipOutputStream.closeEntry();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 6. 释放资源
        zipOutputStream.close();
    }

    // 定义方法, 获取目标文件夹中的每一个文件对象
    public static ArrayList<File> getAllFile(File sourceFolder) {
        // 1. 创建集合对象, 存放文件对象
        ArrayList<File> fileList = new ArrayList<>();
        // 2. 获取源文件夹下所有文件的文件对象数组
        File[] fileArray = sourceFolder.listFiles();
        // 3. 循环判断文件对象时文件夹还是文件
        for (File file : fileArray) {
            if (file != null && file.isFile()) {
                fileList.add(file);
            } else if (file != null && file.isDirectory()) {
                ArrayList<File> list = getAllFile(file);
                fileList.addAll(list);
            }
        }
        return fileList;
    }
}
