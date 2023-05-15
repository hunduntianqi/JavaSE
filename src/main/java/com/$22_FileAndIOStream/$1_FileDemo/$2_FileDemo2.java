package com.$22_FileAndIOStream.$1_FileDemo;

/*
    需求:
        定义一个方法, 找某一个文件夹中是否有以avi结尾的电影(不需要考虑子文件夹)
 */

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class $2_FileDemo2 {
    public static void main(String[] args) {
        // 1. 创建Scanner对象, 录入目标文件夹
        Scanner sc = new Scanner(System.in);
        // 2. 定义目标文件夹路径变量
        System.out.println("请输入目标文件夹路径: ");
        String path = sc.next();
        // 3. 创建文件对象
        File file = new File(path);
        // 4. 获取目标文件夹中所有的avi文件对象
        File[] fileObjectArray = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".avi");
            }
        });
        // 5. 判断文件对象数组中是否含有元素, 有则证明存在.avi文件
        if (fileObjectArray.length != 0) {
            System.out.println(file.getName() + "文件夹下含有.avi文件");
            for (File file1 : fileObjectArray) {
                System.out.println(file1.getAbsoluteFile());
            }
        } else {
            System.out.println(file.getName() + "文件夹内无.avi文件");
        }
    }
}
