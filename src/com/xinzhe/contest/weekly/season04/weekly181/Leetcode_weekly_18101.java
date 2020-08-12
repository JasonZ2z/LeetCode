package com.xinzhe.contest.weekly.season04.weekly181;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/5
 * Title : 1389. 按既定顺序创建目标数组
 * Description : 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
 *          目标数组 target 最初为空。
 *          按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
 *          重复上一步，直到在 nums 和 index 中都没有要读取的元素。
 *          请你返回目标数组。
 *          题目保证数字插入位置总是存在。
 * link : https://leetcode-cn.com/problems/create-target-array-in-the-given-order
 * Level : Easy
 * Comment : 181周赛01
 */
public class Leetcode_weekly_18101 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] res = new int[n];
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            list.add(index[i], nums[i]);
        }
        for (int i = 0; i < n; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}
