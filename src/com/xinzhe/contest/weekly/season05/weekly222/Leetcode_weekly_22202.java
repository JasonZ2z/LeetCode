package com.xinzhe.contest.weekly.season05.weekly222;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/12/27
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_22202 {
    public static void main(String[] args) {
        Leetcode_weekly_22202 lc = new Leetcode_weekly_22202();
        int[] arr = {1,1,1,3,3,3,7};
        System.out.println(lc.countPairs(arr));
    }
    final int mod = (int)(1e9 + 7);
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>(deliciousness.length);
        for (int i : deliciousness) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Arrays.sort(deliciousness);
        long res = 0L;
        int pre = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            if(i > 0 && deliciousness[i] == deliciousness[i-1]) {
                if(Integer.bitCount(deliciousness[i] + deliciousness[i]) == 1) {
                    pre = Math.max(pre - 1, 0);
                    res += pre;
                } else {
                    res += pre;
                }
            } else {
                int cnt = 0;
                for (int j = 0; j < 22; ++j) {
                    int x = (int) Math.pow(2, j);
                    if(x > deliciousness[i] * 2) {
                        cnt += map.getOrDefault(x - deliciousness[i], 0);
                    } else if(x == deliciousness[i] * 2) {
                        cnt += map.get(deliciousness[i]) - 1;
                    }
                }
                res += cnt;
                pre = cnt;
            }
        }
        return (int) (res % mod);

    }
 }
