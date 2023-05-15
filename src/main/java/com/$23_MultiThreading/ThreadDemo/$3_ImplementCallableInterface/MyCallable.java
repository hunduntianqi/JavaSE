package com.$23_MultiThreading.ThreadDemo.$3_ImplementCallableInterface;

import java.util.concurrent.Callable;

// 定义MyCallable类实现Callable接口
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("跟女孩表白" + i);
        }
        //返回值就表示线程运行完毕之后的结果
        return "答应";
    }
}
