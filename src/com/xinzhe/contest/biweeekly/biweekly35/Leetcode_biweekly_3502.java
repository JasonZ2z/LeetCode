package com.xinzhe.contest.biweeekly.biweekly35;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/9/19
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_3502 {
    public static void main(String[] args) {
        Leetcode_biweekly_3502 lc = new Leetcode_biweekly_3502();
        int[] n = {1,2,3,4,5};
        int[][] r = {{1,3}, {0,1}};
        System.out.println(lc.maxSumRangeQuery(n, r));
    }
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] request : requests) {
            for (int i = request[0]; i <= request[1]; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        Arrays.sort(nums);
        long res = 0;
        int mod = (int)1e9 + 7;
        int j = n-1;
        //List<Integer> list = map.values().stream().sorted().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Integer::compareTo);
        for (int i = list.size() - 1; i >= 0; i--) {
            res += list.get(i) * nums[j--];
        }
        return (int)(res % mod);
    }

    public int maxSumRangeQuery2(int[] nums, int[][] requests) {
        int n = nums.length;
        int max = 0;
        for (int[] request : requests) {
            max = Math.max(max, request[1]);
        }
        int[] dist = new int[max + 1];
        for (int[] request : requests) {
            for (int i = request[0]; i <= request[1]; i++) {
                dist[i]++;
            }
        }
        Arrays.sort(dist);
        Arrays.sort(nums);
        long res = 0;
        int mod = (int)1e9 + 7;
        int j = n-1;
        for (int i = max; i >= 0; i--) {
            res += dist[i] * nums[j--];
        }
        return (int)(res % mod);
    }
}
