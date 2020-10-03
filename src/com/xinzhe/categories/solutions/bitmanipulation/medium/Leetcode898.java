package com.xinzhe.categories.solutions.bitmanipulation.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/8/17
 * Title : 898. 子数组按位或操作
 * Description : 我们有一个非负整数数组 A。
 *              对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
 *              返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 * link : https://leetcode-cn.com/problems/bitwise-ors-of-subarrays
 * Level : Medium
 */

public class Leetcode898 {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            for (int j = i-1; j >=0; j--) {
                if((arr[i] | arr[j])  == arr[j]) break;
                arr[j] |= arr[i];
                set.add(arr[j]);
            }
        }
        return set.size();
    }
}
