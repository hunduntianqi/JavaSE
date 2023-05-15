package com.$18_Gather.Demo.$3_SetGatherDemo;

import java.util.Collections;
import java.util.TreeSet;

public class $3_TreeSetDemo1 {
    /*
        利用TreeSet集合存储整数并排序
     */
    public static void main(String[] args) {
        // 创建TreeSet集合对象
        TreeSet<Integer> treeSet = new TreeSet<>();
        // 集合添加数据
        Collections.addAll(treeSet, 1, 5, 8, 2, 4, 3, 9, 13, 21, 0);
        // TreeSet集合默认对整数数据进行升序排序
        System.out.println(treeSet);
    }
}
