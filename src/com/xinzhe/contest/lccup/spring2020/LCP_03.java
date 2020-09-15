package com.xinzhe.contest.lccup.spring2020;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/9/15
 * Title : LCP 03. 机器人大冒险
 * Description : 机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 *              U: 向y轴正方向移动一格 R: 向x轴正方向移动一格。不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 *              给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 * link : https://leetcode-cn.com/problems/programmable-robot
 * Level : Medium
 */
public class LCP_03 {
    public static void main(String[] args) {
        LCP_03 lc = new LCP_03();
        int[][] b = {{2,2}};
        System.out.println(lc.robot("URR", b, 3, 2));
    }
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        Set<Node> set = new HashSet<>(obstacles.length);
        for (int[] obstacle : obstacles) {
            if(obstacle[0] > x || obstacle[1] > y) continue;
            set.add(new Node(obstacle[0], obstacle[1]));
        }
        Node start = new Node(0,0);
        while(true) {
            for (char c : command.toCharArray()) {
                if(c == 'U') {
                    start.y++;
                }else {
                    start.x++;
                }
                if(set.contains(start)) return false;
                if(start.x == x && start.y == y) return true;
            }
            if(start.x > x || start.y > y) break;
        }

        return false;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
