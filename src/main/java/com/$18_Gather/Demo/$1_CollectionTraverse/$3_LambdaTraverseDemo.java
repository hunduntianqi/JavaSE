package com.$18_Gather.Demo.$1_CollectionTraverse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;

public class $3_LambdaTraverseDemo {
    public static void main(String[] args) {
        // 创建Collection系列集合
        Collection<String> list = new ArrayList<>();
        Collections.addAll(list, "三", "连", "外", "加", "转", "发", "了", "吗", "?");
        // 匿名内部类结合forEach遍历集合
        list.forEach(new Consumer<String>() {
            @Override
            // 变量s表示集合中的数据
            public void accept(String s) {
                System.out.print(s + " ");
            }
        });
        System.out.println();
        // 使用lambda结合forEach遍历集合
        list.forEach(s->System.out.print(s + " "));
    }
}
