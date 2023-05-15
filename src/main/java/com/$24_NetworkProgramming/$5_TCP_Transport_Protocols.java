package com.$24_NetworkProgramming;

/*
    TCP传输协议:
        TCP(Transmission Control Protocol): 传输控制协议
        是一种可靠的网络协议, 在通信的两端各建立一个Socket对象, 通信之前要保证连接已建立, 通过Socket产生IO流来进行网络通信
        特点:
            1. 使用时必须双方先建立连接, 是一种面向连接的可靠通信协议
            2. 传输前, 采用"三次握手"方式建立连接, 所以可靠
            3. 在连接中可进行大数据量的传输
            4. 连接, 发送数据都需要确认, 且传输完毕后, 还需释放已建立的连接, 通信效率较低
            5. "四次挥手"断开连接, 保证连接通道的数据处理完毕
        通信场景:
            对信息安全要求较高的场景, 例如: 文件下载, 金融等数据通信
            客户端:
                Socket类:
                    构造器:
                        public Socket(String host, int port): 创建发送端的Socket对象与服务端连接, 参数为服务端的ip和端口
                    成员方法:
                        1. OutputStream getOutputStream(): 获得字节输出流对象
                        2. InputStream getInputStream(): 获得字节输入流对象
                        3. public SocketAddress getRemoteSocketAddress(): 获取Socket iP对象
                        4. void shutdownInput(): 将此套接字的输入流放置在“流的末尾”
                        5. void shutdownOutput(): 禁止用此套接字的输出流
            服务端:
                ServerSocket类:
                    构造器:
                        public ServerSocket(int port): 注册服务端端口
                    成员方法:
                        public Socket accept(): 等待接收客户端的Socket通信连接, 连接成功返回Socket对象与客户端建立端到端通信
             服务端同时处理多个客户端通信要求:
                引入多线程
 */
public class $5_TCP_Transport_Protocols {
}
