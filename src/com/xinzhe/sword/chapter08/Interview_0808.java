package com.xinzhe.sword.chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/7/14
 * Title : 08.08. 有重复字符串的排列组合
 * Description : 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 * link : https://leetcode-cn.com/problems/permutation-i-lcci/
 * Level : Medium
 */
//todo need to review
public class Interview_0808 {
    public static void main(String[] args) {
        Interview_0808 lc = new Interview_0808();
        System.out.println(Arrays.toString(lc.permutation("abb")));
    }
    List<String> list = new ArrayList<>();
    public String[] permutation(String S) {
        char[] array = S.toCharArray();
        Arrays.sort(array);
        boolean[] used = new boolean[S.length()];
        dfs(0, array, used, new char[S.length()]);
        return list.toArray(new String[0]);
    }

    private void dfs(int i, char[] array, boolean[] used, char[] cur) {
        if (i == array.length) {
            list.add(new String(cur));
            return;
        }
        for (int j = 0; j < array.length; j++) {
            if(used[j] || (j > 0 && array[j] == array[j-1]) && used[j-1]) continue;
            used[j] = true;
            cur[i] = array[j];
            dfs(i + 1, array, used, cur);
            used[j] = false;
        }
    }
}
