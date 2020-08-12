package com.xinzhe.contest.spring2020;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/4/18 14:55
 * Title : LCP 13. 寻宝
 * Description : 我们得到了一副藏宝图，藏宝图显示，在一个迷宫中存在着未被世人发现的宝藏。
 * 迷宫是一个二维矩阵，用一个字符串数组表示。它标识了唯一的入口（用 'S' 表示），和唯一的宝藏地点（用 'T' 表示）。但是，宝藏被一些隐蔽的机关保护了起来。在地图上有若干个机关点（用 'M' 表示），只有所有机关均被触发，才可以拿到宝藏。
 * 要保持机关的触发，需要把一个重石放在上面。迷宫中有若干个石堆（用 'O' 表示），每个石堆都有无限个足够触发机关的重石。但是由于石头太重，我们一次只能搬一个石头到指定地点。
 * 迷宫中同样有一些墙壁（用 '#' 表示），我们不能走入墙壁。剩余的都是可随意通行的点（用 '.' 表示）。石堆、机关、起点和终点（无论是否能拿到宝藏）也是可以通行的。
 * 我们每步可以选择向上/向下/向左/向右移动一格，并且不能移出迷宫。搬起石头和放下石头不算步数。那么，从起点开始，我们最少需要多少步才能最后拿到宝藏呢？如果无法拿到宝藏，返回 -1 。
 * link : https://leetcode-cn.com/problems/xun-bao
 * Level : Hard
 * Comment : 2020春季个人赛08
 */

//todo too hard to solve
public class Leetcode_single_041808 {

        int m,n;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        public int minimalSteps(String[] maze) {
            m = maze.length;
            n = maze[0].length();
            //找到地图的起点、终点、机关、石头
            int sx = -1, sy = -1;
            int tx = -1, ty = -1;
            List<int[]> buttons = new ArrayList<>();
            List<int[]> stones = new ArrayList<>();
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(maze[i].charAt(j) == 'S'){
                        sx = i;
                        sy = j;
                    }
                    if(maze[i].charAt(j) == 'T'){
                        tx = i;
                        ty = j;
                    }
                    if(maze[i].charAt(j) == 'M'){
                        buttons.add(new int[]{i, j});
                    }
                    if(maze[i].charAt(j) == 'O'){
                        stones.add(new int[]{i, j});
                    }
                }
            }

            int[][] start = bfs(sx, sy, maze);
            //如果没有石头，就直接返回起点到终点的距离
            if(buttons.size() == 0)
                return start[tx][ty];
            int nb = buttons.size();
            int ns = stones.size();
            //求某个机关到机关、起点、终点的最短距离
            int[][] dis = new int[nb][nb + 2];
            for(int i = 0; i < nb; i++){
                Arrays.fill(dis[i], -1);
            }
            //dd表示某个机关到其他机关、起点、终点的距离
            //到终点的距离
            int[][][] dd = new int[nb][][];
            for(int i = 0; i < nb; i++){
                int[][] d = bfs(buttons.get(i)[0], buttons.get(i)[1], maze);
                dd[i] = d;
                //当第i个机关为最后一个机关，到达终点的距离
                dis[i][nb + 1] = d[tx][ty];
            }
            //到其他机关和起点的距离,见以下两种情况
            //S-O-M
            //M-O-M
            for(int i = 0; i < nb; i++){
                //计算第i个机关到起点的最短距离
                int temp = -1;
                //枚举所有的石头
                for (int[] stone : stones) {
                    int x = stone[0];
                    int y = stone[1];
                    //保证S->O,O->M都可达
                    if (dd[i][x][y] == -1 || start[x][y] == -1)
                        continue;
                    //石头可达，计算S-O-M的最短距离
                    if (temp == -1 || temp > dd[i][x][y] + start[x][y])
                        temp = dd[i][x][y] + start[x][y];
                }
                dis[i][nb] = temp;
                //计算第i个机关到其他的机关的距离
                for(int j = i + 1; j < nb; j++){
                    //枚举所有石头
                    temp = -1;
                    for (int[] stone : stones) {
                        int x = stone[0];
                        int y = stone[1];
                        //保证M->O,O->M都可达
                        if (dd[i][x][y] == -1 || dd[j][x][y] == -1)
                            continue;
                        if (temp == -1 || temp > dd[i][x][y] + dd[j][x][y])
                            temp = dd[i][x][y] + dd[j][x][y];
                    }
                    dis[i][j] = temp;
                    dis[j][i] = temp;
                }
            }
            //如果从起点不能达到任何一个机关或者从任何一个机关都不能达到终点，那么即为不可达
            for(int i = 0; i < nb; i++){
                if(dis[i][nb] == -1 || dis[i][nb + 1] == -1)
                    return -1;
            }
            int[][] dp = new int[1 << nb][nb];
            for(int i = 0; i < (1 << nb); i++){
                Arrays.fill(dp[i], -1);
            }
            //从起点开始
            for(int i = 0; i < nb; i++){
                dp[1<<i][i] = dis[i][nb];
            }
            //计算从起点到终点的所有机关之间的最短距离
            for(int i = 1; i < (1 << nb); i++){
                for(int j = 0; j < nb; j++){
                    //如果第j个机关还没有达到，就不需要继续计算了
                    if((i & (1 << j)) == 0)
                        continue;
                    //计算第j个机关到第k个机关的最短距离
                    for(int k = 0; k < nb; k++){
                        //如果从第j个机关到第k个机关的最短距离已经计算了，那么就不需要重复计算了
                        if((i & (1 << k)) == (1 << k))
                            continue;
                        int mask = i | (1 << k);
                        if(dp[mask][k] == -1 || dp[mask][k] > dp[i][j] + dis[j][k])
                            dp[mask][k] = dp[i][j] + dis[j][k];
                    }
                }
            }
            //计算最后一个机关到终点的最短距离
            int res = -1;
            int mask = (1 << nb) - 1;
            for(int i = 0; i < nb; i++){
                if(res == -1 || res > dp[mask][i] + dis[i][nb + 1])
                    res = dp[mask][i] + dis[i][nb + 1];
            }
            return res;

        }
        //常规的bfs模板
        public int[][] bfs(int x, int y, String[] maze){
            int[][] res = new int[m][n];
            //初始化
            for(int i = 0; i < m; i++){
                Arrays.fill(res[i], -1);
            }
            res[x][y] = 0;
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{x, y});
            while(!que.isEmpty()){
                int[] temp = que.poll();
                x = temp[0];
                y = temp[1];
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n)
                        continue;
                    if(maze[nx].charAt(ny) != '#' && res[nx][ny] == -1){
                        que.offer(new int[]{nx, ny});
                        res[nx][ny] = res[x][y] + 1;
                    }
                }
            }
            return res;
        }
}
