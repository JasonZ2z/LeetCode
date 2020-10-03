package com.xinzhe.contest.weekly.season05.weekly206;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/9/13
 * Title : 1585. 检查字符串是否可以通过排序子字符串得到另一个字符串
 * Description : 给你两个字符串 s 和 t ，请你通过若干次以下操作将字符串 s 转化成字符串 t ：
 *              选择 s 中一个 非空 子字符串并将它包含的字符就地 升序 排序。比方说，对下划线所示的子字符串进行操作可以由 "14234" 得到 "12344" 。
 *              如果可以将字符串 s 变成 t ，返回 true 。否则，返回 false 。 一个 子字符串 定义为一个字符串中连续的若干字符。
 * link : https://leetcode-cn.com/problems/check-if-string-is-transformable-with-substring-sort-operations
 * Level : Hard
 */

//todo too hard to solve
public class Leetcode_weekly_20604 {
    public static void main(String[] args) {
        Leetcode_weekly_20604 lc = new Leetcode_weekly_20604();
    }

    public boolean isTransformable(String s, String t) {
        int n = s.length();
        Queue<Integer>[] pos = new Queue[10];
        for (int i = 0; i < 10; ++i) {
            pos[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; ++i) {
            pos[s.charAt(i) - '0'].offer(i);
        }
        for (int i = 0; i < n; ++i) {
            int digit = t.charAt(i) - '0';
            if (pos[digit].isEmpty()) {
                return false;
            }
            for (int j = 0; j < digit; ++j) {
                if (!pos[j].isEmpty() && pos[j].peek() < pos[digit].peek()) {
                    return false;
                }
            }
            pos[digit].poll();
        }
        return true;
    }

}
