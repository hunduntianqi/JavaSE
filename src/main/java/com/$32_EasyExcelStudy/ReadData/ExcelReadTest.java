package com.$32_EasyExcelStudy.ReadData;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Test;

import java.util.HashMap;

public class ExcelReadTest {
    // 读取Excel数据方式一
    @Test
    public void readData1() {
        // 1. 定义文件路径
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test.xlsx";
        // 2. 读取数据
        EasyExcel.read(fileName, new AnalysisEventListener() {
            @Override
            public void invoke(Object o, AnalysisContext analysisContext) {
                // 该方法每读取一行数据被调用一次
                HashMap<Integer, String> map = (HashMap<Integer, String>) o;
                System.out.println("解析数据为: " + map);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                // 该方法当数据全部读取完毕后被调用
                System.out.println("数据读取完毕!!");
            }
        }).sheet().doRead();
    }

    // 读取Excel数据方式二
    @Test
    public void readData2() {
        // 1. 定义文件路径
        String fileName = "src/main/java/com/$32_EasyExcelStudy/FileStorage/excel_test.xlsx";
        // 2. 创建ExcelReader对象
        ExcelReader excelReader = EasyExcel.read(fileName, new AnalysisEventListener() {
            @Override
            public void invoke(Object o, AnalysisContext analysisContext) {
                // 该方法每读取一行数据被调用一次
                HashMap<Integer, String> map = (HashMap<Integer, String>) o;
                System.out.println("解析数据为: " + map);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                // 该方法当数据全部读取完毕后被调用
                System.out.println("数据读取完毕!!");
            }
        }).build();
        // 3. 创建ReadSheet对象, 可以指定表名或表的索引(索引从0开始)
        ReadSheet readSheet = EasyExcel.readSheet("用户信息").build();
        // 4. 读取数据
        excelReader.read(readSheet);
        // 5. 释放资源
        excelReader.close();
    }
}
