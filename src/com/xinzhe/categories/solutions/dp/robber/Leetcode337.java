package com.xinzhe.categories.solutions.dp.robber;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/3/13 18:43
 * Title : 337. 打家劫舍 III
 * Description :  除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 *                如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * link : https://leetcode-cn.com/problems/house-robber-iii
 * Level : Medium
 */
//todo need to review
public class Leetcode337 {

    public int rob3(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode root) {
        if(root == null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    //root + 4 * grandson vs 2 * child
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int sum1 = root.val;
        int sum2 = 0;
        if(root.left != null){
            sum1 += rob(root.left.left) + rob(root.left.right);
            sum2 += rob(root.left);
        }
        if(root.right != null){
            sum1 += rob(root.right.left) + rob(root.right.right);
            sum2 += rob(root.right);
        }
        return Math.max(sum1, sum2);
    }


    //以下为错误思想：
    //层序遍历 -> 每层和的list -> 仿照1的dp
    private List<Integer> list = new ArrayList<>();
    public int rob2(TreeNode root) {
        if(root == null) return  0;
        if(root.left == null && root.right== null) return  root.val;
         levelOrder(root, 0);
         int n = list.size();
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = list.get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + list.get(i);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);

    }

    private void levelOrder(TreeNode root, int level) {
        if(root == null) return;
        if(list.size() <= level){
            list.add(0);
        }
        list.set(level, list.get(level) + root.val);
        levelOrder(root.left, level+1);
        levelOrder(root.right, level+1);
    }
}
