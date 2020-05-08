package com.xinzhe.categories.structure.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMP {
    private static int[] getNext(String s){
        int n = s.length();
        int[] next = new int[n+1];
        next[0] = -1;
        int k = -1, i = 0;
        while(i < n) {
            if(k == -1 || s.charAt(i) == s.charAt(k)) {
                next[++i] = ++k;
            } else {
                k =  next[k];
            }
        }
        return next;
    }

    private static List<Integer> search(String txt, String pattern){
        int[] next = getNext(pattern);
        List<Integer> res = new ArrayList<>();
        int i=0, j = -1;
        while( i < txt.length()){
            if(j == -1 || txt.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if(j ==  pattern.length()) {
                res.add(i-j);
                j = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String txt = "ABCDAB ABCDABCDABDEABCDABD";
        String pattern = "ABCDABD";
        System.out.println(Arrays.toString(getNext(pattern)));
        System.out.println(search(txt, pattern));
    }
}
