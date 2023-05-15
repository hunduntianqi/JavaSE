package com.$18_Gather.Demo.$1_CollectionTraverse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
/*
    迭代器遍历集合
 */

public class $1_IteratorTraverseDemo {
    public static void main(String[] args) {
        // 创建Collection系列集合
        Collection<String> list = new ArrayList<>();
        Collections.addAll(list, "三", "连", "外", "加", "转", "发", "了", "吗", "?");
        // 获取迭代器对象
        Iterator<String> iterator = list.iterator();
        // 迭代器遍历集合
        // hasNext(): 判断当前索引是否存在元素, 存在返回true, 可作为循环判断条件
        while (iterator.hasNext()) {
            // next(): 获取当前索引元素, 并将索引移向下一个位置
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
//        System.out.println(iterator.next());  获取所有元素后, 再获取元素会发生 NoSuchElementException
    }
}
