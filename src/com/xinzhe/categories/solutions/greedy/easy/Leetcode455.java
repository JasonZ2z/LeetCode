package com.xinzhe.categories.solutions.greedy.easy;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/4/21
 * Title : 455. 分发饼干
 * Description : 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *              对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
 *              如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，
 *              这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * link : https://leetcode-cn.com/problems/assign-cookies
 * Level : Easy
 */

public class Leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;

        if(n == 0 || m == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i=0, j= 0;
        while(i < n && j < m) {
            if(s[j] >= g[i]){
                res++;
                i++;
            }
            j++;
        }
        return res;
    }
}
