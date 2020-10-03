package com.xinzhe.categories.solutions.bitmanipulation.easy;

/**
 * @author Xin
 * @date 2020/4/29
 * Title : 645. 错误的集合
 * Description : 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 *              给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * link : https://leetcode-cn.com/problems/set-mismatch
 * Level : Easy
 */

public class Leetcode645 {

    //使用了额外的空间
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] count = new int[nums.length+1];
        for(int num :nums) {
            if(count[num] != 0) {
                res[0] = num;
            } else {
                count[num] = 1;
            }
        }

        for(int i = 1; i <= nums.length; i++){
            if(count[i] == 0) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    //不需要额外空间
    public int[] findErrorNums1(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if(nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            } else {
                res[0] = Math.abs(nums[i]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if(nums[i] > 0) {
                res[1] = i+1;
                break;
            }
        }
        return res;
    }
    //位运算
    // 1,2,3,4,5,6,7,8
    // 1,2,3,4,5,5,7,8

    // 1 3 5 7 1 3 5 5 7
    // 2 4 6 8 2 4 8

    public int[] findErrorNums2(int[] nums){
        int n = nums.length;
        int xor = 0;
        for (int i = 1; i <= n; ++i) {
            xor ^= i;
        }
        for (int item : nums) {
            xor ^= item;
        }

        //优化
        xor &= -xor;
//        int idx = 1;
//        while (true){
//            if((xor & 1) == 1) {
//                break;
//            } else {
//                xor >>= 1;
//                idx <<= 1;
//            }
//        }
        int res0 = 0, res1 = 0;
        for (int value : nums) {
            if ((value & xor) != 0) {
                res0 ^= value;
            } else {
                res1 ^= value;
            }
        }
        for (int i = 1; i <= n; ++i) {
            if((i & xor) != 0) {
                res0 ^= i;
            } else {
                res1 ^= i;
            }
        }
        boolean flag = false;
        for (int num : nums) {
            if(num == res0) {
                flag = true;
                break;
            }
        }
        return flag ? new int[]{res0, res1} : new int[]{res1, res0};
    }
}
