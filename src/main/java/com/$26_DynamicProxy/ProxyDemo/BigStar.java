package com.$26_DynamicProxy.ProxyDemo;

public class BigStar implements Star{
    private String name;

    public BigStar(String name) {
        this.name = name;
    }

    public BigStar() {
    }

    // 定义唱歌方法
    @Override
    public String sing (String name) {
        System.out.println(this.name + "正在唱" + name);
        return "谢谢";
    }

    // 定义跳舞方法
    @Override
    public void dance () {
        System.out.println(this.name + "正在跳舞");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BigStar{" +
                "name='" + name + '\'' +
                '}';
    }
}
