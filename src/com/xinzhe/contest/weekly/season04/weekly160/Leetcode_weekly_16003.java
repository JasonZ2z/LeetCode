package com.xinzhe.contest.weekly.season04.weekly160;

import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/6/19
 * Title : 1239. 串联字符串的最大长度
 * Description : 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。请返回所有可行解 s 中最长长度。
 * link : https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
 * Level : Medium
 * Comment 160周赛03
 */

public class Leetcode_weekly_16003 {
    //todo need to review
    public static void main(String[] args) {
        Leetcode_weekly_16003 lc = new Leetcode_weekly_16003();
        List<String> arr = Arrays.asList("bcd","cdxyz", "cdefgxyzw", "e");
        System.out.println(lc.maxLength(arr));
    }

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0)
            return 0;
        return dfs(arr, 0, 0);
    }

    private int dfs(List<String> arr, int start, int mask) {
        if(start == arr.size()) return 0;
        int ans = 0;
        for (int i = start; i < arr.size(); i++) {
            int bit = getBit(arr.get(i));
            if(bit == 0 || (mask & bit) != 0) continue;
            ans = Math.max(ans, dfs(arr, i+1, mask|bit) + arr.get(i).length());
        }
        return ans;
    }

    private int getBit(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');
            if((bit & mask) != 0) return 0;
            mask |= bit;
        }
        return mask;
    }

    int[] len;
    int[] bits;
    public int maxLength2(List<String> arr) {
        int n = arr.size();
        this.len = new int[n];
        this.bits = new int[n];

        for(int i=0; i<n; i++) {
            len[i] = arr.get(i).length();
            for(char c : arr.get(i).toCharArray()) {
                if((bits[i] & (1<<(c - 'a'))) > 0){
                    bits[i] = 0;
                    break;
                } else {
                    bits[i] |= 1<<(c - 'a');
                }
            }
        }
        return dfs(arr, 0, 0);
    }

    private int dfs2(List<String> arr, int index, int mask) {
        if(index == arr.size()) return 0;
        int ans = 0;
        for(int i= index; i<arr.size(); i++) {
            if(bits[i] == 0 || (mask & bits[i]) != 0) continue;
            ans = Math.max(ans, dfs2(arr, i+1, mask|bits[i]) + len[i]);
        }
        return ans;
    }
}
