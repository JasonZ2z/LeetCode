package com.xinzhe.contest.weekly.season05.weekly205;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/6
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_20501 {
    public static void main(String[] args) {
        Leetcode_weekly_20501 lc = new Leetcode_weekly_20501();
        int[] arr = {1,2,3,1,2};
        System.out.println(Arrays.toString("a?a".split("\\?")));
    }


    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        s = " " + s + " ";
        char pre = ' ';
        for (int i = 1; i < s.length()-1; ++i) {
            if(s.charAt(i) == '?') {
                int j = 0;
                for (; j < 26; ++j) {
                    if((char)(j + 'a') != pre && (char)(j + 'a') != s.charAt(i+1)) {
                        sb.append((char)(j + 'a'));
                        pre = (char)(j + 'a');
                        break;
                    }
                }
            } else {
                pre = s.charAt(i);
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
}
