package com.$24_NetworkProgramming;

/*
    UDP传输协议:
        UDP(User Datagram Protocol): 用户数据报协议
        特点:
            1. 是一种无连接, 不可靠传输的协议
            2. 将数据源IP, 目的地IP和端口封装成数据包, 不需要建立连接
            3. 每个数据包的大小限制在64KB内
            4. 发送不管对方是否准备好, 接收方收到也不确认, 所以不可靠
            5. 可以广播发送, 发送数据结束时无需释放资源, 开销小, 速度快
        通信场景:
            语音通话, 视频会话等
        数据包对象: DatagramPacket
            构造器:
                1. public DatagramPacket(byte[] buf, int length, InetAddress address, int port): 创建发送端数据包对象
                    buf: 要发送的内容, 字节数组
                    length: 要发送内容的字节长度
                    address: 接收端的IP地址对象
                    port: 接收端的端口号
                2. public DatagramPacket(byte[] buf, int length): 创建接收端的数据包对象
                    buf: 用来存储接收的内容
                    length: 能够接收内容的长度
                常用方法:
                    public int getLength(): 获得实际接收到的字节个数
                    public synchronized InetAddress getAddress(): 获取发送端ip地址对象
                    public synchronized int getPort(): 获取发送端端口号
        发送端和接收端对象:DatagramSocket:
            构造器:
                1. public DatagramSocket(): 创建发送端的Socket对象, 系统会随机分配一个端口号
                2. public DatagramSocket(int port): 创建接收端的Socket对象并指定端口号
                3. public MulticastSocket(): 创建发送端的组播Socket对象, 系统会随机分配一个端口号
                4. public MulticastSocket(int port): 创建接收端的组播Socket对象并指定端口号
            常用方法:
                1. public void send(DatagramPacket dp): 发送数据包
                2. public void receive(DatagramPacket p): 接收数据包, 该方法会阻塞程序执行, 直到接收到数据
        UDP接收端只负责接收数据包, 无所谓是哪个发送端的数据包, 所以接收端可以接收很多发送端的数据
        UDP通信三种方式:
            1. 单播: 单台主机与单台主机之间通信
                之前写的代码就是单播代码
            2. 广播: 当前主机与所在网络中的所有主机通信
                广播地址: 255.255.255.255
                将单播时的发送端发送地址改为255.255.255.255, 就是广播
            3. 组播: 当前主机与选定的一组主机的通信
                组播地址: 224.0.0.0~239.255.255.255, 其中 224.0.0.0~224.0.0.255为预留的组播地址(个人测试使用只能使用预留组播地址)
                将当前主机添加组播地址:
                    InetAddress address = InetAddress.getByName("发送端组播发送地址")
                    接收端组播对象.joinGroup(address)
 */
public class $4_UDP_Transport_Protocols {
}
