package com.xinzhe.contest.solo.spring2020;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/4/18 14:55
 * Title : LCP 08. 剧情触发时间
 * Description : 在战略游戏中，玩家往往需要发展自己的势力来触发各种新的剧情。一个势力的主要属性有三种，分别是文明等级（C），资源储备（R）以及人口数量（H）。在游戏开始时（第 0 天），三种属性的值均为 0。
 *      随着游戏进程的进行，每一天玩家的三种属性都会对应增加，我们用一个二维数组 increase 来表示每天的增加情况。这个二维数组的每个元素是一个长度为 3 的一维数组，例如 [[1,2,1],[3,4,2]] 表示第一天三种属性分别增加 1,2,1 而第二天分别增加 3,4,2。
 *      所有剧情的触发条件也用一个二维数组 requirements 表示。这个二维数组的每个元素是一个长度为 3 的一维数组，对于某个剧情的触发条件 c[i], r[i], h[i]，如果当前 C >= c[i] 且 R >= r[i] 且 H >= h[i] ，则剧情会被触发。
 *      根据所给信息，请计算每个剧情的触发时间，并以一个数组返回。如果某个剧情不会被触发，则该剧情对应的触发时间为 -1 。
 * link : https://leetcode-cn.com/problems/ju-qing-hong-fa-shi-jian
 * Level : Medium
 * Comment : 2020春季个人赛03
 */
public class Leetcode_single_041803 {
    public static void main(String[] args) {
        int[][] a = {{0,4,5}, {4,8,8}, {8,6,1}, {10,10,0}};
        int[][] b = {{12,11,16},{20,2,6}, {9,2,6}, {10,18,3}, {8,14,15}};
        System.out.println(Arrays.toString(getTriggerTime(a, b)));
        System.out.println(Arrays.toString(getTriggerTime2(a, b)));
    }
    //暴力 超时
    public static int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int c= 0, r=0, h=0;
        int count = 0;
        int day = requirements.length;
        int[] res = new int[day];
        Arrays.fill(res, -1);
        for (int[] ints : increase) {
            c += ints[0];
            r += ints[1];
            h += ints[2];
            count++;
            for (int j = 0; j < day; ++j) {
                int rc = requirements[j][0];
                int rr = requirements[j][1];
                int rh = requirements[j][2];
                if(rc == 0 && rr == 0 && rh== 0) res[j] = 0;
                 else if (res[j] == -1 && c >= rc && r >= rr && h >= rh) {
                    res[j] = count;
                }
            }
        }
        return res;
    }

    //二分
    public static int[] getTriggerTime2(int[][] increase, int[][] requirements){
        int day = requirements.length;
        int[] res = new int[day];
        Arrays.fill(res, -1);
        int n = increase.length;
        for (int i = 1; i < n; ++i) {
            increase[i][0] += increase[i-1][0] ;
            increase[i][1] += increase[i-1][1] ;
            increase[i][2] += increase[i-1][2] ;
        }

        for (int i = 0; i < day; ++i) {
            int left = 0, right = n-1;
            while(left < right){
                int mid = left + ((right - left) >>1);
                if(judge(increase[mid], requirements[i])) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if(judge(increase[left], requirements[i])) {
                if(requirements[i][0] == 0 && requirements[i][1] == 0 && requirements[i][2]== 0) res[i] = 0;
                else res[i] = left + 1;
            }
        }
        return res;
    }

    private static boolean judge(int[] increase, int[] requirement) {
        return increase[0] >= requirement[0]
                && increase[1] >= requirement[1]
                && increase[2] >= requirement[2];
    }

}
