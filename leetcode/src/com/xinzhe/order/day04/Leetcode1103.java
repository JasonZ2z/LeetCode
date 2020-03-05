/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.xinzhe.order.day04;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/2/28 14:41
 * Title : 241. 为运算表达式设计优先级
 * Description : 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 *              给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 *              然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 *              重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。
 *              注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 *              返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 * link : https://leetcode-cn.com/problems/distribute-candies-to-people/
 * Level : Easy
 */
public class Leetcode1103 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(7,4)));
        System.out.println(Arrays.toString(distributeCandies(10,3)));
    }
    public static int[] distributeCandies(int candies, int n) {
//        int sum = (1 + n) * n /2;
//        int i = 0;
//        int all = candies;
//        while(all > sum){
//            all -= sum + (i++)*n*n;
//        }
        int[] result = new int[n];
        int tmp = 0;
        int k = 0;


        while(tmp < candies){
            for (int j = 0; j < n; j++) {
                int val = k*n + j+1;
                tmp += val;
                if(tmp > candies){
                    result[j] += candies - tmp + val;
                    break;
                }
                result[j] += val;
            }
            k++;
        }
//        int j = 0;
//        for (; j < n; j++) {
//            for (int k = 0; k <= i; k++) {
//                result[j] += j+1 + k*n;
//            }
//            tmp += result[j];
//            if(tmp > candies){
//                break;
//            }
//        }
//        for (int l = j; l < n; l++) {
//            for (int m = 0; m <= i - 1; m++) {
//                result[j] += j+1 + m*n;
//            }
//        }
       return result;

    }
}
