package com.xinzhe.categories.solutions.slidingwindow.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/03/02
 * Title : 239. 滑动窗口最大值
 * Description : 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 *              你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
 * link : https://leetcode-cn.com/problems/sliding-window-maximum
 * level ： hard
 */
//todo need to review
public class Leetcode239 {
    public static void main(String[] args) {
        int[] nums = {1211,-3110,8735,-7507,1784,7400,-5799,3169,-7696,-8991,-2222,-9434,-4490};
        Leetcode239 lc = new Leetcode239();
        System.out.println(Arrays.toString(lc.maxSlidingWindow1(nums, 5)));
        System.out.println(Arrays.toString(lc.maxSlidingWindow2(nums, 5)));
    }
    //滑动窗口
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        int[] result = new int[nums.length - k + 1];
        //双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //保证从大到小 如果前面数小 弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 窗口长度为k时 再保存当前窗口中最大值
            if (i >= k - 1) {
                result[i + 1 - k] = nums[queue.peek()];
            }

        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k < 1) return new int[]{};
        int[] result = new int[n - k + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int s = 0;
        for (int i = 0; i < n; ++i) {
            if(i - s == k) {
                result[s] = queue.peek()[1];
                if(queue.peek()[0] == s)  queue.poll();
                s++;
            }
            while(!queue.isEmpty() && (queue.peek()[1] < nums[i]) || queue.peek()[0] <= i - k) {
                queue.poll();
            }
            queue.offer(new int[]{i, nums[i]});
        }
        result[s] = queue.peek()[1];
        return result;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k < 1) return new int[]{};
        int[] result = new int[n - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int s = 0;
        for (int i = 0; i < n; ++i) {
            if(i - s == k) {
                result[s] = nums[queue.peekFirst()];
                if(queue.peekFirst() == s)  queue.pollFirst();
                s++;
            }
            while(!queue.isEmpty() && (nums[queue.peekLast()] < nums[i])) {
                queue.pollLast();
            }
            if(!queue.isEmpty() && queue.peekFirst() <= i - k) queue.pollFirst();
            queue.addLast(i);
        }
        result[s] = nums[queue.peekFirst()];
        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1)
            return nums;

        int maxIdx = 0;
        for(int i = 0; i < k; i++) {
            if(nums[i] > nums[maxIdx])
                maxIdx = i;
        }

        int[] maxes = new int[nums.length - k + 1];
        for(int li = 0; li < maxes.length; li++) {
            int ri = li + k - 1;
            if(maxIdx < li) {
                maxIdx = li;
                for(int i = li + 1; i <= ri; i++) {
                    if(nums[i] > nums[maxIdx])
                        maxIdx = i;
                }
            }else if(nums[ri] > nums[maxIdx]) {
                maxIdx = ri;
            }
            maxes[li] = nums[maxIdx];
        }
        return maxes;
    }
}
