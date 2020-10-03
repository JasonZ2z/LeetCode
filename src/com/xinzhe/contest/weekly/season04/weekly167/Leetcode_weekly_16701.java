package com.xinzhe.contest.weekly.season04.weekly167;

import com.xinzhe.categories.structure.linkedlist.ListNode;

/**
 * @author Xin
 * @date 2020/6/03
 * Title : 1290. 二进制链表转整数
 * Description : 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。请你返回该链表所表示数字的 十进制值 。
 * link : https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * Level : Easy
 * Comment 167周赛01
 */

public class Leetcode_weekly_16701 {
    public int getDecimalValue(ListNode head) {
        int res = 0;

        while (head != null) {

            res <<= 1;
            res += head.val;
            head = head.next;
        }
        return res;
    }
}
