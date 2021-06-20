package com.xinzhe.contest.biweeekly.s1.biweekly39;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/14
 * Title : 1652. 拆炸弹
 * Description : 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为n的循环数组code以及一个密钥k。为了获得正确的密码，你需要替换掉每一个数字。所有数字会同时被替换。
 *              如果k > 0，将第i个数字用 接下来k个数字之和替换。
 *              如果k < 0，将第i个数字用 之前k个数字之和替换。
 *              如果k == 0，将第i个数字用0替换。
 *              由于code是循环的，code[n-1]下一个元素是code[0]，且code[0]前一个元素是code[n-1]。给你 循环数组code和整数密钥k，请你返回解密后的结果来拆除炸弹！
 * link : https://leetcode-cn.com/problems/defuse-the-bomb
 * Level : Easy
 */
public class Leetcode_biweekly_3901 {
    public static void main(String[] args) {
        Leetcode_biweekly_3901 lc = new Leetcode_biweekly_3901();
        int[] arr = {2,4,9,3};
        System.out.println(Arrays.toString(lc.decrypt(arr, -2)));
    }
    public int[] decrypt(int[] code, int k) {
        if(k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int n = code.length;
        int[] tmp = new int[n * 2];
        System.arraycopy(code, 0, tmp, 0, n);
        System.arraycopy(code, 0, tmp, n, n);
        int[] res = new int[n];
        if(k > 0) {
            for(int i=0; i<n; i++) {
                for(int j=1; j<=k; j++) {
                    res[i] += tmp[i+j];
                }
            }
            return res;
        } else {
            k *= -1;
            for(int i=n; i<2 * n; i++) {
                for(int j=1; j<=k; j++) {
                    res[i-n] += tmp[i-j];
                }
            }
            return res;
        }
    }
}
