package com.xinzhe.categories.solutions.bitoperation;

import java.util.ArrayList;
import java.util.List;

public class majorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        if(nums == null) {
            return new ArrayList<>() {
            };
        }
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        if(length == 1) {
            list.add(nums[0]);
            return list;
        }
        if(length == 2){
            if(nums[0] == nums[1]){
                list.add(nums[0]);
                return list;
            }else{
                list.add(nums[0]);
                list.add(nums[1]);
                return list;
            }
        }
        int len = length/3;

        int a = nums[0];
        int b = nums[1];
        int ca = 0;
        int cb = 0;
        for(int i = 2; i< length; i++){
            if(nums[i] == a) {
                ca++;
            } else if(nums[i] == b){
                cb++;
            } else {
                if(ca == 0) {
                    a = nums[i];
                    ca = 1;
                }else if(cb == 0){
                    b = nums[i];
                    cb = 1;
                }else {
                    ca--;
                    cb--;
                }
            }
        }
        int countA=0,countB=0;
        if(a == b ) {
            for (int num : nums) {
                if(num == a){
                    countA++;
                }
            }
            if(countA > len){
                list.add(a);
            }
        }
        if(a != b){
            for (int num : nums) {
                if(num == a){
                    countA++;
                }
                if(num == b){
                    countB++;
                }
            }
            if(countA > len){
                list.add(a);
            }
            if(countB > len){
                list.add(b);
            }
        }
        return list;
    }
}
