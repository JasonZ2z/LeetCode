package com.xinzhe.contest.biweeekly.s1.biweekly36;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/10/3
 * Title : 1604. 警告一小时内使用相同员工卡大于等于三次的人
 * Description : 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告。
 *              给你字符串数组keyName和keyTime ，其中[keyName[i], keyTime[i]]对应一个人的名字和他在某一天 内使用员工卡的时间。
 * link : https://leetcode-cn.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period
 * Level : Medium
 */
public class Leetcode_biweekly_3602 {
    public static void main(String[] args) {
        Leetcode_biweekly_3602 lc = new Leetcode_biweekly_3602();
        int[] arr = {1,4,2,5,3};
        String[] t = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] s ={"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        System.out.println(lc.alertNames(t, s));

    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        List<String> res = new ArrayList<>();
        List<Node> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = keyTime[i].split(":");
            times.add(new Node(Integer.parseInt(split[0]),Integer.parseInt(split[1])));
        }

        Map<String, List<Node>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.computeIfAbsent(keyName[i], a -> new ArrayList<>()).add(times.get(i));
        }
        for (Map.Entry<String, List<Node>> entry : map.entrySet()) {
            List<Node> value = entry.getValue();
            value.sort((a, b) -> a.h == b.h ? a.m - b.m : a.h - b.h);
            for (int i = 0; i < value.size(); i++) {
                boolean flag = false;
                for (int j = i+2; j < value.size(); ++j) {
                    if(getGap(value.get(j), value.get(i))) {
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    res.add(entry.getKey());
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;

    }

    private boolean getGap(Node i, Node j) {
        if(i.h - j.h > 2) return false;
        if(i.h - j.h == 1) {
            return i.m <= j.m;
        }
        return i.h == j.h;
    }

    class Node{
        int h;
        int m;

        public Node(int h, int m) {
            this.h = h;
            this.m = m;
        }
    }
}
