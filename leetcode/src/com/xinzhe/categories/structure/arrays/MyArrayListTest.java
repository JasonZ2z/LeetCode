package com.xinzhe.categories.structure.arrays;

import java.util.*;

/**
 * @author xzheng
 * @date 2020-01-06 16:37
 */
public class MyArrayListTest {

    public static void main(String[] args){
        System.out.println(Integer.parseInt("A", 16));
        System.out.println(Integer.toHexString(1234));
    }

    public static List<String> fun(String str){
        if(str == null) return null;
        List<String> list = new ArrayList<>();
        int len = str.length();
        int b=len%8;
        int a=len/8;


        if(b==0){
            char[] arr = new char[len];
            for(int q = 0; q< len; q++){
                arr[q] = str.charAt(q);
            }
            for(int i=0; i<a+1; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<8; j++){
                    sb.append(arr[i*8+j]);
                }
                list.add(sb.toString());
            }
        }else {
            char[] arr = new char[len + 8 - b];
            for(int p=0; p<len+8-b; p++){
                arr[p] = '0';
            }
            for(int q = 0; q< len; q++){
                arr[q] = str.charAt(q);
            }
            for(int i=0; i<a+1; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<8; j++){
                    sb.append(arr[i*8+j]);
                }
                list.add(sb.toString());
            }
        }
        return list;
    }

}

