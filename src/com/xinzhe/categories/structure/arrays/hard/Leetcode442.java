package com.xinzhe.categories.structure.arrays.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @create 2020/4/10 21:37
 * Title : 442. 数组中重复的数据
 * Description : 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *              找到所有出现两次的元素。
 *              你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * link : https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
 * Level : Medium
 */
//todo need to review
//这道题不用交换数据，直接统计就可以
public class Leetcode442 {

    //0,1,2,3,4,5,6
    //1,4,3,4,2,3,5
    //1,
    public static void main(String[] args) {
        int[] num = {1,4,3,4,2,3,5};
        System.out.println(findDuplicates(num));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if(n < 2) return res;
        for (int i = 0; i < n; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                res.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        return res;
    }
}
