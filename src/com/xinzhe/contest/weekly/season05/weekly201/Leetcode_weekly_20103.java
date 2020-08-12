package com.xinzhe.contest.weekly.season05.weekly201;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/8/2
 * Title : 1546. 和为目标值的最大数目不重叠非空子数组数目
 * Description : 给你一个数组 nums 和一个整数 target 。请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
 * link : https://leetcode-cn.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 * Level : Medium
 */

//todo need to review
public class Leetcode_weekly_20103 {
    public static void main(String[] args) {
        Leetcode_weekly_20103 lc = new Leetcode_weekly_20103();
        int[] arr = {-2,6,6,3,5,4,1,2,8};
        System.out.println(lc.maxNonOverlapping(arr, 10));
    }

    public int maxNonOverlapping(int[] nums, int target) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int num : nums) {
            sum += num;
            if(map.containsKey(sum - target)) {
                count += map.get(sum - target);
                sum = 0;
                map.clear();
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public int maxNonOverlapping2(int[] nums, int target) {
        int sum=0;
        int result=0;
        int index=-1;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-target)&&map.get(sum-target)>=index){
                result++;
                index=i;
            }
            map.put(sum,i);
        }
        return result;
    }
}
