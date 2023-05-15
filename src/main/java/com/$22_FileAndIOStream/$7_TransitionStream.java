package com.$22_FileAndIOStream;

/*
    转换流:
        属于字符流, 是字符流和字节流之间的桥梁, 是一种高级流
        作用:
            1. 指定字符集读写
        InputStreamReader:
            是从字节流到字符流的桥梁, 读取字节, 并使用指定的字符集解码为字符
            构造方法:
                1. InputStreamReader(InputStream in): 创建一个使用默认字符集的字符流
                2. InputStreamReader(InputStream in, String charsetName): 创建一个使用指定字符集的字符流
            构造举例:
                1. InputStreamReader isr = new InputStreamReader(new FileInputStream("in.txt"));
                2. InputStreamReader isr2 = new InputStreamReader(new FileInputStream("in.txt"), "GBK");
        OutputStreamWriter:
            是从字符流到字节流的桥梁, 使用指定的字符集将字符编码为字节
            构造方法:
                1. OutputStreamWriter(OutputStream in): 创建一个使用指定字符集的字符流
                2. OutputStreamWriter(OutputStream in, String charsetName): 创建一个指定字符集的字符流
            构造举例:
                1. OutputStreamWriter isr = new OutputStreamWriter(new FileOutputStream("Out.txt"));
                2. OutputStreamWriter isr2 = new OutputStreamWriter(new FileOutputStream("Out.txt"), "GBK");
 */

import java.io.*;

public class $7_TransitionStream {
    public static void main(String[] args) throws Exception{
        inputTransitionStream1();
        inputTransitionStream2();
        outputTransitionStream1();
        outputTransitionStream2();
    }

    // 默认字符集输入转换流演示
    public static void inputTransitionStream1 () throws Exception{
        // 定义变量, 记录文件路径
        String path = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$6_出师表.txt";
        // 创建文件对象
        File file = new File(path);
        // 创建默认字符集的输入转换流对象
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        // 读取文件数据并打印
        char[] chArray = new char[(int)file.length()];
        int len = inputStreamReader.read(chArray);
        System.out.println(len);
        System.out.println(new String(chArray));
        // 关闭文件对象
        inputStreamReader.close();
    }

    // 指定字符集输入转换流演示
    public static void inputTransitionStream2 () throws Exception{
        // 定义变量, 记录文件路径
        String path = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$6_出师表.txt";
        // 创建文件对象
        File file = new File(path);
        // 创建默认字符集的输入转换流对象
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "GBK");
        // 读取文件数据并打印
        char[] chArray = new char[(int)file.length()];
        int len = inputStreamReader.read(chArray);
        System.out.println(len);
        String str = new String(chArray);
        System.out.println(str);
        byte[] byArray = str.getBytes("GBK");
        System.out.println(new String(byArray, "utf-8"));
        // 关闭文件对象
        inputStreamReader.close();
    }

    // 默认字符集输出转换流演示
    public static void outputTransitionStream1 () throws Exception {
        // 定义变量, 保存源文件路径和目标文件路径
        String sourcePath = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$6_出师表.txt";
        String resultPath = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$7_出师表_utf8.txt";
        // 创建字符输出转换流对象
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(resultPath));
        // 创建源文件对象
        File file = new File(sourcePath);
        // 创建源文件字符输入流对象
        FileReader fileReader = new FileReader(file);
        // 创建字符数组, 读取源文件所有信息
        char[] charArray = new char[(int)file.length()];
        fileReader.read(charArray);
        // 将源文件数据写入新的目标文件
        outputStreamWriter.write(charArray);
        // 关闭源文件流和目标文件流
        fileReader.close();
        outputStreamWriter.close();
    }

    // 指定字符集输出转换流演示
    public static void outputTransitionStream2 () throws Exception {
        // 定义变量, 保存源文件路径和目标文件路径
        String sourcePath = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$6_出师表.txt";
        String resultPath = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$7_出师表_gbk.txt";
        // 创建字符输出转换流对象
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(resultPath), "gbk");
        // 创建源文件对象
        File file = new File(sourcePath);
        // 创建源文件字符输入流对象
        FileReader fileReader = new FileReader(file);
        // 创建字符数组, 读取源文件所有信息
        char[] charArray = new char[(int)file.length()];
        fileReader.read(charArray);
        // 将源文件数据写入新的目标文件
        outputStreamWriter.write(charArray);
        // 关闭源文件流和目标文件流
        fileReader.close();
        outputStreamWriter.close();
    }
}
