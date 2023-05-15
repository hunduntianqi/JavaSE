package com.$24_NetworkProgramming;

/*
    IP:
        全称 ==> Internet Protocol, 是互联网协议地址, 也称IP地址, 是分配给上网设备的数字标签, 是唯一的
        IPV4:
            全称 ==> Internet Protocol Version 4, 互联网通信协议第4版
            采用32位地址长度, 分成4组, 每组8个比特位, 共有 2^32 个IP
            特殊IP地址:
                127.0.0.1 / localhost: 是回送地址也称作本地回环地址, 也称作本机IP
            常用的CMD命令:
                1. ipconfig: 查看本机IP地址
                2. ping ip: 检查与目标ip网络是否连通
        IPV6:
            全称 ==> Internet Protocol Version 6, 互联网通信协议第6版
            采用128位地址长度, 分成8组, 每组16个比特位, 共有 2^128 个IP
        InetAddress类:
            是java中的IP地址操作类, 位于java.net包下, 有Inet4Address和Inet6Address两个子类
            常用方法:
                1. public static InetAddress getLocalHost(): 返回本主机的地址对象
                2. public static InetAddress getByName(String host): 得到指定主机的IP地址对象, 参数是域名或者IP地址
                3. public String getHostName(): 获取此IP地址的主机名
                4. public String getHostAddress(): 返回IP地址字符串
                5. public boolean isReachable(int timeout): 在指定毫秒内连通该IP地址对应的主机, 连通返回true
 */

import java.net.InetAddress;

public class $2_IPSummarize {
    public static void main(String[] args) throws Exception {
        // 1. 获取本机地址对象
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());
        System.out.println("===============");

        // 2. 获取域名IP对象
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getHostAddress());
        System.out.println("===============");
        // 3. 获取公网IP对象
        InetAddress ip3 = InetAddress.getByName("39.156.66.14");
        System.out.println(ip3.getHostName());
        System.out.println(ip3.getHostAddress());
        System.out.println("===============");
        // 4. 判断是否能通
        System.out.println(ip3.isReachable(5000));
    }
}
