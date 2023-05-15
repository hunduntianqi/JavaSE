package com.$19_StreamSystem;

/*
    Stream流:
        JDK8 以来, 得益于Lambda表达式带来的函数式编程, 引入的全新概念
        目的: 用于简化集合与数组操作的API
    Stream流式思想核心:
        1. 先得到数组或集合的Stream流(类似一根传送带)
        2. 把集合或数组的元素放进Stream流
        3. 通过Stream流的简化API来方便的操作元素
    Stream流的三类方法:
        1. 获取Stream流 ==> 创建一条流水线, 并把数据放到流水线上准备进行操作
            a. Collection集合获取Stream流:
                default Stream<E> stream(): 获取当前单列集合对象的Stream流
            b. 数组获取Stream流:
                b.1: public static<T> Stream<T> stream(T[] array): Arrays工具类中的静态方法获取当前
                        数组的Stream流
                b.2: public static<T> Stream<T> of(T... values): Stream接口中的静态方法获取当前
                        数组 / 可变参数的Stream流, 该方法要求数组中元素必须为引用数据类型
        2. 中间方法 ==> 对元素所做的具体操作, 一次操作完毕后还可以继续进行其他操作
            a. Stream<T> filter(Predicate<? super T> predicate): 过滤符合表达式条件的元素
            b. Stream<T> limit(long maxSize): 获取前几个元素
            c. Stream<T> skip(long n): 跳过前几个元素
            d. Stream<T> distinct(): 元素去重, 依赖hashCode 和 equals 方法
            e. static<T> Stream<T> concat(Stream a, Stream b): 合并 a 和 b两个流为一个流
            f. Stream<R> map(Function<T, R> mapper): 转换流中的数据类型, T -> 指流中数据原本的数据类型
                                                     R -> 指要转换的数据类型
            注意:
                1. 中间方法会返回新的Stream流, 原来的Stream流只能使用一次, 建议使用链式编程
                2. 修改Stream流中的数据, 不会影响原来集合或者数组中的数据
        3. 终结方法 ==> 对元素操作完毕后, 终结Stream流, 一个Stream流只能有一个终结方法
            a. void forEach(Consumer action): 遍历流中数据
            b. long count(): 统计流中数据的个数, 返回 long 类型的整数
            c. toArray(): 将Stream转换为数组
            d. collect(Collector collector): 将Stream流转换为集合
 */
public class $1_StreamSystem {
}
