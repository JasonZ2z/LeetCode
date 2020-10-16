package com.xinzhe.categories.structure.arrays.easy;


/**
 * @author Xin
 * @date 2020/10/16
 * Title : 283. 移动零
 * Description : 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * link : https://leetcode-cn.com/problems/move-zeroes/
 * Level : Easy
 */
//todo need to review
public class Leetcode283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int len = nums.length;
        for(int i = 0; i < len-1 ; i++){
            if(nums[i] == 0){
                for(int j = i+1; j<len;j++){
                    if(nums[j] != 0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        for (int i = 0, cur = 0; i < len; i++) {
            if(nums[i] == 0) continue;
            if(cur != i){
                nums[cur] = nums[i];
                nums[i] = 0;
            }
            cur++;
        }
    }
}
