package com.xinzhe.contest.weekly.season03.weekly130;

/**
 * @author Xin
 * @date 2020/9/18
 * Title : 1017. 负二进制转换
 * Description : 给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
 *              除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * link : https://leetcode-cn.com/problems/convert-to-base-2
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_13002 {
    public static void main(String[] args) {
        Leetcode_weekly_13002 lc = new Leetcode_weekly_13002();
    }
    public String baseNeg2(int N) {
        StringBuilder res = new StringBuilder(30);
        while (N != 0) {
            int mod = N % (-2);
            N /= -2;
            if (mod == -1) {
                res.append(1);
                N++;//修正N
            } else {
                res.append(mod);
            }
        }
        return res.length() == 0 ? "0" : res.reverse().toString();
    }
}
