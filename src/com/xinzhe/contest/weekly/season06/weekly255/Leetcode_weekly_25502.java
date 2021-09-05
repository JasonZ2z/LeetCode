package com.xinzhe.contest.weekly.season06.weekly255;

/**
 * @author Xin
 * @date 2021/08/22
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_25502 {
    public static void main(String[] args) {
        Leetcode_weekly_25502 lc = new Leetcode_weekly_25502();

    }
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int len = (int) Math.pow(2,n);
        boolean[] arr = new boolean[len];

        for (String num : nums) {
            int index = Integer.parseInt(num, 2);
            arr[index] = true;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i]) {
                res.append(Integer.toBinaryString(i));
                break;
            }
        }
        while (res.length() < n) {
            res.insert(0, '0');
        }
        return res.toString();
    }
}
