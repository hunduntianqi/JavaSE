package com.$27_LoggingFramework;

/*
    日志框架LogBack快速体验
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class $2_LogBackQuickExperience {
    // 创建LogBack日志对象, 写在main方法外面, 使用static和final关键字修饰
    public static final Logger LOGGER = LoggerFactory.getLogger("com.$27_LoggingFramework.$2_LogBackQuickExperience.class");

    public static void main(String[] args) {
        // 模拟用户登陆操作, 使用Logger对象记录用户操作
        // 创建Scanner对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String userName = sc.nextLine();
        System.out.println("请输入密码:");
        String passWord = sc.nextLine();
        if (userName.equals("张三") && passWord.equals("123456")) {
            LOGGER.info("用户登陆成功~~~");
        } else {
            System.err.println("用户信息有误, 登陆失败！！"); // System.err ==> 系统的错误输出流, 在控制台输出字体为红色
            LOGGER.error("用户信息有误, 登陆失败！！！");
        }
    }
}
