package com.$22_FileAndIOStream.$6_SerializeStreamDemo;

/*
    练习:
        1. 将存有多个自定义对象的集合序列化操作, 保存到 list.txt 文件中
        2. 反序列化 list.txt, 并遍历集合, 打印对象信息
    案例分析:
        1. 把若干学生对象, 保存到集合中
        2. 把集合序列化
        3. 反序列化读取时, 只需要读取一次, 转换为集合类型
        4. 遍历集合, 可以打印所有的学生信息
 */

import java.io.*;
import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) throws Exception {
        // 调用方法, 完成对象序列化
//        gatherSerialize();
        // 调用方法, 集合对象反序列化
        gatherDeserialize();

    }

    // 定义方法, 完成集合对象序列化
    public static void gatherSerialize() throws Exception {
        // 定义集合对象, 存储学生对象
        ArrayList<JavaBeanStudent> list = new ArrayList<>();
        // 集合对象添加学生对象数据
        list.add(new JavaBeanStudent("郭鹏涛", 25, "江苏省苏州市"));
        list.add(new JavaBeanStudent("郭鹏强", 22, "上海市徐汇区"));
        list.add(new JavaBeanStudent("陈欣妮", 25, "广东省深圳市"));
        // 定义变量, 记录文件路径
        String path = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$6_SerializeStreamDemo/list.txt";
        // 创建序列化流对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        // 将对象序列化写入本地文件
        objectOutputStream.writeObject(list);
        // 关闭流对象
        objectOutputStream.close();
    }

    // 定义方法, 集合对象反序列化
    public static void gatherDeserialize() throws Exception {
        // 定义变量, 记录文件路径
        String path = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$6_SerializeStreamDemo/list.txt";
        // 创建反序列化流对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        // 判断并读取文件中对象
        ArrayList<JavaBeanStudent> list = (ArrayList<JavaBeanStudent>) objectInputStream.readObject();
        // 打印集合中对象数据
        list.forEach(System.out::println);
        // 关闭流对象
        objectInputStream.close();
    }
}
