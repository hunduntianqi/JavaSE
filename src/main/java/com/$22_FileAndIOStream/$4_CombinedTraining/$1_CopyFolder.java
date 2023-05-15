package com.$22_FileAndIOStream.$4_CombinedTraining;

/*
    综合训练一:
        拷贝文件夹, 需要考虑子文件夹
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class $1_CopyFolder {
    public static void main(String[] args) throws Exception {
        // 记录程序开始事件毫秒值
        long startTime = System.currentTimeMillis();
        // 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        // 定义变量存储源文件夹路径
        System.out.println("请输入源文件夹路径:");
        String sourcePath = sc.next();
        // 定义变量存储目标文件夹路径
        System.out.println("请输入目标文件夹路径:");
        String resultPath = sc.next();
        // 创建目标文件夹
        File resultFolder = new File(resultPath);
        resultFolder.mkdirs();
        // 调用方法, 获取源文件夹下所有文件对象
        ArrayList<File> fileList = getFile(sourcePath);
        // 遍历源文件夹
        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
            // 调用方法, 复制文件
            copyFile(file, sourcePath, resultPath);
        }
        // 记录程序结束事件毫秒值
        long endTime = System.currentTimeMillis();
        System.out.println("复制文件共用时: " + (endTime - startTime) / 1000.0 + "s");
    }

    // 定义方法, 获取源文件夹中所有文件对象
    public static ArrayList<File> getFile(String sourcePath) {
        // 创建集合, 存储文件对象
        ArrayList<File> fileList = new ArrayList<>();
        // 创建目标源文件夹对象
        File sourceFile = new File(sourcePath);
        // 获取源文件夹下所有文件对象数组
        File[] fileArray = sourceFile.listFiles();
        if (fileArray != null && fileArray.length != 0) {
            // 遍历数组, 获取所有文件对象
            for (File file : fileArray) {
                if (file.isFile()) {
                    fileList.add(file);
                } else {
                    fileList.add(file);
                    ArrayList<File> childFileList = getFile(file.getAbsolutePath());
                    fileList.addAll(childFileList);
                }
            }
        }
        return fileList;
    }

    // 定义方法, 复制文件
    public static void copyFile(File file, String sourcePath, String resultPath) throws Exception {
        if (file != null) {
            // 判断文件对象是文件夹还是文件
            if (file.isFile()) {
                // 文件对象是文件
                // 创建字节输入流, 读取文件所有数据
                FileInputStream fileInputStream = new FileInputStream(file);
                // 读取文件所有字节到字节数组
                byte[] fileData = fileInputStream.readAllBytes();
                // 关闭字节输入流
                fileInputStream.close();
                // 获取文件绝对路径
                String fileSourcePath = file.getAbsolutePath();
                // 将文件路径的源文件夹路径替换为目标文件夹路径
                String fileResultPath = fileSourcePath.replace(sourcePath, resultPath);
                // 创建字节输出流对象
                FileOutputStream fileOutputStream = new FileOutputStream(fileResultPath);
                // 向文件写入数据
                fileOutputStream.write(fileData);
                // 刷新文件并关闭文件
                fileOutputStream.flush();
                fileOutputStream.close();
            } else {
                // 文件对象是文件夹
                // 获取文件绝对路径
                String fileSourcePath = file.getAbsolutePath();
                // 将文件路径的源文件夹路径替换为目标文件夹路径
                String fileResultPath = fileSourcePath.replace(sourcePath, resultPath);
                // 根据替换后的路径创建文件夹对象并创建文件夹
                File fileFolder = new File(fileResultPath);
                fileFolder.mkdirs();
            }
        }
    }
}
