package com.xinzhe.categories.arrays;
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
public class RemoveDuplicate {

    public static void main(String[] args) {
        int[]nums = new int[]{0,0,1,1,1,2,2,3,3,4,4,4,4,4,4,22};

        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int tmp = Integer.MIN_VALUE;
        int i = 0;
        for (int num : nums) {
            if(num != tmp){
                nums[i++] = num;
                tmp = num;
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        return i;
    }
}
