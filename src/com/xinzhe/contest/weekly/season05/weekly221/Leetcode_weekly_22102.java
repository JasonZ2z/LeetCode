package com.xinzhe.contest.weekly.season05.weekly221;

import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/12/27
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_22102 {
    public static void main(String[] args) {
        Leetcode_weekly_22102 lc = new Leetcode_weekly_22102();
        int[] arr1 = {3,0,0,0,0,2};
        int[] arr2 = {3,0,0,0,0,2};
        System.out.println(lc.eatenApples(arr1, arr2));
    }

    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int max = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < n + 20000; ++i) {
            if(i < n && apples[i] > 0) queue.offer(new int[]{apples[i], i + days[i] - 1});
            while (!queue.isEmpty()){
                if(queue.peek()[0] > 0 && queue.peek()[1] >= i) {
                    int[] poll = queue.poll();
                    if(poll[0] > 1) {
                        queue.offer(new int[]{poll[0] - 1, poll[1]});
                    }
                    max++;
                    if(queue.isEmpty() && i > n) return max;
                    break;
                } else if(queue.peek()[0] <= 0 || queue.peek()[1] <= i) {
                    queue.poll();
                } else {
                    break;
                }
            }
        }
        return max;
    }
}
