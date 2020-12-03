package com.xinzhe.categories.solutions.math;

/**
 * @author Xin
 * @date 2020/12/03
 * Title : 204. 计数质数
 * Description : 统计所有小于非负整数 n 的质数的数量。
 * link : https://leetcode-cn.com/problems/count-primes/
 * Level : Easy
 */

public class Leetcode204 {
    public static void main(String[] args) {
        Leetcode204 lc = new Leetcode204();
        System.out.println(lc.countPrimes(3));
    }
    //埃氏筛 nloglogn
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        int cnt = 0;
        for(int i=2; i*i<n; i++) {
            if(!primes[i]) cnt++;
            if((long) i * i < n) {
                for (int j = i*i; j < n; j+=i) {
                    primes[j] = true;
                }
            }
        }
        return cnt;
    }
}
