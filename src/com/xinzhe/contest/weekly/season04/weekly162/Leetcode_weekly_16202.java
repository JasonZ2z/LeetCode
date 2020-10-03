package com.xinzhe.contest.weekly.season04.weekly162;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/6/17
 * Title : 1253. 重构 2 行二进制矩阵
 * Description : 给你一个 2 行 n 列的二进制数组：
 *          矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
 *          第 0 行的元素之和为 upper。
 *          第 1 行的元素之和为 lower。
 *          第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
 *          你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
 *          如果有多个不同的答案，那么任意一个都可以通过本题。
 *      如果不存在符合要求的答案，就请返回一个空的二维数组。
 * link : https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix
 * Level : Medium
 * Comment 162周赛02
 */

public class Leetcode_weekly_16202 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        List<List<Integer>> res = new ArrayList<>(2);
        int[] up = new int[n];
        int[] down = new int[n];
        for (int value : colsum) {
            if (value == 2) {
                upper--;
                lower--;
            }
        }
        if(upper < 0 || lower < 0) return res;
        for (int i = 0; i < n; i++) {
            if(colsum[i] == 0) {
                up[i] = 0;
                down[i] = 0;
            }else if(colsum[i] == 2) {
                up[i] = 1;
                down[i] = 1;
            } else {
                if(lower > 0) {
                    down[i] = 1;
                    up[i] = 0;
                    lower--;
                } else if(upper > 0){
                    up[i] = 1;
                    down[i] = 0;
                    upper--;
                } else {
                    return res;
                }
            }
        }
        if(upper > 0 || lower > 0) return res;
        res.add(Arrays.stream(up).boxed().collect(Collectors.toList()));
        res.add(Arrays.stream(down).boxed().collect(Collectors.toList()));
        return res;
    }

}
