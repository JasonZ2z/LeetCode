package com.xinzhe.sword.chapter04;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/11/02
 * Title : 04.12. 求和路径
 * Description : 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 *              注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * link : https://leetcode-cn.com/problems/paths-with-sum-lcci
 * Level : Medium
 */
public class Interview_0412 {
    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        helper(root, sum, list);
        return ans;
    }

    private void helper(TreeNode root, int sum, ArrayList<Integer> list) {
        if(root == null) return;
        int tmp = root.val + list.get(list.size() - 1);
        for (Integer i : list) {
            if(tmp - i == sum) ans++;
        }
        ArrayList<Integer> newList = new ArrayList<>(list);
        newList.add(tmp);
        helper(root.left, sum, list);
        helper(root.right, sum, list);
    }


    public int pathSum2(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper2(root, sum, 0, map);
    }

    private int helper2(TreeNode root, int sum, int cur, Map<Integer, Integer> map) {
        if(root == null) return 0;
        cur += root.val;
        int ans = map.getOrDefault(cur - sum, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        ans += helper2(root.left, sum, cur, map);
        ans += helper2(root.left, sum, cur, map);
        map.put(cur, map.get(cur) - 1);
        return ans;
    }
}
