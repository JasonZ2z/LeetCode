package com.xinzhe.categories.solutions.backtrack.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/3/5 20:10
 * Title : 60. 第k个排列
 * Description : 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *      按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *      "123"
 *      "132"
 *      "213"
 *      "231"
 *      "312"
 *      "321"
 *      给定 n 和 k，返回第 k 个排列。
 *      给定 n 的范围是 [1, 9]。
 *      给定 k 的范围是[1,  n!]。
 * link : https://leetcode-cn.com/problems/permutation-sequence
 * Level : Medium
 */

//todo
public class Leetcode060 {
    public static void main(String[] args) {
        System.out.println(getPermutation(4, 12));
    }
    public static String getPermutation(int n, int k) {
        int[] arr = {1,1,2,6,24,120,720,5040,40320,362880};
        List<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        StringBuilder sb = new StringBuilder();
        for(int i = n; i > 0; --i) {
          int sv = k/arr[i-1];
          k = k % arr[i-1];
          sv = k > 0 ? sv+1 : sv;
          if(k == 0) k = arr[i-1];
          sb.append(list.remove(sv-1));
        }
        return sb.toString();
    }
}
