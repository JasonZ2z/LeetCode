package com.xinzhe.contest.spring2020;

/**
 * @Author Xin
 * @create 2020/4/18 14:55
 * Title : LCP 07. 传递信息
 * Description : 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 *      有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 *      每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 *      每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 *      给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * link : https://leetcode-cn.com/problems/chuan-di-xin-xi
 * Level : Easy
 * Comment : 2020春季个人赛02
 */
public class Leetcode_single_041802 {
    static int count = 0;
    public static int numWays(int n, int[][] relation, int k) {
        bfs(relation, k, 0, n-1);
        return count;
    }

    private static void bfs(int[][] relation, int k, int end, int target) {
        if(k == 0 && end == target){
            count++;
            return;
        }
        if(k <= 0) return;
        for (int[] ints : relation) {
            if (ints[0] == end) {
                bfs(relation, k - 1, ints[1], target);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0,2}, {2,1}, {3,4}, {2,3}, {1,4}, {2,0}, {0,4}};
        System.out.println(numWays(5, arr, 3));
    }
}
