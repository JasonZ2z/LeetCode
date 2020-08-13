package com.xinzhe.contest.nowcoder.s1.s111;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/8/13
 * Title :
 * Description :
 * link :
 */
public class nowcoder_1103 {
    public int[] solve (int n, int k, int[] s) {
        // write code here
        if(n == k) return s;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : s) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> keys = map.keySet().stream().sorted(Integer::compareTo).collect(Collectors.toList());
        int[] res = new int[k];

        int i = 0;
        int j = 0;
        while(i < k) {
            int value = map.get(keys.get(j));
            while (i < k && value-- > 0) {
                res[i++] = keys.get(j);
            }
            j++;
        }
        return res;
    }
}
