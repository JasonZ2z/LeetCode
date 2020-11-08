package com.xinzhe.contest.weekly.season05.weekly214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Xin
 * @date 2020/11/08
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_21402 {
    public static void main(String[] args) {
        Leetcode_weekly_21402 lc = new Leetcode_weekly_21402();
        int[] arr = {3,5};
        System.out.println(lc.minDeletions("abcabc"));
    }
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);
        TreeSet<Integer> gap = new TreeSet<>();
        List<Integer> over = new ArrayList<>();

        int start = 1;
        for (int j : cnt) {
            if (j != 0) {
                while (j > start) {
                    gap.add(start);
                    start++;
                }
                if (j == start) start++;
            }
        }
        for (int i = 1; i < cnt.length; i++) {
            if(cnt[i] != 0 && cnt[i] == cnt[i-1]) {
                over.add(cnt[i]);
            }
        }
        if(over.isEmpty()) return 0;
        int sum = 0;
        for (int i = over.size() - 1; i >= 0; i--) {
            if(gap.size() == 0) sum += over.get(i);
            else {
                Integer lower = gap.lower(over.get(i));
                if(lower == null) sum += over.get(i);
                else {
                    sum += over.get(i) - lower;
                    gap.remove(lower);
                }
            }
        }
        return sum;
    }
}
