package com.xinzhe.categories.structure.design.hard;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/6/16
 * Title : 297. 二叉树的序列化与反序列化
 * Description : 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *              请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * link : https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * Level : Hard
 */

public class Codec {
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(2);
        node.right.right = new TreeNode(4);
        node.right.left.left = new TreeNode(3);
        node.right.left.right = new TreeNode(1);
        String serialize = codec.serialize(node);
        System.out.println(serialize);
        TreeNode root = codec.deserialize(serialize);
        codec.traversal(root);
        System.out.println(codec.list.toString());

    }
    public void traversal(TreeNode root){
        if(root == null) return;
        list.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }


    //dfs
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        List<String> list = new ArrayList<>();
        level(list, root);
        StringBuilder sb = new StringBuilder();
        String s = list.toString();
        sb.append(s, 1, s.length()-1);
        return sb.toString();
    }

    private void level(List<String> list, TreeNode root) {
        if(root == null) {
            list.add("n");

        } else {
            list.add(String.valueOf(root.val));
            level(list, root.left);
            level(list, root.right);
        }
    }

     //Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        LinkedList<String> res = new LinkedList<>();
        for (String s : arr) {
            res.add(s.trim());
        }
        return helper(res);
    }

    private TreeNode helper(LinkedList<String> res) {
        if(res.size() == 0) return null;
        if("n".equals(res.getFirst())) {
            res.removeFirst();
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(res.getFirst()));
        res.removeFirst();
        node.left = helper(res);
        node.right = helper(res);
        return node;
    }

    //bfs


}
