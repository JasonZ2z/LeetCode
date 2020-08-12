package com.xinzhe.contest.weekly.season04.weekly186;

import java.util.*;

/**
 * @author Xin
 * @create 2020/4/24
 * Title : 1424. 对角线遍历 II
 * Description : 给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
 * link : https://leetcode-cn.com/problems/diagonal-traverse-ii/
 * Level : Medium
 * Comment : 186周赛03
 */

public class Leetcode_weekly_18603 {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> l1 = Arrays.asList(14,12,19,16,9);
        List<Integer> l2 = Arrays.asList(13,14,15,8,11);
        List<Integer> l3 = Arrays.asList(11,13,1);
        nums.add(l1);
        nums.add(l2);
        nums.add(l3);
        System.out.println(Arrays.toString(findDiagonalOrder(nums)));
        System.out.println(Arrays.toString(findDiagonalOrder1(nums)));
    }
    //暴力模拟 超时
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        int m = nums.size();
        if(m == 1) {
            return nums.get(0).stream().mapToInt(Integer::valueOf).toArray();
        }
        int n = 0;
        int len = 0;
        int[] arr = new int[m];
        for (int i = 0; i < m; ++i) {
            arr[i] = nums.get(i).size();
            len += arr[i];
            n = Math.max(n, arr[i]);
        }
        int[] res = new int[len];
        if(n == 1) {
            int index = 0;
            for (List<Integer> num : nums) {
                if (num != null) {
                    res[index++] = num.get(0);
                }
            }
        }
        int index = 0;
        for (int cur = 1; cur <= m ; ++cur) {
            int i = cur-1;
            int j = 0;
            int step = 1;
            while(step <= cur && index < len) {
                if(arr[i] > j) {
                    res[index++] = nums.get(i).get(j);
                }
                step++;
                i--;
                j++;
            }
        }
        for (int cur = 1; cur <= n ; ++cur) {
            int i = m-1;
            int j = cur;
            int step = 1;
            while(step <= m && index < len) {
                if(arr[i] > j) {
                    res[index++] = nums.get(i).get(j);
                }
                step++;
                i--;
                j++;
            }
        }
        return res;

    }

    // 根据对角线聚合
    // LinkedHashMap 控制输出顺序
    public static int[] findDiagonalOrder1(List<List<Integer>> nums){
        int m = nums.size();
        if(m == 1) {
            return nums.get(0).stream().mapToInt(Integer::valueOf).toArray();
        }
        int len = 0;
        int mn = 0;
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < m; ++i) {
            int n = nums.get(i).size();
            mn = Math.max(mn,n);
            len += n;
            for (int j = 0; j < n; ++j) {
                if(map.containsKey(i+j)){
                    map.get(i+j).add(nums.get(i).get(j));
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums.get(i).get(j));
                    map.put(i+j, list);
                }
            }
        }
        int[] res = new int[len];
        int index = 0;
        for (int i = 0; i < m+mn; ++i) {
            List<Integer> list = map.get(i);
            if(list != null) {
                for(int j = list.size()-1; j >= 0; --j) {
                    res[index++] = list.get(j);
                }
            }
        }
        return res;
    }
}
