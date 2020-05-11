package com.xinzhe.categories.solutions.segmtree;

/**
 * @Author Xin
 * @create 2020/5/9
 * Title : 53. 最大子序和
 * Description : 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * link : https://leetcode-cn.com/problems/maximum-subarray
 * Level : Easy
 */
public class Leetcode053 {
    public class array{
        public int lSum;
        public int rSum;
        public int mSum;
        public int iSum;
        public array(int lSum,int rSum,int mSum,int iSum){
            this.lSum=lSum;
            this.rSum=rSum;
            this.mSum=mSum;
            this.iSum=iSum;
        }
    }
    public array merge(array l,array r){
        int iSum=l.iSum+r.iSum;
        int lSum=Math.max(l.lSum, l.iSum+r.lSum);
        int rSum=Math.max(r.rSum, r.iSum+l.rSum);
        int mSum=Math.max(Math.max(l.mSum,r.mSum),l.rSum+r.lSum);
        return new array(lSum,rSum,mSum,iSum);
    }
    public array build(int[]nums, int l,int r){
        if(l==r){
            return new array(nums[l],nums[l],nums[l],nums[l]);
        }
        else{
            int medium = (l+r)>>1;
            array left = build(nums,l,medium);
            array right =build(nums,medium+1,r);
            return merge(left,right);
        }

    }

    public int maxSubArray(int[] nums) {
        if(nums.length==0)
            return 0;
        else{
            array a = build(nums,0,nums.length-1);
            return a.mSum;
        }

    }
}
