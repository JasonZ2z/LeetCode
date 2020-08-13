package com.xinzhe.categories.solutions.dp.compress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/8/13
 * Title : 1125. 最小的必要团队
 * Description : 作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员 people[i] 含有一份该备选人员掌握的技能列表）。
 *          所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。
 *          我们可以用每个人的编号来表示团队中的成员：例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。
 *          请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按任意顺序返回答案，本题保证答案存在。
 * link : https://leetcode-cn.com/problems/smallest-sufficient-team
 * Level : Hard
 */

//todo need to review
public class Leetcode1125 {
    int min = Integer.MAX_VALUE;
    List<Integer> res = new ArrayList<>();
    public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        int n = reqSkills.length;
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < reqSkills.length; i++) {
            dict.put(reqSkills[i],i);
        }
        Map<Integer, Integer> persons = new HashMap<>();
        Set<Integer> masks = new HashSet<>();
        for (int i = 0; i < people.size(); i++) {
            int mask = 0;
            for (String s : people.get(i)) {
                if(dict.containsKey(s)) {
                    mask |= 1 << dict.get(s);
                }
            }
            masks.add(mask);
            persons.put(mask, i);
        }
        List<Integer> list = new ArrayList<>(masks);
        dfs(persons, list, n, 0, new ArrayList<>());
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(Map<Integer, Integer> persons, List<Integer> masks, int n, int mask, List<Integer> trace) {
        if(mask == (1 << n) -1) {
            if(trace.size() < min) {
                min = trace.size();
                res = new ArrayList<>(trace);
            }
            return;
        }
        if(trace.size() >= min) return;
        int zeroBit = 0;
        while (((mask >> zeroBit) & 1) == 1) {
            zeroBit++;
        }
        for (int i = 0; i < masks.size(); ++i) {
            if(((masks.get(i) >> zeroBit) & 1) == 1) {
                trace.add(persons.get(masks.get(i)));
                dfs(persons, masks, n, mask | masks.get(i), trace);
                trace.remove(trace.size()-1);
            }
        }
    }
}
