package com.xinzhe.contest.biweeekly.biweekly31;

/**
 * @author Xin
 * @date 2020/7/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_3104 {
    public static void main(String[] args) {
        Leetcode_biweekly_3104 lc = new Leetcode_biweekly_3104();
        System.out.println(lc.countOdds(278382788
                , 569302584));
        System.out.println(0);
    }
    public int countOdds(int low, int high) {
        int count = 0;
        for (int i = low; i <= high ; ++i) {
            if((i&1) == 1) {
                count++;
            }
        }
        return count;

    }
}
