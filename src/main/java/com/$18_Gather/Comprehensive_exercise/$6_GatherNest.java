package com.$18_Gather.Comprehensive_exercise;

/*
    集合嵌套 ==> Map集合案例:
        要求:
            定义一个Map集合, 键表示省份名称, 值表示市名称, 但是市存在多个
            数据添加完毕后, 遍历结果如下:
                江苏省 = 南京市, 扬州市, 苏州市, 无锡市, 常州市
                湖北省 = 武汉市, 孝感市, 十堰市, 宜昌市, 鄂州市
                河北省 = 石家庄市, 唐山市, 邢台市, 保定市, 张家口市
 */

import java.util.*;

public class $6_GatherNest {
    public static void main(String[] args) {
        // 创建一个Map集合
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        // 创建ArrayList集合存储市信息
        ArrayList<String> jiangsuCity = new ArrayList<>();
        Collections.addAll(jiangsuCity, "南京市", "扬州市", "苏州市", "无锡市", "常州市");
        ArrayList<String> hubeiCity = new ArrayList<>();
        Collections.addAll(hubeiCity, "武汉市", "孝感市", "十堰市", "宜昌市", "鄂州市");
        ArrayList<String> hebeiCity = new ArrayList<>();
        Collections.addAll(hebeiCity, "石家庄市", "唐山市", "邢台市", "保定市", "张家口市");
        // mpa集合添加数据
        map.put("江苏省", jiangsuCity);
        map.put("湖北省", hubeiCity);
        map.put("河北省", hebeiCity);
        Set<Map.Entry<String, ArrayList<String>>> entries = map.entrySet();
        for (Map.Entry<String, ArrayList<String>> entry : entries) {
            // 获取省份名
            String key = entry.getKey();
            // 获取存储市名的集合
            ArrayList<String> value = entry.getValue();
            StringJoiner sj = new StringJoiner(", ", "", "");
            // 遍历市名, 拼接字符串
            for (String cityName : value) {
                sj.add(cityName);
            }
            System.out.println(key + " = " + sj);
        }
    }
}
