package com.xinzhe.categories.solutions.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/2/24 11:43
 * Title : 1. 两数之和
 * Description : 给定一个整数数组 nums 和一个目标值 target，
 *              请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *              你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * link : https://leetcode-cn.com/problems/two-sum/
 */
public class Leetcode001 {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target){
        if(nums == null || nums.length == 1) {
            return null;
        }
        // <target-nums[i], i>
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{i, map.get(nums[i])};
            } else {
                map.put(target-nums[i], i);
            }
        }
        return null;
    }
}
