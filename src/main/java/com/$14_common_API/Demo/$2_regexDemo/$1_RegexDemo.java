package com.$14_common_API.Demo.$2_regexDemo;

public class $1_RegexDemo {
    public static void main(String[] args) {
        // 验证手机号
        System.out.println(checkPhoneNum(17320101759L)); // true
        System.out.println(checkPhoneNum(107320101759L)); // false
        System.out.println("==============================");
        // 验证电话号
        System.out.println(checkTelephone("020-55234"));
        System.out.println(checkTelephone("120-55234"));
        System.out.println(checkTelephone("020-052348456"));
        System.out.println("==============================");
        // 验证邮箱
        System.out.println(checkEmail("1729992141@qq.com"));
        System.out.println(checkEmail("17320101759@163.com"));
    }
    
    // 定义方法验证手机号
    public static boolean checkPhoneNum (long numPhone) {
        // 指定匹配规则
        // 手机号第一位: 手机号码只能以1开头
        // 手机号第二位: 只能是3~9之间
        // 手机号码3-11位: 可以是任意数字
        String regex = "1[3-9]\\d{9}";
        boolean flag = "%s".formatted(numPhone).matches(regex);
        return flag;
    }
    
    // 定义方法验证电话号码
    public static boolean checkTelephone (String telephone) {
        // 座机号码
        // 区号: 0\\d{2,3}
        String regex = "0\\d{2,3}.?[1-9]\\d{4,9}";
        boolean flag = telephone.matches(regex);
        return flag;
    }
    
    // 定义方法验证邮箱号码
    public static boolean checkEmail (String email) {
        // 定义正则表达式
        // \\w+: 表示任意字母数字下划线至少出现一次
        // @: 必须有且只能有一次
        // [\\w&&[^_]]{2,6}: 任意的字母数字, 出现2-6次
        String regex = "\\w+@[\\w&&[^_]]{2,6}\\.[a-zA-Z]{2,3}";
        boolean flag = email.matches(regex);
        return flag;
    }
}
