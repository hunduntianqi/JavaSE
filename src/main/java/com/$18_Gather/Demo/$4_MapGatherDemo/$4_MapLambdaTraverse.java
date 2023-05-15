package com.$18_Gather.Demo.$4_MapGatherDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/*
    lambda表达式遍历集合
 */
public class $4_MapLambdaTraverse {
    public static void main(String[] args) {
        // 创建Map集合, 规定key-value均为String
        Map<String, String> map = new HashMap();
        // 添加数据
        map.put("斗破苍穹", "天蚕土豆");
        map.put("武动乾坤", "天蚕土豆");
        map.put("大主宰", "天蚕土豆");
        map.put("遮天", "辰东");
        map.put("完美世界", "辰东");
        map.put("仙武帝尊", "六界三道");
        map.put("永恒之门", "六界三道");
        System.out.println(map);
        // 匿名内部类形式遍历集合
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + ":" + value);
            }
        });
        System.out.println("==============================");
        // lambda表达式遍历集合
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
