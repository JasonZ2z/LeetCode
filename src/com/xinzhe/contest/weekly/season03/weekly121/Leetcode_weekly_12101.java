package com.xinzhe.contest.weekly.season03.weekly121;

/**
 * @author Xin
 * @date 2020/9/28
 * Title : 984. 不含 AAA 或 BBB 的字符串
 * Description : 给定两个整数 A 和 B，返回任意字符串 S，要求满足： S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
 *              子串 'aaa' 没有出现在 S 中； 子串 'bbb' 没有出现在 S 中。
 * link : https://leetcode-cn.com/problems/string-without-aaa-or-bbb
 * Level : Medium
 */

public class Leetcode_weekly_12101 {
    public static void main(String[] args) {
        Leetcode_weekly_12101 lc = new Leetcode_weekly_12101();
        System.out.println(lc.strWithout3a3b(1, 2));
    }
    public String strWithout3a3b(int A, int B) {
        return dfs(A, B, "");
    }

    private String dfs(int x, int y, String s) {
        if(x == 0 && y == 0)  return s;
        if(x == 0 || y == 0) {
            if(x == 0) return s + "b".repeat(y);
            if(y == 0) return s + "a".repeat(x);
        }
        if(x == y) {
            if(s.length() == 0 || s.endsWith("b")) {
                return dfs(x - 1, y - 1 , s + "ab");
            } else {
                return dfs(x - 1, y - 1 , s + "ba");
            }
        }else if( x > y) {
            if(s.length() == 0 || s.endsWith("b"))  {
                return dfs(x - 2, y - 1 , s + "aab");
            } else {
                return dfs(x - 1, y - 1 , s + "ba");
            }
        } else {
            if(s.length() == 0 || s.endsWith("a"))  {
                return dfs(x - 1, y - 2 , s + "bba");
            } else {
                return dfs(x - 1, y - 1 , s + "ab");
            }
        }
    }
}
