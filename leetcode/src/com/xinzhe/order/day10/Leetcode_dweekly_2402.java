package com.xinzhe.order.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/4/18 22:16
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_dweekly_2402 {
    public static void main(String[] args) {
        System.out.println(findMinFibonacciNumbers(10));
    }

    public static int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        while (true){
            int n = list.size();
            int tmp = list.get(n-1) + list.get(n-2);
            if(tmp == k) {
                return 1;
            } else if(tmp > k) {
                break;
            }else {
                list.add(tmp);
            }
        }
        int len = list.size();
        int res = 0;

        while (k > 0) {
            for(int i = len-1; i >= 0; --i) {
                if(k >= list.get(i)){
                    k -= list.get(i);
                    System.out.println(list.get(i));
                    res++;
                    if(k == 0) return res;
                    break;
                }
            }
        }
        return res;
    }
}
