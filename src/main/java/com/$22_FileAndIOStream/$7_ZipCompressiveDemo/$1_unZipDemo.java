package com.$22_FileAndIOStream.$7_ZipCompressiveDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
    解压缩练习
 */
public class $1_unZipDemo {
    public static void main(String[] args) throws Exception {
        // 1. 创建一个File对象表示要解压的压缩包
        String path = "D:\\Users\\Administrator\\Desktop\\jetbra.zip";
        File zipFile = new File(path);
        // 2. 创建一个文件对象, 代表解压后的文件存放的文件夹
        String resultPath = "";
        File resultFolder = new File("D:\\Users\\Administrator\\Desktop\\");
        // 3. 调用方法, 解压文件
        unZip(zipFile, resultFolder);
    }

    // 定义方法用来解压文件
    public static void unZip(File source, File resultFolder) throws Exception {
        // 1. 创建解压缩流, 读取压缩包的数据
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(source));
        // 2. 获取到压缩包中的每一个zipEntry对象
        ZipEntry entry;
        while ((entry = zipInputStream.getNextEntry()) != null) {
            System.out.println(entry);
            // 3. 判断该ZipEntry对象代表文件还是文件夹
            if (entry.isDirectory()) {
                // 文件夹: 创建新的文件夹
                File fileFolder = new File(resultFolder, entry.toString());
                fileFolder.mkdirs();
            } else {
                // 文件: 读取压缩包中的数据, 并创建文件写入数据后存放到目的文件夹
                FileOutputStream fileOutputStream = new FileOutputStream(new File(resultFolder, entry.toString()));
                int b;
                while ((b = zipInputStream.read()) != -1) {
                    fileOutputStream.write(b);
                }
                fileOutputStream.close();
                zipInputStream.closeEntry();
            }
        }
        zipInputStream.close();
    }
}
