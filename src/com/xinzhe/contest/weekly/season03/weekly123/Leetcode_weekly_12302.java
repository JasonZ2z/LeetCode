package com.xinzhe.contest.weekly.season03.weekly123;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/9/24
 * Title : 990. 等式方程的可满足性
 * Description : 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，
 *              并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *              只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 * link : https://leetcode-cn.com/problems/satisfiability-of-equality-equations
 * Level : Easy
 * tag : 并查集
 */

public class Leetcode_weekly_12302 {
    public static void main(String[] args) {
        Leetcode_weekly_12302 lc = new Leetcode_weekly_12302();
        String[] s = {"f==a","a==b","f!=e","a==c","b==e","c==f"};
        System.out.println(lc.equationsPossible(s));
        int[] arr = {2,-3,-1,5,-4};
    }
    Map<Character, Character> map = new HashMap<>();
    public boolean equationsPossible(String[] equations) {
        for (String e : equations) {
            if(e.charAt(1) == '=') {
                char c1 = e.charAt(0), c2 = e.charAt(3);
                if(!map.containsKey(c1)) map.put(c1,c1);
                if(!map.containsKey(c2)) map.put(c2,c2);
                char fc1 = find(c1), fc2 = find(c2);
                if(fc1 == fc2) continue;
                map.put(fc1, fc2);
            }
        }
        for (String e : equations) {
            if(e.charAt(1) == '!') {
                char c1 = e.charAt(0), c2 = e.charAt(3);
                if(!map.containsKey(c1)) map.put(c1,c1);
                if(!map.containsKey(c2)) map.put(c2,c2);
                char fc1 = find(c1), fc2 = find(c2);
                if(fc1 == fc2) return false;
            }
        }
        return true;
    }

    private char find(char c) {
        while(c != map.get(c)) {
            c = map.get(c);
        }
        return c;
    }
}
