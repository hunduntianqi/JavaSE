package com.$32_EasyExcelStudy.WriteData;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/*
    创建User类模板, 通过User类向Excel表格中写数据
    @ExcelProperty注解: 设置Excel表头信息
        value ==> 表头单元格的值
        index ==> 写入Excel字段的顺序
 */
public class User {
    @ExcelProperty("用户编号")
    private Integer userId;
    @ExcelProperty("姓名")
    private String userName;
    @ExcelProperty("性别")
    private String gender;
    @ExcelProperty("工资")
    private Double salary;
    @ExcelProperty("入职时间")
    private Date hireDate;

    public User() {
    }

    public User(Integer userId, String userName, String gender, Double salary, Date hireDate) {
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
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}
