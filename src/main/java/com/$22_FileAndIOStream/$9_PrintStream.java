package com.$22_FileAndIOStream;

/*
    打印流:
        打印流只有输出流, 不能读, 只能写
        特点:
            1. 只操作文件目的地, 不能操作数据源
            2. 特有的写出方法可以实现数据原样写出
            3. 特有的写出方法, 可以实现自动刷新, 自动换行
        打印流分类:
            1. PrintStream: 字节打印流
                构造方法:
                    a. public PrintStream(OutputStream/File/String): 关联字节输出流/文件对象/文件路径, 创建一个字节打印流对象
                    b. public PrintStream(String fileName,Charset charset):指定字符编码, 创建字节打印流对象
                    c. public PrintStream(OutputStream out, boolean autoFlush): 创建一个字节打印流对象, 根据传入参数值决定是否自动刷新
                    d. public PrintStream(OutputStream out, boolean autoFlush, String encoding): 指定字符编码创建打印流对象,
                                                            并根据传入参数值决定是否自动刷新
                常用成员方法:
                    a. public void write(int b): 常规方法, 将指定的字节写出
                    b. public void println(Xxx xxx): 特有方法, 打印任意数据, 自动刷新, 自动换行
                    c. public void print(Xxx xxx): 特有方法, 打印任意数据, 不换行
                    d. public void printf(String format, Object... args): 特有方法, 带有占位符的打印语句, 不换行
            2. PrintWriter: 字符打印流
                构造方法:
                    a. public PrintWriter(Write/File/String): 关联字符输出流/文件对象/文件路径, 创建一个字符打印流对象
                    b. public PrintWriter(String fileName, Charset charset): 指定字符编码, 创建字符打印流对象
                    c. public PrintWriter(Write W, boolean autoFlush): 创建一个字符打印流对象, 根据传入参数确定是否开启自动刷新
                    d. public PrintWriter(OutputStream out, boolean autoFlush, Charset charset): 指定字符编码创建打印流对象, 并根据传入参数值决定是否自动刷新
                常用成员方法:
                    a. public void write(int b): 常规方法, 将指定的字节写出
                    b. public void println(Xxx xxx): 特有方法, 打印任意数据, 自动刷新, 自动换行
                    c. public void print(Xxx xxx): 特有方法, 打印任意数据, 不换行
                    d. public void printf(String format, Object... args): 特有方法, 带有占位符的打印语句, 不换行
 */

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class $9_PrintStream {
    public static void main(String[] args) throws Exception {
        printStreamExample();
        printWriterExample();
    }

    // 定义方法, 演示字节打印流
    public static void printStreamExample() throws Exception {
        // 定义变量, 记录文件路径
        String path = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$5_OtherStreamDemoFile/$9_字节打印流.txt";
        // 1. 创建字节打印流对象
        PrintStream printStream = new PrintStream(new FileOutputStream(path), true, Charset.forName("utf-8"));
        // 2. 向文件写入数据
        printStream.println("混沌初开道为先, 丑地人寅子升天");
        printStream.print("阴顺阳逆长生路, 颠倒归元返胎全");
        printStream.print("\n");
        printStream.printf("九龙翻转甘露洒, %s", "三环盘绕虚空间");
        printStream.print("\n");
        printStream.println("灵苗发长山河换, 枯木逢春一万年");
        // 3. 关闭流对象
        printStream.close();
    }

    // 定义方法, 演示字符打印流
    public static void printWriterExample() throws Exception {
        // 定义变量, 记录文件路径
        String path = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$5_OtherStreamDemoFile/$9_字符打印流.txt";
        // 1. 创建字节打印流对象
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(path), true, Charset.forName("gbk"));
        // 2. 向文件写入数据
        printWriter.println("混沌初开道为先, 丑地人寅子升天");
        printWriter.print("阴顺阳逆长生路, 颠倒归元返胎全");
        printWriter.print("\n");
        printWriter.printf("九龙翻转甘露洒, %s", "三环盘绕虚空间");
        printWriter.print("\n");
        printWriter.println("灵苗发长山河换, 枯木逢春一万年");
        // 3. 关闭流对象
        printWriter.close();
    }
}
