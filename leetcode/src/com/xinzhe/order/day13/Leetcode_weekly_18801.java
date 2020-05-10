package com.xinzhe.order.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/10
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_18801 {
    public static void main(String[] args) {
        int[] a = {2,3,4};
        System.out.println(buildArray(a, 4));
    }
    public static List<String> buildArray(int[] target, int n) {
        int len = target.length;
        List<String> list = new ArrayList<>();
        String push = "Push";
        String pop = "Pop";
//        int i = 1;
//        int j = 0;
//        while(i <= n && j < len) {
//
//        }
        int j = 1;
        for (int i = 0; i < len; ++i) {
            while (j < target[i] && j <= n){
                list.add(push);
                list.add(pop);
                j++;
            }
            list.add(push);
            j++;
        }
        return list;
    }
}
