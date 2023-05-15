package com.$15_DateClass;

/*
    Date时间类:
        用来描述时间, 精确到毫秒
        利用空参构造创建的对象, 默认表示系统当前时间
        利用有参构造创建的对象, 表示指定的时间
        public void setTime(long time): 设置 / 修改时间对象的时间毫秒值
        public long getTime(): 获取时间对象的时间毫秒值
 */

import java.util.Date;

public class $1_JDK7Date {
    public static void main(String[] args) {
        // 空参构造创建Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        // 利用有参构造创建Date对象
        Date date2 = new Date("1971/1/1 00:00:00");
        System.out.println(date2);
        // 指定时间毫秒值获取时间对象
        Date date3 = new Date(1000000000000000000L);
        System.out.println(date3);
        System.out.println(date1.getTime());
        System.out.println(date2.getTime());
        date1.setTime(1000000000000L);
        System.out.println(date1);
        System.out.println(date1.getTime());
    }
}
