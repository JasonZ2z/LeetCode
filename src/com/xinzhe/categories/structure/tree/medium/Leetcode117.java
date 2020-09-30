package com.xinzhe.categories.structure.tree.medium;

/**
 * @author Xin
 * @date 2020/9/28
 * Title : 117. 填充每个节点的下一个右侧节点指针 II
 * Description : 给定一个二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点.
 *              填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *              你只能使用常量级额外空间。 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * link : https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * Level : Medium
 */

//todo need to review
public class Leetcode117 {
    public Node connect(Node root) {
        if(root == null) return root;
        if(root.left != null) {
            root.left.next = root.right != null ? root.right : getNext(root.next);
        }
        if(root.right != null) {
            root.right.next = getNext(root.next);
        }
        // 一定得是先右后左
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNext(Node root) {
        if(root == null) return null;
        if(root.left != null) return root.left;
        if(root.right != null) return root.right;
        if(root.next != null) return getNext(root.next);
        return null;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
