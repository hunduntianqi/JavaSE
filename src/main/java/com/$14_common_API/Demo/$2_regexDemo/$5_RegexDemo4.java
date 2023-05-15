package com.$14_common_API.Demo.$2_regexDemo;

public class $5_RegexDemo4 {
    public static void main(String[] args) {
//        checkUserName();
        checkIdCard();
    }
    
    // 定义方法使用正则表达式验证用户名
    public static void checkUserName () {
        // 要求: 大小写字母数字下划线, 4-16位
        // 定义匹配规则
        String regex = "\\w{4,16}";
        System.out.println("17320101759".matches(regex)); // true
        System.out.println("17320101759Gpt08".matches(regex)); // true
        System.out.println("17320101759Gpt081".matches(regex)); // false
    }
    
    // 定义方法使用正则表达式验证身份证号码
    public static void checkIdCard() {
        // 要求一: 18位, 前17位是任意数字, 最后一位可以是大写或小写x
        String regex = "[1-9]\\d{16}[Xx0-9]";
        System.out.println("410329200010110011".matches(regex));
        // 要求二: 按照身份证号码的格式严格要求
        // 前面六位: 表示省份, 市区, 派出所等信息, 第一位不能是0, 后面五位是任意数字
        // 7, 8两位表示年的前半段: 18， 19， 20
        // 9, 10两位表示年的后半段: 00-99, 任意数字
        // 11, 12两位表示月份: 01-09, 10, 11, 12
        // 13, 14两位表示日期: 01-31
        // 后面4位: 前三位是任意数字, 最后一位: 可以是数字, 也可以是大写或小写x
//        String regex2 = "[1-9]\\d{5}[12][890]\\d{2}[01]\\d[0123]\\d{4}([0-9]|(?i)x)";
        String regex2 = "[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[1-9]|3[01])" +
                "\\d{3}([0-9]|(?i)x)";
        System.out.println("41032920001011001x".matches(regex2));
        System.out.println("410329199802240011".matches(regex2));
        System.out.println("010329199802240011".matches(regex2));
        System.out.println("410329179802240011".matches(regex2));
        System.out.println("410329199813240011".matches(regex2));
        System.out.println("410329199802240011".matches(regex2));
    }
}
