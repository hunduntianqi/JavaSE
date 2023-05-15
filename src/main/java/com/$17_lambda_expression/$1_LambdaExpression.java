package com.$17_lambda_expression;

import java.util.Arrays;

/*
    lambda表达式:
        JDK8开始后的一种新的语法形式
        作用:简化匿名内部类的代码写法
        lambda表达式的简化格式:
            (匿名内部类被重写方法的形参列表) -> {
                被重写方法的方法体代码;
            }
            注: -> 是语法形式, 无实际含义
        注意:lambda表达式只能简化函数式接口的匿名内部类的写法形式
        函数式接口:
            1. 必须是接口
            2. 有且仅有一个抽象方法
            3. 通常会在接口上加上一个@FunctionalInterface, 标记该接口必须满足函数式接口
 */
public class $1_LambdaExpression {
    public static void main(String[] args) {
        Integer[] array = {2, 3, 5, 8, 9, 1, 0, 7, 4, 6};
        // 重写Arrays中的比较器对象
        Arrays.sort(array, (o1,o2)-> o1 - o2);
        System.out.println(Arrays.toString(array));
    }
}
