package com.xinzhe.contest.weekly.season03.weekly143;

/**
 * @author Xin
 * @date 2020/8/18
 * Title : 1103. 分糖果 II
 * Description :  我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 *              给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 *              然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * link : https://leetcode-cn.com/problems/distribute-candies-to-people/
 * Level : Easy
 */

public class Leetcode_weekly_14301 {
    public static void main(String[] args) {
        Leetcode_weekly_14301 lc = new Leetcode_weekly_14301();
    }
    public int[] distributeCandies(int candies, int n) {
        int index = 0;
        int[] res = new int[n];
        while (candies > 0) {
            int i = index % n;
            int cur = (index / n) * n + i + 1;
            res[i] += Math.min(candies, cur);
            candies -= cur;
            index++;
        }
        return res;
    }
}
