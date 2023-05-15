package com.$15_DateClass;
/*
    SimpleDateFormat:
        时间格式化: 将时间字符串变成我们喜欢的格式
        解析时间字符串: 将时间字符串变成 Date 对象
        构造方法:
            public SimpleDateFormat(): 使用默认格式, 创建一个SimpleDateFormat对象
            public SimpleDateFormat(String pattern): 使用指定格式创建一个SimpleDateFormat对象
            常用时间格式化对应关系:
                y-年; M-月; d-日; H-时; m-分; s-秒
        public final String format(Date date): 将日期对象格式化为时间字符串
        public Date parse (String source): 将时间字符串解析为日期对象
            注意: 解析日期对象时, 时间字符串格式必须与格式化对象格式完全一致
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class $2_SimpleDateFormat {
    public static void main(String[] args) throws Exception {
        // 创建默认格式的SimpleDateFormat对象 ==> 2022/9/29 下午9:48
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date d = new Date();
        String strDate = sdf.format(d);
        System.out.println(strDate);
        // 指定格式创建SimpleDateFormat
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate2 = sdf1.format(d);
        System.out.println(strDate2);
        String dateStr = "1998-02-24 06:00:00";
        Date date = sdf1.parse(dateStr);
        System.out.println(date);
        
        // 小练习
        String strDate3 = "2000-11-11";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf2.parse(strDate3);
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(sdf3.format(date1));
    }
}
