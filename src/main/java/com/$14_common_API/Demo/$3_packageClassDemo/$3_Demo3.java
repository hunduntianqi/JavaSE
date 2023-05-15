package com.$14_common_API.Demo.$3_packageClassDemo;

public class $3_Demo3 {
    // 定义方法, 实现toBinaryString方法的效果, 将一个十进制整数转成字符串表示的二进制
    public static void main(String[] args) {
        System.out.println(myToBinaryString(123));
        System.out.println(Integer.toBinaryString(123));
    }
    
    public static String myToBinaryString (int num) {
        StringBuilder sb = new StringBuilder();
        // 转换逻辑: 不断除以2, 得到余数, 直到商为0, 然后将余数倒着拼接起来
        while(true) {
            if (num == 0) {
                break;
            }
            // 定义变量存储余数
            int remainder = num % 2;
            sb.insert(0, remainder);
            // 将num除以二, 并将商赋值给num
            num = num / 2;
        }
        return sb.toString();
    }
}
