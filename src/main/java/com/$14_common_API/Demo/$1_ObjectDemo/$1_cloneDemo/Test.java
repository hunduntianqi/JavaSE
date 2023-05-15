package com.$14_common_API.Demo.$1_ObjectDemo.$1_cloneDemo;

public class Test {
    // 练习使用Object的clone 对象克隆方法
    public static void main(String[] args) throws Exception {
        // 1. 创建对象
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        User u1 = new User(1, "张三", "1234qwer", "girl11", data);
        
        // 2. 克隆对象
        // 方法在底层会创建一个对象, 并把原对象中的数据拷贝过去
        User u2 = (User)u1.clone();
        System.out.println(u1);
        System.out.println(u2);
        
        // 验证 Object中的克隆属于浅克隆
        // 修改数组数据, 如果u1和u2中得数组均被改变, 属于浅克隆
        data[0] = 100;
        System.out.println(u1);
        System.out.println(u2);
    }
}
