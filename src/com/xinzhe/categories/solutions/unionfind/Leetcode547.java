package com.xinzhe.categories.solutions.unionfind;

/**
 * @author Xin
 * @date 2020/4/16
 * Title : 547. 朋友圈
 * Description : 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。
 *              所谓的朋友圈，是指所有朋友的集合。给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
 *              你必须输出所有学生中的已知的朋友圈总数。
 * link : https://leetcode-cn.com/problems/friend-circles
 * Level : Medium
 */

public class Leetcode547 {

    //dfs
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; ++i) {
            if(visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m, int[] visited, int i) {
        for (int j = 0; j < m.length; ++j) {
            if(m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(m, visited, j);
            }
        }
    }

    class UF{
        int[] parent;
        int[] rank;
        public UF(int size){
            this.parent = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; ++i) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int p){
            while(parent[p] != p){
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q){
            int fp = find(p);
            int fq = find(q);
            if(fp == fq) return;
            if(rank[fp] > rank[fq]){
                parent[fq] = fp;
            } else if(rank[fp] < rank[fq]){
                parent[fp] = fq;
            } else {
                parent[fp] = fq;
                rank[fq] += 1;
            }
        }
    }
    public int findCircleNum2(int[][] M) {
        UF uf = new UF(M.length);
        for (int i = 0; i < M.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if(M[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        int[] parent = uf.parent;
        int count = 0;
        for (int i = 0; i < M.length; ++i) {
            if(parent[i] == i){
                count++;
            }
        }
        return count;
    }
}
