package com.xinzhe.contest.biweeekly.biweekly39;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/11/14
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_3903 {
    public static void main(String[] args) {
        Leetcode_biweekly_3903 lc = new Leetcode_biweekly_3903();
        int[] arr = {162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98};

        //System.out.println(lc.minimumJumps(arr, 29,98,80));
        System.out.println(lc.minimumJumps2(arr, 29,98,80));
    }
    //61 122 183
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set;
    int a, b, x;
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if(a - b > x) return -1;
        this.set = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
        this.a = a;
        this.b = b;
        this.x = x;
        if(set.contains(a)) return -1;
        if(a - b == x) return 2;

        return solve(0, false);
    }

    private int solve(int cur, boolean flag) {
        if(cur < 0) return -1;
        if(set.contains(cur)) return -1;
        if(cur == x) return 0;
        if(map.containsKey(cur)) return map.get(cur);
        if(cur > x) {
            if(a > b && cur - x > b) return -1;
            int ans = flag ? solve(cur - b, false) : -1;
            if(ans > 0) return ans + 1;
        }
        int ans = solve(cur + a, true);
        if (ans < 0 && flag) {
            ans = solve(cur - b, false);
        }
        if(ans == -1) {
            map.put(cur, -1);
            return -1;
        }else{
            map.put(cur, ans + 1);
            return ans + 1;
        }
    }


    public int minimumJumps2(int[] forbidden, int a, int b, int x) {
        int[] dp = new int[4001];
        Arrays.fill(dp, (int)1e7);
        Set<Integer> set = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, false));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.index < 0 || cur.index > 4000 || cur.step >= dp[cur.index] || set.contains(cur.index)) continue;
            dp[cur.index] = cur.step;
            if(cur.back) {
                queue.offer(new Node(cur.index - b, cur.step + 1, false));
            }
            queue.offer(new Node(cur.index + a, cur.step + 1, true));
        }
        return dp[x] == (int)1e7 ? -1 : dp[x];
    }

    class Node {
        int index;
        int step;
        boolean back;

        public Node(int index, int step, boolean back) {
            this.index = index;
            this.step = step;
            this.back = back;
        }
    }
}
