package com.$22_FileAndIOStream;

/*
    Zip压缩流:
        解压缩流:
            读取压缩包中的文件, 属于字节输入流
            在java中, 压缩包里的每一个文件都是一个ZipEntry对象, 解压的本质就是把每一个ZipEntry对象按照层级结构拷贝到本地的另一个文件
            夹中
            创建解压缩流对象:
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(ZipPath))
                    ZipPath ==> 待解压压缩包文件路径
            zipInputStream.getNextEntry(): 获取压缩包中的ZipEntry对象, 当读取到最后一个ZipEntry对象后, 再读取会返回null
            ZipEntry.isDirectory(): 判断该ZipEntry对象代表的是文件还是文件夹
            ZipEntry.toString(): 返回ZipEntry对象在压缩包中的层级关系字符串
        压缩流:
            将文件中的数据写入压缩包, 属于字节输出流
            压缩的本质, 就是把每一个文件或文件夹看成ZipEntry对象放到压缩包中
            创建压缩流对象:
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(FileZip))
                    FileZip: 代表文件被压缩后的压缩包文件对象
                ZipEntry zipEntry = new ZipEntry(path): 创建一个ZipEntry文件对象, path表示压缩包中文件和文件夹的子级路径
                zipOutputStream.putNextEntry(zipEntry): 将ZipEntry对象放入压缩包对象中
                将文件数据写入压缩包:
                    1. 先读取源文件数据
                    2. zipOutputStream.write(data)方法写入数据
 */

public class $10_ZipCompressiveStream {

}
