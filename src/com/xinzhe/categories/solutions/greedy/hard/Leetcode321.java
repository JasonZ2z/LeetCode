package com.xinzhe.categories.solutions.greedy.hard;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/21
 * Title : 321. 拼接最大数
 * Description : 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，
 *              要求从同一个数组中取出的数字保持其在原数组中的相对顺序。求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * link : https://leetcode-cn.com/problems/create-maximum-number
 * Level : Hard
 */
//todo need to review
public class Leetcode321 {
    public static void main(String[] args) {
        Leetcode321 lc = new Leetcode321();
        int[] a1 = {6,7};
        int[] a2 = {};
        System.out.println(Arrays.toString(lc.maxNumber(a1, a2, 2)));
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        if(m + n < k) return res;
        // i 的范围与 m n k 相关
        for (int i = Math.max(0, k-n); i <= Math.min(m, k); ++i) {
            int[] l1 = getTopK(nums1, i);
            int[] l2 = getTopK(nums2, k-i);
            int[] merge = merge(l1, l2);
            if(compare(merge, res)) res = merge;
        }
        return res;
    }

    private boolean compare(int[] n1, int[] n2) {
        for (int i = 0; i < n1.length; ++i) {
            if(n1[i] != n2[i]) {
                return n1[i] > n2[i];
            }
        }
        return false;
    }

    // 相同的时候 需要继续比较后继元素的大小，选择大的那个
    private int[] merge(int[] l1, int[] l2) {
        int m = l1.length, n = l2.length;
        int[] res = new int[m+n];
        int p = 0, q = 0, k = 0;
        while (p < m && q < n) {
            if(l1[p] > l2[q]) {
                res[k++] = l1[p++];
            }else if(l1[p] < l2[q]){
                res[k++] = l2[q++];
            } else {
                int i=p, j= q;
                while (i < m && j < n && l1[i]==(l2[j])){
                    i++; j++;
                }
                if(i == m) res[k++] = l2[q++];
                else if(j == n) res[k++] = l1[p++];
                else if(l1[i] > l2[j]) res[k++] = l1[p++];
                else res[k++] = l2[q++];
            }
        }
        while (p < m) { res[k++] = l1[p++]; }
        while (q < n) { res[k++] = l2[q++]; }
        return res;
    }

    //count ： 待删除的数目
    private int[] getTopK(int[] nums, int k) {
        int[] res = new int[k];
        if(k == 0) return res;
        int n = nums.length;
        if(k == n) return nums;
        int count = n - k;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num && count > 0) {
                stack.pop();
                count--;
            }
            if (stack.size() < k) {
                stack.push(num);
            } else {
                count--;
            }
        }
        while (!stack.isEmpty()) {
            res[--k] = stack.pop();
        }
        return res;
    }
}
