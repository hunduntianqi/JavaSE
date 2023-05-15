package com.$14_common_API;
/*
    Object:
        是Java中的顶级父类, 所有的类都直接或间接的继承与Object类, Object类中的方法可以被所有子类访问
        构造方法:
            Object无成员变量, 只有一个空参构造
            public Object(): 空参构造
        成员方法:
            public String toString(): 返回对象的字符串表示形式
                如果打印一个对象, 想要看到对象的属性值, 需要重写toString方法, 将属性拼接为字符串返回
            public boolean equals(Object obj): 比较两个对象是否相等
                如果没有重写equals方法, 默认使用Object中的方法进行比较, 比较的是地址值是否相等
            protected Object clone(int a): 对象克隆, 把A对象的属性值完全拷贝给B对象, 也叫对象拷贝, 对象复制
                对象克隆实现步骤:
                    1. javabean类重写clone方法
                    2. JavaBean类实现Cloneable接口
                    3. 创建原对象并调用clone方法
                浅克隆: 无论对象内部的属性是基本数据类型还是引用数据类型, 都完全拷贝过来, Object中的克隆属于浅克隆
                深克隆:
                    1. 基本数据类型: 直接拷贝过来
                    2. 字符串: 复用字符串池中的数据
                    3. 引用数据类型: 重新创建新的数据
    Objects:
        是一个工具类, 提供了一些方法, 去完成一些功能
        1. public static boolean equals(Object a, Object b): 先做非空判断, 再比较两个对象是否相等
        2. public static boolean isNull (Object obj): 判断对象是否为null, 是则返回true, 反之返回false
        3. public static boolean nonNull (object obj): 判断对象是否为null, 是则返回false, 反之返回true
 */
public class $4_ObjectAndObjects {
    public static void main(String[] args) {
        // 打印对象字符串表现形式
        Object obj = new Object();
        System.out.println(obj.toString());
    }
}
