package com.xinzhe.contest.nowcoder.s1.s109;

/**
 * @Author Xin
 * @create 2020/8/7
 * Title : 牛牛的木板
 * Description : 数组由 0，1组成，修改 m个 0 到 1，判断连续1的最大长度
 * link : https://ac.nowcoder.com/acm/contest/6947/B
 * Level : Medium
 * tag : 滑动窗口
 */
//todo need to review
public class nowcoder_0902 {
    /**
     *
     * @param n int整型
     * @param m int整型
     * @param a int整型一维数组
     * @return int整型
     */
    public int solve (int n, int m, int[] a) {

        int l = 0, r = 0;
        int zeros = 0, max = 0;
        while(r < n) {
            if(a[r] == 0) {
                zeros++;
            }
            while (zeros > m) {
                if(a[l++] == 0) {
                    zeros--;
                }
            }
            max = Math.max(r - l+1, max);
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        nowcoder_0902 nc = new nowcoder_0902();
        int[] arr = {1,0,0,1,1,1};
        System.out.println(nc.solve(6,1, arr));
    }
}
