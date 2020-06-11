package com.xinzhe.interview.easy;

/**
 * @Author Xin
 * @create 2020/6/10
 * Title : 01.09. String Rotation LCCI
 * Description : Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 (e.g.,"waterbottle" is a rotation of"erbottlewat"). 
 *              Can you use only one call to the method that checks if one word is a substring of another?
 * link : https://leetcode-cn.com/problems/string-rotation-lcci
 */
public class Interview_0109 {
    public boolean isFlipedString(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 != n2) return false;
        StringBuilder sb;
        for (int i = 0; i < n2; ++i) {
            sb = new StringBuilder();
            sb.append(s2, i, n2).append(s2, 0, i);
            if(s1.contentEquals(sb)){
                return true;
            }
        }
        return false;
    }

    public boolean isFlipedString2(String s1, String s2){
        return s1.equals(s2)||(s1.length()==s2.length()&&(s1+s1).contains(s2));
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(s.substring(0, 1) + s.substring(1, 2));
    }
}
