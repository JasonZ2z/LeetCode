package com.xinzhe.categories.test;

import java.math.BigInteger;

/**
 * @Author Xin
 * @create 2020/2/18 19:38
 */
public class TestAdd {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(2);
        }
        String a = sb.toString();

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb2.append(a);
        }
        String b = sb2.toString();
        System.out.println(bigInt(a,b));
        System.out.println(add(a,b));
    }

    private static String bigInt(String a, String b) {
        BigInteger inta = new BigInteger(a);
        BigInteger intb = new BigInteger(b);
        return inta.add(intb).toString();
    }

    public static String add(String a, String b){
        if(a == null || "".equals(a)) return b;
        if(b == null || "".equals(b)) return a;
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i>=0 || j>=0){
            int x = i >=0 ? (a.charAt(i--) - '0') : 0;
            int y = j >=0 ? (b.charAt(j--) - '0') : 0;
            int tmp = x +y +carry;
            sb.append(tmp % 10);
            carry = tmp/10;
        }
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
