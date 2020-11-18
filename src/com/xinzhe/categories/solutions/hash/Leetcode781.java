package com.xinzhe.categories.solutions.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/11/16
 * Title : 781. 森林中的兔子
 * Description : 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在answers数组里。返回森林中兔子的最少数量。
 * link : https://leetcode-cn.com/problems/rabbits-in-forest
 * Level : Medium
 */
public class Leetcode781 {
    public static void main(String[] args) {
        Leetcode781 lc = new Leetcode781();
        int[] arr = {1,1,2};
        System.out.println(lc.numRabbits(arr));
    }

    public int numRabbits(int[] answers) {
        int n = answers.length;
        if(n == 0) return 0;
        int[] cnt = new int[1000];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int sum = 0;
        for(int a : answers) {
            if(a == 0) sum++;
            else cnt[a]++;
        }
        for (int i = 0; i < 1000; i++) {
            if(cnt[i] > 0) map.computeIfAbsent(cnt[i], a -> new HashSet<>()).add(i);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> value = entry.getValue();
            Integer key = entry.getKey();

            for (Integer i : value) {
                if(i >= key) sum += i + 1;
                else {
                    int x = key / (i + 1);
                    int y = key % (i + 1);
                    if(y == 0) sum += x * (i + 1);
                    else sum += (x + 1) * (i + 1);
                }
            }

        }
        return sum;
    }

    public int numRabbits2(int[] answers) {
        int res = 0;
        int[] count = new int[1000];

        for(int a : answers){
            count[a]++;
            if(a == 0 || count[a] % (a + 1) == 1)
                res += a + 1;
        }
        return res;
    }
}
