package com.xinzhe.categories.solutions.dp.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/26
 * Title : 514. 自由之路
 * Description : 视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。给定一个字符串ring，表示刻在外环上的编码；给定另一个字符串key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 *              最初，ring的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使key的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完key中的所有字符。旋转ring拼出 key 字符key[i]的阶段中：
 *              您可以将ring顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串ring的一个字符与 12:00 方向对齐，并且这个字符必须等于字符key[i] 。
 *              如果字符key[i]已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作1 步。按完之后，您可以开始拼写key的下一个字符（下一阶段）, 直至完成所有拼写。
 * link : https://leetcode-cn.com/problems/freedom-trail
 * Level : Hard
 */

//todo need to review
public class Leetcode514 {
    String ring, key;
    List<Integer>[] list = new List[26];
    int[][] dp;
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        this.ring = ring; this.key = key;
        this.dp = new int[m][n];
        for(int i=0; i<m; i++) {
            int p = ring.charAt(i) - 'a';
            if(list[p] == null) list[p] = new ArrayList<>();
            list[p].add(i);
        }
        return dfs(0, 0);
    }

    private int dfs(int p, int q) {
        if(q == key.length()) return 0;
        if(dp[p][q] != 0) return dp[p][q];
        int ans = (int)1e4;
        for(int next : list[key.charAt(q) - 'a']) {
            int dist = Math.abs(p - next);
            dist = Math.min(dist, ring.length() - dist);
            ans = Math.min(ans, dist + dfs(next, q + 1) + 1);
        }
        dp[p][q] = ans;
        return ans;
    }
}
