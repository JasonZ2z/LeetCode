package com.xinzhe.contest.weekly.season05.weekly202;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/8/16
 * Title : 1553. 吃掉 N 个橘子的最少天数
 * Description : 厨房里总共有 n 个橘子，你决定每一天选择如下方式之一吃这些橘子： 1 <= n <= 2*10^9
 *              1.吃掉一个橘子。
 *              2.如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子。
 *              3.如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子。
 *          每天你只能从以上 3 种方案中选择一种方案。请你返回吃掉所有 n 个橘子的最少天数
 * link : https://leetcode-cn.com/problems/minimum-number-of-days-to-eat-n-oranges
 * Level : Hard
 */
//todo need to review
public class Leetcode_weekly_20204 {
    public static void main(String[] args) {
        Leetcode_weekly_20204 lc = new Leetcode_weekly_20204();
        System.out.println(lc.minDays(56));
    }
    Map<Integer, Integer> map = new HashMap<>();
    public int minDays(int n) {
        if(n == 0) return 0;
        if(!map.containsKey(n)) {
            int ans = n;
            ans = Math.min(ans, minDays(n/2) + n%2 + 1);
            ans = Math.min(ans, minDays(n/3) + n%3 + 1);
            map.put(n, ans);
        }
        return map.get(n);

    }
}
