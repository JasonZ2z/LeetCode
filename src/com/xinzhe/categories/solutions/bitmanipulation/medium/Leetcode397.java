package com.xinzhe.categories.solutions.bitmanipulation.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/8/18
 * Title : 397. 整数替换
 * Description : 给定一个正整数 n，你可以做如下操作：1. 如果 n 是偶数，则用 n / 2替换 n。2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。n 变为 1 所需的最小替换次数是多少？
 * link : https://leetcode-cn.com/problems/integer-replacement
 * Level : Medium
 */
public class Leetcode397 {
    public static void main(String[] args) {
        int[] nums = {Integer.MAX_VALUE,2,2,2};
    }
    Map<Integer, Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        if(n == 1) return 0;
        if(n == Integer.MAX_VALUE) return 32;
        if(map.containsKey(n)) return map.get(n);
        if((n&1) == 0) return integerReplacement(n>>1) + 1;
        int res = Math.min(integerReplacement(n+1), integerReplacement(n-1)) + 1;
        map.put(n , res);
        return res;
    }

    //todo need to review
    public int integerReplacement2(int n) {
        int count = 0;
        while(n != 1) {
            if((n & 1) == 0) {
                n>>>=1;
            } else {
                if((n&2) == 0) n--;
                else if(n == 3) {
                    count+=2;
                    break;
                } else {
                    n++;
                }
            }
            count++;
        }
        return count;
    }
}
