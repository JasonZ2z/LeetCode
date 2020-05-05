package com.xinzhe.order.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/2
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_dweekly_2501 {
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
