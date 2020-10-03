package com.xinzhe.contest.weekly.season03.weekly130;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/18
 * Title : 1018. 可被 5 整除的二进制前缀
 * Description : 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *              返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * link : https://leetcode-cn.com/problems/binary-prefix-divisible-by-5
 * Level : Easy
 */

public class Leetcode_weekly_13001 {
    public static void main(String[] args) {
        Leetcode_weekly_13001 lc = new Leetcode_weekly_13001();
    }
    public List<Boolean> prefixesDivBy5(int[] a) {
        List<Boolean> res = new ArrayList<>();
        int x = 0;
        for (int value : a) {
            x = (x * 2 + value) % 10;
            if (x % 5 == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
