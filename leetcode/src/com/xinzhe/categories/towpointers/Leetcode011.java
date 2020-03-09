package com.xinzhe.categories.towpointers;

/**
 * @Author Xin
 * @create 2020/3/6 18:01
 * Title : 11. 盛最多水的容器
 * Description : 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 *              在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 *              找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * link : https://leetcode-cn.com/problems/container-with-most-water
 * Level : Medium
 */
public class Leetcode011 {
    public static void main(String[] args) {
        //int[] a = {1,2,4,3};
        int[] a = {1,8,6,2,5,4,8,3,7,1,5,10};
        System.out.println(maxArea(a));
    }
    public static int maxArea(int[] height) {
        if(height.length < 2) return 0;
        int left = 0;
        int right = height.length-1;
        int res = 0;
        int sum;
        while(right > left){
            sum = (right-left) * Math.min(height[right],height[left]);
            res = Math.max(res, sum);

            if(height[right] > height[left]){
                left++;
            } else {
                right++;

            }
        }
        return res;
    }
}
