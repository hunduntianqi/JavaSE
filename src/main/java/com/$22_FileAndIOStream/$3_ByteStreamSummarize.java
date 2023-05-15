package com.$22_FileAndIOStream;

/*
    字节流:
        以字节为单位, 读写数据, 可以操作所有类型的文件
        InputStream: 字节输入流, 属于抽象类, 是字节输入流的父类
            实现类代表:FileInputStream
            构造器:
                1. public FileInputStream(File file): 创建字节输入流管道与源文件对象接通
                2. public FileInputStream(String pathname): 创建字节输入流管道与源文件路径接通
            读取方法:
                public int read(): 每次读取一个字节返回, 如果字节已经没有可读的返回-1
                public int read(byte[] buffer): 每次读取一个字节数组返回, 如果字节已经没有可读的返回-1
        OutputStream: 字节输出流, 属于抽象类, 是字节输出流的父类
            实现类代表:FileOutputStream
            构造器:
                1. public FIleOutputStream(File file): 创建字节输出流管道与源文件对象接通
                2. public FIleOutputStream(File file, boolean append): 创建字节输出流管道与源文件对象接通, 可追加数据
                3. public FIleOutputStream(String filepath): 创建字节输出流管道与源文件路径接通, 文件不存在会新建文件,
                                                             文件存在会清空文件数据
                4. public FIleOutputStream(String filepath, boolean append): 创建字节输出流管道与源文件路径接通, 可追加数据
            写入方法:
                1. public void write(int a): 写一个字节
                2. public void write(byte[] buffer): 写一个字节数组
                3. public void write(byte[] buffer, int pos, int len): 写一个字节数组的一部分
            刷新和关闭写入文件:
                1. 刷新文件:file.flush(), 刷新数据, 确保缓存区数据写入文件, 刷新后可以继续写入数据
                2. 关闭文件: file.close(), 释放资源, 包含刷新数据, 关闭文件后不能继续写入数据
 */

public class $3_ByteStreamSummarize {
}
