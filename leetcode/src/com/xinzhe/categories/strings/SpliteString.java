package com.xinzhe.categories.strings;

import java.util.ArrayList;
import java.util.List;

public class SpliteString {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s,k));
    }

    public static String reverseStr(String s, int k) {
        List<String> strList = getStrList(s, 2*k);
        for (String s1 : strList) {
            System.out.println(s1);
        }
        StringBuilder sb = new StringBuilder();
        for (String s1 : strList) {
            sb.append(conver(s1, k));
        }
        return sb.toString();
    }

    public static String conver(String inputString, int length){
        char[] list = inputString.toCharArray();
        int i = 0;
        int j = length-1;
        if(inputString.length() < length){
            j = inputString.length()-1;
        }
        while(i<j){
            char tmp = list[j];
            list[j] = list[i];
            list[i] = tmp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for(char a: list){
            sb.append(a);
        }
        String s = "";
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            System.out.println(s2);
        }
        return sb.toString();
    }

    public static List<String> getStrList(String inputString, int length) {
        int size = inputString.length() / length;
        if (inputString.length() % length != 0) {
            size += 1;
        }
        return getStrList(inputString, length, size);
    }

    public static List<String> getStrList(String inputString, int length,
                                          int size) {
        List<String> list = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            String childStr = substring(inputString, index * length,
                    (index + 1) * length);
            list.add(childStr);
        }
        return list;
    }

    public static String substring(String str, int f, int t) {
        if (f > str.length()) {
            return null;
        }
        if (t > str.length()) {
            return str.substring(f);
        } else {
            return str.substring(f, t);
        }
    }
}
