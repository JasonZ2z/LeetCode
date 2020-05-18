package com.xinzhe.contest.weekly.weekly182;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/5
 * Title : 1395. 统计作战单位数
 * Description :  n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 *          每 3 个士兵可以组成一个作战单位，分组规则如下：
 *          从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 *          作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
 *          请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 * link : https://leetcode-cn.com/problems/count-number-of-teams
 * Level : Medium
 */
public class Leetcode_weekly_18202 {
    public static void main(String[] args) {
        Leetcode_weekly_18202 lc = new Leetcode_weekly_18202();
        int[] rating = {3,7,5,6};
        System.out.println(lc.numTeams(rating));
    }
    public int numTeams(int[] rating) {
        int n = rating.length;
        List<List<Integer>> more = new ArrayList<>(n);
        List<List<Integer>> less = new ArrayList<>(n);
        for (int value : rating) {
            ArrayList<Integer> tmp_more = new ArrayList<>();
            ArrayList<Integer> tmp_less = new ArrayList<>();
            tmp_more.add(value);
            tmp_less.add(value);
            more.add(tmp_more);
            less.add(tmp_less);
        }
        for (int i = 1; i < n; ++i) {
            for (int j = i-1; j >= 0; --j) {
                if(rating[i] > more.get(j).get(0)) {
                    more.get(j).add(rating[i]);
                }
                if(rating[i] < less.get(j).get(0)) {
                    less.get(j).add(rating[i]);
                }
            }
        }
        System.out.println(more);
        System.out.println(less);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            List<Integer> list = more.get(i);
            int size = list.size();
            if(size < 3) continue;
            for (int j = 1; j < size -1; ++j) {
                for (int k = j+1; k < size; ++k) {
                    if(list.get(k) > list.get(j)) {
                        res++;
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            List<Integer> list = less.get(i);
            int size = list.size();
            if(size < 3) continue;
            for (int j = 1; j < size -1; ++j) {
                for (int k = j+1; k < size; ++k) {
                    if(list.get(k) < list.get(j)) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public int numTeams2(int[] rating) {
        int n = rating.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int[] left = count(rating, 0, i-1, rating[i]);
            int[] right = count(rating, i+1, n, rating[i]);
            res += left[0] * right[1] + right[0] * left[1];
        }
        return res;
    }

    private int[] count(int[] rating, int left, int right, int target) {
        int[] count = new int[2];
        for (int i = left; i < right; ++i) {
            if(rating[i] > target) {
                count[0]++;
            } else if(rating[i] < target){
                count[1]++;
            }
        }
        return count;
    }
}
