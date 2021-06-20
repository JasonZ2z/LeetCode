package com.xinzhe.contest.weekly.season05.weekly243;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2021/05/30
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24303 {
    public static void main(String[] args) {
        Leetcode_weekly_24303 lc = new Leetcode_weekly_24303();
        int[] s = {3,3,2};
        int[] t = {1,2,3,2,1,2};
        System.out.println(Arrays.toString(lc.assignTasks(s, t)));
    }

    class Server{
        int id;
        int weight;
        long time;

        public Server(int id, int weight, long time) {
            this.id = id;
            this.weight = weight;
            this.time = time;
        }
    }


    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Server> ready = new PriorityQueue<>(servers.length, Comparator.<Server>comparingLong(x -> x.weight).thenComparingInt(x -> x.id));
        PriorityQueue<Server> working = new PriorityQueue<>(servers.length, Comparator.comparingLong(x -> x.time));

        for(int i = 0; i < servers.length; i++){
            Server server = new Server(i, servers[i], 0);
            ready.add(server);
        }
        long now = 0;
        int[] ans = new int[tasks.length];
        for(int i = 0; i < tasks.length; i++){
            now = Math.max(now, i);
            while(!working.isEmpty() && working.peek().time <= now){
                ready.add(working.remove());
            }
            if(ready.isEmpty()){
                now = working.peek().time;
            }
            while(!working.isEmpty() && working.peek().time <= now){
                ready.add(working.remove());
            }
            Server match = ready.remove();
            ans[i] = match.id;
            match.time = now + tasks[i];
            working.add(match);
        }

        return ans;
    }
}
