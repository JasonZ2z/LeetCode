package com.xinzhe.categories.solutions.segmtree;

/**
 * @author Xin
 * @date 2020/5/9
 * Title : 327. 区间和的个数
 * Description : 给定一个整数数组nums，返回区间和在[lower, upper]之间的个数，包含lower和upper。区间和S(i, j)表示在nums中，位置从i到j的元素之和，包含i和j(i ≤ j)。
 * link : https://leetcode-cn.com/problems/count-of-range-sum
 * Level : Hard
 */
//todo need to review
public class Leetcode327 {
    //O(n*n)
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (lower <= sum && sum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }
    //归并排序 + 前缀和
    //O(NlogN)
    public int countRangeSum2(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }
                ret += r - l;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = (int) sum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = (int) sum[p1++];
                } else {
                    if (sum[p1] < sum[p2]) {
                        sorted[p++] = (int) sum[p1++];
                    } else {
                        sorted[p++] = (int) sum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return ret;
        }
    }
}
