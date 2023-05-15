package com.$32_EasyExcelStudy.WriteData;

/*
    合并单元格
        @OnceAbsoluteMerge:
            指定范围合并单元格
            参数:
                firstRowIndex: 起始行索引, 从0开始
                lastRowIndex: 结束行索引
                firstColumnIndex: 起始列索引, 从0开始
                lastColumnIndex: 结束列索引
 */

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentLoopMerge;
import com.alibaba.excel.annotation.write.style.OnceAbsoluteMerge;

import java.util.Date;

@OnceAbsoluteMerge(firstRowIndex = 1, lastRowIndex = 2, firstColumnIndex = 1, lastColumnIndex = 2)
public class MergeCell {
    @ContentLoopMerge(eachRow = 2, columnExtend = 2) // 每隔两行合并一次单元格
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;

    public MergeCell() {
    }

    public MergeCell(String string, Date date, Double doubleData) {
        this.string = string;
        this.date = date;
        this.doubleData = doubleData;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(Double doubleData) {
        this.doubleData = doubleData;
    }

    @Override
    public String toString() {
        return "MergeCell{" +
                "string='" + string + '\'' +
                ", date=" + date +
                ", doubleData=" + doubleData +
                '}';
    }
}
