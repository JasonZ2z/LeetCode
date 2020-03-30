package com.xinzhe.categories.structure.arrays;

public class moveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroe(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void moveZeroe(int[] nums) {
        if(nums == null || nums.length <2) {
            return;
        }
        int len = nums.length;
        int tmp;
        for(int i = 0; i < len-1 ; i++){
            if(nums[i] == 0){
                for(int j = i+1; j<len;j++){
                    if(nums[j] != 0){
                        tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
            }

        }
    }
}
