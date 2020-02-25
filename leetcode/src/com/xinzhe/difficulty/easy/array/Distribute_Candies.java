package com.xinzhe.difficulty.easy.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Distribute_Candies {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,2,3,3,3};
        System.out.println(distributeCandies(arr));
    }
    public static int distributeCandies(int[] candies) {
        int n = candies.length;
        if(n == 0 || n%2 != 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int candy : candies) {
            if (map.containsKey(candy)) {
                map.put(candy, map.get(candy) + 1);
            } else {
                map.put(candy, 1);
            }
        }

        List<Integer> collect = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        int sum =0;
        int count =0;
        for (Integer integer : collect) {
            sum += integer;
            count++;
            if(sum > n/2){
                break;
            }
        }


        return Math.min(map.keySet().size(), n/2);

    }
}
