package com.xinzhe.contest.weekly.season04.weekly154;

/**
 * @Author Xin
 * @create 2020/7/28
 * Title : 1189. “气球” 的最大数量
 * Description : 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *              字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * link : https://leetcode-cn.com/problems/maximum-number-of-balloons
 * Level : Easy
 */

public class Leetcode_weekly_15401 {

    public static void main(String[] args) {
        Leetcode_weekly_15401 lc = new Leetcode_weekly_15401();
    }
    public int maxNumberOfBalloons(String text) {
        if(text == null || text.length() < 7) return 0;
        int[] array = new int[5];
        for(char c : text.toCharArray()){
            if( c == 'b') array[0]++;
            if( c == 'a') array[1]++;
            if( c == 'l') array[2]++;
            if( c == 'o') array[3]++;
            if( c == 'n') array[4]++;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<5; i++){
            if(i ==2 || i==3){
                array[i] /= 2;
            }
            min = Math.min(min, array[i]);
        }
        return min;
    }
}
