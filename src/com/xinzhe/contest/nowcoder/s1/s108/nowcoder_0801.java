package com.xinzhe.contest.nowcoder.s1.s108;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/7/25
 * Title :
 * Description :
 * link :
 * Level :
 */
public class nowcoder_0801 {
    /**
     * 返回重新分配后，满足牛牛要求的水量的瓶子最多的数量
     * @param n int整型 瓶子的数量
     * @param x int整型 牛牛的对瓶中的水量要求
     * @param a int整型一维数组 每个瓶子中的含水量
     * @return int整型
     */
    public int solve (int n, int x, int[] a) {
        // write code here
        Arrays.sort(a);
        if(a[n-1] < x) return 0;
        long sum = 0;
        int j = 0;
        for(int i = n-1; i >= 0; --i) {
           sum += a[i];
           j++;
           if(sum / j < x) {
               return j -1;
           }
        }
        return j;
    }
}
