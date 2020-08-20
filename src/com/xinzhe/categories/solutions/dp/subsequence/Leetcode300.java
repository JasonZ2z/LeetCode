package com.xinzhe.categories.solutions.dp.subsequence;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/3/11 18:25
 * Title : 300. 最长上升子序列
 * Description : 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * link : https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 * Level : Medium
 */
public class Leetcode300 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        System.out.println(lengthOfLIS(arr));
        System.out.println(lengthOfLIS2(arr));
    }
    //以 nums[i] 为结尾的最长递增子序列
    //时间复杂度：O(N^2)
    //空间复杂度：O(N)
    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 0;
        for(int i = 1; i<n; ++i){
            for(int j =i-1; j>=0; --j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] +1 ,dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }

    //二分查找
    //时间复杂度：O(NlogN)，遍历数组使用了 O(N)，二分查找法使用了O(logN)。
    //空间复杂度：O(N)
    public static int lengthOfLIS2(int[] nums){
        int n = nums.length;
        if(n < 2) return n;
        //tail[i] 表示为长度i+1的所有上升子序列的结尾的最小值，不是长度，是可能的结尾的最小值
        int[] tail = new int[n];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < n; ++i) {
            if(nums[i] > tail[end]){
                tail[++end] = nums[i];
            } else {
                int left = 0;
                int right = end;
                while (left < right){
                    int mid = left + ((right - left) >> 1);
                    if(tail[mid] < nums[i]){
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
            printArray(nums[i] , tail);
        }
        return ++end;
    }

    public int lengthOfLIS3(int[] nums) {
        if(nums==null||nums.length==0) return 0;

        int len = 0;
        int[] dp = new int[nums.length];

        for(int num: nums){
            int ind = Arrays.binarySearch(dp,0,len,num);

            if(ind<0) ind = -(ind+1);

            if(ind==len) {
                len++;
            }

            dp[ind] = num;
        }

        return len;
    }
    private static void printArray(int num, int[] tail) {
        System.out.print("当前数字：" + num);
        System.out.print("\t当前 tail 数组：");
        int len = tail.length;
        for (int value : tail) {
            if (value == 0) {
                break;
            }
            System.out.print(value + ", ");
        }
        System.out.println();
    }
}
