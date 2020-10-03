package com.xinzhe.categories.structure.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/9/15
 * Title : 857. 雇佣 K 名工人的最低成本
 * Description : 有 N 名工人。 第 i 名工人的工作质量为 quality[i] ，其最低期望工资为 wage[i] 。
 *              现在我们想雇佣 K 名工人组成一个工资组。在雇佣 一组 K 名工人时，我们必须按照下述规则向他们支付工资：
 *              对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
 *              工资组中的每名工人至少应当得到他们的最低期望工资。返回组成一个满足上述条件的工资组至少需要多少钱。
 * link : https://leetcode-cn.com/problems/minimum-cost-to-hire-k-workers
 * Level : Hard
 */
//todo need to review
public class Leetcode857 {
    public static void main(String[] args) {
        Leetcode857 lc = new Leetcode857();
        int[] q = {3,1,10,10,1};
        int[] w = {4,8,2,2,7};
        System.out.println(lc.mincostToHireWorkers(q, w, 3));
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Node[] arr = new Node[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = new Node(quality[i], (double) wage[i]/quality[i]);
        }
        double ans = 1e9;
        int sum = 0;
        Arrays.sort(arr, Comparator.comparingDouble(a -> a.ratio));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (Node node : arr) {
            pq.offer(node.q);
            sum += node.q;
            if(pq.size() > k) {
                sum -= pq.poll();
            }
            if(pq.size() == k) {
                ans = Math.min(ans, sum * node.ratio);
            }
        }
        return ans;

    }

    class Node {
        int q;
        double ratio;

        public Node(int q, double ratio) {
            this.q = q;
            this.ratio = ratio;
        }
    }
}
