package com.xinzhe.contest.weekly.season05.weekly220;

/**
 * @author Xin
 * @date 2020/12/20
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_22001 {
    public static void main(String[] args) {
        Leetcode_weekly_22001 lc = new Leetcode_weekly_22001();
        int[] arr = {3,5};
    }
    public String reformatNumber(String number) {
        number = number.replace("-", "").replace(" ", "");
        int n = number.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(number.charAt(i));
            if (i % 3 == 2 && i < n - 2) {
                result.append("-");
            } else if (n % 3 == 1 && i == n - 3) {
                result.append("-");
            }
        }
        return result.toString();
    }
}
