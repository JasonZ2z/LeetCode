package com.xinzhe.categories.solutions.dp.compress;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/5/15
 * Title : 691. 贴纸拼词
 * Description : 我们给出了 N 种不同类型的贴纸。每个贴纸上都有一个小写的英文单词。
 * 你希望从自己的贴纸集合中裁剪单个字母并重新排列它们，从而拼写出给定的目标字符串 target。
 * 如果你愿意的话，你可以不止一次地使用每一张贴纸，而且每一张贴纸的数量都是无限的。
 * 拼出目标 target 所需的最小贴纸数量是多少？如果任务不可能，则返回 -1。
 * link : https://leetcode-cn.com/problems/stickers-to-spell-word
 * Level : Hard
 */

//todo need to review
public class Leetcode691 {
    public int minStickers(String[] stickers, String target) {
        int m = target.length();
        int len = 1 << m;
        int[] dp = new int[len];
        Arrays.fill(dp, -1);

        for (int state = 0; state < len; ++state) {
            if (dp[state] == -1) continue;
            for (String sticker : stickers) {
                int init = state;
                for (char c : sticker.toCharArray()) {
                    for (int i = 0; i < m; ++i) {
                        if (((init >> i) & 1) == 1) continue;
                        if (target.charAt(i) == c) {
                            init |= (1 << i);
                            break;
                        }
                    }
                }
                if (dp[init] == -1 || dp[init] > dp[state] + 1) {
                    dp[init] = dp[state] + 1;
                }
            }

        }
        return dp[len - 1];
    }

}
