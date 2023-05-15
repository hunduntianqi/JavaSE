package com.$25_Reflection.$5_SaveObjectData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Field;

public class SaveObjectTest {
    /*
        对于一个任意的对象, 都可以把对象的字段名和值, 保存到文件中去
     */
    public static void main(String[] args) throws Exception {
        Student student = new Student("小A", 23, '女', 167.5, "睡觉");
        Teacher teacher = new Teacher("播妞", 10000);
        saveObject(student);
        saveObject(teacher);
    }

    // 把对象里面所有的成员变量名和值保存到本地文件中
    public static void saveObject(Object obj) throws Exception {
        // 1. 获取字节码文件对象
        Class clazz = obj.getClass();
        // 2. 创建IO流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/$25_Reflection/$5_SaveObjectData/text.txt", true));
        // 2. 获取所有的成员变量
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            // 临时取消访问权限
            declaredField.setAccessible(true);
            // 获取成员变量名
            String name = declaredField.getName();
            // 获取成员变量值
            Object value = declaredField.get(obj);
            System.out.println(name + "=" + value);
            bufferedWriter.write(name + "=" + value);
            bufferedWriter.newLine(); // 换行
        }
        bufferedWriter.write("=========================");
        bufferedWriter.newLine();
        System.out.println("==================");
        // 释放资源
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
