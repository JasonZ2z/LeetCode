package com.xinzhe.contest.weekly.season04.weekly155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/7/27
 * Title : 1200. 最小绝对差
 * Description : 给你个整数数组 arr，其中每个元素都 不相同。请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * link : https://leetcode-cn.com/problems/minimum-absolute-difference/
 * Level : Easy
 */

public class Leetcode_weekly_15501 {

    public static void main(String[] args) {
        Leetcode_weekly_15501 lc = new Leetcode_weekly_15501();
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        List<Integer> index = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++) {
            if(arr[i] - arr[i-1] < min) {
                min = arr[i] - arr[i-1] ;
                index.clear();
                index.add(i);
            } else if(arr[i] - arr[i-1] == min) {
                index.add(i);
            }
        }
        for(int i: index) {
            res.add(Arrays.asList(arr[i-1], arr[i]));
        }
        return res;
    }

}
