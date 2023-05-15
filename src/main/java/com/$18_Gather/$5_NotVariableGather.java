package com.$18_Gather;
/*
    不可变集合:
        集合的数据在创建的时候提供, 并且在整个生命周期中都不可改变
        为何使用不可变集合:
            1. 如果某个数据不可被修改, 把它防御性的拷贝到不可变集合是一个很好的实践
            2. 当集合对象被不可信的库调用时, 不可变形式是安全的
        创建不可变集合:
            在List, Set, Map集合接口中存在of方法, 可以创建一个不可变集合
            1. static <E> List<E> of(E...elements): 创建一个具有指定元素的List集合对象
            2. static <E> Set<E> of(E...elements): 创建一个具有指定元素的Set集合对象
            3. static <K, V> Map<K, V> of(E...elements): 创建一个具有指定元素的Map集合对象
                注意: 该方法创建的不可变Map集合中最多只能添加 10 对 键值对
 */

import java.util.List;
import java.util.Map;
import java.util.Set;

public class $5_NotVariableGather {
    public static void main(String[] args) {
        // 创建不可变List集合
        List<Integer> list = List.of(569, 700, 630, 512, 484);
        // list.add(600); // 不可变集合数据在创建集合后不能再发生改变
        // 遍历List集合
        list.forEach(i -> System.out.println(i));
        System.out.println("===========================");
        // 创建不可变Set集合
        Set<String> set = Set.of("郭鹏涛", "郭鹏强", "郭会军", "任杏好");
        set.forEach(str -> System.out.println(str));
        System.out.println("===========================");
        // 创建不可变Map集合
        Map<String, String> map = Map.of("斗破苍穹", "萧炎", "武动乾坤", "林动", "大主宰", "牧尘");
        map.forEach((book, actor) -> System.out.println(book + ":" + actor));
    }
}
