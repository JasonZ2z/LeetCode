package com.xinzhe.contest.weekly.season03.weekly146;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/9/28
 * Title : 1130. 叶值的最小代价生成树
 * Description : 给你一个正整数数组 arr，考虑所有满足以下条件的二叉树：
 *              每个节点都有 0 个或是 2 个子节点。
 *              数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。（知识回顾：如果一个节点有 0 个子节点，那么该节点为叶节点。）
 *              每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
 *              在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。
 * link : https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values
 * Level : Easy
 */

public class Leetcode_weekly_14603 {
    public static void main(String[] args) {
        int[] arr = {6,2,4,3,5};
        Leetcode_weekly_14603 lc = new Leetcode_weekly_14603();
        System.out.println(lc.mctFromLeafValues2(arr));
    }
    Integer[][] dp;
    int[] arr;
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        this.arr = arr;
        this.dp = new Integer[n][n];
        solve(0, n-1);
        return dp[0][n - 1];
    }

    private int solve(int i, int j) {
        if(j <= i) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int lm = 0, ans = Integer.MAX_VALUE;
        for (int k = i; k < j; ++k) {
            lm = Math.max(lm, arr[k]);
            int rm = getMax(k+1, j);
            ans = Math.min(ans, lm * rm + solve(i, k) + solve(k+1, j));
        }
        dp[i][j] = ans;
        return ans;
    }

    private int getMax(int i, int j) {
        int rm = 0;
        for (int k = i; k <=j ; ++k) {
            rm = Math.max(arr[k], rm);
        }
        return rm;
    }

    //todo need to review
    public int mctFromLeafValues2(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(Integer.MAX_VALUE);
        int mct = 0;
        for (int value : arr) {
            while (value >= st.peek()) {
                mct += st.pop() * Math.min(st.peek(), value);
            }
            st.push(value);
        }
        while (st.size() > 2) {
            mct += st.pop() * st.peek();
        }
        return mct;
    }
}
