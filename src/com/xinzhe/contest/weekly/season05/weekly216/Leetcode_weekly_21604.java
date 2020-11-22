package com.xinzhe.contest.weekly.season05.weekly216;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/22
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_21604 {
    public static void main(String[] args) {
        Leetcode_weekly_21604 lc = new Leetcode_weekly_21604();
        int[][] arr =  {{1,3},{2,4},{10,11},{10,12},{8,9}};
        System.out.println(lc.minimumEffort(arr));
    }

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (a[0] - a[1]) == (b[0] - b[1]) ? a[0] - b[0] : (a[0] - a[1]) - (b[0] - b[1]) );
        int x = 0;

        for (int i = tasks.length - 1; i >= 0; i--) {
            x = Math.max(x + tasks[i][0], tasks[i][1]);
        }
        return x;
    }
}
