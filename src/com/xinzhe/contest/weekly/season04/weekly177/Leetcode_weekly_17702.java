package com.xinzhe.contest.weekly.season04.weekly177;

/**
 * @author Xin
 * @date 2020/5/18
 * Title : 1361. 验证二叉树
 * Description : 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
 * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
 * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
 * 注意：节点没有值，本问题中仅仅使用节点编号。
 * link : https://leetcode-cn.com/problems/validate-binary-tree-nodes
 * Level : Medium
 * Comment 177周赛02
 */

public class Leetcode_weekly_17702 {
    public static void main(String[] args) {
        int[] left = {1, -1, 3, -1};
        int[] right = {2, -1, -1, -1};
        Leetcode_weekly_17702 lc = new Leetcode_weekly_17702();
        System.out.println(lc.validateBinaryTreeNodes(4, left, right));
    }

    int[] leftChild, rightChild;
    boolean[] visited;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] in = new int[n];
        for (int i = 0; i < n; ++i) {
            if (leftChild[i] >= 0) {
                in[leftChild[i]]++;
                if (in[leftChild[i]] > 1) return false;
            }
            if (rightChild[i] >= 0) {
                in[rightChild[i]]++;
                if (in[rightChild[i]] > 1) return false;
            }
        }
        int count = 0;
        int root = -1;
        for (int i = 0; i < n; ++i) {
            if (in[i] == 0) {
                root = i;
                count++;
            }
        }
        if (count != 1) return false;

        this.leftChild = leftChild;
        this.rightChild = rightChild;
        visited = new boolean[n];
        dfs(root);

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(int v) {
        if (v == -1) return;
        visited[v] = true;
        dfs(leftChild[v]);
        dfs(rightChild[v]);
    }
}
