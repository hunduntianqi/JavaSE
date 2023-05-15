package com.$21_ExceptionHandling;

/*
    异常: 指程序中可能出现的问题
    异常体系:
        Exception: 指异常体系最上层的父类, 代表程序可能出现的问题, 通常会用Exception以及他的子类来封装程序出现的问题
        运行时异常: RuntimeException及其子类, 编译阶段不会出现异常提醒, 运行时出现的异常(如数组索引越界)
        编译时异常: 直接继承于Exception, 编译阶段就会出现异常提醒的, 如日期解析异常
    异常的作用:
        1. 用来查询Bug的关键参考信息
        2. 异常可以作为方法内部的一种特殊的返回值, 以便通知调用者底层的执行情况
    Throwable常用成员方法:
        1. public String getMessage(): 返回此Throwable的详细信息字符串
        2. public String toString(): 返回此可抛出的简短描述
        3. public void printStackTrace(): 把异常的错误信息输出在控制台
    JVM默认异常处理方式:
        1. 默认会在出现异常的代码那里自动的创建一个异常对象: ArithmeticException
        2. 异常会从方法中出现的点这里抛出给调用者, 调用者最终抛出给JVM虚拟机
        3. 虚拟机接收到异常对象后, 先在控制台直接输出异常栈信息数据
        4. 直接从当前执行的异常点干掉当前程序
        5. 后续代码没有机会执行了, 因为程序已经死亡
    抛出异常:
        1. throws: 写在方法定义处, 表示声明一个异常, 告诉调用者, 使用本方法可能会有哪些异常, 编译时异常必须写
        2. throw: 写在方法内, 手动抛出异常对象, 交给调用者, 方法中下面的代码不再执行
            例:
                public void method_name () {
                    throw new NullPointerException();
                }
    编译时异常处理方式:
        1. throws: 用在方法上, 可将方法内部的异常抛出给方法的调用者处理, 如果异常最终抛出给虚拟机,
                   将引起程序死亡
                抛出异常格式:
                    方法 throws 异常1, 异常2, 异常3.. {
                    }
                规范做法:
                    方法 throws Exception {
                    }
        2. try...catch...:
            监视捕获异常, 用在方法内部, 可以将方法内部的异常直接捕获处理, 程序可以继续向下执行
            格式:
                try{
                    监视可能出现异常的代码
                } catch (异常类型1 变量) {
                    // 处理异常
                } catch(异常类型2 变量) {
                    // 处理异常
                }
            建议格式:
                try {
                    // 可能出现异常的代码
                } catch (Exception e) {
                    e.printStackTrace(); // 直接打印异常栈信息
                }
        3. 1&2结合:
            3.1 方法将异常通过throws抛出给调用者
            3.2 调用者收到异常后直接捕获处理
        在开发中按照规范来说第三种方式是最好的：底层的异常抛出去给最外层，最外层集中捕获处理
    自定义异常:
        必要性:java无法为世界上全部的问题提供异常类
        优点:
            1. 可以使用异常的机制管理业务问题
            2. 出现bug时, 可以用异常的形式清晰指出出错的地方
        分类:
            1. 自定义编译时异常:
                1.1 定义一个异常类继承Exception
                1.2 重写构造器
                1.3 在出现异常的地方用throw new 自定义对象抛出
                作用: 编译时异常编译阶段就报错, 提醒更加强烈, 一定需要处理
            2. 自定义运行时异常:
                2.1 定义一个异常类继承RuntimeException
                2.2 重写构造器
                2.3 在出现异常的地方用throw new 自定义对象抛出
                作用: 提醒不强烈, 编译阶段不报错, 运行时才可能出现
 */

public class $1_ExceptionHandlingSummarize {
    public static void main(String[] args) {
        exceptionTest1();
        exceptionTest2();
    }

    // 定义方法, 测试 try...catch 异常捕获模块
    public static void exceptionTest1() {
        int[] array = {1, 2, 3, 4, 5};
        try {
            System.out.println(array[5]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("成功捕获异常, 我就会被执行~~~");
    }

    // 定义方法, 测试常用三个成员方法
    public static void exceptionTest2() {
        int[] array = {1, 2, 3, 4, 5};
        try {
            System.out.println(array[10]);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Index 10 out of bounds for length 5
            System.out.println(e.toString()); // java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 5
            e.printStackTrace(); // 打印异常信息
        }
    }
}
