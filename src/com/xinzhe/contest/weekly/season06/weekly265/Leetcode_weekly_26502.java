package com.xinzhe.contest.weekly.season06.weekly265;

/**
 * @author Xin
 * @date 2021/10/31
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_26502 {
    public static void main(String[] args) {
        Leetcode_weekly_26502 lc = new Leetcode_weekly_26502();

    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return new int[]{-1, -1};
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = head.next.next;
        int index = 1, max = -1, min = Integer.MAX_VALUE;
        int first = 0, last = 0;
        while (next != null) {
            if((cur.val > pre.val && cur.val > next.val) || (cur.val < pre.val && cur.val < next.val)) {
                if(first == 0) {
                    first = index;
                } else  {
                    min = Math.min(min, index - last);
                    max = Math.max(max, index - first);
                }
                last = index;
            }
            index++;
            pre = pre.next;
            cur = cur.next;
            next = next.next;
        }
        if(min == Integer.MAX_VALUE) min = -1;
        return new int[]{min, max};
    }
}

class ListNode {
  int val;
    ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
