package com.xinzhe.categories.solutions.hash;

/**
 * @author Xin
 * @date 2020/2/24 14:21
 * Title : 167. 两数之和 II - 输入有序数组
 * Description : 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *              函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *              说明:
 *              返回的下标值（index1 和 index2）不是从零开始的。
 *              你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * link : https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * level : Easy
 */
public class Leetcode167 {

    /**
     * Better：Head and tail pointers
     */
    public int[] twoSum2(int[] nums, int target) {
        if(nums == null || nums.length == 1) {
            return null;
        }
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            if(nums[i] + nums[j] == target){
                return new int[]{i+1,j+1};
            } else if(nums[i] + nums[j] < target){
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    /**
     * common solution：
     * double iteration and pruning
     */
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 1) {
            return null;
        }
        for (int i = 0; i < nums.length-1; i++) {
            int j = i+1;
            while (j < nums.length){
                if(nums[i] + nums[j] == target){
                    return new int[]{i+1,j+1};
                } else if(nums[i] + nums[j] < target){
                    j++;
                } else {
                    break;
                }
            }
        }
        return null;
    }
}
