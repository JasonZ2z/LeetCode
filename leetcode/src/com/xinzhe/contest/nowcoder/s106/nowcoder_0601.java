package com.xinzhe.contest.nowcoder.s106;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/7/25
 * Title :
 * Description :
 * link :
 * Level :
 */
public class nowcoder_0601 {
    public static void main(String[] args) {
        nowcoder_0601 nc = new nowcoder_0601();
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(nc.solve(1, a));
    }
    public int solve (int n, int[] a) {
        // write code here
        Set<Integer> set = new HashSet<>();
        int[] evens = Arrays.stream(a).filter(x -> x % 2 == 0).sorted().toArray();

        for (int even : evens) {
            while (even % 2 == 0) {
                even /= 2;
                set.add(even);
            }

        }

        return set.size();
    }
}
