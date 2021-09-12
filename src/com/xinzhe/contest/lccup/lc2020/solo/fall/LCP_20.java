package com.xinzhe.contest.lccup.lc2020.solo.fall;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/9/12
 * Title : LCP 20. 快速公交
 * Description : 小扣打算去秋日市集，由于游客较多，小扣的移动速度受到了人流影响：
 *              小扣从 x 号站点移动至 x + 1 号站点需要花费的时间为 inc；小扣从 x 号站点移动至 x - 1 号站点需要花费的时间为 dec。
 *              现有 m 辆公交车，编号为 0 到 m-1。小扣也可以通过搭乘编号为 i 的公交车，从 x 号站点移动至 jump[i]*x 号站点，耗时仅为 cost[i]。小扣可以搭乘任意编号的公交车且搭乘公交次数不限。
 *              假定小扣起始站点记作 0，秋日市集站点记作 target，请返回小扣抵达秋日市集最少需要花费多少时间。由于数字较大，最终答案需要对 1000000007 (1e9 + 7) 取模。注意：小扣可在移动过程中到达编号大于 target 的站点。
 * link : https://leetcode-cn.com/problems/meChtZ
 * Level : Hard
 */

//todo need to review
public class LCP_20 {
    final int MOD = (int) 1e9 + 7;
    Map<Long, Long> map = new HashMap<>();
    int[] jump, cost;
    int inc, dec;
    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        this.cost = cost; this.jump = jump;
        this.inc = inc; this.dec = dec;
        return (int)(dfs(target) % MOD);
    }
    private long dfs(long n) {
        if(n == 0) return 0;
        if(n == 1) return inc;
        if(map.containsKey(n)) return map.get(n);
        long ans = n * inc;
        for(int i=0; i<jump.length; i++) {
            long reminder = n % jump[i];
            if(reminder == 0) {
                ans = Math.min(ans, dfs(n/jump[i]) + cost[i]);
            } else {
                ans = Math.min(ans, dfs(n / jump[i]) + cost[i] + reminder * inc);
                ans = Math.min(ans, dfs(n / jump[i] + 1) + cost[i] + (jump[i] - reminder) * dec);
            }
        }
        map.put(n, ans);
        return ans;
    }


    public int busRapidTransit2(int target, int inc, int dec, int[] jump, int[] cost) {
        int n = jump.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int) ((o1.cost - o2.cost) % MOD));
        pq.offer(new Node(0, target));
        HashSet<Integer> visit = new HashSet<>();
        long res = (long)target * inc;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visit.contains(cur.pos)) continue;
            visit.add(cur.pos);
            res = Math.min(res, cur.cost + (long)cur.pos * inc);
            if (cur.pos == 1) {
                break;
            }
            pq.offer(new Node(cur.cost + (long)(cur.pos - 1) * inc, 1));
            for (int i = 0; i < n; i++) {
                long remainder = cur.pos % jump[i];
                int prev = cur.pos / jump[i];
                if (remainder == 0) {
                    pq.offer(new Node(cur.cost + cost[i], prev));
                } else {
                    pq.offer(new Node(cur.cost + cost[i] + remainder * inc, prev));
                    pq.offer(new Node(cur.cost + cost[i] + (jump[i] - remainder) * dec, prev + 1));
                }
            }
        }
        return (int)(res % MOD);
    }
    class Node {
        long cost;
        int pos;

        public Node (long cost, int pos) {
            this.cost = cost;
            this.pos = pos;
        }
    }
}
