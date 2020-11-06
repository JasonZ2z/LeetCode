package com.xinzhe.sword.chapter08;

/**
 * @author Xin
 * @date 2020/7/14
 * Title : 08.03. 魔术索引
 * Description : 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 *              给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 * link : https://leetcode-cn.com/problems/magic-index-lcci
 * Level : Medium
 */
//todo need to review
public class Interview_0803 {
    public int findMagicIndex(int[] nums) {
        int flag = 0;
        while (flag < nums.length) {

            if (nums[flag] == flag) {
                return flag;
            } else if (nums[flag] > flag) {  //重点 , 过滤掉不需要比较的元素
                flag = nums[flag];
            }else{
                flag++;
            }
        }

        return -1;
    }

    public int findMagicIndex2(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }
}
