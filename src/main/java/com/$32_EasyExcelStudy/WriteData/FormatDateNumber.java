package com.$32_EasyExcelStudy.WriteData;

/*
    创建FormatDateNumber类模板, 测试日期, 数字格式化写入Excel
        @ExcelProperty注解: 设置Excel表头信息
            value ==> 表头单元格的值
            index ==> 写入Excel字段的顺序
        @DateTimeFormat ==> 日期格式化注解
        @NumberFormat ==> 数字格式化注解(小数或者百分数)
 */

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;

import java.util.Date;

public class FormatDateNumber {
    @ExcelProperty("用户编号")
    private Integer userId;
    @ExcelProperty("姓名")
    private String userName;
    @ExcelProperty("性别")
    private String gender;
    @NumberFormat("#.##") // 数字格式化注解, 格式化小数类型; 百分数 ==> #.##%
    @ExcelProperty("工资")
    private Double salary;
    @DateTimeFormat("yyyy年MM月dd日 HH时:mm分:ss秒") // 时间格式化注解
    @ExcelProperty("入职时间")
    private Date hireDate;

    public FormatDateNumber() {
    }

    public FormatDateNumber(Integer userId, String userName, String gender, Double salary, Date hireDate) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "FormatDateNumber{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}
