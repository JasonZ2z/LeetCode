package com.xinzhe.contest.weekly.season03.weekly146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/9/28
 * Title : 1128. 等价多米诺骨牌对的数量
 * Description : 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *              如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *              形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *              在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * link : https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * Level : Easy
 */

public class Leetcode_weekly_14601 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int[] domino : dominoes) {
            int a = domino[0], b = domino[1];
            int x = a * 1001 + b;
            int y = b * 1001 + a;
            count += map.getOrDefault(x, 0);
            count += x == y ? 0 : map.getOrDefault(y, 0);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return count;
    }
}
