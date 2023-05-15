package com.$14_common_API;

import java.math.BigInteger;
import java.util.Random;

/*
    BigInteger:
        表示大整数对象, 可以表示数据的范围大于long的范围, 但是只能是整数
        BigInteger能表示的最大数字为: 42亿的21亿次方
        构造方法:
            1. public BigInteger (int num, Random rnd): 获取 0~2 的 num 次方 -1 范围内的随机整数
            2. public BigInteger (String val): 获取指定的大整数, val只能是整数的表现形式
            3. public BigInteger (String val, int radix): 获取指定进制的大整数
            静态方法获取BigInteger对象:
                public static BigInteger valueOf(long val): 返回一个BigInteger对象
            注意: BigInteger对象一旦创建, 内部记录的值不能发生改变
        常见操作:
            加: add
            减: subtract
            乘: multiply
            除: divide, divideAndRemainder
            比较: equals, max, min
            次幂: pow
            转成整数: intValue, longValue
 */
public class $5_BigInteger {
    public static void main(String[] args) {
        // 创建BigInteger对象, 随机获取大整数
        BigInteger bigInteger = new BigInteger(100, new Random());
        System.out.println("随机获取大整数:%s".formatted(bigInteger));
        // 获取指定的大整数对象
        BigInteger bigInteger1 = new BigInteger("11231561313");
        System.out.println("获取指定大整数:%s".formatted(bigInteger1));
        // 获取指定进制的大整数
        // 字符串中的数字必须是整数, 而且必须与进制吻合
        BigInteger bigInteger2 = new BigInteger("1011110000010101010101010101010", 2);
        System.out.println("指定二进制获取大整数:%s".formatted(bigInteger2));
        // 静态方法获取BigInteger对象
        BigInteger bigInteger3 = BigInteger.valueOf(1000L);
        System.out.println("静态方法 valueOf() 获取大整数对象:%s".formatted(bigInteger3));
    }
}
