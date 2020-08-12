package com.xinzhe.contest.weekly.season04.weekly179;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/5/13
 * Title : 1376. 通知所有员工所需的时间
 * Description : 公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID 进行标识。
 *              在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。对于总负责人，manager[headID] = -1。题目保证从属关系可以用树结构显示。
 *              公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，然后由这些下属通知他们的下属，直到所有的员工都得知这条紧急消息。
 *              第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，他的所有直属下属都可以开始传播这一消息）。
 *              返回通知所有员工这一紧急消息所需要的 分钟数 。
 * link : https://leetcode-cn.com/problems/time-needed-to-inform-all-employees
 * Level : Medium
 * Comment 179周赛03
 */

public class Leetcode_weekly_17903 {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int res = 0;
    int[] informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.informTime = informTime;
        for (int i = 0; i < n; ++i) {
            if (manager[i] == -1) continue;
            if (map.containsKey(manager[i])) {
                map.get(manager[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(manager[i], list);
            }
        }
        dfs(headID, informTime[headID]);
        return res;

    }

    private void dfs(int headID, int time) {
        List<Integer> list = map.get(headID);
        res = Math.max(res, time);
        if (list == null) return;
        for (int i : list) {
            dfs(i, time + informTime[i]);
        }
    }

    public static void main(String[] args) {
        Leetcode_weekly_17903 lc = new Leetcode_weekly_17903();
        int[] m = {1, 2, 3, 4, 5, 6, -1};
        int[] i = {0, 6, 5, 4, 3, 2, 1};
        System.out.println(lc.numOfMinutes(7, 6, m, i));
    }
}
