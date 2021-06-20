package com.xinzhe.contest.biweeekly.s1.biweekly42;

import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/12/26
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4201 {
    public static void main(String[] args) {
        Leetcode_biweekly_4201 lc = new Leetcode_biweekly_4201();
        int[] arr = {2, 4, 9, 3};
    }
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int student : students) {
            list1.offer(student);
        }
        for (int sandwich : sandwiches) {
            list2.offer(sandwich);
        }
        while (!list1.isEmpty() && !helper(list1, list2.getFirst())) {
            if(list1.getFirst().equals(list2.getFirst())) {
                list1.removeFirst();
                list2.removeFirst();
                if(list1.isEmpty()) return 0;
            } else {
                list1.addLast(list1.removeFirst());
            }
        }
        return list1.size();
    }

    private boolean helper(LinkedList<Integer> list1, Integer first) {
        for (Integer integer : list1) {
            if(first.equals(integer)) return false;
        }
        return true;
    }

}