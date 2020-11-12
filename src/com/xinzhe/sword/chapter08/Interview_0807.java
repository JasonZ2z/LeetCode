package com.xinzhe.sword.chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/7/14
 * Title : 08.07. 无重复字符串的排列组合
 * Description : 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * link : https://leetcode-cn.com/problems/permutation-i-lcci/
 * Level : Medium
 */
public class Interview_0807 {
    public static void main(String[] args) {
        Interview_0807 lc = new Interview_0807();
        System.out.println(Arrays.toString(lc.permutation("abc")));
    }
    List<String> list = new ArrayList<>();
    public String[] permutation(String S) {
        boolean[] used = new boolean[S.length()];
        dfs(0, S, used, new char[S.length()]);
        return list.toArray(new String[0]);
    }

    private void dfs(int i, String s, boolean[] used, char[] cur) {
        if(i == s.length()) {
            list.add(new String(cur));
            return;
        }
        for (int j = 0; j < s.toCharArray().length; j++) {
            if(!used[j]) {
                used[j] = true;
                cur[i] = s.charAt(j);
                dfs(i+1, s, used, cur);
                used[j] = false;
            }
        }
    }

}
