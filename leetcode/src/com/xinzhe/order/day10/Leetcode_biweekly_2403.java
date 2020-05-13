package com.xinzhe.order.day10;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author Xin
 * @create 2020/4/18 22:16
 * Title : 5374. 长度为 n 的开心字符串中字典序第 k 小的字符串
 * Description : 一个 「开心字符串」定义为：
 *      仅包含小写字母 ['a', 'b', 'c'].
 *      对所有在 1 到 s.length - 1 之间的 i ，满足 s[i] != s[i + 1] （字符串的下标从 1 开始）。
 *      比方说，字符串 "abc"，"ac"，"b" 和 "abcbabcbcb" 都是开心字符串，但是 "aa"，"baa" 和 "ababbc" 都不是开心字符串。
 *      给你两个整数 n 和 k ，你需要将长度为 n 的所有开心字符串按字典序排序。
 *      请你返回排序后的第 k 个开心字符串，如果长度为 n 的开心字符串少于 k 个，那么请你返回 空字符串 。
 * link : https://leetcode-cn.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n
 * Level : Medium
 * Comment : 24双周赛03
 */
public class Leetcode_biweekly_2403 {
    public static void main(String[] args) {
        System.out.println(getHappyString2(4,10));
    }

    static ArrayList<String> list = new ArrayList<>();
    public static String getHappyString2(int n, int k) {
        int sum = 3;
        for (int i = 1; i < n; ++i) {
            sum *= 2;
        }
        if(sum < k) return "";
        bfs("a", n-1, "a");
        bfs("b", n-1, "b");
        bfs("c", n-1, "c");
        Collections.sort(list);
        return list.get(k);
    }

    private static void bfs(String s, int n, String cur) {
        if(n == 0) {
            list.add(s);
            return;
        }
        if("a".equals(cur)) {
            bfs(s+"b", n-1, "b");
            bfs(s+"c", n-1, "c");
        }
        if("b".equals(cur)) {
            bfs(s+"a", n-1, "a");
            bfs(s+"c", n-1, "c");
        }
        if("c".equals(cur)) {
            bfs(s+"b", n-1, "b");
            bfs(s+"a", n-1, "a");
        }
    }
}
