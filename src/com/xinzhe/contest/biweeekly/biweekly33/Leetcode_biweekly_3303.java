package com.xinzhe.contest.biweeekly.biweekly33;

/**
 * @author Xin
 * @date 2020/8/22
 * Title : 1558. 得到目标数组的最少函数调用次数
 * Description : 给你一个与 nums 大小相同且初始值全为 0 的数组 arr ，请你调用以上函数得到整数数组 nums 。
 *              请你返回将 arr 变成 nums 的最少函数调用次数。答案保证在 32 位有符号整数以内。
 * link : https://leetcode-cn.com/problems/minimum-numbers-of-function-calls-to-make-target-array
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
