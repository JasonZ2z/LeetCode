package com.xinzhe.contest.weekly.season04.weekly190;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/5/24
 * Title : 1457. 二叉树中的伪回文路径
 * Description : 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 *              请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 * link : https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree
 * Level : Medium
 * Comment 190周赛03
 */
public class Leetcode_weekly_19003 {
    List<List<Integer>> all = new ArrayList<>();

    public int pseudoPalindromicPaths(TreeNode root) {
        helper(root, new ArrayList<>());
        for (List<Integer> tmp : all) {
            System.out.println(tmp);
        }
        int count = 0;
        for (List<Integer> list : all) {
            if (ok(list)) {
                count++;
            }
        }
        return count;
    }

    private boolean ok(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : list) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for (Integer j : map.values()) {
            if (j % 2 == 1) {
                count++;
            }
        }
        return count <= 1;
    }

    public void helper(TreeNode root, ArrayList<Integer> track) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ArrayList<Integer> tmp = new ArrayList<>(track);
            tmp.add(root.val);
            all.add(tmp);
        }
        track.add(root.val);
        helper(root.left, track);
        helper(root.right, track);
        track.remove(track.size() - 1);
    }

    //solution 2
    public int pseudoPalindromicPaths2 (TreeNode root) {
        return dfs(root, new int[10]);
    }

    private int dfs(TreeNode root, int[] arr) {
        if(root == null) return 0;
        arr[root.val]++;
        int res = dfs(root.left, arr) + dfs(root.right, arr);
        if(root.left == null && root.right == null && helper(arr)) res ++;
        arr[root.val] -= 1;
        return res;
    }

    private boolean helper(int[] arr) {
        int count = 0;
        for(int a : arr) {
            if(a % 2 == 1) {
                count++;
            }
        }
        return count < 2;
    }

    //solution 3
    public int pseudoPalindromicPaths3 (TreeNode root) {
        return dfs3(root, 0);
    }
    private int dfs3(TreeNode root, int count) {
        if (root == null) return 0;
        count ^= 1 << (root.val - 1); //异或 相同为0 不同为1
        int res = dfs3(root.left, count) + dfs3(root.right, count);
        if (root.left == root.right && (count & (count - 1)) == 0) res++; //消除最右边的1，判断是否为0
        return res;
    }

}
