package com.$18_Gather;

/*
    可变参数:
        指可接收形参个数不定的参数
        定义格式:
            public return_type func_name (data_type...args) {
            }
            return_type ==> 函数返回值类型
            data_type ==> 可变参数类型
            ...args ==> 可变参数定义格式, args为参数名, 本质为一个数组
        注意:
            a. 一个方法形参中只能定义一个可变参数
            b. 可变参数必须定义在形参列表的最后位置
 */

public class $6_VariableParameter {
    public static void main(String[] args) {
        // 调用方法传参
        sum(1, 2, 3);
    }

    // 定义方法验证可变参数
    public static void sum(int... num) {
        int sum = 0;
        if (num.length != 0) {
            for (int i : num) {
                sum += i;
            }
        }

        System.out.println("数据求和结果为 ==> %s".formatted(sum));
    }
}
