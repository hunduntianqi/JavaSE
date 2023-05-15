package com.$18_Gather.Demo.$3_SetGatherDemo.$3_TreeSetSortDemo;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        // 创建三个学生对象
        Student student = new Student("李天命", 19, 190.3);
        Student student4 = new Student("夜凌风", 19, 190.3);
        Student student2 = new Student("姜妃棂", 16, 178.2);
        Student student3 = new Student("林潇潇", 16, 177.3);
        // 定义数组存储学生信息
        Student[] array = {student, student3, student2, student4};
        // 自定义比较规则, 匿名内部类形式
        Arrays.sort(array, new Comparator<Student>() {
            @Override
            public int compare(Student o2, Student o1) {
                // 按照年龄大小进行降序排序, 年龄一样, 按照身高进行排序
                double temp = o1.getAge() - o2.getAge();
                temp = temp == 0 ? o1.getHeight() - o2.getHeight() : temp;
                temp = temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;
                if (temp > 0) {
                    return 1;
                } else if (temp < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(array));
        // 自定义比较规则, lambda表达式形式
        Arrays.sort(array, (Student o1, Student o2)-> {
                // 按照年龄大小进行升序排序, 年龄一样, 按照身高进行排序
                double temp = o1.getAge() - o2.getAge();
                temp = temp == 0 ? o1.getHeight() - o2.getHeight() : temp;
                temp = temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;
                if (temp > 0) {
                    return 1;
                } else if (temp < 0) {
                    return -1;
                } else {
                    return 0;
                }
            });
        System.out.println(Arrays.toString(array));
    }
}
