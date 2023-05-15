package com.$24_NetworkProgramming.TCPCommunicationExercise.$3_UploadFile;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class ThreadPool_SaveFile {
    // 接受客户端上传的文件, 上传完毕后给出反馈 ==> 多线程改写
    public static void main(String[] args) throws Exception{
        // 1. 创建ServerSocket对象
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            // 2. 监听客户端连接, 获取Socket对象
            Socket client = server.accept();
            // 3. 创建线程池对象
            ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 8, 60, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
            // 4. 提交任务
            pool.submit(new SaveFileThread(client));
        }
    }
}
