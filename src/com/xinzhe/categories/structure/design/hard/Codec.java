package com.xinzhe.categories.structure.design.hard;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Xin
 * @date 2020/6/16
 * Title : 297. 二叉树的序列化与反序列化
 * Description : 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *              请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * link : https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * Level : Hard
 */
//todo need to review
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur == null) {
                sb.append("n").append(",");
            }else {
                sb.append(cur.val).append(",");
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        Collections.addAll(list, arr);
        return buildTree(list);
    }

    private TreeNode buildTree(LinkedList<String> list) {
        if(list.size() == 0) return null;
        String first = list.removeFirst();
        if("n".equals(first)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = buildTree(list);
        root.right = buildTree(list);
        return root;
    }
}
