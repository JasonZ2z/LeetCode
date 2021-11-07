package com.xinzhe.contest.weekly.season06.weekly265;

import java.util.ArrayDeque;
import java.util.Set;

/**
 * @author Xin
 * @date 2021/10/31
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_26503 {
    public static void main(String[] args) {
        Leetcode_weekly_26503 lc = new Leetcode_weekly_26503();
        int[] arr = {2,4,12};
        System.out.println(lc.minimumOperations(arr, 2, 12));

    }
    public int minimumOperations(int[] nums, int start, int goal) {
        boolean[] visited = new boolean[1001];
        ArrayDeque<Integer> deque = new ArrayDeque<>(Set.of(start));
        for (int i = 0; !deque.isEmpty(); i++) {
            for (int j = deque.size(); j > 0; j--) {
                int poll = deque.poll();
                if (poll == goal) {
                    return i;
                } else if (poll >= 0 && poll <= 1000 && !visited[poll]) {
                    visited[poll] = true;
                    for (int num : nums) {
                        deque.offer(poll + num);
                        deque.offer(poll - num);
                        deque.offer(poll ^ num);
                    }
                }
            }
        }
        return -1;
    }
}
