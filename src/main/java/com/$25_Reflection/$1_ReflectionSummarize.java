package com.$25_Reflection;

/*
    反射:
        反射允许对成员变量, 成员方法和构造方法的信息进行编程访问
        获取class对象的三种方式:
            1. Class.forName("全类名") ==> 源代码阶段使用, 是最为常用的方式
                全类名: 包名 + 类名;
            2. 类名.class ==> 加载内存阶段使用, 多当做参数传递使用, 例如多线程同步锁对象
            3. 对象.getClass() ==> 运行阶段可以使用, 当已经有类的对象时才可以使用
        获取构造方法:
            Java中一切皆对象, Constructor ==> java中用来描述构造方法的类
            Class类中获取构造方法的方法:
                1. Constructor<?>[] getConstructors(): 返回所有公共构造方法对象的数组
                2. Constructor<?>[] getDeclaredConstructors(): 返回所有构造方法对象的数组(包括私有的)
                3. Constructor<T> getConstructor(Class<?>... parameterTypes): 返回单个公共构造方法对象, 传入的参数必须与目标参数class文件一致
                4. Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes): 返回单个构造方法对象(包括私有的), 传入的参数必须与目标参数class文件一致
            Constructor类中用来创建对象的方法:
                1. T newInstance(Object... initargs): 根据指定的构造方法创建对象
                2. setAccessible(boolean flag): 设置是否进行访问检查, true代表取消访问检查(暴力反射)
        获取字段(成员变量):
            Field ==> java中用来描述成员变量的类
            Class类中获取成员变量的方法:
                1. Field[] getFields(): 返回所有公共成员变量对象的数组
                2. Field[] getDeclaredFields(): 返回所有成员变量对象的数组
                3. Field getField(String name): 返回单个公共成员变量对象
                4. Field getDeclaredField(String name): 返回单个成员变量对象
            Field类中用于创建对象的方法:
                1. void set(Object obj, Object value): 赋值
                2. Object get(Object obj): 获取值
        获取成员方法:
            Method ==> java中用来描述成员方法的类
            Class类中用于获取成员方法的方法:
                1. Method[] getMethods(): 返回所有公共成员方法对象的数组, 包括继承的
                2. Method[] getDeclaredMethods(): 返回所有成员方法对象的数组, 不包括继承的
                3. Method getMethod(String name, Class<?>... parameterTypes): 返回单个公共成员方法对象
                4. Method getDeclaredMethod(String name, Class<?>... parameterTypes): 返回单个成员方法对象
            Method类中用于创建对象的方法:
                Object invoke(Object obj, Object... args): 运行方法
                    参数一: 用obj对象调用该方法
                    参数二: 调用方法传递的参数(如果没有就不写)
                    返回值: 方法的返回值(如果没有就不写)
        反射的作用:
            1. 获取一个类中所有的信息, 获取到之后再执行其他的业务逻辑
            2. 结合配置文件, 动态的创建对象并调用方法
 */

public class $1_ReflectionSummarize {
}
