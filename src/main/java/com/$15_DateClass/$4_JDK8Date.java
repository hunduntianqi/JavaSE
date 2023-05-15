package com.$15_DateClass;

/*
    JDK8新增时间相关类:
        Date类:
            ZoneId: 代表时区
                static Set<String> getAvailableZoneIds(): 获取Java中支持的所有时区
                static ZoneId systemDefault(): 获取系统默认时区
                static ZoneId of(String zoneId): 获取一个指定时区
            Instant: 代表时间戳
                static Instant now(): 获取当前时间的Instant对象(标准时间)
                static Instant ofXxxx(long epochMilli): 根据(秒/毫秒/纳秒)获取Instant对象
                ZoneDateTime atZone(ZoneId zone): 指定时区
                boolean isXxx(Instant otherInstant): 判断系列的方法
                Instant minusXxx(long millisToSubtract): 减少时间系列的方法
                Instant plusXxx(long millisToSubtract): 增加时间系列的方法
            ZoneDateTime: 带时区的时间
                static ZonedDateTime now(): 获取当前时间的 ZonedDateTime 对象
                static ZonedDateTime ofXxx(): 获取指定时间的 ZonedDateTTime 对象
                ZonedDateTime withXxxx(时间): 修改时间系列的方法
                ZonedDateTime minusXxx(时间): 减少时间系列的方法
                ZonedDateTime plusXxx(时间): 增加时间系列的方法
        日期格式化类:
            DateTimeFormatter: 用于时间的格式化和解析
                static DateTimeFormatter ofPattern(格式): 指定格式获取格式化对象
                String format(时间对象): 按照指定方式格式化时间对象
        日历类:
            LocalDate: 年月日
            LocalTime: 时分秒
            LocalDateTime: 年月日时分秒
                static XXX now(): 获取当前时间的对象
                static XXX of(): 获取指定时间的对象
                get开头的方法: 获取年月日时分秒等信息
                isBefore, isAfter: 比较两个LocalDate
                with开头: 修改时间系列
                minus开头: 减少时间系列
                plus开头: 增加时间系列
                public LocalDate toLocalDate: LocalDateTime对象转化为LocalDate对象
                public LocalTime toLocalTime: LocalDateTime对象转化为LocalTime对象
        工具类:
            Duration: 计算时间间隔(秒, 纳秒)
            Period: 计算时间间隔(年月日)
            ChronoUnit: 可计算所有单位的时间间隔
 */

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class $4_JDK8Date {
    public static void main(String[] args) {
        zoneIdShow();
        System.out.println("----------------------------");
        instantShow();
        System.out.println("----------------------------");
        ZonedDateTimeShow();
        System.out.println("----------------------------");
        dateTimeFormatterShow();
        System.out.println("----------------------------");
    }
    
    public static void zoneIdShow () {
        // 获取java支持的所有时区
        Set<String> zoneSet = ZoneId.getAvailableZoneIds();
        System.out.println("java中支持的时区数量为:%s".formatted(zoneSet.size()));
        System.out.println(zoneSet);
        // 获取系统默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        // 获取指定时区
        ZoneId zoneId1 = ZoneId.of("Asia/Pontianak");
        System.out.println(zoneId1);
    }
    
    public static void instantShow() {
        // 获取当前时间的Instant对象
        Instant instantNow = Instant.now();
        System.out.println(instantNow);
        // 获取指定时间的Instant对象
        Instant instant = Instant.ofEpochMilli(0L);
        Instant instant1 = Instant.ofEpochSecond(1);
        Instant instant2 = Instant.ofEpochSecond(1L, 1000000000L);
        System.out.println(instant);
        System.out.println(instant1);
        System.out.println(instant2);
        // 指定时区
        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(time);
        // isXxx 判断
        boolean flag = instant.isBefore(instant1);
        System.out.println("instant表示时间在instant1之前:%s".formatted(flag));
        flag = instant2.isAfter(instant1);
        System.out.println("instant2在instant1之后:%s".formatted(flag));
        // 减少时间
        Instant instant3 = Instant.now().minusSeconds(1000);
        System.out.println(instant3);
        Instant instant4 = Instant.now().minusMillis(1000000);
        System.out.println(instant4);
        Instant instant5 = Instant.now().minusNanos(1000000000);
        System.out.println(instant5);
        // 增加时间
        Instant instant6 = Instant.now().plusSeconds(1000);
        System.out.println(instant6);
        Instant instant7 = Instant.now().plusMillis(1000000);
        System.out.println(instant7);
        Instant instant8 = Instant.now().plusNanos(1000000000);
        System.out.println(instant8);
    }
    
    public static void ZonedDateTimeShow() {
        // 获取当前时间的ZonedDateTime对象
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
        // 指定时间获取ZonedDateTime对象
        ZonedDateTime time1 = ZonedDateTime.of(2022, 9, 30,
                21, 00, 50, 1000000, ZoneId.systemDefault());
        System.out.println(time1);
        // 修改时间 withXxx系列
        ZonedDateTime time2 = ZonedDateTime.now().withHour(13);
        System.out.println(time2);
    }
    
    public static void dateTimeFormatterShow() {
        // 指定格式获取格式化对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EE a");
        // 格式化时间
        String strDate = dtf.format(LocalDateTime.now());
        System.out.println(strDate);
    }
}
