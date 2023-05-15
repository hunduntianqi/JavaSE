package com.$28_ClassLoader;

/*
    类加载器:
        作用: 负责将存储在硬盘上的字节码文件加载到内存中
        类加载时机:
            1. 创建类的实例(对象)时
            2. 调用类的类方法(静态方法)时
            3. 访问类或者接口的类变量, 或者为该类变量赋值时
            4. 使用反射方式来强制创建某个类或接口对应的java.lang.Class对象时
            5. 初始化某个类的子类时
            6. 直接使用java.exe命令来运行某个主类时
            总结: 用到类就加载, 不用就不加载
        类加载的过程:
            1. 加载:
                a. 通过包名 + 类名获取这个类, 准备用流进行传输
                b. 把这个类加载到内存中
                c. 加载完毕创建一个class对象
            2. 链接:
                a. 验证 ==> 确保Class文件字节流中包含的信息符合当前虚拟机的要求, 并且不会危害虚拟机自身安全
                b. 准备 ==> 负责为类的类变量(static修饰的变量)分类内存, 并设置默认初始化值(初始化静态变量)
                c. 解析 ==> 将类的二进制数据流中的符号引用替换为直接引用(本类中如果用到了其他类, 此时就需要找到对应的类)
            3. 初始化:
                根据程序员通过程序制定的主观计划去初始化类变量和其他资源(静态变量赋值及初始化其他资源)
        类加载器的分类:
            1. Bootstrap class loader: 虚拟机的内置类加载器, 通常表示为null, 并且没有父null
                ClassLoader classLoader2 = 平台类加载器对象.getParent();
            2. Platform class loader: 平台类加载器, 负责加载JDK中一些特殊的模块, 父加载器为Bootstrap
                ClassLoader classLoader1 = 系统类加载对象.getParent();
            3. System class loader: 系统类加载器, 负责加载用户类路径上所指定的类库, 父加载器为Platform
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader 中的两个方法(重点掌握):
            1. public static Classloader getSystemClassloader(): 获取系统类加载器
            2. public InputStream getResourceAsStream(String path): 加载某一个资源文件
 */

import java.io.InputStream;
import java.util.Properties;

public class $1_ClassLoaderSummarize {
    public static void main(String[] args) throws Exception {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //获取系统类加载器的父加载器 --- 平台类加载器
        ClassLoader classLoader1 = systemClassLoader.getParent();
        //获取平台类加载器的父加载器 --- 启动类加载器
        ClassLoader classLoader2 = classLoader1.getParent();
        // 打印
        System.out.println("系统类加载器 ==> " + systemClassLoader);
        System.out.println("平台类加载器 ==> " + classLoader1);
        System.out.println("启动类加载器 ==> " + classLoader2);
        // 利用系统类加载器加载一个指定的文件
        InputStream inputStream = systemClassLoader.getResourceAsStream("com/$28_ClassLoader/prop.properties");
        Properties prop = new Properties();
        prop.load(inputStream);
        inputStream.close();
        System.out.println(prop);
    }
}
