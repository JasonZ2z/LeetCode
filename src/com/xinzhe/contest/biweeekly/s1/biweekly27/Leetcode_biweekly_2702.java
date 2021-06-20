package com.xinzhe.contest.biweeekly.s1.biweekly27;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/5/30
 * Title : 1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
 * Description : 给你一个二进制字符串 s 和一个整数 k 。如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 True ，否则请返回 False
 * link : https://leetcode-cn.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 * Level : Medium
 */
public class Leetcode_biweekly_2702 {
    public static void main(String[] args) {
        String s = "00110";
        int k = 2;
        System.out.println(hasAllCodes(s, 2));
    }

    public static boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; ++i) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == Math.pow(2, k);
    }


    public boolean hasAllCodes2(String s, int k) {
        int need = 1 << k;
        boolean[] got = new boolean[need];
        int allOne = need - 1;
        int hashVal = 0;

        for (int i = 0; i < s.length(); i++) {
            // calculate hash for s.substr(i-k+1,i+1)
            hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');
            // hash only available when i-k+1 > 0
            if (i >= k - 1 && !got[hashVal]) {
                got[hashVal] = true;
                need--;
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
