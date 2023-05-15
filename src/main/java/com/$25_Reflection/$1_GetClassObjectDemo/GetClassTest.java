package com.$25_Reflection.$1_GetClassObjectDemo;

public class GetClassTest {
    /*
         获取class对象的三种方式:
            1. Class.forName("全类名") ==> 源代码阶段使用
            2. 类名.class ==> 加载内存阶段使用
            3. 对象.getClass() ==> 运行阶段可以使用
     */
    public static void main(String[] args) throws Exception{
        // 1. Class.forName("全类名")获取class对象
        Class clazz1 = Class.forName("com.$25_Reflection.$1_GetClassObjectDemo.Student");
        System.out.println(clazz1);
        // 2. 类名.class获取class对象
        Class clazz2 = Student.class;
        System.out.println(clazz2);
        // 3. 对象.getClass()获取class对象
        Student student = new Student();
        Class clazz3 = student.getClass();
        System.out.println(clazz3);
        // 比较三个class对象
        System.out.println(clazz1 == clazz2); // true
        System.out.println(clazz3 == clazz2); // true
    }
}
