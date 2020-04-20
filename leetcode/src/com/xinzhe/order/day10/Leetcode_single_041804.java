package com.xinzhe.order.day10;

/**
 * @Author Xin
 * @create 2020/4/18 14:55
 * Title : LCP 09. 最小跳跃次数
 * Description : 为了给刷题的同学一些奖励，力扣团队引入了一个弹簧游戏机。游戏机由 N 个特殊弹簧排成一排，编号为 0 到 N-1。
 *              初始有一个小球在编号 0 的弹簧处。若小球在编号为 i 的弹簧处，通过按动弹簧，可以选择把小球向右弹射 jump[i] 的距离，或者向左弹射到任意左侧弹簧的位置。
 *              也就是说，在编号为 i 弹簧处按动弹簧，小球可以弹向 0 到 i-1 中任意弹簧或者 i+jump[i] 的弹簧（若 i+jump[i]>=N ，则表示小球弹出了机器）。小球位于编号 0 处的弹簧时不能再向左弹。
 *              为了获得奖励，你需要将小球弹出机器。请求出最少需要按动多少次弹簧，可以将小球从编号 0 弹簧弹出整个机器，即向右越过编号 N-1 的弹簧。
 * link : https://leetcode-cn.com/problems/zui-xiao-tiao-yue-ci-shu
 * Level : Hard
 * Comment : 2020春季个人赛04
 */
//todo need to review
public class Leetcode_single_041804 {
    public static void main(String[] args) {
        int[] jump = {2, 5, 1, 1, 1, 1};
        System.out.println(minJump(jump));
        System.out.println(minJump2(jump));

    }
    public static int minJump(int[] jump) {
        int n = jump.length;
        int[] dp = new int[n+1];

        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = n;
            for(int j = i-1; j >= 0; --j) {
                if(i == n) {
                    if(j + jump[j] >= i){
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                } else {
                    if(j + jump[j] == i) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    } else if(j + jump[j] > i) {
                        dp[i] = Math.min(dp[i], dp[j] + 2);
                    }
                }
            }
        }
        return dp[n];
    }
    public static int minJump2(int[] jump){
        int count = 0;
        int n = jump.length;
        int i=0;
        while (i < n){
            int tmp = jump[i];
            if(i + tmp >= n) return count+1;
            if(tmp == 1) {
                count++;
                i++;
            } else {
                int max = 0;
                int index = 0;
                for (int j = 1; j <= tmp; ++j) {
                    if(jump[i+j] + i+j > max){
                        max = jump[i+j] + i+j;
                        index = j;
                    }
                }
                if(index == tmp) count += 1;
                else count += 2;
                i += index;
            }

        }
        return count;
    }
}
