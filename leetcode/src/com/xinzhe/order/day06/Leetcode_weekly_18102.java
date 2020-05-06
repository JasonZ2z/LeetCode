package com.xinzhe.order.day06;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/5/5
 * Title : 1390. 四因数
 * Description : 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。
 *              如果数组中不存在满足题意的整数，则返回 0 。
 * link : https://leetcode-cn.com/problems/four-divisors/
 * Level : Medium
 * Comment : 181周赛02
 */
public class Leetcode_weekly_18102 {
    public static void main(String[] args) {
        int[] arr = {21,4,7};
        System.out.println(sumFourDivisors(arr));
    }
    public static int sumFourDivisors(int[] nums) {
        int res = 0;
        if(nums.length == 0) return res;
        for (int num : nums) {
            Set<Integer> set = new HashSet<>();
            set.add(1);
            set.add(num);
            for (int i = 2; i*i <= num; ++i) {
                int tmp = num/i;
                if(tmp * i == num){
                    set.add(tmp);
                    set.add(i);
                }
            }
            if(set.size() == 4) {
                for (Integer j : set) {
                    res += j;
                }
            }
        }
        return res;
    }
}
