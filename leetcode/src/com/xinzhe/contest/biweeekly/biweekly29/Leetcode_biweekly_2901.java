package com.xinzhe.contest.biweeekly.biweekly29;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/6/27
 * Title :
 * Description :
 * link :
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
