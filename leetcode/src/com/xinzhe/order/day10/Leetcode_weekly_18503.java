package com.xinzhe.order.day10;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * @Author Xin
 * @create 2020/4/19 10:24
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_18503 {
    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("crocracokrakoak"));
    }
    public static int minNumberOfFrogs(String s) {
        int n = s.length();
        if(n % 5 != 0) return -1;
        if(!s.startsWith("c")) return -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        if(map.size() != 5) return -1;
        int max = map.get('c');
        for (Integer value : map.values()) {
            if(value != max) {
                return -1;
            }
        }

        int[] res = new int[5];
        Arrays.fill(res, 0);
        char[] nums = s.toCharArray();

        int i = 1;
        res[0] = 1;
        int count = 0;
        while(i < n){
            if(nums[i] == 'c'){
                res[0] += 1;
            }
            else if(nums[i] == 'r'){
                res[1] += 1;
            }
            else if(nums[i] == 'o'){
                res[2] += 1;
            }
            else if(nums[i] == 'a'){
                res[3] += 1;
            }
            else if(nums[i] == 'k'){
                res[4] += 1;
            }
            int[] tmp = isTrue(res);
            count = Math.max(count, tmp[0] -tmp[1]);

        }
        return count;
    }

    private static int[] isTrue(int[] res) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int re : res) {
            max = Math.max(max, re);
            min = Math.min(min, re);
        }
        return new int[]{max, min};
    }

}
