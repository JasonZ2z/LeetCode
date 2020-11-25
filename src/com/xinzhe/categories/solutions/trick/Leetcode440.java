package com.xinzhe.categories.solutions.trick;

/**
 * @author Xin
 * @date 2020/11/25
 * Title :440. 字典序的第K小数字
 * Description : 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。注意：1 ≤ k ≤ n ≤ 109
 * link : https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 * Level : Hard
 */
//todo need to review
public class Leetcode440 {
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        int cur = 1;
        while(cur < k) {
            int next = getNext(n, prefix);
            if(next + cur > k) {
                prefix *= 10;
                cur++;
            } else {
                prefix ++;
                cur += next;
            }
        }
        return prefix;
    }

    private int getNext(int n, int prefix) {
        long next = prefix + 1;
        int cnt = 0;
        while (prefix <= n) {
            cnt += Math.min(n + 1, next) - prefix;
            prefix *= 10;
            next *= 10;
        }
        return cnt;
    }
}