package com.xinzhe.interview.chapter01;

/**
 * @Author Xin
 * @create 2020/6/10
 * Title : 01.06. Compress String LCCI
 * Description : Implement a method to perform basic string compression using the counts of repeated characters.
 *              For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string.
 *              You can assume the string has only uppercase and lowercase letters (a - z).
 * link : https://leetcode-cn.com/problems/compress-string-lcci
 * Level : Easy
 */
public class Interview_0106 {
    public String compressString(String s) {
        int n = s.length();
        if (n < 2) return s;
        StringBuilder sb = new StringBuilder();
        char pre = s.charAt(0);
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == pre) {
                count++;
            } else {
                sb.append(pre).append(count);
                count = 1;
                pre = c;
            }
        }
        sb.append(pre).append(count);
        return sb.length() > n ? s : sb.toString();
    }
}
