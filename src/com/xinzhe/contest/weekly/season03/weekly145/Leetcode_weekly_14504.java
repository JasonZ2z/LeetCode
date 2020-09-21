package com.xinzhe.contest.weekly.season03.weekly145;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/8/23
 * Title : 1125. 最小的必要团队
 * Description : 作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员 people[i] 含有一份该备选人员掌握的技能列表）。
 *              所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。
 *              我们可以用每个人的编号来表示团队中的成员：例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。
 *              请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按任意顺序返回答案，本题保证答案存在。
 * link : https://leetcode-cn.com/problems/smallest-sufficient-team
 * Level :
 */

//todo need to review
public class Leetcode_weekly_14504 {

    public static void main(String[] args) {
        Leetcode_weekly_14504 lc = new Leetcode_weekly_14504();
    }

    int min = (int)1e9;
    List<Integer> res = new ArrayList<>();
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skills = new HashMap<>();
        for(int i=0; i<req_skills.length; i++){
            skills.put(req_skills[i], i);
        }
        int[] peoples = new int[people.size()];
        for(int i=0; i<people.size(); i++) {
            int mask = 0;
            for(String s : people.get(i)) {
                if(skills.containsKey(s)) {
                    mask |= 1 << skills.get(s);
                }
            }
            peoples[i] = mask;
        }
        dfs(peoples, req_skills.length, 0, new ArrayList<>());
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void dfs(int[] peoples, int n, int mask, List<Integer> trace) {
        if(mask == (1 << n) - 1) {
            if(trace.size() < min) {
                res = new ArrayList<>(trace);
                min = trace.size();
            }
            return;
        }
        if(trace.size() >= min) return;
        int zeroBits = 0;
        while((mask & (1 << zeroBits)) != 0) {
            zeroBits++;
        }
        for(int i=0; i<peoples.length; i++) {
            if((peoples[i] & (1 << zeroBits)) > 0) {
                trace.add(i);
                dfs(peoples, n, mask|peoples[i], trace);
                trace.remove(trace.size()-1);
            }
        }
    }
}
