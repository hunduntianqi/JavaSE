package com.$32_EasyExcelStudy.WriteData;

/*
    设置Excel表格的列宽和行高
        @ContentRowHeight(30) ==> 设置内容高度
        @HeadRowHeight(40) ==> 设置表头高度
        @ColumnWidth(25) ==> 设置列宽, 可以修饰属性也可以修饰类
 */

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

import java.util.Date;

@ContentRowHeight(30) // 设置内容高度
@HeadRowHeight(40) // 设置标题高度
@ColumnWidth(25) // 设置列宽
public class SetWidthAndHeight {
    @ExcelProperty("字符串标题")
    private String String;
    @ExcelProperty("日期标题")
    private Date date;
    @ColumnWidth(50) // 设置列宽(可以修饰类, 也可以修饰具体属性)
    @ExcelProperty("数字标题")
    private Double doubleData;

    public SetWidthAndHeight() {
    }

    public SetWidthAndHeight(java.lang.String string, Date date, Double doubleData) {
        String = string;
        this.date = date;
        this.doubleData = doubleData;
    }

    public java.lang.String getString() {
        return String;
    }

    public void setString(java.lang.String string) {
        String = string;
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
    public java.lang.String toString() {
        return "SetWidthAndHeight{" +
                "String='" + String + '\'' +
                ", date=" + date +
                ", doubleData=" + doubleData +
                '}';
    }
}
