package com.$18_Gather;
/*
    Map双列集合:
        双列集合: 元素以键值对形式存在, 键不能重复, 值可以重复
        Map是双列集合的顶层接口, 它的功能是全部双列集合都可以使用的
        Map集合常用方法:
            V put(K key, V value): 添加元素, 如果键不存在, 直接添加数据;
                                   如果键已经存在, 会覆盖原来的键值对, 并返回被覆盖的值
            V remove(Object key): 根据键删除元素
            void clear(): 删除集合中所有的键值对元素
            boolean containsKey(Object key): 判断集合是否包含指定的键
            boolean containsValue(Object value): 判断集合是否包含指定的值
            boolean isEmpty(): 判断集合是否为空
            int size(): 集合长度, 即集合中键值对的个数
        Map集合遍历方式:
            1. 键找值遍历:
                a. Set<V> keySet = map.keySet(): 会将所有的键名存入一个Set集合中
                b. 遍历Set集合, 通过get(key)方法获取值
            2. 依次获取键值对:
                a. Set<V> keyValueSet = map.entrySet(): 获取所有的键值对对象, 存入Set集合
                b. 根据getKey()和getValue()方法获取键值数据
            3. lambda表达式遍历:
                default void forEach(BiConsumer<? super K, ? super V> action): 集合lambda遍历集合
    Map集合接口实现类:
        HashMap集合:
            特点: 无序, 不重复, 无索引
            底层是哈希表结构的, 依赖hashCode和equals方法保证键的唯一性
            如果键存储的是自定义对象, 需要重写hashCode和equals方法;
            如果值存储自定义对象, 不需要重写hashCode和equals方法
        LinkedHashMap集合:
            是HashMap的子类
            特点: 由键决定, 有序, 不重复, 无索引
            底层是哈希表结构, 每个键值对元素又额外多出一个双链表的机制记录存储的顺序
        TreeMap集合:
            底层是基于红黑树实现的
            特点: 由键决定, 不重复, 无索引, 可排序
            排序规则: 对键进行排序, 默认按照键从小到大排序
            自定义排序规则:
                1. 自定义类型实现Comparable接口, 指定比较规则
                2. 创建集合时通过有参构造传递Comparator比较器对象, 指定比较规则
                当两种比较规则均存在时, 默认使用集合有参构造器自定义比较规则

 */
public class $2_MapGather {
}
