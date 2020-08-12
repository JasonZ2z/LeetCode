package com.xinzhe.categories.solutions.bitmanipulation.medium;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/8/11
 * Title : 756. 金字塔转换矩阵
 * Description : 现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示。
 *              使用三元组表示金字塔的堆砌规则如下：
 *              对于三元组(A, B, C) ，“C”为顶层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。当且仅当(A, B, C)是被允许的三元组，我们才可以将其堆砌上。
 *              初始时，给定金字塔的基层 bottom，用一个字符串表示。一个允许的三元组列表 allowed，每个三元组用一个长度为 3 的字符串表示。
 *              如果可以由基层一直堆到塔尖就返回 true ，否则返回 false 。
 * link : https://leetcode-cn.com/problems/pyramid-transition-matrix
 * Level : Medium
 */
public class Leetcode756 {
    public static void main(String[] args) {
        List<String> nums = Arrays.asList("BCG", "CDE", "GEA", "FFF");
        Leetcode756 lc = new Leetcode756();
        System.out.println(lc.pyramidTransition("BCD", nums));
    }
    Map<String, Set<Character>> map = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for(String s : allowed) {
            String pre = s.substring(0,2);
            map.computeIfAbsent(pre, a->new HashSet<>()).add(s.charAt(2));
        }
        return dfs(bottom, "");
    }

    private boolean dfs(String bottom, String cur) {
        int n = bottom.length();
        if(n == 2 && map.containsKey(bottom)) return true;
        if(cur.length() ==  bottom.length() -1) return dfs(cur, "");
        String tmp = bottom.substring(cur.length(), cur.length() + 2);
        if(!map.containsKey(tmp)) return false;
        for(Character c : map.get(tmp)) {
            if(dfs(bottom, cur+c)) return true;
        }
        return false;
    }

    public boolean pyramidTransition2(String bottom, List<String> allowed) {
        for(String s : allowed) {
            String pre = s.substring(0,2);
            map.computeIfAbsent(pre, a->new HashSet<>()).add(s.charAt(2));
        }
        return dfs(bottom);
    }

    private boolean dfs(String bottom) {
        int n = bottom.length();
        if(n == 2 && map.containsKey(bottom)) return true;
        for (int i = 0; i<bottom.length()-1; i++) {
            if (!map.containsKey(bottom.substring(i,i+2))) return false;
        }
        List<String> bottoms = trackBack(bottom, 0, "");
        for(String b : bottoms) {
            if(dfs(b)) return true;
        }
        return false;
    }

    private List<String> trackBack(String bottom, int start, String trace) {
        List<String> res = new ArrayList<>();
        if(start == bottom.length()-1) {
            res.add(trace);
            return res;
        }
        String pre = bottom.substring(start, start+2);
        for(char c : map.get(pre)) {
            String tmp = trace + c;
            res.addAll(trackBack(bottom, start+1, tmp));
        }
        return res;
    }
}
