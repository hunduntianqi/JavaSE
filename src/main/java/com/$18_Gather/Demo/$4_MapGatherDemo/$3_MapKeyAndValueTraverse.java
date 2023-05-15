package com.$18_Gather.Demo.$4_MapGatherDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
    键值对遍历
 */
public class $3_MapKeyAndValueTraverse {
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
        // 获取所有的键值对对象
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        // 增强for遍历集合
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("=====================================");
        // lambda表达式遍历集合
        entrySet.forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
        System.out.println("=====================================");
        // 迭代器遍历
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>)iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
