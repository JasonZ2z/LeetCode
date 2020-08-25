package com.xinzhe.contest.weekly.season03.weekly138;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/8/25
 * Title : 1054. 距离相等的条形码
 * Description : 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 * link : https://leetcode-cn.com/problems/distant-barcodes
 * Level : Medium
 */

public class Leetcode_weekly_13804 {
    public static void main(String[] args) {
        Leetcode_weekly_13804 lc = new Leetcode_weekly_13804();
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] arr = new int[10001];
        int n = barcodes.length;
        for (int barcode : barcodes) { arr[barcode]++; }
        int max =  Arrays.stream(arr).max().orElse(0);
        if(max == 1) return barcodes;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i=0; i<10001; i++) { if(arr[i] != 0) queue.offer(new int[]{i, arr[i]}); }
        int[] res = new int[n];
        int j =0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            while(cur[1]-- > 0) {
                res[j] = cur[0];
                j+=2;
                if(j >= n) j = 1;
            }
        }
        return res;

    }
}
