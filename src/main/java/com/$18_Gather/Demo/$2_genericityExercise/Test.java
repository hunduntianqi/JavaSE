package com.$18_Gather.Demo.$2_genericityExercise;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        // 创建波斯猫对象
        PersianCat persianCat = new PersianCat("小波", 5);
        // 创建狸花猫对象
        ChineseLiHuaCat liHuaCat = new ChineseLiHuaCat("小花", 3);
        // 创建泰迪对象
        Teddy teddy = new Teddy("小迪", 6);
        // 创建哈士奇对象
        Husky husky = new Husky("二哈", 8);
        // 创建集合, 只能存储波斯猫对象
        ArrayList<PersianCat> listCat = new ArrayList<>();
        listCat.add(persianCat);
        // 创建集合, 存储狸花猫对象
        ArrayList<ChineseLiHuaCat> listLiHuaCat = new ArrayList<>();
        listLiHuaCat.add(liHuaCat);
        // 创建集合, 存储泰迪对象
        ArrayList<Teddy> listTeddy = new ArrayList<>();
        listTeddy.add(teddy);
        // 创建集合, 存储哈士奇对象
        ArrayList<Husky> listHusky = new ArrayList<>();
        listHusky.add(husky);
        KeepPet(listCat);
        KeepPet(listLiHuaCat);
        KeepPet(listTeddy);
        KeepPet(listHusky);
    }
    
    // 定义方法用于饲养动物
    // 1. 可以养所有的猫, 不能养狗 ==> ? extends Cat
    // 2. 可以养所有的狗, 不能养猫 ==> ? extends Dog
    // 3. 可以养所有的动物, 但是不能养传递其他类型数据 ==> ? extends Animal
    public static void KeepPet(ArrayList<? extends Animal> list) {
        // lambda表达式遍历集合
        list.forEach(list1 -> list1.eat());
    }
}
