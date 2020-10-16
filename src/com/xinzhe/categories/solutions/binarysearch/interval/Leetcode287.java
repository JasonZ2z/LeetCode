package com.xinzhe.categories.solutions.binarysearch.interval;

/**
 * @author Xin
 * @date 2020/3/31 21:37
 * Title : 287. 寻找重复数
 * Description : 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *      不能更改原数组（假设数组是只读的）。
 *      只能使用额外的 O(1) 的空间。
 *      时间复杂度小于 O(n2) 。
 *      数组中只有一个重复的数字，但它可能不止重复出现一次。
 * link : https://leetcode-cn.com/problems/find-the-duplicate-number
 * Level : Medium
 */
//todo need to review
public class Leetcode287 {
    //二分查找 + 抽屉原理
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if(count > mid){
                right = mid; //[left, mid]
            } else {
                left = mid +1;//[mid + 1, right]
            }
        }
        return left;
    }
    // 快慢指针
    public int findDuplicate2(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while(fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    public int findDuplicate3(int[] nums) {
        int n = nums.length;
        int l = 1, r = n-1;
        while(l < r) {
            int s1 = 0, s2 = 0;
            int mid = l + r >> 1;
            for(int x : nums) {
                if(x >= l && x <= mid)  s1++;
                if(x > mid && x <= r)  s2++;
            }
            if(s1 > s2) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
