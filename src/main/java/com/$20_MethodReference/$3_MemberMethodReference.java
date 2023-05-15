package com.$20_MethodReference;

/*
    成员方法引用:
        格式: object_name::member_method_name
        引用其他类成员方法: 其他类对象::方法名
        引用本类成员方法: this::方法名
            注意: 静态方法中无this关键字
        引用父类成员方法: super::方法名
            注意: 静态方法中无super关键字
 */

import java.util.ArrayList;
import java.util.Collections;

public class $3_MemberMethodReference {
    public static void main(String[] args) {
        /*
            需求:
                集合中有一些名字, 按照要求过滤数据
                数据: "张无忌", "周芷若", "赵敏", "张强", "张三丰"
                要求: 只要以张开头, 而且名字是三个字的
         */
        // 1. 创建集合
        ArrayList<String> listName = new ArrayList<>();
        Collections.addAll(listName, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        // 2. 过滤数据
        // stream流过滤数据
        listName.stream().filter(s->s.startsWith("张")).filter(s->s.length() == 3).forEach(s -> System.out.println(s));
        System.out.println("=================");
        // 其他类成员方法方法引用
        // 创建测试类对象
        TestClass1 test1 = new TestClass1();
        listName.stream().filter(test1::filter).forEach(s -> System.out.println(s));
    }
    public boolean filter (String str) {
        return str.startsWith("张") && str.length() == 3;
    }
}

class TestClass1 {
    // 定义成员方法, 按照需求过滤数据
    public boolean filter (String str) {
        return str.startsWith("张") && str.length() == 3;
    }
}
