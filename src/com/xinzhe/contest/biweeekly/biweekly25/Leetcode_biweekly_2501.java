package com.xinzhe.contest.biweeekly.biweekly25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/5/2
 * Title :  1431. 拥有最多糖果的孩子
 * Description : 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 *              对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 * link : https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies
 * Level : Easy
 */
public class Leetcode_biweekly_2501 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = Arrays.stream(candies).boxed().max(Integer::compareTo).get();
        for (int candy : candies) {
            if(candy + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;

    }
}
