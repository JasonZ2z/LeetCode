package com.xinzhe.order.day06;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/3/21 15:13
 * Title : 365. 水壶问题
 * Description : 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *              如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *          你允许：
 *              装满任意一个水壶
 *              清空任意一个水壶
 *              从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * link : https://leetcode-cn.com/problems/water-and-jug-problem/
 * Level : Medium
 */
public class Leetcode365 {

    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        Set<Integer> set = new HashSet<>();
        return helper(x,y,z,set);
    }

    private boolean helper(int x, int y, int z, Set<Integer> set) {
        if(set.contains(z)) return false;
        if(z == x || z == y || z ==Math.abs(x-y) || z== x+y) return true;
        set.add(z);
        return helper(x,y,Math.abs(x -z),set) || helper(x,y, Math.abs(y-z),set);
    }
}
