package com.xinzhe.contest.weekly.season05.weekly211;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/10/18
 * Title : 1625. 执行操作后字典序最小的字符串
 * Description : 给你一个字符串 s 以及两个整数 a 和 b 。其中，字符串 s 的长度为偶数，且仅由数字 0 到 9 组成。你可以在 s 上按任意顺序多次执行下面两个操作之一：
 *              累加：将 a 加到 s 中所有下标为奇数的元素上（下标从 0 开始）。数字一旦超过 9 就会变成 0，如此循环往复。例如，s = "3456" 且 a = 5，则执行此操作后 s 变成 "3951"。
 *              轮转：将 s 向右轮转 b 位。例如，s = "3456" 且 b = 1，则执行此操作后 s 变成 "6345"。
 *              请你返回在 s 上执行上述操作任意次后可以得到的 字典序最小 的字符串。
 * link : https://leetcode-cn.com/problems/lexicographically-smallest-string-after-applying-operations
 * Level : Medium
 */
public class Leetcode_weekly_21102 {
    public static void main(String[] args) {
        Leetcode_weekly_21102 lc = new Leetcode_weekly_21102();
        int[] arr = {3,5};
        String s = "1234";
        System.out.println(lc.add(s, 8));
    }

    public String findLexSmallestString(String s, int a, int b) {
        HashSet<String> set = new HashSet<>();
        String ans = s;
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if(cur.compareTo(ans) < 0) {
                ans = cur;
            }
            String next1 = add(cur,a);
            if(set.add(next1)) {
                queue.offer(next1);
            }
            String next2 = move(cur, b);
            if(set.add(next2)) {
                queue.offer(next2);
            }
        }
        return ans;
    }

    private String add(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            if((i & 1) == 1) {
                arr[i] = (char)((arr[i] - '0' + a) % 10 + '0');
            }
        }
        return new String(arr);
    }

    private String move(String s, int b) {
        return s.substring(s.length() - b) + s.substring(0, s.length() - b);
    }
}
