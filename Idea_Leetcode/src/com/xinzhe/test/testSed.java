package com.xinzhe.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class testSed {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,2,5,2,3,7};

        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(10);
        for(int i: nums){
            if(!map.containsKey(i)){
                map.put(i, 1);
            } else {
                map.put(i, map.get(i)+1);
            }
        }
        int max = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();
            int value = entry.getValue();
            Integer integer1 = map.get(key - 1);
            if(integer1 != null) {
                if(integer1 + value > max){
                    max = integer1 + value;
                }
            }
            Integer integer2 = map.get(key + 1);
            if(integer2 != null) {
                if(integer2 + value > max){
                    max = integer2 + value;
                }
            }
        }

        return max;
    }
}
