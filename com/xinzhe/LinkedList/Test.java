package com.xinzhe.LinkedList;

public class Test {
    public static void main(String[] args) {
        com.xinzhe.LinkedList.ListNode a1 = new com.xinzhe.LinkedList.ListNode(1);
        com.xinzhe.LinkedList.ListNode a2 = new com.xinzhe.LinkedList.ListNode(2);
        com.xinzhe.LinkedList.ListNode a3 = new com.xinzhe.LinkedList.ListNode(3);
        com.xinzhe.LinkedList.ListNode a4 = new com.xinzhe.LinkedList.ListNode(4);
//        ListNode a5 = new ListNode(5);
//        ListNode a6 = new ListNode(6);
//        ListNode a7 = new ListNode(7);
        a1.next= a2;
        a2.next= a3;
        a3.next= a4;
//        a4.next= a5;
//        a5.next= a6;
//        a6.next= a7;


        com.xinzhe.LinkedList.ListNode[] listNodes = splitListToParts(a1, 5);
        for (com.xinzhe.LinkedList.ListNode listNode : listNodes) {
            while(listNode != null){
                System.out.print(listNode.val);
                listNode = listNode.next;
            }
            System.out.println();
        }

    }

    public static com.xinzhe.LinkedList.ListNode[] splitListToParts(com.xinzhe.LinkedList.ListNode root, int k) {
        com.xinzhe.LinkedList.ListNode[] result = new com.xinzhe.LinkedList.ListNode[k];
        if(root == null) return result;
        int len = 0;
        com.xinzhe.LinkedList.ListNode cur = root;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        int a = len/k;
        int b = len%k;

        com.xinzhe.LinkedList.ListNode newHead = root;
        for(int i = 0; i< k; i++){
            if(newHead == null){
                result[i] = newHead;
            } else {
                int tmp = 0;
                com.xinzhe.LinkedList.ListNode curHead = newHead;
                com.xinzhe.LinkedList.ListNode before = null;
                com.xinzhe.LinkedList.ListNode post = newHead;
                while(tmp < a && post != null){
                    before = post;
                    post = post.next;
                    tmp++;
                }
                if(b> 0 && post != null){
                    before = post;
                    b--;
                }
                if(before == null || before.next == null){
                    newHead = null;
                } else {
                    newHead = before.next;
                    before.next = null;
                }

                result[i] = curHead;

            }
        }
        return result;
    }
}
