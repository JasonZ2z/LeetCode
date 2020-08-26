package com.xinzhe.contest.weekly.season03.weekly136;

/**
 * @author Xin
 * @date 2020/8/26
 * Title : 1041. 困于环中的机器人
 * Description : 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：
 *              "G"：直走 1 个单位   "L"：左转 90 度   "R"：右转 90 度
 *              机器人按顺序执行指令 instructions，并一直重复它们。只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
 * link : https://leetcode-cn.com/problems/robot-bounded-in-circle
 * Level : Medium
 */

//此题trick之处在于，无限次的循环，模拟实现，较为繁琐，终点是关键。
//只需判断终点位置是否重复 或者 一次循环之后的朝向有无改变
public class Leetcode_weekly_13601 {
    public static void main(String[] args) {
        Leetcode_weekly_13601 lc = new Leetcode_weekly_13601();
    }
    public boolean isRobotBounded(String instructions) {
        if(!instructions.contains("G")) return true;
        char[] arr = instructions.toCharArray();
        int dir = 0, x = 0, y = 0;
        for(char c : arr){
            if(c == 'G') {
                if(dir == 0) y++;
                if(dir == 1) x++;
                if(dir == 2) y--;
                if(dir == 3) x--;
            } else if( c == 'L') {
                dir--;
                if(dir < 0) dir += 4;
            } else {
                dir++;
                if(dir > 3) dir -= 4;
            }
        }
        return (x == 0 && y == 0) || dir != 0;
    }
}
