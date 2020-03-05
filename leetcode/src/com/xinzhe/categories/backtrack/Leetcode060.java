package com.xinzhe.categories.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/5 20:10
 * Title : 60. 第k个排列
 * Description : 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 *      按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *      给定 n 和 k，返回第 k 个排列。

 *      给定 n 的范围是 [1, 9]。
 *      给定 k 的范围是[1,  n!]。
 * link : https://leetcode-cn.com/problems/permutation-sequence
 * Level :
 */

//todo
public class Leetcode060 {

    public static void main(String[] args) {
        System.out.println(getPermutation(3,3));
    }

    // bfs 超时
    private static List<String> result = new ArrayList<>();
    public static String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        dfs(n,list);
        result.sort(String::compareTo);
        return result.get(k-1);
    }

    private static void dfs(int n, List<String> list) {
        if(list.size() == n){
            String s = String.join("", new ArrayList<>(list));
            System.out.println(s);
            result.add(s);
            return;
        }
        if(list.size() > n) return;
        for (int i = 1; i <= n; i++) {
            String value = String.valueOf(i);
            if(!list.contains(value)){
                list.add(value);
                dfs(n, list);
                list.remove(list.size()-1);
            }
        }
    }
}
