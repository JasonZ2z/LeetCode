package com.xinzhe.test;

public class TestIntegerCache {

    public static void main(String[] args) {
        Integer a10 = 10;
        Integer a1000 = 1000;
        Integer b10 = -10;
        Integer b1000 = -1000;

        Integer aa10 = 10;
        Integer aa1000 = 1000;

        int c10 = 10;
        int c1000 = 1000;

        int d10 = -10;
        int d1000 = -1000;

        System.out.println(a1000 == c1000);
        System.out.println(a10 == c10);


        System.out.println(a1000 == 1000);
        System.out.println(a10 == 10);

        System.out.println(a10 == aa10);
        System.out.println(a1000 == aa1000);
    }
}
