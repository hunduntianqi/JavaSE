package com.$25_Reflection.$2_GetConstructorMethod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class GetConstructorTest {
    /*
        Class类中获取构造方法的方法:
                1. Constructor<?>[] getConstructors(): 返回所有公共构造方法对象的数组
                2. Constructor<?>[] getDeclaredConstructors(): 返回所有构造方法对象的数组(包括私有的)
                3. Constructor<T> getConstructor(Class<?>... parameterTypes): 返回单个公共构造方法对象
                4. Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes): 返回单个构造方法对象(包括私有的)
            Constructor类中用来创建对象的方法:
                1. T newInstance(Object... initargs): 根据指定的构造方法创建对象
                2. setAccessible(boolean flag): 设置是否进行访问检查, true代表取消访问检查
     */
    public static void main(String[] args) throws Exception {
        // 1. 获取Class字节码文件对象
        Class clazz = Class.forName("com.$25_Reflection.$2_GetConstructorMethod.Student");
        // 2. 获取所有公共的构造方法
        Constructor[] cons = clazz.getConstructors();
        // 遍历数组
        for (Constructor constructor : cons) {
            System.out.println(constructor);
        }
        System.out.println("====================================");
        // 3. 获取所有构造方法
        Constructor[] cons2 = clazz.getDeclaredConstructors();
        for (Constructor constructor : cons2) {
            System.out.println(constructor);
        }
        System.out.println("====================================");
        // 4. 获取空参构造
        Constructor con1 = clazz.getConstructor();
        System.out.println(con1);
        // 5. 获取带参数构造方法, 传入参数必须与对应构造方法参数类型的字节码文件一致
        Constructor con2 = clazz.getConstructor(String.class);
        System.out.println(con2);
        Constructor con3 = clazz.getDeclaredConstructor(int.class);
        System.out.println(con3);
        Constructor con4 = clazz.getDeclaredConstructor(String.class, int.class);
        System.out.println(con4);
        System.out.println("===================================");
        // 获取构造方法后获取构造方法的信息
        // 获取权限修饰符
        int modifier = con1.getModifiers();
        System.out.println("public ==> " + modifier);
        // 获取构造方法的参数类型
        Parameter[] parameters = con4.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        // 利用构造方法创建对象
        // 被private修饰构造方法创建对象需要设置临时取消权限校验(暴力反射)
        con4.setAccessible(true);
        Student student = (Student) con4.newInstance("郭鹏涛", 25);
        System.out.println(student);
    }
}
