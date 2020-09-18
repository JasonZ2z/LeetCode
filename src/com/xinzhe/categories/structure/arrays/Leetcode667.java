package com.xinzhe.categories.structure.arrays;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/18
 * Title : 667. 优美的排列 II
 * Description : 给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
 *              ① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
 *              ② 如果存在多种答案，你只需实现并返回其中任意一种.
 * link : https://leetcode-cn.com/problems/beautiful-arrangement-ii
 * Level : Medium
 */

public class Leetcode667 {
    public static void main(String[] args) {
        Leetcode667 lc = new Leetcode667();
        System.out.println(Arrays.toString(lc.constructArray(8, 4)));
        System.out.println(Arrays.toString(lc.constructArray2(8, 4)));
    }
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = i+1;
        }
        if(k == 1) return res;
        for (int i = 2; i <= k; ++i) {
            reverse(res, i-1, n-1);
        }
        return res;
    }

    private void reverse(int[] res, int i, int j) {
        while(i < j) {
            res[i] ^= res[j];
            res[j] ^= res[i];
            res[i] ^= res[j];
            i++;
            j--;
        }
    }

    public int[] constructArray2(int n, int k) {
        int[] res = new int[n];
        int i = 1, j = n, p = 0;
        while(p < k) {
            res[p++] = i++;
            if(p < k) {
                res[p++] = j--;
            } else {
                break;
            }
        }
        if(k % 2 == 0) {
            for (int l = k; l < n; ++l) {
                res[l] = j--;
            }
        }else {
            for (int l = k; l < n; ++l) {
                res[l] = i++;
            }
        }
        return res;
    }
}
