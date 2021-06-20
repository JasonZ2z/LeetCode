package com.xinzhe.contest.biweeekly.s1.biweekly47;

/**
 * @author Xin
 * @date 2021/03/06
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4703 {
    public static void main(String[] args) {
        Leetcode_biweekly_4703 lc = new Leetcode_biweekly_4703();
        int[] arr = {2, 4, 9, 3};
        String s= "aabcb";
        System.out.println(lc.beautySum(s));
    }
    int n;
    char[] arr;
    public int beautySum(String s) {
        this.n = s.length();
        this.arr = s.toCharArray();
        int sum = 0;
        for (int i = 3; i <= n; ++i) {
            int[] tmp = new int[26];
            for (int j = 0; j < i; ++j) {
                tmp[arr[j] - 'a']++;
            }
            sum += getSum(i, tmp);
            int l = 0, r = i;
            while (r < n) {
                tmp[arr[r++] - 'a']++;
                tmp[arr[l++] - 'a']--;
                sum += getSum(i, tmp);
            }
        }
        return sum;
    }

    private int getSum(int i, int[] tmp) {
        int max = 1, min = n;
        for (int j = 0; j < 26; ++j) {
            if(tmp[j] != 0) {
                max = Math.max(max, tmp[j]);
                min = Math.min(min, tmp[j]);
            }
        }
        return max - min;
    }
}