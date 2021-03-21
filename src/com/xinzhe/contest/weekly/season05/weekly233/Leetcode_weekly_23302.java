package com.xinzhe.contest.weekly.season05.weekly233;

import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2021/03/14
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23302 {
    public static void main(String[] args) {
        Leetcode_weekly_23302 lc = new Leetcode_weekly_23302();
        //int[][]  arr =  {{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}};
        //int[][]  arr =  {{10,5,0},{15,2,1},{25,1,1},{30,4,0}};
        int[][]  arr =  {{26,7,0},{16,1,1},{14,20,0},{23,15,1},{24,26,0},{19,4,1},{1,1,0}};
        System.out.println(lc.getNumberOfBacklogOrders(arr));

    }
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Node> sell = new PriorityQueue<>((a, b) -> a.price - b.price);
        PriorityQueue<Node> buy = new PriorityQueue<>((a,b) -> b.price - a.price);

        for (int[] order : orders) {
            int price =  order[0], amount = order[1];
            if(order[2] == 0) {
                while (amount > 0 && !sell.isEmpty() && sell.peek().price <= price) {
                    Node poll = sell.poll();
                    if(poll.amount > amount) {
                        sell.offer(new Node(poll.price, poll.amount - amount));
                        amount = 0;
                        break;
                    } else {
                        amount -= poll.amount;
                    }
                }
                if(amount > 0 ) {
                    buy.offer(new Node(price, amount));
                }
            } else {
                while (amount > 0 && !buy.isEmpty() && buy.peek().price >= price) {
                    Node poll = buy.poll();
                    if(poll.amount > amount) {
                        buy.offer(new Node(poll.price, poll.amount - amount));
                        amount = 0;
                        break;
                    } else {
                        amount -= poll.amount;
                    }
                }
                if(amount > 0 ) {
                    sell.offer(new Node(price, amount));
                }
            }
        }
        long res = 0L;
        while (!buy.isEmpty()) {
            Node poll = buy.poll();
            res += poll.amount;
        }
        while (!sell.isEmpty()) {
            Node poll = sell.poll();
            res += poll.amount;
        }
        int mod = (int)1e9 + 7;
        return (int) (res % mod);
    }

    class Node {
        int price;
        int amount;

        public Node(int price, int amount) {
            this.price = price;
            this.amount = amount;
        }
    }

}
