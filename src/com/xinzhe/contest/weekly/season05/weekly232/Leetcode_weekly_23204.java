package com.xinzhe.contest.weekly.season05.weekly232;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Xin
 * @date 2021/03/14
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23204 {
    public static void main(String[] args) {
        Leetcode_weekly_23204 lc = new Leetcode_weekly_23204();
        int[] arr = {1,4,3,7,4,5};
        System.out.println(lc.maximumScore(arr, 3));
    }
    public int maximumScore(int[] heights, int k) {
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                if(i >= k + 1  && stack.peek() <= k + 1) {
                    area = Math.max(area, (i - stack.peek() - 1) * h);
                }
            }
            stack.push(i);
        }

        return area;

    }
}
