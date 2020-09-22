package com.xinzhe.contest.weekly.season03.weekly126;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 1002. 查找常用字符
 * Description : 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 *              例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。你可以按任意顺序返回答案。
 * link : https://leetcode-cn.com/problems/find-common-characters
 * Level : Easy
 */

public class Leetcode_weekly_12601 {
    public static void main(String[] args) {
        Leetcode_weekly_12601 lc = new Leetcode_weekly_12601();
        int[] arr = {2,-3,-1,5,-4};
    }
    public List<String> commonChars(String[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char c : arr[i].toCharArray()) {
                dp[i][c- 'a']++;
            }
        }
        int[] res = dp[0];
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                if(dp[i][j] < res[j]) {
                    res[j] = dp[i][j];
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            if(res[i] != 0) {
                for (int j = 0; j < res[i]; ++j) {
                    list.add(String.valueOf((char)('a' + i)));
                }
            }
        }
        return list;
    }
}
