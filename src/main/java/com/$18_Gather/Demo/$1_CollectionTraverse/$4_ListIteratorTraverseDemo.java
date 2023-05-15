package com.$18_Gather.Demo.$1_CollectionTraverse;
/*
    列表迭代器遍历
 */

import java.util.*;

public class $4_ListIteratorTraverseDemo {
    public static void main(String[] args) {
        // 创建List系列集合
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "三", "连", "外", "加", "转", "发", "了", "吗", "?");
        // 创建列表迭代器
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            // 添加元素
            if (iterator.nextIndex() == list.size() - 1) {
                iterator.add("?");
            }
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println(list);
        // 删除 next() 返回的最后一个元素
        iterator.remove();
        System.out.println(list);
    }
}
