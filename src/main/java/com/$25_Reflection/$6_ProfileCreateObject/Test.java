package com.$25_Reflection.$6_ProfileCreateObject;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
    /*
        反射与配置文件结合, 动态的创建对象, 并调用方法
     */
    public static void main(String[] args) throws Exception{
        // 1. 读取配置文件的信息
        Properties properties = new Properties();
        // 2. 创建IO流
        FileInputStream fileInputStream = new FileInputStream("src/com/$25_Reflection/$6_ProfileCreateObject/prop.properties");
        // 3. 加载配置文件
        properties.load(fileInputStream);
        // 4. 释放资源
        fileInputStream.close();
        // 打印配置文件数据
        System.out.println(properties);
        // 获取全类名和方法名
        String className = (String)properties.get("classname");
        System.out.println(className);
        String method = (String)properties.get("method");
        System.out.println(method);
        // 利用反射去创建对象并运行方法
        // 1. 获取字节码文件对象
        Class clazz = Class.forName(className);
        // 2. 获取构造方法
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        // 3. 创建对象
        Object o = declaredConstructor.newInstance();
        System.out.println(o);
        // 4. 获取成员方法并运行
        Method method2 = clazz.getDeclaredMethod(method);
        method2.setAccessible(true);
        method2.invoke(o);
    }
}
