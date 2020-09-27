package com.xinzhe.contest.weekly.season03.weekly122;

import com.xinzhe.categories.structure.tree.TreeNode;

/**
 * @author Xin
 * @date 2020/9/25
 * Title : 
 * Description :
 * link :
 * Level : Easy
 */

public class Leetcode_weekly_12202 {
    public static void main(String[] args) {
        Leetcode_weekly_12202 lc = new Leetcode_weekly_12202();
        int[] arr = {2,-3,-1,5,-4};
    }

    int min = 26;
    String res = "";
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return "";
        helper(root, "");
        return res;
    }

    private void helper(TreeNode root, String s) {
        if(root == null) return;
        s = (char)(root.val + 'a') + s;
        if(root.left == null && root.right == null) {
            if(root.val == min) {
                boolean flag = true;
                int i = 0;
                for(; i < Math.min(res.length(), s.length()); i++) {
                    if(res.charAt(i) > s.charAt(i)) {
                        res = s;
                        flag = false;
                        break;
                    } else if(res.charAt(i) < s.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    if(res.length() > i && s.length() == i) {
                        res = s;
                    }
                }
            } else if(root.val < min){
                min = root.val;
                res = s;
            }
            return;
        }
        helper(root.right, s);
        helper(root.left, s);
    }
}
