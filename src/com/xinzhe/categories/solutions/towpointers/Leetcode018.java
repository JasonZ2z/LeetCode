package com.xinzhe.categories.solutions.towpointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/3/6 19:11
 * Title : 18. 四数之和
 * Description : 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 *               找出所有满足条件且不重复的四元组。注意：答案中不可以包含重复的四元组。
 * 示例：
 *      给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *      满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * link : https://leetcode-cn.com/problems/4sum
 * Level : Medium
 */
public class Leetcode018 {
    public static void main(String[] args) {
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        System.out.println(fourSum(nums, -11));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int pre = nums[i] + nums[j];
                int p = j+1;
                int q = nums.length-1;
                while(p < q && p< nums.length){
                    int sum = pre + nums[p] + nums[q];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i],nums[j], nums[p], nums[q]));
                        while (p < q && nums[p] == nums[p+1]) p++;
                        while (p < q && nums[q] == nums[q-1]) q--;
                        p++;
                        q--;
                    } else if(sum > target){
                        q--;
                    } else {
                        p++;
                    }
                }
                while(j<nums.length -2 && nums[j] == nums[j+1]) j++;
            }
            while(i<nums.length -3 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }
}
