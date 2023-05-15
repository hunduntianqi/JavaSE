package com.$15_DateClass;

/*
    Calendar:
        代表了系统当前时间的日历对象, 可以单独修改, 获取时间中的年, 月, 日
        细节: Calendar是一个抽象类, 不能直接创建对象
        获取当前时间的日历对象:
            public static Calendar getInstance(): 获取当前时间的日历对象
        常用方法:
            public final static getTime(): 获取日期对象
            public final setTime(Date date): 给日历设置日期对象
            public long getTimeInMillis(): 获取时间毫秒值
            public void setTimeInMillis(long millis): 给日历设置时间毫秒值
            public int get(int field): 获取日历中某个字段的信息
            public void set(int field, int value): 修改日历的某个字段信息
            public void add(int field, int amount): 为某个字段增加 / 减少指定的值
*/

import java.util.Calendar;
import java.util.Date;

public class $3_Calendar {
    public static void main(String[] args) {
        // 获取当前时间的日历对象
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        // 月份范围为 0-11, 获取的月份加一才是实际的月份
        System.out.println(calendar.get(Calendar.MONTH) + 1 + "月");
        // 星期是从周日到周六, 分别对应1-7, 获取的数字减一, 才是正确的本周的第几天
        System.out.println("周" + (calendar.get(Calendar.DAY_OF_WEEK) - 1));
        // 获取时间毫秒值
        System.out.println(calendar.getTimeInMillis());
        // 修改日期代表的时间
        Date date = new Date(0L);
        calendar.setTime(date);
        System.out.println(calendar);
    }
}
