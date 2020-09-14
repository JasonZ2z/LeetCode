package com.xinzhe.contest.lccup.summer2020.group;

/**
 * @author Xin
 * @date 2020/4/25 14:56
 * Title : LCP 12. 小张刷题计划
 * Description : 为了提高自己的代码能力，小张制定了 LeetCode 刷题计划，他选中了 LeetCode 题库中的 n 道题，编号从 0 到 n-1，并计划在 m 天内按照题目编号顺序刷完所有的题目（注意，小张不能用多天完成同一题）。
 *              在小张刷题计划中，小张需要用 time[i] 的时间完成编号 i 的题目。
 *              此外，小张还可以使用场外求助功能，通过询问他的好朋友小杨题目的解法，可以省去该题的做题时间。
 *              为了防止“小张刷题计划”变成“小杨刷题计划”，小张每天最多使用一次求助。
 * 我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。请你帮小张求出最小的 T是多少。
 * link : https://leetcode-cn.com/problems/xiao-zhang-shua-ti-ji-hua
 * Level : Medium
 * Comment 2020-spring-group-02
 */
public class LCP_12 {
    public static void main(String[] args) {
        LCP_12 lt = new LCP_12();
        int[] time = {1,2,3,3};
        System.out.println(lt.minTime(time, 2));
    }
    public int minTime(int[] time, int m) {
        int n = time.length;
        if( m >= n) return 0;

        int sum = 0;
        for (int value : time) {
            sum += value;
        }
        int left = 0, right = sum;
        while(left < right) {
            int mid = left + ((right - left) >> 1) ;
            if(helper(time, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean helper(int[] time, int m, int mid){
        int sum = 0;
        int max = 0;
        for (int value : time) {
            sum += value;
            max = Math.max(max, value);
            if (sum - max > mid) {
                m--;
                sum = value;
                max = value;
            }
        }
        return m > 0;
    }
}
