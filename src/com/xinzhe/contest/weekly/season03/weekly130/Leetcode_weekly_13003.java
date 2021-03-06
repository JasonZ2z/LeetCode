package com.xinzhe.contest.weekly.season03.weekly130;

import com.xinzhe.categories.structure.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/18
 * Title : 1019. 链表中的下一个更大节点
 * Description : 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *              每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，
 *              而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *              注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5
 * link : https://leetcode-cn.com/problems/next-greater-node-in-linked-list
 * Level : Easy
 */

public class Leetcode_weekly_13003 {
    public static void main(String[] args) {
        Leetcode_weekly_13003 lc = new Leetcode_weekly_13003();
    }
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }
        int[] res = new int[list.size()];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < list.size(); ++i) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}
