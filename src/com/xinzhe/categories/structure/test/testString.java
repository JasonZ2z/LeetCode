package com.xinzhe.categories.structure.test;

/**
 * @author xzheng
 * @date 2020-01-06 14:43
 */
public class testString {

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "c";
        String s3 = s1 + s2;
        String s4 = s1 + "c";
        String s5 = "a"+"b"+"c";
        String s6 = "abc";
        String s7 = "a" + "b" + s2;
        System.out.print("s3 == s4: ");
        System.out.println(s3 == s4);

        System.out.print("s3 == s5: ");
        System.out.println(s3== s5);

        System.out.print("s4 == s5: ");
        System.out.println(s4== s5);

        System.out.print("s6 == s5: ");
        System.out.println(s6== s5);

        System.out.print("s6 == s5: ");
        System.out.println(s4== s5);

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();


    }
}
