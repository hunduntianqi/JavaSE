package com.$14_common_API;

import java.math.BigDecimal;

/*
    BigDecimal:
        用于解决浮点型运算精度失真的问题
        构造方法:
            public BigDecimal(double val): 根据浮点数创建BigDecimal对象
            public BigDecimal(String val): 根据字符串创建BigDecimal对象
        静态方法获取BigDecimal对象:
            BigDecimal b1 = BigDecimal.valueOf(浮点数);
        常用方法:
            1.public BigDecimal add(BigDecimal b): 加法
            2.public BigDecimal subtract(BigDecimal b):减法
            3.public BigDecima multiply(BigDecimal b):乘法
            4.public BigDecimal divide(BigDecimal b):除法
            5.public BigDecimal divide(另一个BigDecimal对象, 精确几位, 舍入模式):除法
        注意事项:
            BigDecimal一定要进行精度运算, 如果传入数据无法进行精度运算, 系统会崩溃
 */
public class $6_BigDecimal {
    public static void main(String[] args) {
        // 创建BigDecimal对象
        BigDecimal bigDecimal = new BigDecimal(1.23);
        System.out.println("根据浮点数创建BigDecimal对象: %s".formatted(bigDecimal));
        BigDecimal bigDecimal1 = new BigDecimal("1.32");
        System.out.println("根据字符串创建BigDecimal对象:%s".formatted(bigDecimal1));
        BigDecimal bigDecimal2 = BigDecimal.valueOf(1.58);
        System.out.println("根据静态方法创建BigDecimal对象:%s".formatted(bigDecimal2));
    }
}
