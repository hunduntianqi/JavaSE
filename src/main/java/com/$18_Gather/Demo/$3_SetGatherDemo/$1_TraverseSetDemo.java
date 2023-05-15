package com.$18_Gather.Demo.$3_SetGatherDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class $1_TraverseSetDemo {
    public static void main(String[] args) {
        // 创建Set系列集合
        Set<String> listSet = new HashSet<>();
        listSet.add("你好");
        listSet.add("我是郭鹏涛");
        listSet.add("混沌天炁");
        
        // 迭代器遍历
        iteratorTraverse(listSet);
        // 增强for遍历
        forTraverse(listSet);
        // lambda表达式遍历
        lambdaTraverse(listSet);
    }
    
    public static void iteratorTraverse(Set<String> listSet) {
        // 获取迭代器
        Iterator<String> listIterator = listSet.iterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next());
        }
        System.out.println();
    }
    
    public static void forTraverse(Set<String> listSet) {
        for (String s : listSet) {
            System.out.print(s);
        }
        System.out.println();
    }
    
    public static void lambdaTraverse(Set<String> listSet) {
        listSet.forEach(s -> System.out.print(s));
        System.out.println();
    }
}
