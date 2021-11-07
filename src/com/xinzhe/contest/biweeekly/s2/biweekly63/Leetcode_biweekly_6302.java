package com.xinzhe.contest.biweeekly.s2.biweekly63;

/**
 * @author Xin
 * @date 2021/10/16
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6302 {
    public static void main(String[] args) {
        Leetcode_biweekly_6302 lc = new Leetcode_biweekly_6302();

    }
    public boolean winnerOfGame(String colors) {
        int n = colors.length(), alice = -1, bob = 0;
        for (int i = 1; i < n - 1; ++i) {
            if(colors.charAt(i) == 'A'){
                if(colors.charAt(i-1) == 'A' && colors.charAt(i+1) == 'A') alice++;
            } else {
                if(colors.charAt(i-1) == 'B' && colors.charAt(i+1) == 'B') bob++;
            }
        }
        return alice >= bob;
    }

}