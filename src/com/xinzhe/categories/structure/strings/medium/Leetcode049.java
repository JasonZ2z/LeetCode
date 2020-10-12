package com.xinzhe.categories.structure.strings.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/10/12
 * Title : 49. 字母异位词分组
 * Description : 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * link : https://leetcode-cn.com/problems/group-anagrams/
 * Level : Medium
 */

public class Leetcode049 {
    public static void main(String[] args) {
        Leetcode049 lc = new Leetcode049();
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(lc.groupAnagrams(arr));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            map.computeIfAbsent(new String(arr), a -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
