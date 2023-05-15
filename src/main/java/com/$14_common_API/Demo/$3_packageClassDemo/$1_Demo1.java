package com.$14_common_API.Demo.$3_packageClassDemo;

import java.util.ArrayList;
import java.util.Scanner;

public class $1_Demo1 {
    /*
        键盘录入一些1-100的整数, 存入集合中, 直到集合中的数据和超过200为止
     */
    public static void main(String[] args) {
        // 创建集合存储整数数据
        ArrayList<Integer> list = new ArrayList<>();
        // 创建Scanner对象接收键盘录入数据
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 定义变量存储集合数据之和
            int sum = 0;
            System.out.println("请输入一个1-100之间的整数:");
            String numStr = sc.nextLine();
            // 将获取的字符串数字转换为int类型
            int num = Integer.parseInt(numStr);
            // 判断数字是否符合条件
            if (num < 1 || num > 100) {
                System.out.println("输入数据不符合条件, 请输入1-100的整数！！");
                continue;
            }
            list.add(num);
            // 遍历集合, 将集合中数据相加, 判断是否大于200
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            if (sum > 200) {
                System.out.println("集合中数据之和为:%s".formatted(sum));
                return;
            }
        }
    }
}
