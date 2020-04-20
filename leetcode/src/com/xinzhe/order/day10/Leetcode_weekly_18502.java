package com.xinzhe.order.day10;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/4/19 10:24
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_18502 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, List<Inner>> map  = new HashMap<>();
        Set<String> dishes = new HashSet<>();
        for (List<String> order : orders) {
            dishes.add(order.get(2));
            if (map.containsKey(order.get(1))) {
                map.get(order.get(1)).add(new Inner(order.get(0), order.get(2)));
            } else {
                ArrayList<Inner> list = new ArrayList<>();
                list.add(new Inner(order.get(0), order.get(2)));
                map.put(order.get(1), list);
            }
        }
        LinkedList<String> title = new LinkedList<>(dishes);
        Collections.sort(title);

        List<List<String>> res = new LinkedList<>();
        for (Map.Entry<String, List<Inner>> entry : map.entrySet()) {
            LinkedList<String> tmp = new LinkedList<>();
            tmp.add(entry.getKey());
            List<Inner> inners = entry.getValue();
            for (String s : title) {
                int count = 0;
                for (Inner inner : inners) {
                    if (inner.dishName.equals(s)) {
                        count++;
                    }
                }
                tmp.add(String.valueOf(count));
            }
            res.add(tmp);
        }
        res.sort(Comparator.comparingInt(s -> Integer.parseInt(s.get(0))));
        title.addFirst("Table");
        res.add(0, title);
        return res;
    }
    class Inner{
        String customer;
        String dishName;
        public Inner(String customer, String dishName){
            this.customer = customer;
            this.dishName = dishName;
        }
    }
}
