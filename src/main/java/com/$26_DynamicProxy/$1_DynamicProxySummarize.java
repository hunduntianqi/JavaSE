package com.$26_DynamicProxy;

/*
    动态代理:
        可以无侵入式的给代码增加额外的功能
        程序为什么需要代理:
            如果觉得对象本身的功能太过复杂, 可以通过代理来转移部分职责
        代理长什么样:
            对象有什么方法想被代理, 代理就一定要有对应的方法
        实现步骤:
            1. 创建接口, 定义所有要被代理的方法
            2. 创建被代理对象类, 重写接口方法
            3. 创建代理类, 定义静态方法, 创建代理对象
                创建代理对象:
                    java.lang.reflect.Proxy类: 提供为对象产生代理对象的方法:
                        public static Object newProxyInstance(ClassLoader loader, Class<?>[] interface, InvocationHandler h)
                        参数一: 用于指定那个类加载器, 去加载生成的代理类
                        参数二: 指定接口, 接口中要定义生成的代理中有哪些方法
                        参数三: 用于指定生成的代理对象要实现什么功能
 */

public class $1_DynamicProxySummarize {
}
