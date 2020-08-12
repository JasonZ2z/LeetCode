package com.xinzhe.contest.weekly.season04.weekly160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/6/19
 * Title : 1237. 找出给定方程的正整数解
 * Description : 给出一个函数  f(x, y) 和一个目标结果 z，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。
 * link : https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation/
 * Level : Easy
 * Comment 160周赛01
 */

public class Leetcode_weekly_16001 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2}};
    }
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 1000; ++i) {
            for (int j = 1; j <= 1000; ++j) {
                if(customfunction.f(i,j) == z) {
                    res.add(Arrays.asList(i,j));
                    break;
                }
            }
        }
        return res;
    }
}

interface CustomFunction {
    int f(int x, int y);
}