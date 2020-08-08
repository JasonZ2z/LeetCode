package com.xinzhe.contest.biweeekly.biweekly32;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/8/8
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_biweekly_3202 {
    public static void main(String[] args) {
        Leetcode_biweekly_3202 lc = new Leetcode_biweekly_3202();
        String s = "input";
        String t = "ouput";
        System.out.println(lc.canConvertString(s, t, 35));
    }

    public boolean canConvertString(String s, String t, int k) {
        int m = s.length();
        int n = t.length();
        if(m != n) return false;
        int sum  = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m; ++i) {
            int a = s.charAt(i) - 'a';
            int b = t.charAt(i) - 'a';
            int tmp = b-a;
            if(tmp < 0) tmp += 26;
            if(tmp == 0) continue;
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            sum = Math.max(sum, key + (value-1) * 26);
            if(sum > k) return false;
        }
        return true;
    }
}
