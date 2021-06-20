package com.xinzhe.contest.weekly.season05.weekly245;

/**
 * @author Xin
 * @date 2021/06/13
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24502 {
    public static void main(String[] args) {
        Leetcode_weekly_24502 lc = new Leetcode_weekly_24502();
        //"qobftgcueho"
        //"obue"
        //[5,3,0,6,4,9,10,7,2,8]

        //"qlevcvgzfpryiqlwy"
        //"qlecfqlw"
        //[12,5]
        String s = "qlevcvgzfpryiqlwy", p = "qlecfqlw";
        int[] re = {12,5};
        System.out.println(lc.maximumRemovals(s, p, re));

    }
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0, r = removable.length-1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (!check(p, mid, s, removable)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return check(p, l, s, removable) ? l + 1 : l;
    }

    private boolean check(String p, int mid, String s, int[] removable) {
        char[] arr = s.toCharArray();
        for (int i = 0; i <= mid; i++) {
            arr[removable[i]] = '-';
        }
        return check2(p, new String(arr));
    }


    private boolean check2(String s, String t) {
        char[] arr = s.toCharArray();
        int i = -1;
        for(char c : arr) {
            i = t.indexOf(c, i+1);
            if(i == -1) {
                return false;
            }
        }
        return true;
    }


}
