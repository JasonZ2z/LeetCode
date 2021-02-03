package com.xinzhe.categories.solutions.slidingwindow.hard;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Xin
 * @date 2021/02/03
 * Title : 480. 滑动窗口中位数
 * Description : 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *              给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。
 *              你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * link : https://leetcode-cn.com/problems/sliding-window-median
 * Level : hard
 */
public class Leetcode480 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Leetcode480 lc = new Leetcode480();
        System.out.println(Arrays.toString(lc.medianSlidingWindow(arr, 4)));
    }
    private Queue<Long> maxheap;
    private Queue<Long> minheap;
    public double[] medianSlidingWindow(int[] nums, int k) {
        this.maxheap = new PriorityQueue<>((a, b) -> Long.compare(b,a));
        this.minheap = new PriorityQueue<>();
        int n = nums.length;
        int len = n - k + 1;
        double[] res = new double[len];

        for (int i = 0; i < n; ++i) {
            minheap.offer((long) nums[i]);
            if(i > k - 1) {
                long num = nums[i - k];
                if (!minheap.remove(num)) {
                    maxheap.remove(num);
                }
            }
            if(minheap.size() > maxheap.size() + 1) {
                maxheap.offer(minheap.poll());
            }
            if(maxheap.size() > 0 && minheap.size() > 0 && maxheap.peek() > minheap.peek()) {
                maxheap.offer(minheap.poll());
            }
            if(maxheap.size() > minheap.size() + 1) {
                minheap.offer(maxheap.poll());
            }
            if(i >= k - 1) {
                if(minheap.size() > maxheap.size()) res[i - k+ 1] = minheap.peek();
                else if(minheap.size() < maxheap.size()) res[i - k+ 1] = maxheap.peek();
                else res[i - k+ 1] = (maxheap.peek() + minheap.peek()) / 2D;
            }

        }
        return res;
    }

}
