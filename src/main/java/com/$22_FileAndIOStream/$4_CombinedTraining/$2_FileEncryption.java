package com.$22_FileAndIOStream.$4_CombinedTraining;

/*
    文件加密:
        为了保证文件的安全性, 需要对原始文件进行加密存储, 在使用的时候对齐进行解密处理
        加密原理:
            对原始文件中的每一个字节数据进行更改, 然后将更改以后的数据存储到新的文件中
        解密原理:
            读取加密之后的文件, 按照加密之后的规则进行反向操作, 变成原始文件
        ^: 异或符号, 如果符号两边是数字, 则异或两次相同数字后, 与原来的数字相同
           异或逻辑 ==> 相同为0, 不同为1; 异或符号在比对数字时, 底层会转换为二进制按位异或
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class $2_FileEncryption {
    public static void main(String[] args) throws Exception {
        // 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        // 获取目标文件路径
        System.out.println("请输入源文件路径:");
        String sourceFilePath = sc.next();
        // 创建源文件对象
        File sourceFile = new File(sourceFilePath);
        // 获取加密后文件存储路径
        System.out.println("请输入加密后文件存储位置:");
        String resultFilePath = sc.next();
        // 调用方法加密文件
        encryptionFile(sourceFile, resultFilePath);
        // 调用方法查看文件解密数据
        decodeFile(resultFilePath);
    }

    // 定义方法, 加密文件
    public static void encryptionFile(File sourceFile, String resultPath) throws Exception {
        // 创建字节输入流对象
        FileInputStream fileInputStream = new FileInputStream(sourceFile);
        // 读取文件所有字节数据到字节数组
        byte[] fileDataArray = fileInputStream.readAllBytes();
        // 关闭字节输入流
        fileInputStream.close();
        // 文件数据加密 ==> 遍历字节数组, 将每个字节数据与 10 异或, 再存入原数组
        for (int i = 0; i < fileDataArray.length; i++) {
            fileDataArray[i] = (byte) (fileDataArray[i] ^ 10);
        }
        // 创建字节输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream(resultPath);
        // 写入数据
        fileOutputStream.write(fileDataArray);
        // 关闭字节输出流
        fileOutputStream.close();
    }

    // 定义方法, 解读加密后文件
    public static void decodeFile(String filePath) throws Exception {
        // 创建字节输入流对象
        FileInputStream fileInputStream = new FileInputStream(filePath);
        // 读取文件字节数据到字节数组
        byte[] fileDataArray = fileInputStream.readAllBytes();
        // 关闭字节输入流
        fileInputStream.close();
        // 解密文件数据 ==> 文件数据每个字节通过与 10 异或加密, 每个字节再次与 10 异或即可恢复原数据
        // 遍历字节数组
        for (int i = 0; i < fileDataArray.length; i++) {
            fileDataArray[i] = (byte) (fileDataArray[i] ^ 10);
        }
        // 解码打印字节数组
        System.out.println(new String(fileDataArray));
    }
}
