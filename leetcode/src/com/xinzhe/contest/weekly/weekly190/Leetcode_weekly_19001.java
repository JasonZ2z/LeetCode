package com.xinzhe.contest.weekly.weekly190;

/**
 * @Author Xin
 * @create 2020/5/24
 * Title :
 * Description :
 * link :
 * Level : Easy
 * Comment 190周赛01
 */
public class Leetcode_weekly_19001 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

}
