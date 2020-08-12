package com.xinzhe.contest.weekly.season04.weekly176;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/5/19
 * Title : 1354. 多次求和构造目标数组
 * Description :  给你一个整数数组 target 。一开始，你有一个数组 A ，它的所有元素均为 1 ，你可以执行以下操作：
 * 令 x 为你数组里所有元素的和
 * 选择满足 0 <= i < target.size 的任意下标 i ，并让 A 数组里下标为 i 处的值为 x 。
 * 你可以重复该过程任意次
 * 如果能从 A 开始构造出目标数组 target ，请你返回 True ，否则返回 False 。
 * link : https://leetcode-cn.com/problems/construct-target-array-with-multiple-sums
 * Level : Hard
 * Comment 176周赛04
 */
//todo need to review
public class Leetcode_weekly_17604 {

    public boolean isPossible(int[] target) {
        if (target.length == 1) return true;
        PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0L;
        for (int value : target) {
            queue.add((long) value);
            sum += value;
        }
        if (queue.isEmpty() || queue.peek() == 1) return true;

        while (true) {
            long cur = queue.poll();
            if (queue.peek() == 1) {
                return (cur - 1) % (sum - cur) == 0;
            } else {
                long n = (cur - queue.peek()) / (sum - cur) + 1;
                long x = cur - n * (sum - cur);
                if (x <= 0) return false;
                sum = cur - (sum - cur) * (n - 1);
                queue.offer(x);
            }
        }
    }
}
