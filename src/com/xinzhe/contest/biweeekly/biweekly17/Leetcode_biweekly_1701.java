package com.xinzhe.contest.biweeekly.biweekly17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/5/26
 * Title : 1313. 解压缩编码列表
 * Description : 给你一个以行程长度编码压缩的整数列表 nums 。
 * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
 * 请你返回解压后的列表。
 * link : https://leetcode-cn.com/problems/decompress-run-length-encoded-list
 * Level : Easy
 * Comment 17双周赛01
 */

public class Leetcode_biweekly_1701 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < nums[2 * i]; ++j) {
                list.add(nums[2 * i + 1]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
