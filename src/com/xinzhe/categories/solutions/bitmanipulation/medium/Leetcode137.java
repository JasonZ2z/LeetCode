package com.xinzhe.categories.solutions.bitmanipulation.medium;

/**
 * @author Xin
 * @date 2020/3/17 21:00
 * Title : 137. 只出现一次的数字 II
 * Description : 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * link : https://leetcode-cn.com/problems/single-number-ii/
 * Level : Medium
 */
public class Leetcode137 {
    public static void main(String[] args) {
        int[] nums = {Integer.MAX_VALUE,2,2,2};
        System.out.println(singleNumber(nums));
    }
    //状态机的思想
    //适用于m次的情况
    public static int singleNumber(int[] nums) {
        if(nums.length == 0) return 0;
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; ++i) {
                if((num & 1)== 1) {
                    count[i]++;
                }
                num >>= 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 31; i >= 0; --i) {
            sb.append(count[i]%3);
        }
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }


    public int singleNumber3(int[] nums) {
        int[] bits = new int[32];
        for (int i = 31; i >= 0; i--) {
            int bit = 0;
            for (int j = 0; j < nums.length; j++) {
                bit += (nums[j] & 1);
                nums[j] >>>= 1;
            }
            bits[i] = bit % 3;
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = 2 * ans + bits[i];
        }

        return ans;
    }
    //todo need to review
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
