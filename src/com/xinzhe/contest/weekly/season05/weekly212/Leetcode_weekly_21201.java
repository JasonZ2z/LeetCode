package com.xinzhe.contest.weekly.season05.weekly212;

/**
 * @author Xin
 * @date 2020/10/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21201 {
    public static void main(String[] args) {
        Leetcode_weekly_21201 lc = new Leetcode_weekly_21201();
        int[] arr = {3,5};
    }
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char cur = keysPressed.charAt(0);
        int last = releaseTimes[0];

        for (int m = 1; m < keysPressed.toCharArray().length; m++) {
            if(releaseTimes[m] - releaseTimes[m-1] > last) {
                last = releaseTimes[m] - releaseTimes[m-1];
                cur = keysPressed.charAt(m);
            } else if(releaseTimes[m] - releaseTimes[m-1] == last) {
                char c = keysPressed.charAt(m);
                if(c > cur) cur = c;
            }
        }

        return cur;

    }
}
