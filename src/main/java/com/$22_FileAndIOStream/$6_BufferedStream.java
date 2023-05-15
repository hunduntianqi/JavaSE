package com.$22_FileAndIOStream;

/*
    缓冲流:
        也叫高效流, 是对4个基本的FileXxx流的增强
        基本原理:
            在创建流对象时, 会创建一个内置的默认大小的缓冲区数组, 通过缓冲区读写, 减少系统IO次数,
            从而提高读写效率
        字节缓冲流:
            BufferedInputStream:
                构造方法: public BufferedInputStream(InputStream in): 创造一个新的缓冲字节输入流
            BufferedOutputStream:
                构造方法: public BufferedOutputStream(OutputStream out): 创造一个新的缓冲字节输出流
        字符缓冲流:
            BufferedReader:
                构造方法: public BufferedReader(Reader in): 创造一个新的缓冲字符输入流
                特有方法: public String readLine(): 按行读取数据, 无数据后返回null
            BufferedWriter:
                构造方法: public BufferedWriter(Writer out): 创造一个新的缓冲字符输出流
                特有方法: public void newLine(): 写一行换行分隔符, 由系统属性定义换行符号(跨平台)

 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class $6_BufferedStream {
    public static void main(String[] args) throws Exception {
        bufferInputStreamExample();
        inputStreamExample();
        bufferOutputStreamExample();
        System.out.println(bufferReaderExample());
        bufferWriterExample();
    }

    // 定义方法, 演示缓冲字节输入流
    public static void bufferInputStreamExample() throws Exception {
        // 记录程序开始时间
        long start = System.currentTimeMillis();
        // 定义变量, 存储文件路径
        String path = "D:\\Users\\Administrator\\Desktop\\小练习\\test\\QQ评论0.txt";
        // 创建缓冲字节输入流对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        byte[] fileData = bufferedInputStream.readAllBytes();
        // 关闭缓冲字节输入流对象
        bufferedInputStream.close();
        System.out.println("读取文件数据如下:\n" + new String(fileData, StandardCharsets.UTF_8));
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("程序共耗时: " + (end - start) / 1000.0);
    }

    // 定义方法, 演示字节输入流
    public static void inputStreamExample() throws Exception {
        // 记录程序开始时间
        long start = System.currentTimeMillis();
        // 定义变量, 存储文件路径
        String path = "D:\\Users\\Administrator\\Desktop\\小练习\\test\\QQ评论0.txt";
        // 创建缓冲字节输入流对象
        InputStream inputStream = new FileInputStream(path);
        byte[] fileData = inputStream.readAllBytes();
        // 关闭字节输入流对象
        inputStream.close();
        System.out.println("读取文件数据如下:\n" + new String(fileData, StandardCharsets.UTF_8));
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("程序共耗时: " + (end - start) / 1000.0);
    }

    // 定义方法, 演示缓冲字节输出流
    public static void bufferOutputStreamExample() throws Exception {
        // 记录程序开始时间
        long start = System.currentTimeMillis();
        // 定义变量存储文件路径
        String path = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$6_java_test.txt";
        // 创建缓冲字节输出流对象
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        // 定义变量, 存储要写入的数据
        String data = "3.侍中、侍郎郭攸之、费祎、董允等，此皆良实，志虑忠纯，是以先帝简拔以遗陛下。愚以为宫中之事，事无大小，悉以咨之，然后施行，必得裨补阙漏，有所广益。\n" +
                "8.愿陛下托臣以讨贼兴复之效，不效，则治臣之罪，以告先帝之灵。若无兴德之言，则责攸之、祎、允等之慢，以彰其咎；陛下亦宜自谋，以咨诹善道，察纳雅言，深追先帝遗诏，臣不胜受恩感激。\n" +
                "4.将军向宠，性行淑均，晓畅军事，试用之于昔日，先帝称之曰能，是以众议举宠为督。愚以为营中之事，悉以咨之，必能使行阵和睦，优劣得所。\n" +
                "2.宫中府中，俱为一体，陟罚臧否，不宜异同。若有作奸犯科及为忠善者，宜付有司论其刑赏，以昭陛下平明之理，不宜偏私，使内外异法也。\n" +
                "1.先帝创业未半而中道崩殂，今天下三分，益州疲弊，此诚危急存亡之秋也。然侍卫之臣不懈于内，忠志之士忘身于外者，盖追先帝之殊遇，欲报之于陛下也。诚宜开张圣听，以光先帝遗德，恢弘志士之气，不宜妄自菲薄，引喻失义，以塞忠谏之路也。\n" +
                "9.今当远离，临表涕零，不知所言。\n" +
                "6.臣本布衣，躬耕于南阳，苟全性命于乱世，不求闻达于诸侯。先帝不以臣卑鄙，猥自枉屈，三顾臣于草庐之中，咨臣以当世之事，由是感激，遂许先帝以驱驰。后值倾覆，受任于败军之际，奉命于危难之间，尔来二十有一年矣。\n" +
                "7.先帝知臣谨慎，故临崩寄臣以大事也。受命以来，夙夜忧叹，恐付托不效，以伤先帝之明，故五月渡泸，深入不毛。今南方已定，兵甲已足，当奖率三军，北定中原，庶竭驽钝，攘除奸凶，兴复汉室，还于旧都。此臣所以报先帝而忠陛下之职分也。至于斟酌损益，进尽忠言，则攸之、祎、允之任也。\n" +
                "5.亲贤臣，远小人，此先汉所以兴隆也；亲小人，远贤臣，此后汉所以倾颓也。先帝在时，每与臣论此事，未尝不叹息痛恨于桓、灵也。侍中、尚书、长史、参军，此悉贞良死节之臣，愿陛下亲之信之，则汉室之隆，可计日而待也";
        // 向文件写入数据
        bufferedOutputStream.write(data.getBytes());
        // 关闭缓冲字节输出流
        bufferedOutputStream.close();
        // 记录程序结束时间
        long end = System.currentTimeMillis();
        System.out.println("程序共耗时: " + (end - start) / 1000.0);
    }

    // 定义方法, 演示字符缓冲输入流
    public static String bufferReaderExample() throws Exception {
        // 记录程序开始时间
        long start = System.currentTimeMillis();
        // 定义变量, 存储文件路径
        String path = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$6_java_test.txt";
        // 创建缓冲字符输入流对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        // 定义StringJoiner对象
        StringBuilder fileData = new StringBuilder("");
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            fileData.append(line);
            fileData.append("\n");
        }
        System.out.println("读取的文件数据为: \n" + fileData.toString());
        // 关闭缓冲字符输入流
        bufferedReader.close();
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("程序共耗时: " + (end - start) / 1000.0);
        return fileData.toString();
    }

    // 定义方法, 演示缓冲字符输出流
    public static void bufferWriterExample() throws Exception {
        // 记录程序开始时间
        long start = System.currentTimeMillis();
        // 定义变量, 记录文件路径
        String path = "../JavaStudy/$5_JavaSeNewStudy/src/com/javabasic/$22_FileAndIOStream/$6_出师表.txt";
        // 创建字符缓冲输出对象
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        // 调用方法, 获取原文件中数据
        String fileData = bufferReaderExample();
        // 将原数据按行拆分为数组
        String[] data = fileData.split("\n");
        // 创建集合, 遍历存储原数据
        ArrayList<String> dataList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            dataList.add(data[i]);
        }
        // 为集合中数据进行排序
        Collections.sort(dataList);
        // 遍历集合, 并将数据写入文件
        for (String s : dataList) {
            System.out.println(s);
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        // 关闭字符缓冲流对象
        bufferedWriter.close();
        // 记录程序结束时间
        long end = System.currentTimeMillis();
        System.out.println("程序共耗时: " + (end - start) / 1000.0);
    }
}
