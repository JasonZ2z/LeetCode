package com.xinzhe.contest.nowcoder.s1.s106;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/7/25
 * Title :
 * Description :
 * link :
 * Level :
 */
public class nowcoder_0603 {

    public int solve (int n, int[] array) {
        // write code here
        int len = array.length;
        Arrays.sort(array);
        int m1 = 0;
        int m2 = 0;
        for (int i = 2; i < n; i+=2) {
            m1 = Math.max(m1, array[i] - array[i-2]);
        }
        for (int i = 3; i < n; i+=2) {
            m2 = Math.max(m2, array[i] - array[i-2]);
        }
        return Math.max(array[n-1] - array[n-2], Math.max(m1, m2));
    }
}
