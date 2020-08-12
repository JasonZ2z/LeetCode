package com.xinzhe.contest.weekly.season04.weekly158;

/**
 * @Author Xin
 * @create 2020/7/15
 * Title : 1221. 分割平衡字符串
 * Description : 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。返回可以通过分割得到的平衡字符串的最大数量。
 * link : https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
 * Level : Easy
 * Comment 158周赛01
 */

public class Leetcode_weekly_15801 {

    public static void main(String[] args) {
        Leetcode_weekly_15801 lc = new Leetcode_weekly_15801();
    }
    public int balancedStringSplit(String s) {
        if("".equals(s) || s.length() == 1) return 0;
        int count = 1;
        int result = 0;
        char tmp = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == tmp) {
                count++;
            } else {
                count -= 1;
            }
            if(count == 0){
                result++;
            }
        }
        return result;
    }
}
