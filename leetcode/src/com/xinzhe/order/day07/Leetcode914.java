package com.xinzhe.order.day07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xin
 * @create 2020/3/27 19:55
 * Title : 638. 大礼包
 * Description : 给定一副牌，每张牌上都写着一个整数。此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *              每组都有 X 张牌。
 *              组内所有的牌上都写着相同的整数。
 *              仅当你可选的 X >= 2 时返回 true。
 * link : https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * Level : Easy
 */

public class Leetcode914 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,3,2,1,1};
        System.out.println(hasGroupsSizeX(arr));
    }

    //最大公约数
    private static boolean hasGroupsSizeX2(int[] deck) {
        int[] cnt = new int[10000];
        for (int num : deck) {
            cnt[num]++;
        }

        int x = cnt[deck[0]];

        for (int i = 0; i < 10000; ++i) {
            if(cnt[i] == 1) return false;
            x= gcd(x, cnt[i]);
            if(x == 1) return false;

        }
        return true;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    //暴力破解
    private static boolean hasGroupsSizeX(int[] deck) {
        if(deck.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> values = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        int min = values.get(values.size()-1);
        System.out.println(min);

        while (min >= 2){
            boolean flag = true;
            for (int i : values) {
                if(i % min != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
            min--;
        }

        return false;
    }
}
