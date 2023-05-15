package com.$18_Gather.Demo.$4_MapGatherDemo;

import java.util.HashMap;
import java.util.Map;

public class $1_MapGatherAPIDemo {
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
        map.put("永恒之门", "六界"); // 键重复, 会覆盖原来的数据
        System.out.println(map);
        // 删除数据
        map.remove("永恒之门");
        System.out.println(map);
        // 判断集合是否包含指定的键
        System.out.println("集合中是否包含‘仙武帝尊’的键:" + map.containsKey("仙武帝尊"));
        System.out.println("集合中是否包含‘永恒之门’的键:" + map.containsKey("永恒之门"));
        // 判断集合是否包含指定的值
        System.out.println("集合中是否包含‘辰东’的值:" + map.containsValue("辰东"));
        System.out.println("集合中是否包含‘天蚕土豆’的值:" + map.containsValue("天蚕土豆"));
        System.out.println("集合中是否包含‘风青阳’的值:" + map.containsValue("风青阳"));
        // 判断集合是否为空
        System.out.println("集合是否为空:" + map.isEmpty());
        // 返回集合中键值对的个数
        System.out.println("集合中元素的个数为:" + map.size());
        // 清空集合
        map.clear();
        System.out.println("集合中元素的个数为:" + map.size());
    }
}
