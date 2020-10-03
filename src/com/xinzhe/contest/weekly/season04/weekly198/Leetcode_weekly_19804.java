package com.xinzhe.contest.weekly.season04.weekly198;

import java.util.ArrayList;

/**
 * @author Xin
 * @date 2020/7/19
 * Title : 1521. 找到最接近目标值的函数值
 * Description : Winston 构造了一个如上所示的函数 func 。他有一个整数数组 arr 和一个整数 target ，他想找到让 |func(arr, l, r) - target| 最小的 l 和 r 。
 *              请你返回 |func(arr, l, r) - target| 的最小值。请注意， func 的输入参数 l 和 r 需要满足 0 <= l, r < arr.length 。
 * link : https://leetcode-cn.com/problems/find-a-value-of-a-mysterious-function-closest-to-target
 * Level : Hard
 * comment : should not care about that
 */

//todo undo
public class Leetcode_weekly_19804 {
    public static void main(String[] args) {
        Leetcode_weekly_19804 lc = new Leetcode_weekly_19804();
    }

    public int closestToTarget(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (list.isEmpty() || i != list.get(list.size() - 1)) {
                list.add(i);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            for (int j = i; j < list.size(); j++) {
                x &= list.get(j);
                ans = Math.min(ans, Math.abs(target - x));
                if (x <= target)
                    break;
            }
        }
        return ans;
    }
}
