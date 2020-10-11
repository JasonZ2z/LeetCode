package com.xinzhe.contest.weekly.season05.weekly210;

/**
 * @author Xin
 * @date 2020/10/11
 * Title :
 * Description :
 * link :
 * Level : Easy
 */

//"x"
//"y"
//"xbdef"
//"xecab"
//"ulacfd"
//"jizalu"
//"cdeoo"
//"oooab"
//"pvhmupgqeltozftlmfjjde"
//"yjgpzbezspnnpszebzmhvp"
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
