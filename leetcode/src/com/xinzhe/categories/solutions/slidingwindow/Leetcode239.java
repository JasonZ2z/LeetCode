package com.xinzhe.categories.solutions.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/03/02 18:01
 * Title : 239. 滑动窗口最大值
 * Description : 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 *              你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *              返回滑动窗口中的最大值。
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * link : https://leetcode-cn.com/problems/sliding-window-maximum
 * level ： hard
 */
public class Leetcode239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow1(nums, 3)));
    }

    //滑动窗口
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[]{};
        int[] result = new int[nums.length-k+1];
        //双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //保证从大到小 如果前面数小 弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if(queue.peek() <= i - k){
                queue.poll();
            }
            // 窗口长度为k时 再保存当前窗口中最大值
            if( i >= k -1){
                result[i+1-k] = nums[queue.peek()];
            }

        }
        return result;
    }
    //暴力
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[]{};
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i <= nums.length - k; i++) {
            List<Integer> tmp = new ArrayList<>(k);
            for (int j = 0; j < k; j++) {
                tmp.add(nums[j+i]);
            }
            list.add(tmp.stream().max(Integer::compareTo).orElse(0));
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
