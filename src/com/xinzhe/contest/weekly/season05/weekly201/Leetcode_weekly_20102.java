package com.xinzhe.contest.weekly.season05.weekly201;

/**
 * @Author Xin
 * @create 2020/8/2
 * Title : 1545. 找出第 N 个二进制字符串中的第 K 位
 * Description : 给你两个正整数 n 和 k，二进制字符串  Sn 的形成规则如下：
 *          S1 = "0"当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
 *          其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）
 *          请你返回  Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
 * link : https://leetcode-cn.com/problems/find-kth-bit-in-nth-binary-string
 * Level : Medium
 */
public class Leetcode_weekly_20102 {
    public static void main(String[] args) {
        Leetcode_weekly_20102 lc = new Leetcode_weekly_20102();
        System.out.println(lc.findKthBit(20, 1000000));
    }
    public char findKthBit(int n, int k) {
        String[] arr = new String[n+1];
        arr[1] = "0";
        for (int i = 2; i <= n; ++i) {
            arr[i] = arr[i - 1] + "1" + invert(arr[i - 1]);
        }
        return arr[n].charAt(k-1);
    }

    private String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i) == '1' ? '0' : '1');
        }
        return sb.reverse().toString();
    }

    public char findKthBit2(int n, int k) {
        if (n == 1) {
            return '0';
        }
        int len = (1 << n) - 1;
        if (k == len / 2 + 1) {
            return '1';
        } else if (k > len / 2 + 1) {
            return findKthBit(n - 1, len - k + 1) == '0' ? '1' : '0';
        } else {
            return findKthBit(n - 1, k);
        }
    }
}
