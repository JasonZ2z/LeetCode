package com.xinzhe.contest.weekly.season05.weekly222;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/12/27
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_22203 {
    public static void main(String[] args) {
        Leetcode_weekly_22203 lc = new Leetcode_weekly_22203();
        int[] arr = {1,1,1};
        System.out.println(lc.waysToSplit(arr));
    }

    final int mod = (int)(1e9 + 7);
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for(int i=1; i<=n; i++) pre[i] = pre[i-1] + nums[i-1];

        long[][] sum = new long[n][n];
        for (int i = 0; i < n; ++i) {
            int cur = 0;
            for (int j = i; j < n; ++j) {
                cur += nums[j];
                sum[i][j] = cur;
            }
        }

        long res = 0L;
        for (int i = 0; i < n - 2; ++i) {
            // left_start = 0;
            // left_end = i;
            long left = pre[i+1] - pre[0];
            // mid_start = i + 1;
            // mid_end = mid;

            // right_start = mid + 1;
            // right_end = n;

            int start = Arrays.binarySearch(sum[i + 1], i + 1, n - 1, left);
            if(start < 0) {
                start = -(start+1);
            }
            if(start > i && start < n - 1 && pre[start + 1] - pre[i + 1] >= pre[i+1] && pre[n] - pre[start + 1] >= pre[start + 1] - pre[i + 1]) {
                int l = start + 1, r = n;

                while ( l < r ) {
                    int mid = l + r >> 1;
                    if(pre[mid + 1] - pre[i + 1] >= pre[i+1] && pre[n] - pre[mid + 1] >= pre[mid + 1] - pre[i + 1]) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                if(pre[l + 1] - pre[i + 1] >= pre[i+1] && pre[n] - pre[l + 1] >= pre[l + 1] - pre[i + 1]) {
                    res += l - start + 1;
                }
            }

        }
        return (int) (res % mod);
    }
}
