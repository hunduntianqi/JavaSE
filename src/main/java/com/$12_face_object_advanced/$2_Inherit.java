package com.$12_face_object_advanced;

/*
    继承概述:
        指类与类之间的一种关系, 多个类继承单独的某一个类, 多个类就可以使用单独的这个类的属性和行为了
        继承的多个类称为子类(派生类), 单独的这个类称为父类(超类或基类)
    格式:
        public class 子类 extends 父类 {
        }
    继承的好处:
        提高代码的复用性, 减少代码冗余, 增强类的功能扩展性
    继承后子类的特点:
        1.子类继承父类, 子类可以得到父类的属性和行为, 但是子类不能继承父类的构造器
        2.Java中子类更强大
        3.Java是单继承模式:一个类只能继承一个直接父类
        4.Java不支持多继承, 但是支持多层继承
        5.Java中所有的类都是Object类的子类, 要么直接继承, 要么间接继承, 要么默认继承Object类是祖宗类
        6.子类继承父类的属性, 子类对象可以直接访问公开属性, 不能直接访问私有属性(私有属性可继承不可直接访问)
        7.子类不可以继承父类静态成员, 但可以共享父类静态成员(可以通过子类类名使用不可以继承)
    继承设计规范:
        子类们相同特征(共性属性, 共性方法)放在父类中定义, 子类独有的属性和行为定义在子类中

    继承后成员变量和成员方法的访问特点:
        1. 就近原则:子类局部范围-子类成员范围-父类成员范围-报错
            子类中出现于父类重名的成员, 会优先使用子类成员
            子类中指定使用父类变量 / 方法, 要使用super关键字:
                格式：
                    super.父类成员变量/父类成员方法
        2. 方法重写:
            指子类中出现的与父类一模一样的方法声明, 子类方法被称为重写父类方法
            应用场景:
                子类需要父类功能, 但父类功能不能完全满足需求时, 子类可以重写父类方法
                  重写格式:
                        @Override // 方法重写注解, 可帮助检查重写是否正确
                        public void 方法名(与父类一致) {
                            super.父类方法;
                            子类增加功能;
                        }
            方法重写注意事项和要求:
                1.重写方法的名称、形参列表必须与被重写方法的名称和形参列表一致
                2.私有方法不能被重写
                3.子类重写父类方法时, 访问权限必须大于或者等于父类(缺省< protected < public)
                4.子类不能重写父类的静态方法,重写时会报错
    子类继承父类后构造器的特点:
        1.子类中所有的构造器默认先访问父类的无参构造器, 再执行自己的构造器
            原因:
                子类初始化之前, 要调用父类构造器先完成父类数据空间的初始化
        2.子类调用父类有参构造器:
            super调用父类有参构造器:
                作用:初始化继承自父类的数据
            注意:
                父类只有有参构造器没有无参构造器, 直接调用父类构造器会报错, 因为子类默认调用父类无参构造器
                通过super(...), 手动调用父类有参构造器可解决此异常！！！
    this/super使用详情:
        1. this:
            代表本类对象的引用
            1.1 访问成员变量:
                this.成员变量
            1.2 访问成员方法:
                this.成员方法(...);
            1.3 访问构造方法:
                this();
        2. super:
            代表父类存储空间的标识
            2.1 访问成员变量:
                super.成员变量
           2.2 访问成员方法:
                super.成员方法(...);
           2.3 访问父类构造器:
                super(...);
            注意:
                1. 子类通过this(...) 去调用本类的其他构造器, 本类的其他构造器会通过super(...)去手动调用父类的构造器
                    最终还是会调用父类构造器
                2. this(...)和super(...)都只能放在构造器的第一行, 所以二者不能存在同一个构造器中
 */

public class $2_Inherit {
}
