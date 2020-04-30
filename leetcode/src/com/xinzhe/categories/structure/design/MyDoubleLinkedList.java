package com.xinzhe.categories.structure.design;
/**
 * @author Xin
 * @create 2020/4/26
 * Title : 707. 设计链表
 * Description : 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *      在链表类中实现这些功能：
 *          get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 *          addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 *          addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 *          addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 *          deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * link : https://leetcode-cn.com/problems/design-linked-list
 * Level : Medium
 */

//双链表实现
    //关键点在于：构造 head/tail dummy node
    // addAtIndex: 前插，问题在于index==size 转换为尾插！
public class MyDoubleLinkedList {
    int size;
    Node head;
    Node tail;
    public MyDoubleLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        return getIndex(index).val;
    }

    public Node getIndex(int index) {
        Node pre;
        if(index <= size -index) {
            pre = head.next;
            for (int i = 0; i < index; ++i) {
                pre = pre.next;
            }
        }else {
            pre = index == size ? tail : tail.pre;
            for (int i = 0; i < size - index -1 ; ++i) {
                pre = pre.pre;
            }
        }
        return pre;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index < 0) index = 0;
        Node cur = getIndex(index);
        Node target = new Node(val);
        Node pre = cur.pre;
        target.pre = pre;
        target.next = cur;
        cur.pre = target;
        pre.next = target;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        Node cur = getIndex(index);
        Node pre = cur.pre;
        Node next = cur.next;
        pre.next = next;
        next.pre = pre;
        cur.next = null;
        cur.pre = null;
        size--;

    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("head <-> ");
        Node tempNode= head.next;
        for (int i=0;i<size;i++,tempNode=tempNode.next){
            sb.append(tempNode.val).append(" <-> ");
        }
        sb.append("tail");
        return sb.toString();
    }

    static class Node{
        int val;
        Node next;
        Node pre;
        public Node() {
        }
        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        System.out.println("new   " + list.toString());
        list.addAtHead(1);
        System.out.println("addAtHead 1   " + list.toString());
        list.addAtHead(2);
        System.out.println("addAtHead 2   " + list.toString());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.addAtTail(3);
        System.out.println("addAtTail 3   " + list.toString());
        list.addAtIndex(1,2);
        System.out.println("addAtIndex 1,2   " + list.toString());
        System.out.println("get 1   "+list.get(1));
        list.deleteAtIndex(1);
        System.out.println("deleteAtIndex 1   " + list.toString());
        System.out.println("get 1   " + list.get(1));
    }
}
