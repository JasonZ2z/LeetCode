package com.xinzhe.categories.solutions.dp.palindrome;

/**
 * @author Xin
 * @date 2020/6/19
 * Title : 125. 验证回文串
 * Description : 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
 * link : https://leetcode-cn.com/problems/valid-palindrome/
 * Level : Easy
 */

public class Leetcode125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Leetcode125 lc = new Leetcode125();
        System.out.println(lc.isPalindrome(s));
    }
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        char[] arr = s.toLowerCase().toCharArray();
        int l =0, r = s.length()-1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(arr[l])) l++;
            while (l < r && !Character.isLetterOrDigit(arr[r])) r--;
            if(l <= r && arr[l] == arr[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
