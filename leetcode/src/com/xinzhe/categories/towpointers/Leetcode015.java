package com.xinzhe.categories.towpointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/6 18:11
 * Title : 15. 三数之和
 * Description : 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * link : https://leetcode-cn.com/problems/3sum
 * Level : Medium
 */
public class Leetcode015 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length <= 2) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int p = i+1, q = nums.length-1;
            while(p < q){
                int sum = nums[p] + nums[i] + nums[q];
                if(sum == 0){
                    res.add(Arrays.asList(nums[p], nums[i], nums[q]));
                    while (p<q && nums[p] == nums[p+1]) p++;
                    while (p<q && nums[q] == nums[q-1]) q--;
                    q--;
                    p++;
                } else if(sum < 0){
                    p++;
                } else {
                    q--;
                }
            }
        }
        return res;
    }
}
