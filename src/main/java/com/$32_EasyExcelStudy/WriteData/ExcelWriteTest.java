package com.$32_EasyExcelStudy.WriteData;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.*;

public class ExcelWriteTest {
    // 向Excel写数据方式一
    @Test
    public void writeData1() {
        // 1. 创建一个Excel文档
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test1.xlsx";
        // 2. 根据User类模板构建数据
        List<User> list = new ArrayList<>();
        User user1 = new User(1001, "郭鹏涛", "男", 6230.5, new Date());
        User user2 = new User(1002, "郭鹏强", "男", 12000.0, new Date());
        User user3 = new User(1003, "郭会军", "男", 6500.5, new Date());
        Collections.addAll(list, user1, user2, user3);
        // 3. 向Excel表格写数据
        EasyExcel.write(fileName, User.class).sheet("用户信息").doWrite(list);
    }

    // 向Excel写数据方式二
    @Test
    public void writeData2() {
        // 1. 创建一个Excel文档
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test2.xlsx";
        // 2. 根据User类模板构建数据
        List<User> list = new ArrayList<>();
        User user1 = new User(1001, "郭鹏涛", "男", 6230.5, new Date());
        User user2 = new User(1002, "郭鹏强", "男", 12000.0, new Date());
        User user3 = new User(1003, "郭会军", "男", 6500.5, new Date());
        Collections.addAll(list, user1, user2, user3);
        // 3. 向Excel表格写数据
        // 创建ExcelWriter对象
        ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).build();
        // 创建Sheet对象
        WriteSheet writerSheet = EasyExcel.writerSheet("用户信息").build();
        // 写数据
        excelWriter.write(list, writerSheet);
        // 释放资源
        excelWriter.close();
    }

    // 排除字段写入数据(只写入想要的字段数据)
    @Test
    public void writeDate3() {
        // 1. 定义文件路径, 创建一个Excel文档
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test3.xlsx";
        // 2. 根据User类模板构建数据
        List<User> list = new ArrayList<>();
        User user1 = new User(1001, "郭鹏涛", "男", 6230.5, new Date());
        User user2 = new User(1002, "郭鹏强", "男", 12000.0, new Date());
        User user3 = new User(1003, "郭会军", "男", 6500.5, new Date());
        Collections.addAll(list, user1, user2, user3);
        // 3. 定义一个集合, 放入要排除字段名
        Set<String> set = new HashSet<>();
        set.add("hireDate"); // 排除时间字段, 不写入该字段数据
        set.add("salary"); // 排除薪水字段, 不写入该字段数据
        // 4. 向文件中写入数据, excludeColumnFieldNames(set) ==> 排除该集合字段数据
        EasyExcel.write(fileName, User.class).excludeColumnFieldNames(set).sheet("用户信息").doWrite(list);
    }

    // 指定字段写入数据(只写入想要的字段数据)
    @Test
    public void writeDate4() {
        // 1. 定义文件路径, 创建一个Excel文档
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test4.xlsx";
        // 2. 根据User类模板构建数据
        List<User> list = new ArrayList<>();
        User user1 = new User(1001, "郭鹏涛", "男", 6230.5, new Date());
        User user2 = new User(1002, "郭鹏强", "男", 12000.0, new Date());
        User user3 = new User(1003, "郭会军", "男", 6500.5, new Date());
        Collections.addAll(list, user1, user2, user3);
        // 3. 定义一个集合, 放入要写入数据的字段名
        Set<String> set = new HashSet<>();
        set.add("userId"); // 添加用户编号字段, 写入该字段数据
        set.add("hireDate"); // 添加时间字段, 写入该字段数据
        set.add("salary"); // 添加薪水字段, 写入该字段数据
        // 4. 向文件中写入数据, includeColumnFieldNames(set) ==> 只写入该集合字段数据
        EasyExcel.write(fileName, User.class).includeColumnFieldNames(set).sheet("用户信息").doWrite(list);
    }

    // 设置写入字段的顺序,@ExcelProperty注解: value ==> 表头单元格的值; index ==> 控制写入Excel字段的顺序
    @Test
    public void writeDate5() {
        // 1. 定义文件路径, 创建一个Excel文档
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test5.xlsx";
        // 2. 根据User_Index类模板构建数据
        List<User_Index> list = new ArrayList<>();
        User_Index user1 = new User_Index(1001, "郭鹏涛", "男", 6230.5, new Date());
        User_Index user2 = new User_Index(1002, "郭鹏强", "男", 12000.0, new Date());
        User_Index user3 = new User_Index(1003, "郭会军", "男", 6500.5, new Date());
        Collections.addAll(list, user1, user2, user3);
        // 3. 向文件中写入数据
        EasyExcel.write(fileName, User_Index.class).sheet("用户信息").doWrite(list);
    }

    // 复杂头数据写入
    @Test
    public void writeDate6() {
        // 1. 定义文件路径, 创建一个Excel文档
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test6.xlsx";
        // 2. 根据ComplexHeaderUser模板构建数据
        List<ComplexHeaderUser> list = new ArrayList<>();
        ComplexHeaderUser user1 = new ComplexHeaderUser(1001, "郭鹏涛", new Date());
        ComplexHeaderUser user2 = new ComplexHeaderUser(1002, "郭鹏强", new Date());
        ComplexHeaderUser user3 = new ComplexHeaderUser(1003, "郭会军", new Date());
        Collections.addAll(list, user1, user2, user3);
        // 3. 向Excel中写入数据
        EasyExcel.write(fileName, ComplexHeaderUser.class).sheet("用户信息").doWrite(list);
    }

    // 重复将数据写入一个Sheet表格中
    @Test
    public void writeData7() {
        // 1. 创建一个Excel文档
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test7.xlsx";
        // 2. 根据User类模板构建数据
        List<User> list = new ArrayList<>();
        User user1 = new User(1001, "郭鹏涛", "男", 6230.5, new Date());
        User user2 = new User(1002, "郭鹏强", "男", 12000.0, new Date());
        User user3 = new User(1003, "郭会军", "男", 6500.5, new Date());
        Collections.addAll(list, user1, user2, user3);
        // 3. 向Excel表格写数据
        // 创建ExcelWriter对象
        ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).build();
        // 创建Sheet对象
        WriteSheet writerSheet = EasyExcel.writerSheet("用户信息").build();
        for (int i = 0; i < 5; i++) {
            // 写数据
            excelWriter.write(list, writerSheet);
        }
        // 释放资源
        excelWriter.close();
    }

    // 重复将数据写入不同的Sheet表格中
    @Test
    public void writeData8() {
        // 1. 创建一个Excel文档
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test8.xlsx";
        // 2. 根据User类模板构建数据
        List<User> list = new ArrayList<>();
        User user1 = new User(1001, "郭鹏涛", "男", 6230.5, new Date());
        User user2 = new User(1002, "郭鹏强", "男", 12000.0, new Date());
        User user3 = new User(1003, "郭会军", "男", 6500.5, new Date());
        Collections.addAll(list, user1, user2, user3);
        // 3. 向Excel表格写数据
        // 创建ExcelWriter对象
        ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).build();
        for (int i = 0; i < 5; i++) {
            // 创建Sheet对象
            WriteSheet writerSheet = EasyExcel.writerSheet("用户信息%s".formatted(i + 1)).build();
            // 写数据
            excelWriter.write(list, writerSheet);
        }
        // 释放资源
        excelWriter.close();
    }

    // 日期, 数字类型格式化
    @Test
    public void writeData9() {
        // 1. 创建一个Excel文档
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test9.xlsx";
        // 2. 根据User类模板构建数据
        List<FormatDateNumber> list = new ArrayList<>();
        FormatDateNumber user1 = new FormatDateNumber(1001, "郭鹏涛", "男", 6230.5, new Date());
        FormatDateNumber user2 = new FormatDateNumber(1002, "郭鹏强", "男", 12000.0, new Date());
        FormatDateNumber user3 = new FormatDateNumber(1003, "郭会军", "男", 6500.5, new Date());
        Collections.addAll(list, user1, user2, user3);
        // 3. 向Excel表格写数据
        EasyExcel.write(fileName, FormatDateNumber.class).sheet("用户信息").doWrite(list);
    }

    // 设置列宽和行高
    @Test
    public void writeData10() {
        // 1. 创建一个Excel文档
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test10.xlsx";
        // 2. 构建数据
        List<SetWidthAndHeight> list = new ArrayList<>();
        SetWidthAndHeight setWidthAndHeight = new SetWidthAndHeight("ABC", new Date(), 1001D);
        list.add(setWidthAndHeight);
        EasyExcel.write(fileName, SetWidthAndHeight.class).sheet("Data").doWrite(list);
    }

    // 将图片写入Excel中
    @Test
    public void writeData11() throws Exception {
        // 1. 定义文件路径, 创建一个Excel文件
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test11.xlsx";
        // 2. 构建数据(五种写入图片方式)
        List<ImageData> list = new ArrayList<>();
        ImageData imageData = new ImageData();
        imageData.setFile(new File("src/main/java/com/$32_EasyExcelStudy/FileStorage/52196720552427712321666885798167.jpg"));
        imageData.setInputStream(new FileInputStream(new File("src/main/java/com/$32_EasyExcelStudy/FileStorage/52196720552427712321666885798167.jpg")));
        imageData.setString("src/main/java/com/$32_EasyExcelStudy/FileStorage/52196720552427712321666885798167.jpg");
        imageData.setUrl(new URL("https://android-screenimgs.25pp.com/fs08/2016/08/20/3/102_e3a9f08466858f0409a54dd66d5cad6d.jpeg"));
        byte[] bytes = new byte[(int) new File("src/main/java/com/$32_EasyExcelStudy/FileStorage/52196720552427712321666885798167.jpg").length()];
        FileInputStream fileInputStream = new FileInputStream("src/main/java/com/$32_EasyExcelStudy/FileStorage/52196720552427712321666885798167.jpg");
        fileInputStream.read(bytes);
        fileInputStream.close();
        imageData.setByteArray(bytes);
        list.add(imageData);

        // 3. 向Excel中写入图片数据
        EasyExcel.write(fileName, ImageData.class).sheet("img").doWrite(list);
    }

    // 通过注解设置写入样式
    @Test
    public void writeData12() {
        // 1. 创建一个Excel文档
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test12.xlsx";
        // 2. 构建数据
        List<SetWriteStyle> list = new ArrayList<>();
        SetWriteStyle setWriteStyle = new SetWriteStyle("ABC", new Date(), 1001D);
        list.add(setWriteStyle);
        EasyExcel.write(fileName, SetWriteStyle.class).sheet("Data").doWrite(list);
    }

    // 合并指定单元格
    @Test
    public void writeData13() {
        // 1. 创建一个Excel文档
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test13.xlsx";
        // 2. 构建数据
        List<MergeCell> list = new ArrayList<>();
        MergeCell mergeCell = new MergeCell("ABC", new Date(), 1001D);
        list.add(mergeCell);
        EasyExcel.write(fileName, MergeCell.class).sheet("Data").doWrite(list);
    }
}
