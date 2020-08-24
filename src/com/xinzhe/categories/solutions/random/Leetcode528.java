package com.xinzhe.categories.solutions.random;

import java.util.Random;
import java.util.TreeMap;

/**
 * @author Xin
 * @date 2020/8/24
 * Title : 528. 按权重随机选择
 * Description : 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
 *              例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 *              也就是说，选取下标 i 的概率为 w[i] / sum(w)
 * link : https://leetcode-cn.com/problems/random-pick-with-weight
 * Level : Medium
 */
//todo need to review
public class Leetcode528 {
    int sum = 0;
    Random r ;
    // <sum, index>
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public Leetcode528(int[] w) {
        this.r = new Random();
        for (int j = 0; j < w.length; j++) {
            sum += w[j];
            map.put(sum, j);
        }
    }
    public int pickIndex() {
        int index = r.nextInt(sum);
        int ceilingKey = map.higherKey(index);
        return map.get(ceilingKey);
    }
}
