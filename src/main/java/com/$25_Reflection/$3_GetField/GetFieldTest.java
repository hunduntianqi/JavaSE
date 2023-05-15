package com.$25_Reflection.$3_GetField;

import java.lang.reflect.Field;

public class GetFieldTest {
    /*
        Class类中获取成员变量的方法:
                1. Field[] getFields(): 返回所有公共成员变量对象的数组
                2. Field[] getDeclaredFields(): 返回所有成员变量对象的数组
                3. Field getField(String name): 返回单个公共成员变量对象
                4. Field getDeclaredField(String name): 返回单个成员变量对象
            Field类中用于创建对象的方法:
                1. void set(Object obj, Object value): 赋值
                2. Object get(Object obj): 获取值
     */
    public static void main(String[] args) throws Exception {
        // 1. 获取Student字节码文件对象
        Class clazz = Class.forName("com.$25_Reflection.$3_GetField.Student");
        // 2. 获取所有的公共成员变量
        Field[] fields1 = clazz.getFields();
        for (Field field : fields1) {
            System.out.println(field);
        }
        System.out.println("==============================");
        // 3. 获取所有成员变量
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field);
        }
        System.out.println("===============================");
        // 4. 获取单个成员变量(public)
        Field field1 = clazz.getField("gender");
        System.out.println(field1);
        // 5. 获取单个成员变量(非public)
        Field field2 = clazz.getDeclaredField("name");
        Field field3 = clazz.getDeclaredField("age");
        System.out.println(field2);
        System.out.println(field3);
        System.out.println("================================");
        // 获取成员变量的权限修饰符
        int modifiers = field1.getModifiers();
        System.out.println(modifiers);
        // 获取成员变量名
        String name = field1.getName();
        System.out.println(name);
        // 获取成员变量类型
        Class<?> type = field1.getType();
        System.out.println(type);
        System.out.println("================================");
        // 获取成员变量记录的值
        Student student = new Student("郭鹏涛", 25, "男");
        field1.setAccessible(true);
        String value = (String) field1.get(student);
        System.out.println(value);
        // 修改对象里面记录的值
        field1.set(student, "未知");
        System.out.println(student);
    }
}
