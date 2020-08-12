package com.xinzhe.contest.weekly.season04.weekly155;

/**
 * @author Xin
 * @date 2020/7/27
 * Title : 1201. 丑数 III
 * Description : 请你帮忙设计一个程序，用来找出第 n 个丑数。丑数是可以被 a 或 b 或 c 整除的 正整数。
 * link : https://leetcode-cn.com/problems/ugly-number-iii/
 * Level : Medium
 */

//todo need to review
    //有交集的三个集合取总并集
    //A∪B∪C=A+B+C-A∩B-B∩C-A∩C+A∩B∩C
public class Leetcode_weekly_15502 {

    public static void main(String[] args) {
        Leetcode_weekly_15502 lc = new Leetcode_weekly_15502();
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(c, b);
        long abc = lcm(ab, c);
        long left = 1, right = Integer.MAX_VALUE;
        while(left < right) {
            long mid = (left + right)>>1;
            long sum = mid/a + mid/b + mid/c - mid/ab - mid/ac- mid/bc + mid/abc;
            if(sum < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int)left;

    }
    public long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public long lcm(long a, long b){
        return a * b / gcd(a, b);
    }
}
