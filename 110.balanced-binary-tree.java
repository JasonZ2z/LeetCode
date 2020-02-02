/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 *
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (42.06%)
 * Likes:    1570
 * Dislikes: 141
 * Total Accepted:    373.2K
 * Total Submissions: 887.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * 
 * a binary tree in which the left and right subtrees of every node differ in
 * height by no more than 1.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Given the following tree [3,9,20,null,null,15,7]:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * Return true.
 * 
 * Example 2:
 * 
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * 
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   2
 * ⁠   / \
 * ⁠  3   3
 * ⁠ / \
 * ⁠4   4
 * 
 * 
 * Return false.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private class ReturnNode{
        boolean isB;
        int depth;
        public ReturnNode(boolean isB, int depth){
          this.isB = isB;
          this.depth = depth;
        }
      }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return isFun(root).isB;
    }

    public ReturnNode isFun(TreeNode root){
        if(root == null) return new ReturnNode(true, 0);
        ReturnNode left = isFun(root.left);
        ReturnNode right = isFun(root.right);

        if(!left.isB || !right.isB){
            return new ReturnNode(false, 0);
        }

        if(Math.abs(left.depth - right.depth) > 1){
            return new ReturnNode(false, 0);
        }
        return new ReturnNode(true, Math.max(left.depth , right.depth)+1);
    }
}


  
// @lc code=end

