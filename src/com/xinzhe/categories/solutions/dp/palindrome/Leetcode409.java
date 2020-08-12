package com.xinzhe.categories.solutions.dp.palindrome;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/3/19 18:01
 * Title : 409. 最长回文串
 * Description : 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *              在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * link : https://leetcode-cn.com/problems/longest-palindrome/
 * Level : Easy
 */
public class Leetcode409 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cc"));
    }
    public int longestPalindrome3(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }
        int ans = 0;
        for (int x: cnt) {
            // 字符出现的次数最多用偶数次。
            ans += x - (x & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return ans < s.length() ? ans + 1 : ans;
    }
    public int longestPalindrome2(String s) {
        Map<Integer, Integer> count = s.chars().boxed()
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));

        int ans = count.values().stream().mapToInt(i -> i - (i & 1)).sum();
        return ans < s.length() ? ans + 1 : ans;
    }

    private static int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c) == 1){
                    count +=2;
                    map.put(c, 0);
                } else {
                    map.put(c, 1);
                }
            } else {
                map.put(c, 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() != 0){
                count++;
                break;
            }
        }
        return count;
    }
}
