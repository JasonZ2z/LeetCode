package com.xinzhe.contest.weekly.season03.weekly142;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/19
 * Title : 1093. 大样本统计
 * Description : 我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 的采样个数。
 *              我们以 浮点数 数组的形式，分别返回样本的最小值、最大值、平均值、中位数和众数。其中，众数是保证唯一的。
 * link : https://leetcode-cn.com/problems/statistics-from-a-large-sample
 * Level : Medium
 */

public class Leetcode_weekly_14201 {
    public static void main(String[] args) {
        Leetcode_weekly_14201 lc = new Leetcode_weekly_14201();
        int[] arr = {0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(lc.sampleStats(arr)));
    }
    public double[] sampleStats(int[] count) {
        double[] res = new double[5];
        int max = 0, index = 0;
        for (int i = 0; i < count.length; i++) {
            if(count[i] > max) {
                max =  count[i];
                index = i;
            }
        }
        res[4] = index;
        long sum = Arrays.stream(count).sum();
        int cur = 0;
        if(sum % 2 == 0) {
            for (int i = 0; i < count.length; i++) {
                cur += count[i];
                if(cur == sum / 2){
                    res[3] = ((double)(i +i+1)) /2;
                    break;
                } else if(cur > sum / 2) {
                    res[3] = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < count.length; i++) {
                cur += count[i];
                if(cur > sum / 2) {
                    res[3] = i;
                    break;
                }
            }
        }
        long total = 0;
        for (int i = 0; i < count.length; i++) {
            total += count[i] * i;
        }
        res[2] = (double) total/sum;
        int i = 0;
        for (; i < count.length; i++) {
            if(count[i] > 0) break;
        }
        res[0] = i;

        int j = count.length-1;
        for (; j>=0; j--) {
            if(count[j] > 0) break;
        }
        res[1] = j;
        return res;
    }
}
