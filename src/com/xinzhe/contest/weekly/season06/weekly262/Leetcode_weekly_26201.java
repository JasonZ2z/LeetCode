package com.xinzhe.contest.weekly.season06.weekly262;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2021/10/10
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_26201 {
    public static void main(String[] args) {
        Leetcode_weekly_26201 lc = new Leetcode_weekly_26201();

    }
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> list = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> s3 = Arrays.stream(nums3).boxed().collect(Collectors.toSet());

        list.addAll(s1);
        list.retainAll(s2);
        res.addAll(list);

        list.clear();
        list.addAll(s1);
        list.retainAll(s3);
        res.addAll(list);

        list.clear();
        list.addAll(s2);
        list.retainAll(s3);
        res.addAll(list);

        return new ArrayList<>(res);
    }
}
