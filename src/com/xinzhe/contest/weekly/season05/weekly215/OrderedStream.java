package com.xinzhe.contest.weekly.season05.weekly215;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/11/15
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class OrderedStream {
    public static void main(String[] args) {
        OrderedStream lc = new OrderedStream(9);
        int[] arr = {3,5};
        lc.insert(9, "nghbm");
        lc.insert(7, "hgeob");
        lc.insert(6, "mwlrz");
        lc.insert(4, "oalee");
    }

    Map<Integer, String> map = new HashMap<>();
    int ptr = 1;
    public OrderedStream(int n) {

    }

    public List<String> insert(int id, String value) {
        map.put(id, value);
        List<String> res = new ArrayList<>();
        if(id <= ptr) {
            while (map.containsKey(id)) {
                res.add(map.get(id));
                id++;
                if(id > ptr) ptr = id;
            }
        }
        return res;
    }
}
