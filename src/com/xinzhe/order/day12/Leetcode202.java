package com.xinzhe.order.day12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/4/30
 * Title : 202. 快乐数
 * Description : 编写一个算法来判断一个数 n 是不是快乐数。
 *      「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *      如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * link : https://leetcode-cn.com/problems/happy-number
 * Level : Easy
 */

public class Leetcode202 {
    public static void main(String[] args) {
        System.out.println(isHappy(11));
    }
    //常规思路
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(true) {
            int res = 0;
            while(n != 0){

                int tmp = n% 10;
                res += tmp*tmp;
                n /= 10;
            }
            if(res == 1) return true;
            if(set.contains(res)){
                return false;
            } else {
                set.add(res);
            }
            n = res;
        }
    }

    //快慢指针
    public boolean isHappy2(int n) {
        int fast = helper(n);
        int slow = n;
        while(fast != slow) {
            fast = helper(helper(fast));
            slow = helper(slow);
        }
        return slow == 1;
    }

    public int helper(int n) {
        int res = 0;
        while(n != 0){

            int tmp = n% 10;
            res += tmp*tmp;
            n /= 10;
        }
        return res;
    }
}
