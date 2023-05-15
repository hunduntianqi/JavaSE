package com.$20_MethodReference;

/*
    静态方法引用:
        格式: class_name::static_method_name
 */

import java.util.ArrayList;
import java.util.Collections;

public class $2_StaticMethodReference {
    /*
        需求:
            集合中有以下数字, 要求把他们都变成int类型
            "1", "2", "3", "4", "5"
     */
    public static void main(String[] args) {
        // 创建集合并添加元素
        ArrayList<String> listStr = new ArrayList<>();
        Collections.addAll(listStr, "1", "2", "3", "4", "5");
        // 方法引用实现需求
        listStr.stream().map(Integer::parseInt).forEach(s -> System.out.println(s + ":" + s.getClass()));
    }
}
