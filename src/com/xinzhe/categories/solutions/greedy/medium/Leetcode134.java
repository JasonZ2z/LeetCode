package com.xinzhe.categories.solutions.greedy.medium;

/**
 * @author Xin
 * @date 2020/5/25
 * Title : 134. 加油站
 * Description : 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *              如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。 如果题目有解，该答案即为唯一答案。输入数组均为非空数组，且长度相同。 输入数组中的元素均为非负数。
 * link : https://leetcode-cn.com/problems/gas-station
 * Level : Medium
 */

//todo need to review
public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int gasSum = 0, min = Integer.MAX_VALUE, mi = 0;
        for (int i = 0; i < n; ++i) {
            gasSum = gasSum + gas[i] - cost[i];
            if(gasSum < min) {
                min = gasSum;
                mi = i;
            }
        }
        if(gasSum < 0) return -1;
        return (mi +1) % n;
    }


    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0, cur = 0, start = 0;
        for (int i = 0; i < n; ++i) {
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            if(cur < 0) {
                cur = 0;
                start = i + 1;
            }
        }
        return total < 0 ? -1 : start;
    }
}
