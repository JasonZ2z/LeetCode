package com.xinzhe.categories.solutions.towpointers.multipointers;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/12/01
 * Title : 632. 最小区间
 * Description : 你有k个 非递减排列 的整数列表。找到一个 最小 区间，使得k个列表中的每个列表至少有一个数包含在其中。
 *              我们定义如果b-a < d-c或者在b-a == d-c时a < c，则区间 [a,b] 比 [c,d] 小。
 * link : https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists
 * Level : Hard
 */
//todo need to review
    //合并k个排序链表
public class Leetcode632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int inf = (int)1e9;
        int left = -inf, right = inf;
        int max = -inf;
        PriorityQueue<Item> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            queue.offer(new Item(i, 0, val));
            max = Math.max(val, max);
        }

        while (queue.size() == k) {
            Item item = queue.poll();
            int i = item.i;
            int j = item.j;
            if(max - item.val < right - left) {
                right = max;
                left = item.val;
            }
            if(j + 1< nums.get(i).size()) {
                int val = nums.get(i).get(j + 1);
                queue.offer(new Item(i, j + 1, val));
                max = Math.max(max, val);
            }
        }
        return new int[]{left, right};
    }

    class Item{
        int i, j, val;

        public Item(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
}
