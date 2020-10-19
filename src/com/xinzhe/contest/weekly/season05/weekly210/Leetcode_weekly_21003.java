package com.xinzhe.contest.weekly.season05.weekly210;

/**
 * @author Xin
 * @date 2020/10/11
 * Title : 1616. 分割两个字符串得到回文串
 * Description : 给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。
 *              由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。
 *              请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
 *              当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割
 *              如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。请注意， x + y 表示连接字符串 x 和 y 。
 * link : https://leetcode-cn.com/problems/split-two-strings-to-make-palindrome
 * Level : Medium
 */

public class Leetcode_weekly_21003 {
    public static void main(String[] args) {
        Leetcode_weekly_21003 lc = new Leetcode_weekly_21003();
        int[] arr = {3,5};
        String a = "cdeoo";
        String b = "oooab";
        System.out.println(lc.checkPalindromeFormation(a, b));
    }
    public boolean checkPalindromeFormation(String a, String b) {
        if(isPalindrome(a) || isPalindrome(b)) return true;
        int n = a.length();
        int l = 0, r = n -1;
        while(a.charAt(l) == b.charAt(r)) {
            l++;
            r--;
        }
        if(isPalindrome(a.substring(l, r + 1)) || isPalindrome(b.substring(l , r + 1)) ) return true;
        l = 0;
        r = n-1;
        while(b.charAt(l) == a.charAt(r)) {
            l++;
            r--;
        }
        return isPalindrome(b.substring(l, r + 1)) || isPalindrome(a.substring(l, r + 1));
    }

    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        char[] arr = s.toLowerCase().toCharArray();
        int l =0, r = s.length()-1;
        while (l < r) {
            if(arr[l] == arr[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
