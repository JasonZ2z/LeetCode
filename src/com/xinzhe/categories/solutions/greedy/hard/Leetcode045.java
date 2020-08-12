package com.xinzhe.categories.solutions.greedy.hard;

/**
 * @author Xin
 * @date 2020/5/4
 * Title : 45. 跳跃游戏 II
 * Description : 给定一个非负整数数组，你最初位于数组的第一个位置。
 *              数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *              你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * link : https://leetcode-cn.com/problems/jump-game-ii
 * Level : Hard
 */
public class Leetcode045 {

    //[2,3,1,1,4]
    public int jump(int[] nums) {
        int index = 0;
        int max = 0;
        int res = 0;
          for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == index) {
                index = max;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode045 lc = new Leetcode045();
        int[] arr = {2,3,1,1,4};
        System.out.println(lc.jump(arr));
    }
}
