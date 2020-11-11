package com.xinzhe.categories.structure.strings.medium;

/**
 * @author Xin
 * @date 2020/11/11
 * Title : 443. 压缩字符串
 * Description : 给定一组字符，使用原地算法将其压缩。压缩后的长度必须始终小于或等于原数组长度。数组的每个元素应该是长度为1的字符（不是 int 整数类型）。在完成原地修改输入数组后，返回数组的新长度。
 * link : https://leetcode-cn.com/problems/string-compression
 * Level : Medium
 */

public class Leetcode443 {
    public int compress(char[] chars) {
        int n = chars.length;
        int cnt = 1, p = 0, q = 1;
        while(p < n) {
            if(chars[p] != chars[p - 1]) {
                if(cnt > 1) {
                    for (char c : String.valueOf(cnt).toCharArray())
                        chars[q++] = c;
                }
                chars[q++] = chars[p];
                cnt = 1;
            } else {
                cnt++;
            }
            p++;
        }
        if(cnt > 1) {
            for (char c : String.valueOf(cnt).toCharArray())
                chars[q++] = c;
        }
        return q;
    }
}
