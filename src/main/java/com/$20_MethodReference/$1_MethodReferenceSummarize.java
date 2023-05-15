package com.$20_MethodReference;

/*
    方法引用:
        把已经有的方法拿过来用, 当作函数式接口中抽象方法的方法体
        方法引用实现条件:
            1. 引用处必须是函数式接口
            2. 被引用的方法必须是已经存在的方法
            3. 被引用方法的形参和返回值需要和抽象方法保持一致
            4. 被引用方法的功能要满足当前需求
        :: ==> 方法引用符, class_name::method_name ==> 引用对应类的对应静态方法
        方法引用的分类:
            1. 引用静态方法
            2. 引用成员方法
                a. 引用其他类的成员方法
                b. 引用本类的成员方法
                c. 引用父类的成员方法
            3. 引用构造方法
 */

import java.util.Arrays;
import java.util.Comparator;

public class $1_MethodReferenceSummarize {
    public static void main(String[] args) {
        // 需求: 创建一个数组, 进行倒序排序
        Integer[] array = {3, 5, 4, 1, 6, 2};

        // 匿名内部类实现排序
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(array));
        System.out.println("====================");

        // Lambda表达式实现排序
        Arrays.sort(array, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(array));
        System.out.println("====================");

        // 方法引用实现排序
        Arrays.sort(array, $1_MethodReferenceSummarize::subtraction);
        System.out.println(Arrays.toString(array));
    }

    // 创建方法, 测试方法引用
    public static int subtraction(int num1, int num2) {
        return num2 - num1;
    }
}
