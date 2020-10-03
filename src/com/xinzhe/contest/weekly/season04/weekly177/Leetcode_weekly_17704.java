package com.xinzhe.contest.weekly.season04.weekly177;

/**
 * @author Xin
 * @date 2020/5/18
 * Title : 1363. 形成三的最大倍数
 * Description : 给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
 * 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
 * 如果无法得到答案，请返回一个空字符串。
 * link : https://leetcode-cn.com/problems/largest-multiple-of-three
 * Level : Hard
 * Comment 177周赛04
 */

public class Leetcode_weekly_17704 {
    public static void main(String[] args) {
        int[] d = {1};
        System.out.println(largestMultipleOfThree(d));
    }

    public static String largestMultipleOfThree(int[] digits) {
        int[] dp = new int[10];
        for (int digit : digits) {
            dp[digit]++;
        }

        int sum = getSum(dp);

        boolean flag = false;
        while (sum % 3 != 0) {
            int var = sum % 3;
            for (int i = 0; i < 3; ++i) {
                if (dp[i * 3 + var] > 0) {
                    dp[i * 3 + var]--;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int i = 1; i <= 3; ++i) {
                    if (dp[i * 3 - var] > 0) {
                        dp[i * 3 - var]--;
                        break;
                    }
                }
            }
            sum = getSum(dp);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; --i) {
            sb.append(String.valueOf(i).repeat(dp[i]));
        }
        String res = sb.toString();
        if (res.startsWith("0")) {
            return "0";
        }
        return res;
    }

    private static int getSum(int[] dp) {
        int sum = 0;
        for (int i = 1; i < 10; ++i) {
            sum += i * dp[i];
        }
        return sum;
    }
}
