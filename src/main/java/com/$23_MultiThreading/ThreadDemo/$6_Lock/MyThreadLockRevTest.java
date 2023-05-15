package com.$23_MultiThreading.ThreadDemo.$6_Lock;

public class MyThreadLockRevTest {
    public static void main(String[] args) {
        // 创建MyThreadLockRev对象
        MyThreadLockRev myThreadLockRev1 = new MyThreadLockRev();
        MyThreadLockRev myThreadLockRev2 = new MyThreadLockRev();
        MyThreadLockRev myThreadLockRev3 = new MyThreadLockRev();
        // 设置线程名称
        myThreadLockRev1.setName("Windows one");
        myThreadLockRev2.setName("Windows two");
        myThreadLockRev3.setName("Windows three");
        // 启动子线程
        myThreadLockRev1.start();
        myThreadLockRev2.start();
        myThreadLockRev3.start();
    }
}
