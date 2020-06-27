package com.xinzhe.contest.biweeekly.biweekly29;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/6/27
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_biweekly_2902 {
    public static void main(String[] args) {
        System.out.println(kthFactor(7, 2));
    }

    public static int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if( n % i == 0) {
                list.add(i);
            }
        }
        if(k > list.size()) return -1;
        return list.get(k-1);
    }

}
