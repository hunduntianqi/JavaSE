package com.$12_face_object_advanced;
/*
    包(package):
        就是文件夹, 用来管理各种不同功能的Java类, 方便后期代码维护
        包名规则: 公司域名反写+包的作用, 需要全部英文小写, 见名知意
        类的全类名 / 全限定名: 包名 + 类名
        使用其他类的规则:
            1. 使用同一个包中的类, 不需要导包
            2. 使用java.lang包中的类, 不需要导包
            3. 其他情况都需要导包
            4. 如果同时使用两个包中的同名类, 需要用全类名
    final ==> 最终的:
        final修饰方法 ==> 表明该方法是最终方法, 不能被重写
        final修饰类 ==> 表明该类是最终类, 不能被继承
        final修饰变量 ==> 变为常量, 一旦被赋值, 其值不能再发生改变
        常量:
            实际开发中, 一般作为系统的配置信息, 方便维护, 提高可读性
            常量命名规范:
                1. 单个单词: 全部大写
                2. 多个单词: 全部大写, 单词之间使用下划线隔开
        细节:
            final修饰变量:
                基本数据类型: 变量存储的数据值不能发生改变
                引用数据类型: 变量存储的地址值不能发生改变, 对象内部的数据可以改变
 */

public class $4_PackageAndFinalKeyWord {
}
