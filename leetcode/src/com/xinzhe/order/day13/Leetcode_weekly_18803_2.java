package com.xinzhe.order.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/10
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_18803_2 {
    //dfs
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].hasApple = hasApple.get(i);
        }
        for (int[] e : edges) {
            Node a = nodes[e[0]];
            Node b = nodes[e[1]];
            a.next.add(b);
            b.next.add(a);
        }

        dfs(nodes[0], null);
        int ans = count(nodes[0], null);
        return ans;
    }

    public void dfs(Node root, Node p) {
        for (Node node : root.next) {
            if (node == p) {
                continue;
            }
            dfs(node, root);
            root.hasApple = root.hasApple || node.hasApple;
        }
    }

    public int count(Node root, Node p) {
        int ans = 0;
        if (root.hasApple && p != null) {
            ans += 2;
        }
        for (Node node : root.next) {
            if (node == p) {
                continue;
            }
            ans += count(node, root);
        }

        return ans;
    }
    class Node {
        List<Node> next = new ArrayList<>();
        boolean hasApple;
    }
}


