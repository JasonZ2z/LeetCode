package com.xinzhe.contest.weekly.season05.weekly235;

/**
 * @author Xin
 * @date 2021/03/28
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23502 {
    public static void main(String[] args) {
        Leetcode_weekly_23502 lc = new Leetcode_weekly_23502();
        System.out.println(lc.findTheWinner(5, 2));
        System.out.println(lc.findTheWinner(6, 5));

    }
    public int findTheWinner(int n, int k) {
        if(n == 1) return 1;
        if(k == 1) return n;
        boolean[] arr = new boolean[n];
        int start = 0;
        while (check(arr)) {
            int x = 0;
            for (int i = 0;; ++i) {
                if(!arr[(start + i) % n]){
                    x++;
                    if(x == k){
                        arr[(start + i) % n] = true;
                        start = (start + i) % n;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i]) return  i + 1;
        }
        return -1;
    }

    private boolean check(boolean[] arr) {
        int count = 0;
        for (boolean b : arr) {
            if(!b) count++;
            if(count > 1) return true;
        }
        return false;
    }

}
