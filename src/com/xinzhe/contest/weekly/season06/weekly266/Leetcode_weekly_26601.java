package com.xinzhe.contest.weekly.season06.weekly266;

import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2021/11/07
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_26601 {
    public static void main(String[] args) {
        Leetcode_weekly_26601 lc = new Leetcode_weekly_26601();

    }
    public int countVowelSubstrings(String word) {
        int n = word.length();
        int res = 0;
        boolean[] arr = new boolean[5];
        List<Character> set = List.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i + 5 <= n; i++) {
            if(set.contains(word.charAt(i))){
                arr[set.indexOf(word.charAt(i))] = true;
                for (int j = i+1; j < n; ++j) {
                    if(set.contains(word.charAt(j))) {
                        arr[set.indexOf(word.charAt(j))] = true;
                        if((arr[0] & arr[1] & arr[2] & arr[3] & arr[4])) {
                            res++;
                        }
                    } else {
                        break;
                    }
                }
                Arrays.fill(arr, false);
            }
        }
        return res;
    }
}
