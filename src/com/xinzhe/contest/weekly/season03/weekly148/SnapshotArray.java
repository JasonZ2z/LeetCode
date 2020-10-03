package com.xinzhe.contest.weekly.season03.weekly148;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Xin
 * @date 2020/10/3
 * Title : 1146. 快照数组
 * Description : 实现支持下列接口的「快照数组」- SnapshotArray：
 *          SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
 *          void set(index, val) - 会将指定索引 index 处的元素设置为 val。
 *          int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
 *          int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
 * link : https://leetcode-cn.com/problems/snapshot-array
 * Level : Medium
 */

public class SnapshotArray {
    public static void main(String[] args) {
        SnapshotArray lc = new SnapshotArray(10);
    }

    List<TreeMap<Integer, Integer>> list = new ArrayList<>();
    int snap = 0;
    public SnapshotArray(int length) {
        for (int i = 0; i < length; i++) {
            list.add(new TreeMap<>());
        }
    }

    public void set(int index, int val) {
        TreeMap<Integer, Integer> map = list.get(index);
        map.put(snap, val);
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> map = list.get(index);
        Integer key = map.floorKey(snap_id);
        return key != null ? map.get(key) : 0;
    }
}
