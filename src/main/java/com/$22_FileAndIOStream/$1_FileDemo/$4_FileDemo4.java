package com.$22_FileAndIOStream.$1_FileDemo;

/*
    需求:
        删除一个含有内容的多级文件夹
 */

import java.io.File;

public class $4_FileDemo4 {
    public static void main(String[] args) {
        // 定义目标文件夹路径
        String sourcePath = "D:\\文件\\Python\\2020版Python教程【千锋】";
        fileDelete(sourcePath);
    }

    // 定义方法递归删除文件夹
    public static void fileDelete (String path) {
        // 1. 获取文件夹下的所有内容对象数组
        File fileSource = new File(path);
        File[] fileArray = fileSource.listFiles();
        if (fileArray != null && fileArray.length != 0) {
            // 2. 遍历判断文件对象
            for (File file : fileArray) {
                if (file.isFile()) {
                    // 3. 删除文件
                    System.out.println(file.getAbsolutePath() + "删除成功！！");
                    file.delete();
                } else {
                    if (file.isDirectory()) {
                        // 4. 文件夹对象递归删除
                        fileDelete(file.getAbsolutePath());
                    }
                }
            }
        }
        // 5. 删除源文件夹
        fileSource.delete();
    }
}
