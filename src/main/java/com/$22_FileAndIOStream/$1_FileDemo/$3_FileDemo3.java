package com.$22_FileAndIOStream.$1_FileDemo;

/*
    需求:
        找到电脑中所有以.avi结尾的电影 (需要考虑子文件夹)
        需要用到递归
        思路:
            1. 进入文件夹
            2. 获取文件对象数组并遍历
            3. 判断是否为文件
            4. 判断是否为文件夹
 */

import java.io.File;
import java.util.ArrayList;

public class $3_FileDemo3 {
    public static void main(String[] args) {
//        File sourceFile = new File("D:\\");
        // 获取电脑所有盘符对象
        File[] sourceFileArray = File.listRoots();
        for (File file : sourceFileArray) {
            ArrayList<File> list = lookForFile(file);
            for (File file1 : list) {
                System.out.println(file1.getAbsoluteFile());
            }
        }
    }

    // 定义方法, 寻找.avi文件
    public static ArrayList<File> lookForFile (File sourceFile) {
        // 创建文件对象集合, 存储找到的文件对象
        ArrayList<File> fileResultList = new ArrayList<>();
        File[] fileArray = sourceFile.listFiles();
        if (fileArray != null && fileArray.length != 0) {
            for (File file : fileArray) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".avi")) {
//                        System.out.println(file.getName());
                        fileResultList.add(file);
                    }
                } else {
                    if (file.isDirectory()) {
                        ArrayList<File> list = lookForFile(file);
                        fileResultList.addAll(list);
                    }
                }
            }
        }
        return fileResultList;
    }
}
