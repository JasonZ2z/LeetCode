package com.xinzhe.contest.weekly.season05.weekly224;

/**
 * @author Xin
 * @date 2021/01/17
 * Title : 1725. 可以形成最大正方形的矩形数目
 * Description : 给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
 *          如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。
 *          设 maxLen 为可以从矩形数组rectangles 切分得到的 最大正方形 的边长。返回可以切出边长为 maxLen 的正方形的矩形 数目 。
 * link : https://leetcode-cn.com/problems/number-of-rectangles-that-can-form-the-largest-square
 * Level : Easy
 */
public class Leetcode_weekly_22401 {
    public static void main(String[] args) {
        Leetcode_weekly_22401 lc = new Leetcode_weekly_22401();
    }
    public int countGoodRectangles(int[][] rectangles) {
        int n = 0, cnt = 0;
        for (int[] rectangle : rectangles) {
            int cur = Math.min(rectangle[0], rectangle[1]);
            if(cur > n) {
                n = cur;
                cnt = 1;
            } else if(cur == n) {
                cnt++;
            }
        }
        return cnt;
    }
}
