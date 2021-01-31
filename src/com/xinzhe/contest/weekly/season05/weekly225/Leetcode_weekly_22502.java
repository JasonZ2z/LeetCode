package com.xinzhe.contest.weekly.season05.weekly225;

/**
 * @author Xin
 * @date 2021/01/24
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22502 {
    public static void main(String[] args) {
        Leetcode_weekly_22502 lc = new Leetcode_weekly_22502();
        String a = "aba";
        String b = "caa";
        System.out.println(lc.minCharacters2(a, b));
    }
    public int minCharacters(String a, String b) {
        int[] as = new int[26];
        int[] bs = new int[26];
        int maxa = 0, maxb = 0;
        int mina = 100, minb = 100;
        for (char c : a.toCharArray()) {
            maxa = Math.max(maxa, (c - 'a'));
            mina = Math.min(mina, (c - 'a'));
            as[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            maxb = Math.max(maxb, (c - 'a'));
            minb = Math.min(minb, (c - 'a'));
            bs[c - 'a']++;
        }
        if(mina > maxb || minb > maxa) return 0;

        int x=0; // a > b
        int y=0; // b > a

        int p = 0, q = 0;
        for (int i = 0; i <= maxa; ++i) {
            x += bs[i];
        }

        for (int i = 0; i <= maxb; ++i) {
            y += as[i];
        }

        for (int i = minb; i < 26; ++i) {
            p += as[i];
        }

        for (int i = mina; i < 26; ++i) {
            q += bs[i];
        }

        int max = 0;
        for (int i = 0; i < 26; ++i) {
            max = Math.max(max, as[i] + bs[i]);
        }
        return Math.min(a.length() + b.length() - max , Math.min(Math.min(p,q), Math.min(x, y)));

    }


    public int minCharacters2(String a, String b) {
        if(a.length() == 1 && b.length() == 1) return 0;
        int[] as = new int[26];
        int[] bs = new int[26];
        int maxa = 0, maxb = 0;
        int mina = 100, minb = 100;
        for (char c : a.toCharArray()) {
            maxa = Math.max(maxa, (c - 'a'));
            mina = Math.min(mina, (c - 'a'));
            as[c - 'a']++;
        }
        int sumb = b.length();
        int suma = a.length();
        for (char c : b.toCharArray()) {
            maxb = Math.max(maxb, (c - 'a'));
            minb = Math.min(minb, (c - 'a'));
            bs[c - 'a']++;
        }
        if(mina > maxb || minb > maxa) return 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int prea = 0;
        int preb = 0;
        for (int i = 0; i < 26; ++i) {
            min1 = Math.min(min1, prea + as[i] + sumb - bs[i]);
            prea += as[i];
            sumb -= bs[i];
            min2 = Math.min(min2, preb + bs[i] + suma - as[i]);
            preb += bs[i];
            suma -= as[i];
            min3 = Math.min(min3, a.length() + b.length() - as[i] - bs[i]);

        }
        return Math.min(min1, Math.min(min3, min2));
    }
}
