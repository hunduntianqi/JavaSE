package com.$22_FileAndIOStream;

/*
    字符流:
        以字符为单位, 读写数据, 只能操作纯文本文件
        Reader: 字符输入流, 属于抽象类, 是字符输入流的父类
            实现类代表:FileReader
            构造器:
                1. public FileReader(File file): 创建字符输入流管道与源文件对象接通
                2. public FileReader(String pathname): 创建字符输入流管道与源文件路径接通
            常用方法:
                1. public int read(): 每次读取一个字符返回, 如果字符已经没有可读的返回-1
                2. public int read(char[] buffer): 每次读取一个字符数组, 返回读取的字符个数, 如果字符已经没有可读的
                                                                返回-1
        Writer: 字符输出流, 属于抽象类, 是字符输出流的父类
            实现类代表:FileWriter
            构造器:
                1. public FileWriter(File file): 创建字符输出流管道与源文件对象接通
                2. public FIleWriter(File file, boolean append): 创建字符输出流管道与源文件对象接通, 可追加数据
                3. public FileWriter(String filepath): 创建字符输出流管道与源文件路径接通
                3. public FIleWriter(String filepath, boolean append): 创建字符输出流管道与源文件路径接通, 可追加数据
            常用方法:
                1. void write(int c): 写一个字符
                2. void write(char[] cbuf): 写入一个字符数组
                3. void write(char[] cbuf, int off, int len): 写入字符数组的一部分
                4. void write(String str): 写一个字符串
                5. void write(String str, int off, int len): 写一个字符串的一部分
            文件关闭与刷新:
                1. 刷新文件:file.flush(), 刷新数据, 确保缓存区数据写入文件, 刷新后可以继续写入数据
                2. 关闭文件: file.close(), 释放资源, 包含刷新数据, 关闭文件后不能继续写入数据
 */

public class $4_CharStreamSummarize {
}
