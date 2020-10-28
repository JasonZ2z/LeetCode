package com.xinzhe.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestBigDecimal {
    public static void main(String[] args) {

        // 银行家舍入
        BigDecimal a = new BigDecimal("15.825");
        System.out.println(a.setScale(2, RoundingMode.HALF_EVEN));
        BigDecimal b = new BigDecimal("15.835");
        System.out.println(b.setScale(2, RoundingMode.HALF_EVEN));
    }
}
