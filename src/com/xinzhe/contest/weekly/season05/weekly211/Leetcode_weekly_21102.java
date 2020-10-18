package com.xinzhe.contest.weekly.season05.weekly211;

/**
 * @author Xin
 * @date 2020/10/18
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21102 {
    public static void main(String[] args) {
        Leetcode_weekly_21102 lc = new Leetcode_weekly_21102();
        int[] arr = {3,5};
    }

    public String findLexSmallestString(String s, int a, int b) {
        char[] chars = s.toCharArray();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            arr[i] = chars[i] - '0';
        }
        return "";
    }

    private int[] add(int[] arr, int a) {
        for (int i = 0; i < arr.length; ++i) {
            if((i & 1) == 1) {
                arr[i] = (arr[i] + a) % 10;
            }
        }
        return arr;
    }

    private int[] move(int[] arr, int b) {
        int n = arr.length;
        int[] tmp = new int[n];
        System.arraycopy(arr, n - b, tmp, 0, b);
        System.arraycopy(arr, 0, tmp, b+1, n- b);
        return tmp;
    }

    private boolean compare(int[] min, int[] cur) {
        for (int i = 0; i < min.length; ++i) {
            if(min[i] < cur[i]) return false;
        }
        return true;
    }
}
