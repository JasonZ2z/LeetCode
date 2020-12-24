package com.xinzhe.contest.weekly.season05.weekly220;

/**
 * @author Xin
 * @date 2020/12/20
 * Title : 1694. 重新格式化电话号码
 * Description : 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。请你按下述方式重新格式化电话号码。
 *              首先，删除 所有的空格和破折号。
 *              其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 *                  2 个数字：单个含 2 个数字的块。
 *                  3 个数字：单个含 3 个数字的块。
 *                  4 个数字：两个分别含 2 个数字的块。
 *              最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。返回格式化后的电话号码。
 * link : https://leetcode-cn.com/problems/reformat-phone-number
 * Level : Easy
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
