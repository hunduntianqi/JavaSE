package com.$18_Gather.Demo.$4_MapGatherDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
    键找值遍历
 */
public class $2_MapKeyToValueTraverse {
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
        // 获取存储键名的Set集合
        Set<String> keySet = map.keySet();
        // lambda表达式遍历keySet集合
        keySet.forEach(key -> System.out.println(key + ":" + map.get(key)));
        System.out.println("==============================");
        // 增强for遍历集合
        for (String key : keySet) {
            System.out.println(key + ":" + map.get(key));
        }
        System.out.println("==============================");
        // 迭代器遍历集合
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            System.out.println(key + ":" + map.get(key));
        }
    }
}
