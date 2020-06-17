package com.xinzhe.contest.weekly.season04.weekly185;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/4/19 10:24
 * Title : 5389. 点菜展示表
 * Description : 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，
 *              其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 *              请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。
 *              接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 *              注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 * link : https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant
 * Level : Medium
 * Comment : 185周赛02
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
    static class Inner{
        String customer;
        String dishName;
        public Inner(String customer, String dishName){
            this.customer = customer;
            this.dishName = dishName;
        }
    }
}
