package com.xinzhe.contest.biweeekly.s1.biweekly39;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/11/14
 * Title : 1655. 分配重复整数
 * Description : 给你一个长度为n的整数数组nums，这个数组中至多有50个不同的值。同时你有 m个顾客的订单 quantity，其中，整数quantity[i]是第i位顾客订单的数目。请你判断是否能将 nums中的整数分配给这些顾客，且满足：
 *              第i位顾客 恰好有quantity[i]个整数。
 *              第i位顾客拿到的整数都是 相同的。
 *              每位顾客都满足上述两个要求。如果你可以分配 nums中的整数满足上面的要求，那么请返回true，否则返回 false。
 * link : https://leetcode-cn.com/problems/distribute-repeating-integers
 * Level : Hard
 */
public class Leetcode_biweekly_3904 {
    public static void main(String[] args) {
        Leetcode_biweekly_3904 lc = new Leetcode_biweekly_3904();
        int[] arr = {1,1,2};
        System.out.println(lc.numRabbits(arr));
    }


    public int numRabbits(int[] answers) {
        int n = answers.length;
        if(n == 0) return 0;
        int[] cnt = new int[1000];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int sum = 0;
        for(int a : answers) {
            if(a == 0) sum++;
            else cnt[a]++;
        }
        for (int i = 0; i < 1000; i++) {
            if(cnt[i] > 0) map.computeIfAbsent(cnt[i], a -> new HashSet<>()).add(i);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> value = entry.getValue();
            Integer key = entry.getKey();

            for (Integer i : value) {
                if(i >= key) sum += i + 1;
                else {
                    int x = key / (i + 1);
                    int y = key % (i + 1);

                    if(y == 0) sum += x * (i + 1);
                    else sum += (x + 1) * (i + 1);
                }

            }

        }
        return sum;
    }

    public int numRabbits2(int[] answers) {
        int res = 0;
        int[] count = new int[1000];

        for(int a : answers){
            count[a]++;
            if(a == 0 || count[a] % (a + 1) == 1)
                res += a + 1;
        }

        return res;
    }
}
