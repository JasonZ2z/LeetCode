package com.xinzhe.categories.structure.sort.implement;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/26
 * Title : 179. 最大数
 * Description : 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * link : https:https://leetcode-cn.com/problems/largest-number/
 * Level : Medium
 */
//todo need to review
public class Leetcode179 {
    public String largestNumber(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .map(num -> Integer.toString(num))
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .reduce(String::concat)
                .filter(s->!s.startsWith("0"))
                .orElse("0");
    }
}
