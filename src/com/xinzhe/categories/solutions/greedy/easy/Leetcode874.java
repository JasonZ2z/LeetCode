package com.xinzhe.categories.solutions.greedy.easy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/4/21
 * Title : 874. 模拟行走机器人
 * Description : 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *          -2：向左转 90 度
 *          -1：向右转 90 度
 *          1 <= x <= 9：向前移动 x 个单位长度
 *      在网格上有一些格子被视为障碍物。
 *      第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *      机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *      返回从原点到机器人的最大欧式距离的平方。
 * link : https://leetcode-cn.com/problems/walking-robot-simulation
 * Level : Easy
 */

public class Leetcode874 {
    public static void main(String[] args) {
        int[] c = {7,-2,-2,7,5};
        int[][] o = {{-3,2},{-2,1},{0,1},{-2,4},{-1,0},{-2,-3},{0,-3},{4,4},{-3,3},{2,2}};
        System.out.println(robotSim(c,o));
    }
    public static int robotSim(int[] commands, int[][] obstacles) {
        if(commands.length == 0) return 0;
        int x = 0, y = 0;
        int max = 0;
        //                     ↑        →     ↓       ←
        int[][] directions = {{0, 1}, {1,0},{0, -1}, {-1,0}};
        int i= 0;
        Set<Inner> list = new HashSet<>();
        for (int[] obstacle : obstacles) {
            list.add(new Inner(obstacle[0], obstacle[1]));
        }
        for (int command : commands) {
            if (command == -1) {
                i= (i+1)%4;
            } else if(command == -2) {
                i =(i-1+4)%4;
            } else {
                for (int j = 0; j < command; ++j) {
                    x += directions[i][0];
                    y += directions[i][1];
                    if(!list.contains(new Inner(x, y))){
                        max = Math.max(max, x*x+y*y);
                    } else {
                        if(directions[i][0] == 0) {
                            y-=directions[i][1];
                        } else {
                            x-=directions[i][0];
                        }
                        break;
                    }
                }
                System.out.println(x + " " + y);
            }
        }

        return max;
    }
    static class Inner{
        int x;
        int y;
        public Inner(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Inner inner = (Inner) o;
            return x == inner.x &&
                    y == inner.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
