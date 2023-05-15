package com.$19_StreamSystem.StreamDemo;

/*
    Stream流中间方法示例
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class $3_MiddleMethodDemo {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<String> list = new ArrayList<>();
        // 集合添加元素
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山",
                "张良", "张无忌", "王二麻子", "张无忌", "张翠山", "谢广坤");
        // filter(Predicate<? super T> predicate) ==> 过滤符合条件的元素 ==> 筛选出以'张'开头的名字
        list.stream().filter(name -> name.startsWith("张")).forEach(name -> System.out.println(name));
        System.out.println("==========================================");
        // limit(long maxSize) ==> 获取Stream流前maxSize个元素 ==> 获取Stream流前三个元素
        list.stream().limit(3).forEach(name -> System.out.println(name));
        System.out.println("==========================================");
        // skip(long n) ==> 跳过前n个元素 ==> 跳过前三个元素
        list.stream().skip(3).forEach(name -> System.out.println(name));
        System.out.println("==========================================");
        // distinct() ==> 元素去重, 结合 hashCode 和 equals 方法
        list.stream().distinct().forEach(name -> System.out.println(name));
        System.out.println("==========================================");
        // concat(Stream a, Stream b) ==> 合并两个流为一个流
        Stream.concat(list.stream(), list.stream()).forEach(name -> System.out.println(name));
    }
}
