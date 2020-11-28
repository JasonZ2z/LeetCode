package com.xinzhe.contest.biweeekly.biweekly40;

/**
 * @author Xin
 * @date 2020/11/28
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_biweekly_4001 {
    public static void main(String[] args) {
        Leetcode_biweekly_4001 lc = new Leetcode_biweekly_4001();
        int[] arr = {2, 4, 9, 3};
        System.out.println("abc".repeat(0));
    }
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        if(!sequence.contains(word)) return 0;
        int x = 1;
        while (x * m <= n) {
            String tmp = word.repeat(x);
            if(sequence.contains(tmp)) {
                x++;
            } else {
                break;
            }
        }
        return x-1;
    }
}