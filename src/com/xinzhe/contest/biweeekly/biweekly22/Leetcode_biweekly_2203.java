package com.xinzhe.contest.biweeekly.biweekly22;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/4/18 22:16
 * Title : 1387. 将整数按权重排序
 * Description : 我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
 *      如果 x 是偶数，那么 x = x / 2
 *      如果 x 是奇数，那么 x = 3 * x + 1
 *      比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
 *      给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
 *      请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
 *      注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。
 * link : https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum
 * Level : Easy
 * Comment : 24双周赛01
 */
public class Leetcode_biweekly_2203 {
    public static void main(String[] args) {
        Leetcode_biweekly_2203 lc = new Leetcode_biweekly_2203();
        System.out.println(lc.getKth2(12, 15, 2));
    }

    public int getKth(int l, int h, int k) {
        List<Newint> list = new ArrayList<>();
        for (int i = l; i <= h; ++i) {
            list.add(new Newint(i));
        }
        list.sort(Newint::compareTo);
        return list.get(k-1).a;
    }

    static class Newint implements Comparable<Newint>{
        int a;
        public Newint(int a) {
            this.a = a;
        }
        @Override
        public int compareTo(Newint o) {
            int a1 = helper(a);
            int b2 = helper(o.a);
            if(a1 == b2) return a-o.a;
            return a1-b2;
        }
        private int helper(int a) {
            int count = 0;
            while (a != 1) {
                if(a % 2 == 0) {
                    a /= 2;
                } else {
                    a = 3*a + 1;
                }
                count++;
            }
            return count;
        }
    }

    //优先队列 + 记忆化
    //<value, weight>
    Map<Integer, Integer> map = new HashMap<>();
    public int getKth2(int l, int h, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = l; i <= h; ++i) {
            queue.add(new int[]{i, helper(i)});
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return Objects.requireNonNull(queue.peek())[0];
    }
    private int helper(int a) {
        if(a== 1) return 0;
        if(map.containsKey(a)) return map.get(a);
        int count;
        if((a&1) == 1) {
            count = helper(3*a+1);
        } else {
            count = helper(a/2);
        }
        count++;
        map.put(a, count);
        return count;
    }
}
