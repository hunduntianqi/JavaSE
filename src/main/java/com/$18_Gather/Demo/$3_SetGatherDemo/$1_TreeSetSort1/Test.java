package com.$18_Gather.Demo.$3_SetGatherDemo.$1_TreeSetSort1;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        // 创建TreeSet对象
        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.add(new Student("李天命", 19));
        treeSet.add(new Student("林潇潇", 15));
        treeSet.add(new Student("姜妃棂", 16));
        treeSet.add(new Student("夜凌风", 14));
        // 遍历集合
        treeSet.forEach(student -> System.out.println(student));
    }
}
