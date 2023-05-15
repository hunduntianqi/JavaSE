package com.$22_FileAndIOStream;

/*
    File对象:
        指一个路径, 可以是文件的路径, 也可以是文件件的路径; 该路径可以是存在的, 也可以是不存在的
    File类常用构造方法:
        1. public File(String pathname): 根据文件路径创建文件对象
        2. public File(String parent, String child): 根据父路径名字符串和子路径名字符串创建文件对象
        3. public File(File parent, String child): 根据父路径对应的文件对象和子路径名字字符串创建文件对象
    File类对象常用方法:
        1. public boolean isDirectory(): 判断此路径名表示的File是否为文件夹
        2. public boolean isFile(): 判断此路径名表示的File是否为文件
        3. public boolean exists(): 判断此路径名表示的File是否存在
        4. public String getAbsolutePath(): 返回此文件对象的绝对路径名字符串
        5. public String getPath(): 返回定义文件对象时使用的路径
        6. public String getName(): 返回由此文件对象表示的文件或文件夹的名称, 带扩展名
        7. public long lastModified(): 返回文件最后修改的时间毫秒值
        8. public long length(): 返回对应文件对象的字节大小
    File类创建和删除文件方法:
        1. public boolean createNewFile(): 创建一个新的空文件
            注意:
                1. 文件不存在则创建成功, 返回true, 文件已存在则创建失败, 返回false
                2. 如果父级路径不存在, 会产生IOException异常
                3. 该方法创建的一定是文件, 不会是文件夹, 如果没有后缀名, 会创建一个没有后缀的文件
        2. public boolean mkdir(): 创建一级文件夹
        3. public boolean mkdirs(): 创建多级文件夹
            注意: 该方法既可以创建单级文件夹, 也可以创建多级文件夹
        4. public boolean delete(): 删除文件和空文件夹
        注意:
            1. delete方法默认只能删除文件和空文件夹
            2. delete方法直接删除不走回收站, 删除动作无法撤销
    File类遍历功能:
        1. public String[] list(): 获取当前目录下所有一级文件名称到一个字符串数组并返回
        2. public File[] listFiles()(常用): 获取当前目录下所有的一级文件对象到一个文件对象数组中去返回(重点)
            listFiles方法注意事项:
                1. 当调用者不存在时, 返回null
                2. 当调用者是一个文件时, 返回null
                3. 当调用者是一个空文件夹时, 返回一个长度为0的数组
                4. 当调用者是一个有内容的文件夹时, 将里面所有文件和文件夹的路径放在File数组中返回
                5. 当调用者是一个有隐藏文件的文件夹时, 将里面所有文件和文件夹的路径放在File数组中返回, 包含隐藏内容
                6. 当调用者是一个需要权限才能进入的文件夹时, 返回null
        3. public static File[] listRoots(): 列出所有可用的系统盘符
        4. public String[] list(FilenameFilter filter): 利用文件名过滤器获取当前目录下所有文件名到字符串数组中返回
        5. public File[] listFiles(FilenameFilter filter): 利用文件名过滤器获取当前目录下所有的一级文件对象到一个文件对象数组中去返回
        6. public File[] listFiles(FileFilter filter): 利用文件名过滤器获取当前目录下所有的一级文件对象到一个文件对象数组中去返回
 */

import java.io.File;
import java.util.Arrays;

public class $1_FileSummarize {
    public static void main(String[] args) throws Exception{
        // 1. 根据文件路径创建文件对象
        String path = "D:\\Users\\Administrator\\Desktop\\新建文本文档.txt";
        File file1 = new File(path);
        System.out.println("file1对应文件是否存在: " + file1.exists());
        System.out.println("file1是否为文件夹: " + file1.isDirectory());
        System.out.println("file1是否为文件: " + file1.isFile());
        System.out.println("file1对应文件绝对路径:  " + file1.getAbsolutePath());
        System.out.println("file1对应文件的字节大小:  " + file1.length());
        System.out.println("file1文件对象创建时使用的路径为: " + file1.getPath());
        System.out.println("file1对应的文件名为: " + file1.getName());
        System.out.println("file1文件的最终修改时间毫秒值为: " + file1.lastModified());
        // 2. 根据父路径名字符串和子路径名字符串创建文件对象
        String parent = "D:\\Users\\Administrator\\Desktop\\";
        String child = "新建文本文档.txt";
        File file2 = new File(parent, child);
        System.out.println("file2: " + file2.getAbsoluteFile());
        // 3. 根据父路径对应的文件对象和子路径名字字符串创建文件对象
        File parent2 = new File("D:\\Users\\Administrator\\Desktop\\");
        File file3 = new File(parent2, child);
        System.out.println("file3: " + file3.getAbsoluteFile());

        // 4. 创建一个空的文件夹对象
        File file4 = new File("D:\\Users\\Administrator\\Desktop\\javaFileTest");
        boolean result = file4.mkdir();
        System.out.println("文件夹javaFileTest是否创建成功: " + result);
        // 5. 创建一个空文件对象
        File file5 = new File("D:\\Users\\Administrator\\Desktop\\javaFileTest\\javaFileTest.txt");
        result = file5.createNewFile();
        System.out.println("文件javaFileTest.txt是否创建成功: " + result);
        // 6. 创建多级文件夹
        File file6  = new File("D:\\Users\\Administrator\\Desktop\\javaFileTest1\\javaFileTest2");
        result = file6.mkdirs();
        System.out.println("文件夹javaFileTest1下面的javaFileTest2是否创建成功: " + result);

        // 7. 获取对应文件夹内所有文件的文件名
        File file7 = new File("D:\\Users\\Administrator\\Desktop\\小练习\\test\\图片备份");
        String[] fileNameArray = file7.list();
        for (String fileName : fileNameArray) {
            System.out.println(fileName);
        }
        System.out.println("==========================");
        // 8. 获取对应文件夹对象下所有的文件对象数组
        File[] fileobjectArray = file7.listFiles();
        for (File file : fileobjectArray) {
            System.out.println(file.getName());
        }

        // 9. 打印系统所有盘符
        System.out.println(Arrays.toString(File.listRoots()));
    }
}
