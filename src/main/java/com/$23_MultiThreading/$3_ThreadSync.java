package com.$23_MultiThreading;

/*
    线程同步:
        数据安全问题:
            java中线程的执行是具有随机性的, 在执行过程中可能会因为丢失CPU的执行权, 从而导致出现异常
            安全问题出现的条件:
                a. 在多线程环境下
                b. 存在多个线程共享的数据
                c. 有多条代码语句操作共享数据
        同步代码块:
            可以把操作共享数据的代码锁起来, 保证同一时刻只有一个线程可以操作数据
            格式:
                synchronized (Lock_Object) {
                    操作共享数据的代码
                }
            注意:
                1. 锁默认打开, 当有一个线程操作共享数据时, 锁会自动关闭
                2. 当一个线程操作共享数据的所有代码执行完毕后, 锁才会自动打开
                3. 锁对象可以是任意的对象, 但必须保持唯一, 可以使用static关键字进行修饰, 或者使用当前类的字节码文件对象(类名.class)
        同步方法:
            使用synchronized关键字修饰的方法
            格式:
                修饰符 synchronized 返回值类型 方法名(方法参数) {...}
            特点:
                1. 同步方法会锁住方法内的所有代码
                2. 锁对象不能自己指定
                    非静态方法 ==》this(方法调用者)
                    静态方法 ==》 当前类的字节码文件对象
        Lock锁:
            提供了获得锁和释放锁的方法, 可以让程序员自己手动上锁和释放锁
            void lock(): 获得锁 ==> 加锁
            void unlock(): 释放锁
            注意:
                Lock是一个接口, 不能直接实例化, 使用其实现类ReentrantLock来实例化
                构造方法 ==> ReentrantLock() ==> 创建一个ReentrantLock对象
        注意:
            千万要避免锁嵌套问题, 因为极有可能造成死锁！！！
 */
public class $3_ThreadSync {
}
