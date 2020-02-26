package com.xinzhe.categories.tree.traverse;

import com.xinzhe.categories.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/2/19 9:34
 */
public class LevelOrder {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrderRecur(TreeNode root){
        order(root, 0);
        return result;
    }
    public void order(TreeNode root, int level){
        if(root == null) return;
        if(result.size() <= level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        order(root.left,level+1);
        order(root.right,level+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.offer(cur);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                cur = queue.pop();
                list.add(cur.val);
                TreeNode left = cur.left;
                if(left != null){
                    queue.offer(left);
                }
                TreeNode right = cur.right;
                if(right != null){
                    queue.offer(right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
