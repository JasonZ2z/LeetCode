package com.xinzhe.contest.weekly.season03.weekly128;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 1009. 十进制整数的反码
 * Description : 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
 *              二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
 *              给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。
 * link : https://leetcode-cn.com/problems/complement-of-base-10-integer
 * Level : Easy
 */

public class Leetcode_weekly_12801 {
    public static void main(String[] args) {
        Leetcode_weekly_12801 lc = new Leetcode_weekly_12801();
    }
    public int bitwiseComplement(int num) {
        if(num == 0) return 1;
        int ans = 0;
        int i = 0;
        while(num != 0) {
            if((num & 1) == 0){
                ans += 1 << i;
            }
            num >>= 1;
            i++;
        }
        return ans;
    }
}
