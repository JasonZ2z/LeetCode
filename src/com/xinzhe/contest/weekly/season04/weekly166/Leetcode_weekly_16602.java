package com.xinzhe.contest.weekly.season04.weekly166;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/6/08
 * Title : 1282. 用户分组
 * Description : 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
 * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 * link : https://leetcode-cn.com/problems/group-the-people-given-the-group-size-they-belong-to
 * Level : Medium
 * Comment 166周赛02
 */

public class Leetcode_weekly_16602 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            map.computeIfAbsent(groupSizes[i], a -> new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> value = entry.getValue();
            if (value.size() == key) {
                res.add(value);
            } else {
                for (int i = 0; i < value.size() / key; ++i) {
                    List<Integer> tmp = new ArrayList<>();
                    for (int j = 0; j < key; j++) {
                        tmp.add(value.get(j + i * key));
                    }
                    res.add(tmp);
                }
            }
        }
        return res;
    }
}
