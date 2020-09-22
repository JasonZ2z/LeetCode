package com.xinzhe.categories.structure.tree.hard;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 968. 监控二叉树
 * Description : 给定一个二叉树，我们在树的节点上安装摄像头。节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。计算监控树的所有节点所需的最小摄像头数量。
 * link : https://leetcode-cn.com/problems/binary-tree-cameras/
 * Level : Hard
 */
//todo need to review
public class Leetcode968 {
    int max = 0;
    //0-当前节点和子节点没有相机；
    //1-当前节点有相机子节点没有相机；
    //2-当前节点没有相机子节点有相机。
    //底层节点要返回 0，以此往上一层就要返回 1，再往上一层就要返回 2，循环。
    public int minCameraCover(TreeNode root){
        return postOrder(root) == 0 ?  max +  1 : max;

    }
    public int postOrder(TreeNode root) {
        if(root == null) return 2;
        int left = postOrder(root.left);
        int right = postOrder(root.right);

        if(left == 2 && right == 2) return 0;
        if(left == 0 || right == 0) {
            max++;
            return 1;
        }
        if(left == 1 || right == 1) return 2;
        return 0;
    }
}
