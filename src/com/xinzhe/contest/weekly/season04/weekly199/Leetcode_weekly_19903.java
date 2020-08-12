package com.xinzhe.contest.weekly.season04.weekly199;

import com.xinzhe.categories.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/7/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_19903 {
    public static void main(String[] args) {
        Leetcode_weekly_19903 lc = new Leetcode_weekly_19903();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(lc.countPairs(root, 3));
    }
    List<TreeNode> nodes = new ArrayList<>();
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    public int countPairs(TreeNode root, int distance) {
        if((root.left == null && root.right == null ) || distance == 1) return 0;
        int count = 0;

        dfs(root, new TreeNode(-1));
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i+1; j < nodes.size(); j++) {
                if(ok(nodes.get(i), nodes.get(j), distance)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean ok(TreeNode n1, TreeNode n2, int distance) {
        int tmp = getSameFather(n1, n2);
        return tmp <= distance;
    }

    private int getSameFather(TreeNode n1, TreeNode n2) {
        List<TreeNode> nodes1 = map.get(n1);
        List<TreeNode> nodes2 = map.get(n2);
        for (int i = nodes2.size() - 1; i >= 0; i--) {
            if(nodes1.contains(nodes2.get(i))) {
                int j = nodes1.indexOf(nodes2.get(i));
                return nodes2.size() - i + nodes1.size() - j;
            }
        }
        return 0;
    }

    private void dfs(TreeNode root, TreeNode father) {
        if(root == null) return;
        List<TreeNode> fathers = map.computeIfAbsent(root, a ->new ArrayList<>());
        fathers.addAll(map.getOrDefault(father, new ArrayList<>()));
        if(!fathers.contains(father)) {
            fathers.add(father);
        }
        if(root.left == null && root.right == null){
            nodes.add(root);
            return;
        }
        dfs(root.left, root);
        dfs(root.right, root);

    }

    private int distance = 0;

    private int res = 0;

    public int countPairs2(TreeNode root, int distance) {
        this.distance = distance;
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode node){
        if(node == null){
            return new int[distance + 1];
        }
        int[] dis = new int[distance + 1];
        if(node.left == null && node.right == null){
            dis[1] = 1;
            return dis;
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        for(int i = 1; i < distance; i++){
            for(int j = 1; j <= distance - i; j++){
                res += left[i] * right[j];
            }
        }
        for(int i = 2; i <= distance; i++){
            dis[i] = left[i - 1] + right[i - 1];
        }
        return dis;
    }


    private int count = 0;

    public int countPairs3(TreeNode root, int distance) {
        count = 0;
        countPairs(new ArrayList<>(), root, 0, distance);
        return count;
    }

    private void countPairs(ArrayList<Integer> list, TreeNode root, int depth, int distance) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            list.add(depth);
        } else {
            ArrayList<Integer> left = new ArrayList<>(), right = new ArrayList<>();
            countPairs(left, root.left, depth + 1, distance);
            countPairs(right, root.right, depth + 1, distance);
            list.addAll(left);
            list.addAll(right);
            for (int i : left) {
                for (int j : right) {
                    if (i + j - 2 * depth <= distance) {
                        count++;
                    }
                }
            }
        }
    }
}
