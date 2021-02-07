package com.xinzhe.contest.weekly.season05.weekly227;

/**
 * @author Xin
 * @date 2021/02/07
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22703 {
    public static void main(String[] args) {
        Leetcode_weekly_22703 lc = new Leetcode_weekly_22703();
        String s = "guguuuuuuuuuuuuuuguguuuuguug";
        String q = "gguggggggguuggguugggggg";
        System.out.println(lc.largestMerge(s, q));
    }
    public String largestMerge(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int p= 0, q = 0;
        StringBuilder sb = new StringBuilder();
        while (p < m || q < n) {
            if(p == m) {
                sb.append(word2.charAt(q++));
            } else if(q == n) {
                sb.append(word1.charAt(p++));
            } else {
                char c1 = word1.charAt(p);
                char c2 = word2.charAt(q);
                if(c1 > c2) {
                    sb.append(c1);
                    p++;
                } else if (c1 < c2) {
                    sb.append(c2);
                    q++;
                } else {
                    int i = p, j = q;
                    while (i < m && j < n && word1.charAt(i) == word2.charAt(j)) {
                        i++;
                        j++;
                    }
                    if(i < m && j < n) {
                        if(word1.charAt(i) > word2.charAt(j)) {
                            sb.append(c1);
                            p++;
                        } else {
                            sb.append(c2);
                            q++;
                        }
                    } else {
                        if(i == m && j == n) {
                            sb.append(c1);
                            p++;
                        } else if(i == m) {
                            sb.append(c2);
                            q++;
                        } else {
                            sb.append(c1);
                            p++;
                        }
                    }
                }
            }

        }
        return sb.toString();
    }
}
