package com.xinzhe.contest.biweeekly.biweekly29;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/6/27
 * Title : 1491. 去掉最低工资和最高工资后的工资平均值
 * Description : 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * link : https://leetcode-cn.com/problems/average-salary-excluding-the-minimum-and-maximum-salary
 * Level : Easy
 */
public class Leetcode_biweekly_2901 {
    public static void main(String[] args) {

    }
    public double average(int[] salary) {
        int max = Arrays.stream(salary).max().getAsInt();
        int min = Arrays.stream(salary).min().getAsInt();
        return Arrays.stream(salary).filter(a -> a != max && a != min).average().getAsDouble();
    }

}
