package com.xinzhe.categories.solutions.bitmanipulation.medium;

/**
 * @author Xin
 * @date 2020/8/12
 * Title : 318. 最大单词长度乘积
 * Description : 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * link : https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * Level : Medium
 */
public class Leetcode318 {
    public static void main(String[] args) {
       int[] x = {1,-2,-5,0,10};
       int[] y = {0,-2,-1,-7,-4};
        Leetcode318 lc = new Leetcode318();
    }

    public int maxProduct(String[] words) {
        int n = words.length;
        if(n < 2) return 0;
        int[] dp = new int[n];
        for(int i=0;i<n; i++){
            for(char c: words[i].toCharArray()){
                dp[i] |= 1 <<(c -'a');
            }
        }
        int res = 0;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if((dp[i]&dp[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
