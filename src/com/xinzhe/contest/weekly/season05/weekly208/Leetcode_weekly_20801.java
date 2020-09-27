package com.xinzhe.contest.weekly.season05.weekly208;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/9/27
 * Title :  1598 文件夹操作日志搜集器
 * Description : 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录 ...
 * link : https://leetcode-cn.com/problems/crawler-log-folder
 * Level : Easy
 */
public class Leetcode_weekly_20801 {
    public static void main(String[] args) {
        Leetcode_weekly_20801 lc = new Leetcode_weekly_20801();
    }
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            if("../".equals(log)) {
                if(stack.isEmpty()) continue;
                stack.pop();
            }else if(!log.startsWith(".")) {
                stack.push(log);
            }
        }
        return stack.size();
    }
}
