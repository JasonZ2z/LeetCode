package com.xinzhe.categories.solutions.greedy.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/4/21
 * Title : 860. 柠檬水找零
 * Description : 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *              顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *              每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *              注意，一开始你手头没有任何零钱。
 *              如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * link : https://leetcode-cn.com/problems/lemonade-change
 * Level : Easy
 */

public class Leetcode860 {
    public static void main(String[] args) {
        int[] b = {5,5,5,5,20,20,5,5,20,5};
        System.out.println(lemonadeChange(b));
    }
    public static boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        if (n == 0) return true;
        if (bills[0] != 5) return false;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10,0);
        for (int bill : bills) {
            if(bill == 5) {
                map.put(5, map.get(5) + 1);
            } else if(bill == 10) {
                if(map.get(5) == 0) {
                    return false;
                } else {
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) + 1);
                }
            } else if(bill == 20) {
                if(map.get(5) <= 0) {
                    return false;
                } else if(map.get(10) <= 0 && map.get(5) < 3){
                    return false;
                } else if(map.get(10) > 0){
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) - 1);
                } else {
                    map.put(5, map.get(5) - 3);
                }
            }
        }
        return true;
    }
}
