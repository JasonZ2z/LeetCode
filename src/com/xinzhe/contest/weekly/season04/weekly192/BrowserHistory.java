package com.xinzhe.contest.weekly.season04.weekly192;

import java.util.LinkedList;

/**
 * @Author Xin
 * @create 2020/6/7
 * Title :
 * Description :
 * link :
 * Level : Medium
 * Comment 192周赛03
 */
public class BrowserHistory {
    LinkedList<String> list;
    int index;

    public BrowserHistory(String homepage) {
        this.list = new LinkedList<>();
        list.addLast(homepage);
        this.index = 1;
    }

    public void visit(String url) {
        while (list.size() > index) {
            list.removeLast();
        }
        list.add(url);
        index = list.size();
    }

    public String back(int steps) {
        if (index <= steps) {
            index = 1;
            return list.get(0);
        } else {
            while (steps-- > 0) {
                index--;
            }
            return list.get(index - 1);
        }

    }

    public String forward(int steps) {
        if (index + steps >= list.size()) {
            index = list.size();
            return list.get(list.size() - 1);
        } else {
            while (steps-- > 0) {
                index++;
            }
            return list.get(index - 1);
        }
    }

    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory("leetcode.com");
        bh.visit("google.com");
        bh.visit("facebook.com");
        bh.visit("youtube.com");
        System.out.println(bh.list);
        System.out.println(bh.back(1));
        System.out.println(bh.back(1));
        System.out.println(bh.forward(1));
        bh.visit("linkedin.com");
        System.out.println(bh.list);
        System.out.println(bh.forward(2));
        System.out.println(bh.back(2));
        System.out.println(bh.back(2));
        System.out.println(bh.back(7));
    }

}
