package com.$25_Reflection.$4_GetMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class GetMethodTest {
    /*
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
     */
    public static void main(String[] args) throws Exception {
        // 1. 获取Student类的字节码文件对象
        Class clazz = Class.forName("com.$25_Reflection.$4_GetMethod.Student");
        // 2. 获取所有的公共成员方法对象数组, 包括继承的(父类中的)
        Method[] methods1 = clazz.getMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
        System.out.println("==========================");
        // 3. 获取所有成员方法的数组, 不包括继承的
        Method[] methods2 = clazz.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }
        System.out.println("=============================");
        // 4. 返回单个公共成员方法对象
        Method method1 = clazz.getMethod("sleep");
        System.out.println(method1);
        // 5. 返回单个成员方法对象, 非公共的
        Method method2 = clazz.getDeclaredMethod("eat", String.class);
        System.out.println(method2);
        // 获取方法的修饰符
        int modify = method2.getModifiers();
        System.out.println("modify ==> " + modify);
        // 获取方法的名字
        String name = method2.getName();
        System.out.println(name);
        // 获取方法的形参
        Parameter[] parameters = method2.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        // 获取方法抛出的异常
        Class<?>[] exceptionTypes = method2.getExceptionTypes();
        for (Class<?> exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }
        // 方法运行
        /*
            Object invoke(Object obj, Object... args): 运行方法
                    参数一: 用obj对象调用该方法
                    参数二: 调用方法传递的参数(如果没有就不写)
                    返回值: 方法的返回值(如果没有就不写)
         */
        Student student = new Student();
        method2.setAccessible(true);
        // 参数一: student, 表示方法的调用者
        // 参数二: 表示在调用方法时传递的实际参数
        // 获取方法的返回值
        String result = (String) method2.invoke(student, "汉堡包");
        System.out.println(result);
    }
}
