package com.xinzhe.categories.structure.strings.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Xin
 * @date 2020/4/16
 * Title : 833. 字符串中的查找与替换
 * Description : 某个字符串 S 需要执行一些替换操作，用新的字母组替换原有的字母组（不一定大小相同）。
 *              每个替换操作具有 3 个参数：起始索引 i，源字 x 和目标字 y。规则是：如果 x 从原始字符串 S 中的位置 i 开始，那么就用 y 替换出现的 x。如果没有，则什么都不做。
 *              举个例子，如果 S= “abcd” 并且替换操作 i = 2，x = “cd”，y = “ffff”，那么因为 “cd” 从原始字符串 S 中的位置 2 开始，所以用“ffff” 替换它。
 *              再来看 S = “abcd” 上的另一个例子，如果一个替换操作 i = 0，x = “ab”，y = “eee”，以及另一个替换操作 i = 2，x = “ec”，y = “ffff”，那么第二个操作将不会执行，因为原始字符串中S[2] = 'c'，与 x[0] = 'e' 不匹配。
 *              所有这些操作同时发生。保证在替换时不会有任何重叠：S = "abc", indexes = [0, 1],sources = ["ab","bc"] 不是有效的测试用例。
 * link : https://leetcode-cn.com/problems/find-and-replace-in-string
 * Level : Medium
 */

public class Leetcode833 {
    public static void main(String[] args) {
        String s = "abcd";
        int[] index = {0,2};
        String[] source = {"ab", "ec"};
        String[] target = {"eee", "fff"};
        Leetcode833 lc = new Leetcode833();
        System.out.println(lc.findReplaceString(s, index, source, target));
    }
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int n = indexes.length;
        Item[] items = new Item[n];
        for (int i = 0; i < indexes.length; i++) {
            items[i] = new Item(indexes[i], sources[i], targets[i]);
        }
        Arrays.sort(items, Comparator.comparingInt(item -> item.index));
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            if(S.startsWith(item.source, item.index)) {
                item.flag = true;
            }
        }
       int i=0, j =0;
        while (i < n && j < S.length()) {
            Item x = items[i];
            if(!x.flag) {
                i++;
            } else {
                if(j == x.index) {
                    sb.append(x.target);
                    i++;
                    j = j + x.source.length();
                } else {
                    sb.append(S.charAt(j++));
                }
            }
        }
        sb.append(S.substring(j));
        return sb.toString();
    }

    class Item {
        int index;
        String source;
        String target;
        Boolean flag;

        public Item(int i, String source, String target) {
            this.index = i;
            this.source = source;
            this.target = target;
            flag = false;
        }
    }
}
