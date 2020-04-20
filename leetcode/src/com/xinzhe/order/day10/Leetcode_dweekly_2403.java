package com.xinzhe.order.day10;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/4/18 22:16
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_dweekly_2403 {
    public static void main(String[] args) {
        System.out.println(getHappyString(4,10));
        System.out.println(getHappyString2(4,10));
    }

    static ArrayList<String> list = new ArrayList<>();
    public static String getHappyString2(int n, int k) {
        int sum = 3;
        for (int i = 1; i < n; ++i) {
            sum *= 2;
        }
        if(sum < k) return "";

        bfs("a", n-1, "a");
        bfs("b", n-1, "b");
        bfs("c", n-1, "c");
        Collections.sort(list);
        return list.get(k);


    }

    private static void bfs(String s, int n, String cur) {
        if(n == 0) {
            list.add(s);
            return;
        }

        if("a".equals(cur)) {
            bfs(s+"b", n-1, "b");
            bfs(s+"c", n-1, "c");
        }
        if("b".equals(cur)) {
            bfs(s+"a", n-1, "a");
            bfs(s+"c", n-1, "c");
        }
        if("c".equals(cur)) {
            bfs(s+"b", n-1, "b");
            bfs(s+"a", n-1, "a");
        }
    }
    public static String getHappyString(int n, int k) {
        int sum = 3;
        for (int i = 1; i < n; ++i) {
            sum *= 2;
        }
        if(sum < k) return "";

        String cur;
        int target = sum / 3;
        StringBuilder sb = new StringBuilder();
        if (k <= target) {
            sb.append("a");
            cur = "a";
        } else if (k <= (target * 2)) {
            sb.append("b");
            cur = "b";
        } else {
            sb.append("c");
            cur = "c";
        }

        while (target > 1) {
            target /= 2;
            if (k <= target) {
                switch (cur) {
                    case "a":
                        sb.append("b");
                        cur = "b";
                        break;
                    case "b":
                        sb.append("a");
                        cur = "a";
                        break;
                    case "c":
                        sb.append("a");
                        cur = "a";
                        break;
                }
            } else {
                switch (cur) {
                    case "a":
                        sb.append("c");
                        cur = "c";
                        break;
                    case "b":
                        sb.append("c");
                        cur = "c";
                        break;
                    case "c":
                        sb.append("b");
                        cur = "b";
                        break;
                }
            }
        }
        return sb.toString();
    }
}
