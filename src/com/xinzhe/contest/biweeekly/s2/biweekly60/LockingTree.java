package com.xinzhe.contest.biweeekly.s2.biweekly60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/09/04
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class LockingTree {
    public static void main(String[] args) {
        int[] p = {-1,0,8,0,7,4,2,3,3,1};
        LockingTree lc = new LockingTree(p);
        System.out.println(lc.lock(5, 22));
        System.out.println(lc.upgrade(1, 3));
        System.out.println(lc.lock(5, 20));
        System.out.println(lc.upgrade(0, 38));
        System.out.println(lc.lock(5, 14));
        System.out.println(lc.lock(6, 34));
        System.out.println(lc.lock(6, 28));
        System.out.println(lc.upgrade(3, 23));

    }
    Node[] tree;
    Map<Integer, List<Integer>> map = new HashMap<>();
    public LockingTree(int[] parent) {
        int n = parent.length;
        tree = new Node[n];
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(parent[i], a -> new ArrayList<>()).add(i);
            tree[i] = new Node(parent[i], 0);

        }
    }

    public boolean lock(int num, int user) {
        if(tree[num].user == 0) {
            tree[num].user = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if(tree[num].user == user) {
            tree[num].user = 0;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if(tree[num].user != 0) return false;

        int x = num;
        while (tree[x].father != -1) {
            if(tree[x].user != 0) return false;
            x = tree[x].father;
        }
        if(tree[x].father == -1 && tree[x].user != 0) return false;
        boolean f1 = false;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(num);
        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            for (Integer j : map.getOrDefault(i, new ArrayList<>())) {
                if(tree[j].user != 0) {
                    f1 = true;
                    tree[j].user = 0;
                }
                queue.offer(j);
            }
        }
        if(!f1) return false;
        tree[num].user = user;
        return true;
    }

    class Node {
        int father;
        int user;

        public Node(int father, int user) {
            this.father = father;
            this.user = user;
        }
    }
}