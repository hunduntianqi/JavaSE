package com.$15_DateClass.Demo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class $1_Demo1 {
    // 分别使用JDK7时间类和JDK8时间类计算自己活了多少天
    public static void main(String[] args) {
        JDK7DateClass();
        JDK8DateClass();
    }
    
    public static void JDK7DateClass() {
        // 规则: 使用JDK7时间类进行计算或者判断, 需要先获取当前时间的毫秒值
        // 获取当前时间的毫秒值
        long nowMillis = System.currentTimeMillis();
        // 指定时间获取时间毫秒值
        Date birthDayMillis = new Date("1998/2/24 06:00:00");
        long timeGap = nowMillis - birthDayMillis.getTime();
        // 计算天数
        double dayNum = timeGap / 1000 / 60 / 60 / 24.0;
        System.out.println("你从出生到现在一共过了:%.2f天".formatted(dayNum));
    }
    
    public static void JDK8DateClass() {
        // 创建当前时间对象
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        // 指定时间获取时间对象
        LocalDateTime localDateTimeBirthDay = LocalDateTime.of(1998, 2, 24, 6, 0, 0);
        // 使用ChronoUnit获取时间差异
        System.out.println("你从出生到现在过了%s天".formatted(ChronoUnit.DAYS.between(localDateTimeBirthDay, localDateTimeNow)));
    }
}
