package com.xinzhe.contest.biweeekly.biweekly33;

/**
 * @author Xin
 * @date 2020/8/22
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_3301 {
    public static void main(String[] args) {
        Leetcode_biweekly_3301 lc = new Leetcode_biweekly_3301();
        System.out.println(lc.thousandSeparator(1234));
    }
    public String thousandSeparator(int n) {
        if(n < 1000) return String.valueOf(n);
        char[] arr = String.valueOf(n).toCharArray();
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i-=3) {
            sb.append(arr[i]);
            if(i-1 >=0)sb.append(arr[i-1]);
            if(i-2>=0)sb.append(arr[i-2]);
            sb.append(".");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString();
    }
}
