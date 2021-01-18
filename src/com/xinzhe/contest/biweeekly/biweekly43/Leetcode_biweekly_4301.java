package com.xinzhe.contest.biweeekly.biweekly43;

/**
 * @author Xin
 * @date 2021/01/09
 * Title : 1720. 解码异或后的数组
 * Description : 未知 整数数组 arr 由 n 个非负整数组成。
 *              经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 *              给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 *              请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * link : https://leetcode-cn.com/problems/decode-xored-array
 * Level : Easy
 */
public class Leetcode_biweekly_4301 {
    public static void main(String[] args) {
        Leetcode_biweekly_4301 lc = new Leetcode_biweekly_4301();
        int[] arr = {2, 4, 9, 3};
    }
    public int totalMoney(int n) {
        if(n == 1) return 1;
        int s = 1;
        int res = 0;
        while (n > 0) {
            if( n <= 7) {
                res += n * s + (n-1)*n/2;
                return res;
            } else {
                res += 7 * s + 3*7;
            }
            n -= 7;
            s++;
        }
        return res;
    }
}