package com.xinzhe.categories.structure.strings.medium;

import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/5/28
 * Title : 394. 字符串解码
 * Description : 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * E.g:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * <p>
 * link : https://leetcode-cn.com/problems/decode-string
 * Level : Medium
 */

public class Leetcode394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        LinkedList<Integer> multi = new LinkedList<>();
        LinkedList<String> res = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                multi.addLast(tmp);
                res.add(sb.toString());
                tmp = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                sb = new StringBuilder(res.removeLast() + sb.toString().repeat(multi.removeLast()));
            } else if (Character.isDigit(c)) tmp = tmp * 10 + Integer.parseInt(c + "");
            else sb.append(c);
        }
        return sb.toString();
    }
}
