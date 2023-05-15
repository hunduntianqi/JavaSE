package com.$23_MultiThreading.ThreadDemo.$3_ImplementCallableInterface;

import java.util.concurrent.FutureTask;

public class TestMyCallable {
    public static void main(String[] args) throws Exception {
        // 创建MyCallable对象
        MyCallable myCallable = new MyCallable();
        // 创建FutureTask对象
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        // 创建Thread对象
        Thread thread = new Thread(futureTask);
        // 启动子线程
        thread.start();
        // 获取返回结果
        String result = futureTask.get();
        System.out.println(result);
    }
}
