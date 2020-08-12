package com.xinzhe.categories.structure.tree.traverse;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/8/10
 * Title : 987. 二叉树的垂序遍历
 * Description : 给定二叉树，按垂序遍历返回其结点值。对位于 (X, Y) 的每个结点而言，其左右子结点分别位于 (X-1, Y-1) 和 (X+1, Y-1)。
 *              把一条垂线从 X = -infinity 移动到 X = +infinity ，每当该垂线与结点接触时，我们按从上到下的顺序报告结点的值（ Y 坐标递减）。
 *              如果两个结点位置相同，则首先报告的结点值较小。按 X 坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。
 * link : https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree
 * Level : Medium
 */

public class VerticalOrder {
    Map<Integer, List<Node>> map = new HashMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, 0);
        List<Integer> list = map.keySet().stream().sorted(Integer::compareTo).collect(Collectors.toList());
        for (int i = list.get(0); i <= list.get(list.size() - 1); ++i) {
            if(map.containsKey(i)) {
                res.add(map.get(i).stream().sorted((a, b) -> a.y == b.y ? a.val - b.val : b.y - a.y).map(a -> a.val).collect(Collectors.toList()));
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int x, int y) {
        if(root == null) return;
        map.computeIfAbsent(x, a-> new ArrayList<>()).add(new Node(root.val, x, y));
        dfs(root.left, x-1, y-1);
        dfs(root.right, x+1, y-1);
    }

    static class Node {
        int val;
        int x;
        int y;

        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
}
