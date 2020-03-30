package com.xinzhe.categories.structure.arrays;

import java.util.*;

public class ThreeSums {
    public static void main(String[] args) {
       //int[] nums = new int[]{-1,0,1,2,-1,-4};
        //int[] nums = new int[]{0,0,0,0};
        //int[] nums = new int[]{3,0,-2,-1,1,2};
        int[] nums = new int[]{-2,0,0,2,2};
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        System.out.println(list.toString());
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        int len = nums.length;
        if(len == 1 || len == 2 )return  result;
        if(len == 3 && (nums[0] + nums[1] + nums[2] != 0)) return result;

        Arrays.sort(nums);
        for (int i = 0; i < len-2; i++) {
            if(nums[i] > 0 ) continue;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int p = i+1;

            int q = len-1;

            while(p < q ){
                if(nums[i] + nums[p] + nums[q] == 0 ){
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[p]);
                    list.add(nums[i]);
                    list.add(nums[q]);
                    result.add(list);
                    while(p > q && nums[p] == nums[p+1]) {
                        p++;
                    }
                    while(p > q  && nums[q] == nums[q-1]) {
                        q--;
                    }
                    q--;
                    p++;
                }else if(nums[i] + nums[p] + nums[q] > 0){
                    q--;
                }else{
                    p++;
                }
            }
        }
        return result;
    }



}
