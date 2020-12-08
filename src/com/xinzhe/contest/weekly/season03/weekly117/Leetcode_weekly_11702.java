package com.xinzhe.contest.weekly.season03.weekly117;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/12/08
 * Title : 967. 连续差相同的数字
 * Description : 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K的非负整数。
 *              请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01因为有一个前导零，所以是无效的；但 0是有效的。你可以按任何顺序返回答案。
 * link : https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences
 * Level : Medium
 */

public class Leetcode_weekly_11702 {
    public static void main(String[] args) {
        Leetcode_weekly_11702 lc = new Leetcode_weekly_11702();
        System.out.println(Arrays.toString(lc.numsSameConsecDiff(2, 1)));
    }
    List<Integer> res = new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        if(n == 1) {
            for (int i = 0; i < 10; ++i) {
                res.add(i);
            }
        } else if(k == 0) {
            for (int i = 1; i < 10; ++i) {
                res.add(Integer.parseInt(String.valueOf(i).repeat(n)));
            }
        } else {
            for (int i = 1; i < 10; ++i) {
                dfs(i, n, k, i);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int i, int n, int k, int val) {
        if(String.valueOf(val).length() == n) {
            res.add(val);
            return;
        }
        if(i + k < 10) dfs(i+k, n ,k, val * 10 + (i + k));
        if(i - k >= 0) dfs(i-k, n ,k, val * 10 + (i - k));
    }
}
