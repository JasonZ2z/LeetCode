package com.xinzhe.contest.weekly.season03.weekly127;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 1005. K 次取反后最大化的数组和
 * Description : 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。
 *              （我们可以多次选择同一个索引 i。）以这种方式修改数组后，返回数组可能的最大和
 * link : https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * Level : Easy
 */

public class Leetcode_weekly_12701 {
    public static void main(String[] args) {
        Leetcode_weekly_12701 lc = new Leetcode_weekly_12701();
        int[] arr = {2,-3,-1,5,-4};
        System.out.println(lc.largestSumAfterKNegations(arr, 2));
    }
    public int largestSumAfterKNegations(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int min = 101;
        for (int i : A) {
            if(i < 0) list.add(-1 * i);
            else sum += i;
            min = Math.min(min, Math.abs(i));
        }
        if(list.size() <= K) {
            int x =  sum + list.stream().mapToInt(Integer::intValue).sum();
            if(K % 2 == list.size() % 2) return x;
            else return x - min * 2;
        }else {
            list.sort((a,b) -> b - a);
            for (int i = 0; i < list.size(); ++i) {
                if(i < K) sum += list.get(i);
                else sum -= list.get(i);
            }
            return sum;
        }
    }
}
