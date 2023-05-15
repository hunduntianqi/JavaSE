package com.$22_FileAndIOStream.$7_ZipCompressiveDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
    压缩单个文件
 */
public class $2_ZipFile {
    public static void main(String[] args) throws Exception{
        // 1. 创建File对象表示要压缩的文件
        File source = new File("D:\\Users\\Administrator\\Desktop\\小练习\\java_test\\go_图片备份\\0b7ec39fdb4e30c28fe131af02750ff6.jpg");
        // 2. 创建File对象表示压缩包的位置
        File resultZip = new File("../JavaSeNewStudy/src/com/javaBasic/$22_FileAndIOStream/$7_ZipCompressiveDemo/");
        // 3. 调用方法压缩文件
        toZip(source, resultZip);
    }

    public static void toZip (File src, File dest) throws Exception{
        /**
         * 作用: 压缩单个文件
         * 参数一: 要压缩的文件对象
         * 参数二: 压缩包的位置
         */
        // 1. 创建压缩流关联压缩包对象
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(dest, "pic.zip")));
        // 2. 创建ZipEntry对象, 表示压缩包里的文件和文件夹
        ZipEntry zipEntry = new ZipEntry("0b7ec39fdb4e30c28fe131af02750ff6.jpg");
        // 3. 将ZipEntry对象放入压缩包中
        zipOutputStream.putNextEntry(zipEntry);
        // 4. 将源文件的数据写入压缩包中
        FileInputStream fileInputStream = new FileInputStream(src);
        int b;
        while ((b = fileInputStream.read()) != -1) {
            zipOutputStream.write(b);
        }
        zipOutputStream.closeEntry();
        zipOutputStream.close();
    }
}
