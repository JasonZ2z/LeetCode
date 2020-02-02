package com.xinzhe.Binary;

import java.util.Arrays;

public class HammingDistance {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-2,1,1,-3,1,-3,-3,-4,-2};
        Arrays.sort(nums);

    }
    public static int hammingDistance(int x, int y) {
        int a = x^y;
        int sum = 0;
        while(a>0){
            if(a%2 != 0){
                sum++;
            }
            a /= 2;
        }
        return sum;
    }

    public static int singleNumber(int[] nums) {
        if(nums == null || nums.length < 4) {
            return 0;
        }
        int[] count = new int[32];

        for(int j = 0; j < nums.length; j++){
            for(int i = 0; i< 32; i++) {
                if(nums[j] % 2 == 1){
                    count[i]++;
                }
                nums[j]>>=1;
            }
        }
        int value=0;
        for(int i=31; i>=0; i--){
            value <<=1;
            if(count[i] % 3 != 0){
                value++;
            }

        }
        return value;

    }
}
