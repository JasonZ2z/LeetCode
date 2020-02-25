package com.xinzhe.categories.tree.easy;

import com.xinzhe.categories.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsSubTree {


    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(2);
        node1.right = node2;
        System.out.println(Arrays.toString(findMode(node1)));

    }
    public static int[] findMode(TreeNode root) {
        helper(root);
        List<Integer> res = new ArrayList<>();
        if(list == null || list.size() == 0) return new int[]{};

        int max = 1;
        int pre = list.get(0);
        int count =1;
        res.add(pre);
        for(int i=1; i<list.size(); i++){
            if(list.get(i) == pre){
                count++;
            }else{
                pre = list.get(i);
                if(count > max){
                    max =count;
                    res.clear();
                    res.add(list.get(i));
                } else if(count == max){
                    res.add(list.get(i));
                }
                count = 1;
            }
        }
        int[] result = new int[res.size()];
        for(int i=0; i< res.size(); i++){
            result[i] = res.get(i);
        }

        return result;
    }
    public static void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}
