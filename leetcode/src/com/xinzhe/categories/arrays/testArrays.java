package com.xinzhe.categories.arrays;

import java.util.*;

/**
 * @author xzheng
 * @date 2020-01-08 17:52
 */
public class testArrays {
    public static void main(String[] args) {
        Set<String> list1 = new TreeSet<>();
        Map<String, String> map = new HashMap<>();
        list1.add("1");
        list1.add("2");

        //List<String> list1 = Arrays.asList("1","2");
        ArrayList<String> list2 = new ArrayList<>(list1);
        list2.forEach(System.out::println);
    }
}
