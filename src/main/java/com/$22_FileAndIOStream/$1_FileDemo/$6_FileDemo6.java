package com.$22_FileAndIOStream.$1_FileDemo;

/*
    需求:
        统计一个文件夹中每种文件的个数并打印
 */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class $6_FileDemo6 {
    public static void main(String[] args) {
        // 创建HashMap集合, 统计各类型文件数量, 键为后缀名, 值为文件个数
        HashMap<String, Integer> fileTypeCount = new HashMap<>();
        // 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入目标文件夹路径: ");
        String filePath = sc.next();
        // 创建文件对象
        File sourceFile = new File(filePath);
        ArrayList<File> fileList = getAllFile(sourceFile);
        for (File file : fileList) {
            System.out.println(file.getName());
            // 拆分文件名为数组, 获取后缀名
            String[] strArray = file.getName().split("\\.");
            if (strArray.length >= 2) {
                String fileType = strArray[strArray.length - 1];
                // 判断改后缀名是否在HashMap集合作为键存在
                if (fileTypeCount.containsKey(fileType)) {
                    // 文件类型已存在, 则对应文件数值加1
                    // 先获取改文件类型原来的文件数量
                    Integer count = fileTypeCount.get(fileType);
                    // 将已有文件类型对应数值加一
                    count++;
                    fileTypeCount.put(fileType, count);
                } else {
                    // 改文件类型在HashMap集合作为键不存在, 将其加入集合, 数值初始为一
                    fileTypeCount.put(fileType, 1);
                }
            }
        }
        // 数据统计完毕, 打印HashMap集合
        System.out.println(fileTypeCount);
    }

    // 定义方法, 获取所有文件对象数组
    public static ArrayList<File> getAllFile(File sourceFile) {
        // 1. 定义集合存储所有文件对象
        ArrayList<File> fileList = new ArrayList<>();
        // 2. 获取源文件夹下所有文件对象数组
        File[] fileArray = sourceFile.listFiles();
        if (fileArray != null && fileArray.length != 0) {
            for (File file : fileArray) {
                if (file.isFile()) {
                    fileList.add(file);
                } else {
                    fileList.addAll(getAllFile(file));
                }
            }
        }
        return fileList;
    }
}
