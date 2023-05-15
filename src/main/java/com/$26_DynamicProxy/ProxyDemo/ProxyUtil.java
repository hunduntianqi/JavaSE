package com.$26_DynamicProxy.ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    /*
        作用: 创建一个代理
     */
    public static Star createProxy(BigStar star) {
        /*
            作用: 给一个明星的对象创建代理
            形参: 被代理的对象
            返回值: 给被代理对象创建的代理
         */
        /*
            public static Object newProxyInstance(ClassLoader loader, Class<?>[] interface, InvocationHandler h)
                参数一: 用于指定那个类加载器, 去加载生成的代理类
                参数二: 指定接口, 接口中要定义生成的代理中有哪些方法
                参数三: 用于指定生成的代理对象要实现什么功能
         */
        Star starProxy = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(), // 参数一: 获取类加载器, 基本上是固定格式
                new Class[]{Star.class}, // 参数二: 指定接口, 将接口的字节码文件放入数组, 多个接口都可以写进去
                new InvocationHandler() { // 参数三: 指定代理要实现的功能
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*
                            参数一: 被代理对象, 基本不用
                            参数二: 要运行的代理方法
                            参数三: 运行方法时传递的参数
                         */
                        if ("sing".equals(method.getName())) {
                            System.out.println("准备话筒, 收钱");
                        } else if ("dance".equals(method.getName())) {
                            System.out.println("准备场地, 收钱");
                        }
                        return method.invoke(star, args); // 调用被代理对象方法, 有返回值返回数据, 无返回值返回null
                    }
                });
        return starProxy;
    }
}
