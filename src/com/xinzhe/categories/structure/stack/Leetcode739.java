package com.xinzhe.categories.structure.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/6/11
 * Title : 739. Daily Temperatures
 * Description : 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * link : https://leetcode-cn.com/problems/daily-temperatures
 * Level : Medium
 */
public class Leetcode739 {
    public static void main(String[] args) {
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(t)));
    }

    public static int[] dailyTemperatures(int[] t) {
        int n = t.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[n];
        for (int i = 0; i < t.length; i++) {
            while (!stack.isEmpty() && t[i] > t[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
