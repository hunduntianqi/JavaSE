package com.$19_StreamSystem.StreamDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class $2_GetStream {
    public static void main(String[] args) {
        // a. 单列集合获取stream流
        // 创建集合
        Collection<String> list = new ArrayList();
        // 集合添加元素
        Collections.addAll(list, "a", "b", "c", "d");
        // 获取Stream流
        Stream<String> streamList = list.stream();
        streamList.forEach(data -> System.out.print(data + ", "));
        System.out.println("\n================================");
        // b. 数组获取Stream流
        // 静态初始化创建数组
        int[] arrayInt = {1, 3, 5, 8};
        // 获取数组Stream流
        IntStream streamArray = Arrays.stream(arrayInt);
        streamArray.forEach(num -> System.out.print(num + ", "));
        System.out.println();
    }
}
