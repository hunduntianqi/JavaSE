package com.$21_ExceptionHandling;

/*
    需求:
        键盘录入自己心仪的女朋友姓名和年龄
        姓名的长度在3-10之间
        年龄的范围在18-40岁之间
        超出这个范围的是异常数据不能赋值, 需要重新录入, 一直录到正确为止
    提示:
        需要考虑用户在键盘录入时的所有情况
        比如: 录入年龄时超出范围, 录入了abc等情况
 */

import java.util.Scanner;

public class $2_ExceptionDemo {
    public static void main(String[] args){
        // 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        // 定义布尔变量, 控制循环运行
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("请输入您女朋友的姓名: ");
                String name = sc.next();
                if (name.length() < 3 || name.length() > 10) {
                    throw new RuntimeException("姓名长度不合法");
                } else {
                    System.out.println("姓名:" + name + "合法");
                    System.out.println("请输入您女朋友的年龄: ");
                    int age = Integer.parseInt(sc.next());
                    if (age >= 18 && age <= 40) {
                        System.out.println("年龄:" + age + "合法");
                        flag = false;
                    } else {
                        throw new RuntimeException("年龄不合法");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
