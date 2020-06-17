package com.xinzhe.contest.weekly.season04.weekly165;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/6/03
 * Title : 1277. 统计全为 1 的正方形子矩阵
 * Description : 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * link : https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/
 * Level : Medium
 * Comment 165周赛03
 */

public class Leetcode_weekly_16503 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result = new ArrayList<>();
        if (tomatoSlices % 2 != 0 || tomatoSlices > 4 * cheeseSlices || tomatoSlices < 2 * cheeseSlices) {
            return result;
        }
        int bigBurgers = tomatoSlices / 2 - cheeseSlices;
        int smallBurgers = cheeseSlices - bigBurgers;
        result.add(bigBurgers);
        result.add(smallBurgers);
        return result;
    }
}
