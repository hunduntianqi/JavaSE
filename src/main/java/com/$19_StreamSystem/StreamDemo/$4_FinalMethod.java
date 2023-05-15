package com.$19_StreamSystem.StreamDemo;

/*
    终结方法示例
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class $4_FinalMethod {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<String> list = new ArrayList<>();
        // 集合添加元素
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山",
                "张良", "张无忌", "王二麻子", "张无忌", "张翠山", "谢广坤");
        // forEach ==> 遍历
        list.stream().distinct().forEach(name -> System.out.println(name));
        System.out.println("===============================");
        // count ==> 统计流中数据的个数
        System.out.println(list.stream().count());
        System.out.println("===============================");
        // toArray ==> 将Stream流转换为数组
        // 空参toArray()
        Object[] objArray = list.stream().distinct().toArray();
        System.out.println(Arrays.toString(objArray));
        // 指定数据类型数组转换
        String[] arrayEmpty = {};
        String[] array = list.stream().distinct().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(array));
        System.out.println("===============================");
        // collect(Collector collector) ==> 将Stream流转换为集合
        List<String> listSwitch =  list.stream().filter(name -> name.startsWith("张")).collect(Collectors.toList());
        System.out.println(listSwitch.getClass());
    }
}
