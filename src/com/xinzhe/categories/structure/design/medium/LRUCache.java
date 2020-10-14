package com.xinzhe.categories.structure.design.medium;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/5/12
 * Title : 146. LRU缓存机制
 * Description : 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *              获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 *              写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * link : https://leetcode-cn.com/problems/lru-cache
 * Level : Medium
 */
//todo need to review
public class LRUCache {
    Map<Integer, Node> cache = new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
            if(cache.size() > capacity) {
                Node cur = removeTail();
                cache.remove(cur.key);
            }
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        Node front = node.pre;
        Node after = node.next;
        front.next = after;
        after.pre = front;
    }

    private Node removeTail() {
        Node cur = tail.pre;
        removeNode(cur);
        return cur;
    }

    private void addToHead(Node node) {
        Node tmp = head.next;
        node.next = tmp;
        tmp.pre = node;
        head.next = node;
        node.pre = head;
    }

    class Node {
        int key;
        int val;
        Node next;
        Node pre;

        public Node() { }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        System.out.println(c.get(1));
        c.put(3, 3);
        System.out.println(c.get(2));
        c.put(4, 4);
        System.out.println(c.get(1));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
    }
}
