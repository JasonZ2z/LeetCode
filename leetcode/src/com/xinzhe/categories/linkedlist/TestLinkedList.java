
package com.xinzhe.categories.linkedlist;


import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        String s = "abcdefg";
        LinkedList<Character> list = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            list.addLast(s.charAt(i));
        }
        System.out.println(list);
        int n = 2;
        while(n > 0) {
            char c = list.pollFirst();
            System.out.println(c);
            list.addLast(c);
            n--;
        }
    }
}
