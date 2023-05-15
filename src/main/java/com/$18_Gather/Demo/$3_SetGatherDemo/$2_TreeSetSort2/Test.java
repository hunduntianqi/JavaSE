package com.$18_Gather.Demo.$3_SetGatherDemo.$2_TreeSetSort2;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        // 创建TreeSet对象, 使用有参构造指定比较器规则
        TreeSet<Student> treeSet = new TreeSet<>((o1, o2) -> o1.getAge() - o2.getAge());
        treeSet.add(new Student("李天命", 19));
        treeSet.add(new Student("林潇潇", 15));
        treeSet.add(new Student("姜妃棂", 16));
        treeSet.add(new Student("夜凌风", 14));
        // 遍历集合
        treeSet.forEach(student -> System.out.println(student));
    }
}
