package com.$14_common_API.Demo.$1_ObjectDemo.$1_cloneDemo;

import java.util.Arrays;

/*
    Cloneable:
        是一个标记型接口, 没有任何抽象方法
        一旦实现Cloneable接口, 就表示当前类的对象可以被克隆, 否则就不可以被克隆
 */
public class User implements Cloneable{
    private int id; // 游戏角色
    private String name; // 用户名
    private String passWord; // 密码
    private String path; // 游戏图片
    private int[] data; // 游戏进度
    
    public User() {
    }
    
    public User(int id, String name, String passWord, String path, int[] data) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
        this.path = path;
        this.data = data;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassWord() {
        return passWord;
    }
    
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public int[] getData() {
        return data;
    }
    
    public void setData(int[] data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", path='" + path + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
    
    // 重写clone方法
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 调用父类的clone方法, 克隆一个对象并返回
        return super.clone();
    }
}
