package com.xinzhe.contest.weekly.season05.weekly216;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/22
 * Title : 1665. 完成所有任务的最少初始能量
 * Description : 给你一个任务数组tasks ，其中tasks[i] = [actuali, minimumi]：
 *              actuali是完成第 i个任务 需要耗费的实际能量。
 *              minimumi是开始第 i个任务前需要达到的最低能量。
 *              比方说，如果任务为[10, 12]且你当前的能量为11，那么你不能开始这个任务。如果你当前的能量为13，你可以完成这个任务，且完成它后剩余能量为 3。
 *              你可以按照 任意顺序完成任务。请你返回完成所有任务的 最少初始能量。
 * link : https://leetcode-cn.com/problems/minimum-initial-energy-to-finish-tasks
 * Level : Hard
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
