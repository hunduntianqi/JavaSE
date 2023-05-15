package com.$32_EasyExcelStudy.WriteData;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/*
    定义一个复杂头数据类模板
    复杂头: 表头数据不止一行
 */
public class ComplexHeaderUser {
    @ExcelProperty({"用户主题1", "用户编号"})
    private Integer userId;
    @ExcelProperty({"用户主题2", "用户名称"})
    private String userName;
    @ExcelProperty({"用户主题3", "入职时间"})
    private Date hireDate;

    public ComplexHeaderUser(Integer userId, String userName, Date hireDate) {
        this.userId = userId;
        this.userName = userName;
        this.hireDate = hireDate;
    }

    public ComplexHeaderUser() {
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "ComplexHeaderUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
