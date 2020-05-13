package com.xinzhe.order.day09;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/4/12 10:10
 * Title : 5381. 查询带键的排列
 * Description : 给你一个待查数组 queries ，数组中的元素为 1 到 m 之间的正整数。 请你根据以下规则处理所有待查项 queries[i]（从 i=0 到 i=queries.length-1）：
 * 一开始，排列 P=[1,2,3,...,m]。
 * 对于当前的 i ，请你找出待查项 queries[i] 在排列 P 中的位置（下标从 0 开始），然后将其从原位置移动到排列 P 的起始位置（即下标为 0 处）。注意， queries[i] 在 P 中的位置就是 queries[i] 的查询结果。
 * 请你以数组形式返回待查数组  queries 的查询结果。
 * link : https://leetcode-cn.com/problems/queries-on-a-permutation-with-key
 * Level : Medium
 */
public class Leetcode_weekly_18402 {

    public static void main(String[] args) {
        int[] arr = {7,5,5,8,3};
        System.out.println(Arrays.toString(processQueries(arr, 8)));
    }
    public static int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        if(n == 0) return new int[0];
        int[] res = new int[n];
        //P=[];
        int[] tmp = new int[m];
        for (int i = 0; i < m; ++i) {
            tmp[i] = i+1;
        }
        //index in P
        int index_in_tmp = 0;

        for (int i = 0; i < n; ++i) {
            int index = queries[i];
            index_in_tmp = find(tmp, index);
            move(tmp, index_in_tmp);
            res[i] = index_in_tmp;
        }
        return res;
    }

    private static void move(int[] arr, int index) {
        int tmp = arr[index];
        while (index > 0){
            arr[index] = arr[index-1];
            index--;
        }
        arr[0] = tmp;
    }

    private static int find(int[] tmp, int index) {
        for (int i = 0; i < tmp.length; ++i) {
            if(tmp[i] == index){
                return i;
            }
        }
        return 0;
    }
}
