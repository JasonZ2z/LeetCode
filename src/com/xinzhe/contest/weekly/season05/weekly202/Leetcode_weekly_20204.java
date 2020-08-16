package com.xinzhe.contest.weekly.season05.weekly202;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/8/16
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20204 {
    public static void main(String[] args) {
        Leetcode_weekly_20204 lc = new Leetcode_weekly_20204();
        System.out.println(lc.minDays(56));
    }


    public int minDays(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(n);
        int count = 0;
        while (!queue.isEmpty()) {

            for (int j = 0; j < 3; ++j) {
                int i = queue.poll();
                if(set.contains(i)) continue;
                if(i == 1) return count;
                if(i % 2 == 0) {
                    queue.add(i/2);
                }
                if (i % 3 == 0) {
                    queue.add(i/3);
                }
                queue.add(i-1);
            }

            count++;
        }
        return count;
    }
}
