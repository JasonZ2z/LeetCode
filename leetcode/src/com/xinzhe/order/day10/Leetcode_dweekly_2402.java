package com.xinzhe.order.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/4/18 22:16
 * Title : 5373. 和为 K 的最少斐波那契数字数目
 * Description : 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 *      斐波那契数字定义为：
 *          F1 = 1
 *          F2 = 1
 *          Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 *      数据保证对于给定的 k ，一定能找到可行解。
 * link : https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k
 * Level : Medium
 * Comment : 24双周赛02
 */
public class Leetcode_dweekly_2402 {
    public static void main(String[] args) {
        System.out.println(findMinFibonacciNumbers(10));
    }

    public static int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        while (true){
            int n = list.size();
            int tmp = list.get(n-1) + list.get(n-2);
            if(tmp == k) {
                return 1;
            } else if(tmp > k) {
                break;
            }else {
                list.add(tmp);
            }
        }
        int len = list.size();
        int res = 0;

        while (k > 0) {
            for(int i = len-1; i >= 0; --i) {
                if(k >= list.get(i)){
                    k -= list.get(i);
                    System.out.println(list.get(i));
                    res++;
                    if(k == 0) return res;
                    break;
                }
            }
        }
        return res;
    }
}
