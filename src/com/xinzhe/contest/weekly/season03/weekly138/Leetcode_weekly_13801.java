package com.xinzhe.contest.weekly.season03.weekly138;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/25
 * Title : 1051. 高度检查器
 * Description : 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 *              注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
 * link : https://leetcode-cn.com/problems/height-checker
 * Level : Easy
 */

public class Leetcode_weekly_13801 {
    public static void main(String[] args) {
        Leetcode_weekly_13801 lc = new Leetcode_weekly_13801();
    }
    public int heightChecker(int[] heights) {
        int[] h = heights.clone();
        Arrays.sort(h);
        int count = 0;
        for(int i = 0; i<h.length; i++) {
            if(h[i] != heights[i]) count++;
        }
        return count;
    }
}
