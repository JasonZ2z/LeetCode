package com.xinzhe.contest.biweeekly.biweekly33;

/**
 * @author Xin
 * @date 2020/8/22
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_biweekly_3303 {
    public static void main(String[] args) {
        Leetcode_biweekly_3303 lc = new Leetcode_biweekly_3303();
        int[] arr = {1,5};
        System.out.println(lc.minOperations(arr));
    }
    public int minOperations(int[] nums) {
        int count= 0;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < nums.length; ++i){
                if(nums[i] % 2 == 1) {
                    nums[i]--;
                    count++;
                    flag = true;
                }
            }

            if(!flag) {
                int c  = 0;
                for (int i = 0; i < nums.length; ++i) {
                    if(nums[i] == 0) c++;
                    nums[i] /= 2;
                }
                if(c == nums.length) {
                    return count;
                }
                count++;
            }
        }
    }
}
