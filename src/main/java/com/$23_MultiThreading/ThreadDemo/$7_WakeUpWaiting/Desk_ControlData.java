package com.$23_MultiThreading.ThreadDemo.$7_WakeUpWaiting;

// 定义桌子类, 代表第三方, 控制生产者和消费者数据交换以及是否等待判断, 继承Thread类
public class Desk_ControlData {
    /**
     * 作用: 控制生产者和消费者的执行
     */
    // 定义变量, 记录第三方状态
    // 1: 桌子上有面条, 吃货可以直接开吃, 无需等待
    // 0: 桌子上没有面条, 吃货需要等待厨师制作面条
    public static int foodFlag = 0;

    // 定义变量, 规定吃货最多可以吃的面条数量
    public static int count = 10;

    // 定义一个锁对象
    public static Object lock = new Object();
}
