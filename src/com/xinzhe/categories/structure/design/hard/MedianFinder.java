package com.xinzhe.categories.structure.design.hard;

import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/9/17
 * Title : 295. 数据流的中位数
 * Description : 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *              例如，[2,3,4] 的中位数是 3 [2,3] 的中位数是 (2 + 3) / 2 = 2.5. 设计一个支持以下两种操作的数据结构：
 *              void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 *              double findMedian() - 返回目前所有元素的中位数。
 * link : https://leetcode-cn.com/problems/find-median-from-data-stream
 * Level : Hard
 */
//todo need to review
//中位数问题 ： 有限考虑双优先队列，一个大顶，一个小顶，注意调整双队列的平衡！
public class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a,b) -> b-a);
    }

    public void addNum(int num) {
        if(small.size() <= large.size()) {
            large.offer(num);
            small.offer(large.poll());
        }else{
            small.offer(num);
            large.offer(small.poll());
        }
    }

    public double findMedian() {
        if(large.size() > small.size()) return large.peek();
        if(large.size() < small.size()) return small.peek();
        return (large.peek() + small.peek()) / 2.0;
    }
}
