package com.xinzhe.contest.weekly.season04.weekly159;

import java.util.*;

/**
 * @author Xin
 * @date 2020/6/23
 * Title : 1233. 删除子文件夹
 * Description : 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹.
 *      我们这样定义「子文件夹」：如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的子文件夹。
 *      文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：/ 后跟一个或者多个小写英文字母。
 *      例如，/leetcode 和 /leetcode/problems 都是有效的路径，而空字符串和 / 不是。
 * link : https://leetcode-cn.com/problems/remove-sub-folders-from-the-filesystem
 * Level : Medium
 * Comment 159周赛02
 */

public class Leetcode_weekly_15902 {

    public static void main(String[] args) {
        Leetcode_weekly_15902 lc = new Leetcode_weekly_15902();
        int[][] arr = {{2,5},{2,4},{2,8}};
    }
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        Set<String> set= new TreeSet<>((s1, s2)->{
            if(s1.contains(s2+"/"))
                return 0;
            return s1.compareTo(s2);
        });
        Collections.addAll(set,folder);
        return new ArrayList<>(set);
    }
}
