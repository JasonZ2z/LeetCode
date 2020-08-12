package com.xinzhe.categories.structure.design.easy;

/**
 * @author Xin
 * @date 2020/5/12
 * Title : 705. 设计哈希集合
 * Description : 不使用任何内建的哈希表库设计一个哈希集合
 *              add(value)：向哈希集合中插入一个值。
 *              contains(value) ：返回哈希集合中是否存在这个值。
 *              remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * link : https://leetcode-cn.com/problems/design-hashset
 * Level : Easy
 */

public class MyHashSet2 {
    private Bucket[] buckets;
    private int range;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet2() {
        this.range = 769;
        this.buckets = new Bucket[this.range];
        for (int i = 0; i < range; ++i) {
            buckets[i] = new Bucket();
        }
    }

    protected int hash(int key) {
        return key % range;
    }

    public void add(int key) {
        int index = hash(key);
        buckets[index].insert(key);
    }

    public void remove(int key) {
        int index = hash(key);
        buckets[index].delete(key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].exists(key);
    }

    class Bucket {
        private BSTree tree;
        public Bucket() {
            tree = new BSTree();
        }

        public void insert(Integer key) {
            tree.root = tree.insertIntoBSTree(tree.root, key);
        }
        public void delete(Integer key) {
            tree.root = tree.deleteNode(tree.root, key);

        }
        public boolean exists(Integer key) {
            TreeNode node = tree.searchBSTree(tree.root, key);
            return node != null;
        }
    }

    class BSTree {
        TreeNode root = null;

        public TreeNode searchBSTree(TreeNode root, int val) {
            if(root == null || root.val == val) return  root;
            return root.val > val ?  searchBSTree(root.left, val) : searchBSTree(root.right, val);
        }

        public TreeNode insertIntoBSTree(TreeNode root, int val) {
            if(root == null) return new TreeNode(val);
            if(root.val > val) {
                root.left = insertIntoBSTree(root.left, val);
            } else if(root.val < val){
                root.right = insertIntoBSTree(root.right, val);
            }
            return root;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null) return null;
            if(root.val == key) {
                if(root.left == null && root.right == null) {
                    return null;
                } else if(root.right == null){
                    return root.left;
                } else if(root.left == null) {
                    return root.right;
                } else {
                    TreeNode node = root.right;
                    while(node.left!= null) {
                        node = node.left;
                    }
                    node.left = root.left;
                    return root.right;
                }
            } else if(root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }
            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
