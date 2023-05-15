package com.$26_DynamicProxy.ProxyDemo;

public class Test {
    public static void main(String[] args) {
        /*
            需求:
                外面的人想要大明星唱一首歌,
                1. 获取代理的对象
                    代理对象 = ProxyUtil.createProxy(大明星的对象)
                2. 调用代理的唱歌方法
                    代理对象.唱歌的方法("歌名")
                3. 调用代理的跳舞方法
         */
        // 1. 创建大明星对象
        BigStar star = new BigStar("刘亦菲");
        // 2. 获取代理的对象
        Star proxy = ProxyUtil.createProxy(star);
        // 3. 调用唱歌的方法
        String singName = proxy.sing("三生三世");
        System.out.println(singName);
        // 4. 调用跳舞的方法
        proxy.dance();
    }
}
