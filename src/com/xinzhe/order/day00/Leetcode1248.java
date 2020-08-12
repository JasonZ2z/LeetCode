package com.xinzhe.order.day00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/2/25 16:10
 * Title : 1248. 统计「优美子数组」
 * Description : 给你一个整数数组 nums 和一个整数 k。
 *      如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *      请返回这个数组中「优美子数组」的数目。
 * link : https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * Level : medium
 */
public class Leetcode1248 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1};
        System.out.println(numberOfSubarrays(nums, 2));
        System.out.println(numberOfSubarrays2(nums, 2));
        System.out.println(numberOfSubarrays3(nums, 2));
        System.out.println(numberOfSubarrays4(nums, 2));
    }

    //超时
    public static int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length < k) return 0;
        if (nums.length == k) {
            for (int num : nums) {
                if (num % 2 == 0) return 0;
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = i; j < nums.length; j++) {
                if (tmp < k) {
                    if (nums[j] % 2 != 0) {
                        tmp++;
                        if (tmp == k) {
                            count++;
                        }
                    }
                } else if (tmp == k) {
                    if (nums[j] % 2 == 0) {
                        count++;
                    } else {
                        tmp++;
                    }

                } else {
                    break;
                }
            }
        }
        return count;
    }

    // 滑动窗口
    public static int numberOfSubarrays2(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        int feed = 0;

        int[] arr = new int[len + 2];
        for (int i = 0; i < len; i++) {
            if ((nums[i] & 1) == 1) {
                arr[++feed] = i;
            }
        }
        arr[0] = -1;
        arr[feed + 1] = len;

        for (int i = 1; i + k < feed + 2; i++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;
    }

    //将间隔的偶数个数放入list集合即可
    public static int numberOfSubarrays3(int[] nums, int k) {
        System.out.println(Arrays.toString(nums));
        int res = 0;
        int preEven = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if ((num & 1) == 0) {
                preEven++;
            } else {
                list.add(preEven + 1);
                preEven = 0;
            }
        }
        list.add(preEven + 1);
        System.out.println(list);
        for (int i = 0; i < list.size() - k; ++i) {
            res += list.get(i) * list.get(i + k);
        }
        return res;
    }

    public static int numberOfSubarrays4(int[] nums, int k) {
        int res = 0;
        if (nums.length == 0) {
            return res;
        }
        int left = 0, right = left + 1; // 双指针
        int kCnt = nums[0] % 2 == 0 ? 0 : 1; // 当前指针内奇数的个数
        int lastkindex = -1; // 双指针窗口左边最近一个奇数的下标
        while (right < nums.length) {
            if (kCnt == k) { // 当窗口符合条件
                res += (left - lastkindex); // 计算的条件为，right每走一步，加上 两个指针之间偶数的个数
            }
            if (nums[right++] % 2 != 0) {
                if (kCnt == 0) {
                    left = right - 1; // 初始化左指针到第一个奇数的位置
                }
                kCnt++;
            }
            if (kCnt > k) { // 当窗口内的奇数过大时，需要调整 lastKIndex和left
                lastkindex = left;
                left++;
                while (nums[left] % 2 == 0) {
                    left++;
                }
                kCnt--;
            }
        }
        if (kCnt == k) { // 最后一个right指针没有计算，所以需要额外计算一次
            res += (left - lastkindex);
        }
        return res;
    }
}
