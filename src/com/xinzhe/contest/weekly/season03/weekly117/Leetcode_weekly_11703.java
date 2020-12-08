package com.xinzhe.contest.weekly.season03.weekly117;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/12/08
 * Title : 966. 元音拼写检查器
 * Description : 对于给定的查询单词 query，拼写检查器将会处理两类拼写错误：
 *              大小写：如果查询匹配单词列表中的某个单词（不区分大小写），则返回的正确单词与单词列表中的大小写相同。
 *              元音错误：如果在将查询单词中的元音（‘a’、‘e’、‘i’、‘o’、‘u’）分别替换为任何元音后，能与单词列表中的单词匹配（不区分大小写），则返回的正确单词与单词列表中的匹配项大小写相同。
 *          此外，拼写检查器还按照以下优先级规则操作：
 *              当查询完全匹配单词列表中的某个单词（区分大小写）时，应返回相同的单词。
 *              当查询匹配到大小写问题的单词时，您应该返回单词列表中的第一个这样的匹配项。
 *              当查询匹配到元音错误的单词时，您应该返回单词列表中的第一个这样的匹配项。
 *              如果该查询在单词列表中没有匹配项，则应返回空字符串。
 * link : https://leetcode-cn.com/problems/vowel-spellchecker
 * Level : Medium
 */

public class Leetcode_weekly_11703 {
    public static void main(String[] args) {
        Leetcode_weekly_11703 lc = new Leetcode_weekly_11703();
        int[][] arr = {{1,3}, {-2,2}};
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> map = new HashMap<>();
        Map<String, String> removeMap = new HashMap<>();
        for (String s : wordlist) {
            String low = s.toLowerCase();
            if(!map.containsKey(low)) map.put(low, s);
            String tmp = delete(low);
            if(!removeMap.containsKey(tmp)) removeMap.put(tmp, s);
        }
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if(set.contains(queries[i])) {
                res[i] = queries[i];
                continue;
            }
            String low = queries[i].toLowerCase();
            if(map.containsKey(low)) {
                res[i] = map.get(low);
                continue;
            }
            String tmp = delete(low);
            if(removeMap.containsKey(tmp)){
                res[i] = removeMap.get(tmp);
                continue;
            }
            res[i] = "";
        }
        return res;
    }
    Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    private String delete(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(!set.contains(c)) sb.append(c);
            else sb.append('-');
        }
        return sb.toString();
    }
}
