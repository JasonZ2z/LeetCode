package com.xinzhe.contest.weekly.season05.weekly218;

/**
 * @author Xin
 * @date 2020/12/06
 * Title : 1678. 设计 Goal 解析器
 * Description : 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
 *          Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *          给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * link : https://leetcode-cn.com/problems/goal-parser-interpretation
 * Level : Easy
 */
public class Leetcode_weekly_21801 {
    public static void main(String[] args) {
        Leetcode_weekly_21801 lc = new Leetcode_weekly_21801();
        int[] arr = {3,5};
    }
    public String interpret(String command) {
        return command.replaceAll("\\(al\\)", "al").replaceAll("\\(\\)", "o");
    }
}
