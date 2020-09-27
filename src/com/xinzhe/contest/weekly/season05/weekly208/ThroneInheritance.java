package com.xinzhe.contest.weekly.season05.weekly208;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/9/27
 * Title : 1600. 皇位继承顺序
 * Description : 一个王国里住着国王、他的孩子们、他的孙子们等等。每一个时间点，这个家庭里有人出生也有人死亡。
 * link : https://leetcode-cn.com/problems/throne-inheritance/
 * Level : Medium
 */
public class ThroneInheritance {
    Map<String, List<String>> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    String king;
    public ThroneInheritance(String kingName) {
        this.king = kingName;
    }

    public void birth(String parentName, String childName) {
        map.computeIfAbsent(parentName, a -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        set.add(name);
    }

    public List<String> getInheritanceOrder() {
        ArrayList<String> list = new ArrayList<>();
        getInheritanceOrder(king, list);
        return list;

    }

    private void getInheritanceOrder(String name, ArrayList<String> list) {
        if(!set.contains(name)) list.add(name);
        for (String s : map.getOrDefault(name, new ArrayList<>())) {
            getInheritanceOrder(s, list);
        }
    }
}
