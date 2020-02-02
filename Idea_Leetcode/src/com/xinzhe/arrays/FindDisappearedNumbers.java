package com.xinzhe.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {


    public static void main(String[] args) {
        int[]  nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);

        for (Integer disappearedNumber : nums) {
            System.out.print(disappearedNumber + " ");
        }
        System.out.println();

        for (Integer disappearedNumber : disappearedNumbers) {
            System.out.print(disappearedNumber + " ");
        }
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i])-1]>0){
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i);
            }
        }
        return list;
    }
}
