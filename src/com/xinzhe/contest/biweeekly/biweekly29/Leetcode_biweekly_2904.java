package com.xinzhe.contest.biweeekly.biweekly29;

/**
 * @author Xin
 * @date 2020/6/27
 * Title : 1494. 并行课程 II
 * Description : 给你一个整数 n 表示某所大学里课程的数目，编号为 1 到 n ，数组 dependencies 中， dependencies[i] = [xi, yi]  表示一个先修课的关系，也就是课程 xi 必须在课程 yi 之前上。
 *          同时你还有一个整数 k, 在一个学期中，你 最多 可以同时上 k 门课，前提是这些课的先修课在之前的学期里已经上过了。请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。
 * link : https://leetcode-cn.com/problems/parallel-courses-ii
 * Level : Hard
 * Comment : 此题贪心解法都不可取
 * tag : 状压DP
 */
public class Leetcode_biweekly_2904 {
    //todo need to review
    public static void main(String[] args) {
        int[][] a = {{1,6},{2,7},{8,7},{2,5},{3,4}};
        System.out.println(minNumberOfSemesters(8,a, 3));
    }

    public static int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        //todo
        return 0;
    }

}
