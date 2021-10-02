package com.xinzhe.contest.weekly.season06.weekly259;

/**
 * @author Xin
 * @date 2021/09/19
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_25901 {
    public static void main(String[] args) {
        Leetcode_weekly_25901 lc = new Leetcode_weekly_25901();

    }
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if(operation.contains("+")) x++;
            else x--;
        }
        return x;
    }

}
