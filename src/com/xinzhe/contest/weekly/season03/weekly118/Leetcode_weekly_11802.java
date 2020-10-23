package com.xinzhe.contest.weekly.season03.weekly118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/23
 * Title : 969. 煎饼排序
 * Description : 给定数组  A，我们可以对其进行煎饼翻转：我们选择一些正整数  k  <= A.length，然后反转 A 的前 k  个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
 *              返回能使  A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在  10 * A.length 范围内的有效答案都将被判断为正确。
 * link : https://leetcode-cn.com/problems/pancake-sorting
 * Level : Medium
 */

public class Leetcode_weekly_11802 {
    public static void main(String[] args) {
        Leetcode_weekly_11802 lc = new Leetcode_weekly_11802();
        int[] arr = {3,2,4,1};
        System.out.println(lc.pancakeSort(arr));
    }

    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        while(n > 1) {
            for (int i = 0; i < n; ++i) {
                if(arr[i] == n) {
                    if(i == 0) {
                        res.add(n);
                        swap(arr, n -1);
                    } else if(i != n - 1) {
                        int diff = i + 1;
                        if(diff != 1) {
                            res.add(diff);
                            swap(arr, i);
                            res.add(n);
                            swap(arr, n -1);
                        }
                    }
                    n--;
                    break;
                }
            }
        }
        return res;
    }

    private void swap(int[] arr, int j) {
        for (int i = 0; i < (j+1) / 2; ++i) {
            int tmp = arr[i];
            arr[i] = arr[j-i];
            arr[j-i] = tmp;
        }
    }
}
