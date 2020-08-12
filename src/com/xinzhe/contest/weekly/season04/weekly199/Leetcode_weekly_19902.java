package com.xinzhe.contest.weekly.season04.weekly199;

/**
 * @author Xin
 * @date 2020/7/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_19902 {
    public static void main(String[] args) {
        Leetcode_weekly_19902 lc = new Leetcode_weekly_19902();
        System.out.println(lc.minFlips2("000"));
    }

    public int minFlips(String target) {
        int n = target.length();
        boolean[] dist = new boolean[n];
        char[] arr = target.toCharArray();
        for (int i = 0; i < n; i++) {
            if(arr[i] == '1'){
                dist[i] = true;
            }
        }
        int count = 0;
        boolean[] tmp = new boolean[n];
        int i = 0;
        while ( i < n) {
            while (i < n && dist[i] == tmp[i]) {
                i++;
            }
            for (int j = i; j < n; ++j) {
                tmp[j] = !tmp[j];
            }
            count++;
        }
        return count -1;
    }

    public int minFlips2(String target) {
        int n = target.length();
        int start = 0;
        while (start < n && target.charAt(start) == '0') {
            start++;
        }
        if(start == n) return 0;
        target = target.substring(start, n);
        char[] arr = target.toCharArray();
        int count = 1;
        char pre = '1';

        int j = 1;
        while (j < target.length()) {
            if(arr[j] != pre) {
                pre = arr[j];
                count++;
            }
            j++;
        }
        return count;
    }
}
