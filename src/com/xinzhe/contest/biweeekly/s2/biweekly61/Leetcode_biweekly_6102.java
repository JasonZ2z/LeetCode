package com.xinzhe.contest.biweeekly.s2.biweekly61;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2021/09/18
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6102 {
    public static void main(String[] args) {
        Leetcode_biweekly_6102 lc = new Leetcode_biweekly_6102();

    }

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n % 2 != 0) return new int[]{};
        int[] arr = new int[100001];
        for (int i : changed) {
            arr[i]++;
        }
        List<Integer> list = new ArrayList<>(n/2);
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] != 0) {
                if(i % 2 != 0) return new int[]{};
                if(arr[i/2] < arr[i]) return new int[]{};
                for (int j = 0; j < arr[i]; j++) {
                    list.add(i/2);
                    arr[i/2]--;
                }
            }
        }
        int[] res = new int[n/2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}