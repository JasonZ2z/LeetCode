package com.xinzhe.contest.weekly.season03.weekly120;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/20/21
 * Title : 979. 在二叉树中分配硬币
 * Description : 给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
 *              在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
 *              返回使每个结点上只有一枚硬币所需的移动次数。
 * link : https://leetcode-cn.com/problems/distribute-coins-in-binary-tree
 * Level : Medium
 */
//todo need to review 需要理解思路
public class Leetcode_weekly_12003 {
    public static void main(String[] args) {
        Leetcode_weekly_12003 lc = new Leetcode_weekly_12003();
    }
    /**
     * 从后序遍历的第一个叶子节点开始，假设自己有x个金币，剩余x-1个金币都还给父节点，x-1可能为负数、0、正数
     * x-1 < 0说明不够金币，需要从父节点获得，因此子节点有|x-1|个入方向的操作，次数加上|x-1|
     * x-1 == 0说明刚好，无需与父节点有金币的交换，次数加0
     * x-1 > 0 说明有多余的金币，需要交给父节点，因此子节点有x-1个出方向的操作，次数加上|x-1|
     */
    private int ans = 0;// 移动次数
    public int distributeCoins(TreeNode root) {
        lrd(root);
        return ans;
    }
    public int lrd(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left != null){
            root.val += lrd(root.left);
        }
        if(root.right != null){
            root.val += lrd(root.right);
        }
        ans += Math.abs(root.val - 1);
        return root.val - 1;
    }
}
