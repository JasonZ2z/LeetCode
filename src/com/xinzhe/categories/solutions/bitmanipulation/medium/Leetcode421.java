package com.xinzhe.categories.solutions.bitmanipulation.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/8/11
 * Title : 421. 数组中两个数的最大异或值
 * Description : 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 *              你能在O(n)的时间解决这个问题吗？
 * link : https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
 * Level : Medium
 */

//todo need to review
//A ^ B = C, then A ^ B ^ B = C ^ B, then A = C ^ B
public class Leetcode421 {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i) ;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(mask & num);
            }
            int tmp = max | (1 << i);
            for (int pre : set) {
                if(set.contains(pre ^ tmp)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
