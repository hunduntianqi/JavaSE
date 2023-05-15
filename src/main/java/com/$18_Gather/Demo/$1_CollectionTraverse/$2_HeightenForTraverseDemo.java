package com.$18_Gather.Demo.$1_CollectionTraverse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
    增强for遍历集合
 */
public class $2_HeightenForTraverseDemo {
    public static void main(String[] args) {
        // 创建Collection系列集合
        Collection<String> list = new ArrayList<>();
        Collections.addAll(list, "三", "连", "外", "加", "转", "发", "了", "吗", "?");
        // 增强for遍历集合
        for (String list1 : list) {
            System.out.print(list1 + " ");
        }
        System.out.println();
    }
}
