package com.xinzhe.categories.solutions.dfs.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/7
 * Title : 842. 将数组拆分成斐波那契序列
 * Description : 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *              0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 *              F.length >= 3；
 *              对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 *              另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * link : https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
 * Level : Medium
 */

//todo need to review
public class Leetcode842 {
    public static void main(String[] args) {
        Leetcode842 lc = new Leetcode842();
        System.out.println(lc.splitIntoFibonacci("11235813"));
        System.out.println(lc.splitIntoFibonacci("1320581321313221264343965566089105744171833277577"));
    }
    public List<Integer> splitIntoFibonacci(String s) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < 3) return res;
        if(dfs(s, 0, res)) return res;
        return new ArrayList<>();
    }

    private boolean dfs(String s, int index, List<Integer> list) {
        if(index == s.length()) {
            return list.size() > 2;
        }
        if(s.charAt(index) == '0') {
            if (list.size() < 2 || list.get(list.size() - 1) + list.get(list.size() - 2) == 0) {
                list.add(0);
                return dfs(s, index + 1, list);
            }
        } else {
            for (int i = 1; i + index <= s.length(); ++i) {
                long x = Long.parseLong(s.substring(index, index + i));
                if(x > Integer.MAX_VALUE) break;
                if(list.isEmpty()) {
                    list.add((int) x);
                    if(dfs(s, index + i, list)) return true;
                    list.clear();
                } else if(list.size() == 1 || list.get(list.size() - 1) + list.get(list.size() - 2) == x) {
                    list.add((int) x);
                    if(dfs(s, index + i, list)) return true;
                    list.remove(list.size() - 1);
                }
            }
        }
        return false;
    }
}
