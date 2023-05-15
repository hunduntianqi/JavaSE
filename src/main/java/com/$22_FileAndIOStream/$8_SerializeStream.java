package com.$22_FileAndIOStream;

/*
    序列化
        Java提供了一种对象序列化的机制, 可以用一个字节序列表示一个对象, 该字节序列包含对象的数据,
    对象的类型, 对象中存储的属性等信息; 将字节序列写出到文件, 相当于持久保存了一个对象的信息
    反序列化:
        字节序列可以从文件中读取回来, 重构对象; 对象的数据, 对象的类型, 对象中存储的数据等信息, 可以
    用来在内存中创建对象
    序列化条件:
        1. 序列化对象所属类型必须实现 java.io.Serializable 接口, 该接口是一个标记接口, 不实现该接口
           的类将不会使对象序列化或反序列化, 会抛出 NotSerializableException异常
        2. 该类的所有属性序列必须是可序列化的, 如果有属性不需要序列化, 则该属性必须注明是瞬态的, 使用
           transient 关键字修饰
    序列化操作:
        ObjectOutputStream类:
            将java对象的原始数据类型写出到文件, 实现对象的持久存储
            构造方法:
                public ObjectOutputStream(OutputStream out): 创建一个指定字节输出流的对象序列化流对象
            构造举例:
                1. 创建字节输出流对象:
                    FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                2. 创建对象序列化流对象"
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            将指定对象序列化写出本地文件:
                public final void writeObject (Object obj): 将指定的对象写出
    反序列化操作:
        ObjectInputStream类:
            将之前使用ObjectOutputStream序列化的原始数据恢复为对象
            构造方法:
                public ObjectInputStream(InputStream in): 创建一个指定字节输入流的反序列化流对象
            构造举例:
                1. 创建字节输入流对象:
                    FileInputStream fileInputStream = new FileInputStream(filePath);
                2. 创建反序列化流对象:
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            读取文件中的对象:
                public final Object readObject(): 读取一个对象
        注意:
            1. 反序列化对象时, 必须保证对象所属类型的class文件是存在的, 否则会抛出 ClassNotFoundException异常
            2. 反序列化对象时, 可以找到class文件, 但是class文件在对象序列化后发生了修改, 反序列化操作也会失败
               会抛出一个 InvalidClassException 异常, 异常原因如下:
               a. 该类的序列版本号与从流中读取的类描述符的版本号不匹配
               b. 该类包含未知数据类型
               c. 该类没有可访问的无参数构造方法
               Serializable 接口给需要序列化的类, 提供了一个序列版本号 serialVersionUID 该版本号的目的在
               于验证序列化的对象和对应类是否版本匹配

 */

import java.io.*;

public class $8_SerializeStream {
    public static void main(String[] args) throws Exception{
        objectSerializable();
        objectDeserialization();
    }

    // 定义方法, 实现对象序列化
    public static void objectSerializable() throws Exception{
        // 创建一个对象, 用来进行序列化
        Employee employee = new Employee();
        employee.name = "郭鹏涛";
        employee.age = 25;
        employee.address = "江苏省苏州市昆山市";
        employee.addressCheck();
        // 定义变量, 记录文件储存路径
        String path = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$5_OtherStreamDemoFile/$8_对象序列化.txt";
        // 创建序列化对象流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        // 将准备好的对象写入本地文件
        objectOutputStream.writeObject(employee);
        // 关闭流对象
        objectOutputStream.close();
    }

    // 定义方法, 实现对象反序列化
    public static void objectDeserialization() throws Exception {
        // 定义变量, 记录文件储存路径
        String path = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$5_OtherStreamDemoFile/$8_对象序列化.txt";
        // 创建反序列化对象流
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        // 读取文件中的对象
        Employee employee = (Employee) objectInputStream.readObject();
        // 关闭反序列化流对象
        objectInputStream.close();
        // 打印对象数据
        System.out.println("name : " + employee.name);
        System.out.println("age : " + employee.age); // 因为年龄属性被定义为瞬态, 使用transient关键字修饰, 无法被序列化, 初始值为0
        System.out.println("address : " + employee.address);
    }
}

// 定义一个类, 实现 Serializable 接口, 演示对象序列化操作
class Employee implements Serializable {
    public String name;
    public String address;
    public transient int age; // transient瞬态修饰成员,不会被序列化
    public void addressCheck() {
        System.out.println("Address  check : " + this.name + " -- " + this.address);
    }
}
