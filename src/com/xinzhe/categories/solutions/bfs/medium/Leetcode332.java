package com.xinzhe.categories.solutions.bfs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/8/27
 * Title : 332. 重新安排行程
 * Description : 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
 *              所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *              如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 *              所有的机场都用三个大写字母表示（机场代码）。 假定所有机票至少存在一种合理的行程。
 * link : https://leetcode-cn.com/problems/reconstruct-itinerary
 * Level : Medium
 */
public class Leetcode332 {
    //todo need to review
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> l1 = Arrays.asList("JFK","KUL");
        List<String> l2 = Arrays.asList("JFK","NRT");
        List<String> l3= Arrays.asList("NRT","JFK");
        tickets.add(l1);
        tickets.add(l2);
        tickets.add(l3);
        Leetcode332 lc = new Leetcode332();
        System.out.println(lc.findItinerary(tickets));

    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            map.computeIfAbsent(from, a->new PriorityQueue<>()).offer(to);
        }
        List<String> res=new LinkedList<>();
        bfs(map,"JFK", res);
        return res;
    }

    private void bfs(Map<String, PriorityQueue<String>> map, String cur, List<String> res) {
        PriorityQueue<String> queue = map.get(cur);
        while (queue != null && queue.size() > 0) {
            String poll = queue.poll();
            bfs(map, poll, res);
        }
        res.add(0, cur);
    }
}
