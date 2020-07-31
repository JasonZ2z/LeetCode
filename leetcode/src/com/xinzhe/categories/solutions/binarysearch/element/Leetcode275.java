package com.xinzhe.categories.solutions.binarysearch.element;

/**
 * @author Xin
 * @date 2020/4/9 15:56
 * Title : 275. H指数 II
 * Description : 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。
 *              h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 * link : https://leetcode-cn.com/problems/h-index-ii
 * Level : Medium
 */

public class Leetcode275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 0 || citations[n-1] == 0) return 0;
        int left = 0, right = n -1;
        while (left <right){
            int mid = left + ((right - left) >> 1);
            if(citations[mid] < n - mid){
                left = mid +1;
            } else {
                right = mid;
            }
        }
        return n - left;
    }

    public int hIndex2(int[] c) {
        int l = 0;
        int r = c.length;
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if(c[c.length - mid] >= mid) {
                l = mid;
            } else
                r = mid -1;
        }
        return l;
    }
}
