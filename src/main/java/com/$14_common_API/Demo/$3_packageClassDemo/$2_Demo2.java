package com.$14_common_API.Demo.$3_packageClassDemo;

import java.util.Scanner;

public class $2_Demo2 {
    // 定义方法, 实现parseInt()方法的效果
    /*要求:
        字符串中只能是数字, 不能有其他字符, 最少一位, 最多10位, 0不能开头
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数:");
        String  str = sc.nextLine();
        int num = myParseInt(str);
        System.out.println(num);
    }
    
    public static int myParseInt(String str) {
        // 定义正则表达式校验字符串是否符合规则
        String regex = "[1-9]\\d{0,9}";
        // 定义变量存储转换后的数字
        int num = 0;
        if (str.matches(regex)) {
            for (int i = 0; i < str.length(); i++) {
//                int temp = (str.charAt(i) - 48) * (int)Math.pow(10, str.length() - 1 - i);
//                num += temp;
                int temp = str.charAt(i) - '0';
                num = num * 10 + temp;
            }
        } else {
            System.out.println("输入数据不符合规则！！");
            return -1;
        }
        return num;
    }
}
