package com.xinzhe.categories.solutions.binarysearch.function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/4/10 21:37
 * Title : 911. 在线选举
 * Description : 在选举中，第 i 张票是在时间为 times[i] 时投给 persons[i] 的。
 *          现在，我们想要实现下面的查询函数： TopVotedCandidate.q(int t) 将返回在 t 时刻主导选举的候选人的编号。
 *          在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 * link : https://leetcode-cn.com/problems/online-election
 * Level : Medium
 */

public class Leetcode911 {
    int[] persons;
    int[] times;
    int[] res;
    public Leetcode911(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        int n = times.length;
        res = new int[n];
        Map<Integer, Inner> map = new HashMap<>();
        for (int i = 0; i < persons.length; ++i) {
            if(map.containsKey(persons[i])){
                Inner inner = map.get(persons[i]);
                inner.setTickets(inner.getTickets()+1);
                inner.setLast(i);
            } else {
                map.put(persons[i], new Inner(persons[i],1, i));
            }
            int max = 0, last = 0, id = -1;
            for (Inner inner : map.values()) {
                if(inner.tickets > max) {
                    id = inner.id;
                    max = inner.tickets;
                    last = inner.isLast;
                }else if(inner.tickets == max){
                    if(inner.isLast > last){
                        id = inner.id;
                        last = inner.isLast;
                    }
                }
            }
            res[i] = id;
        }
        System.out.println(Arrays.toString(res));
    }


    //[0,1, 1, 0, 0, 1, 0]
    //[0,5,10,15,20,25,30]

    //[3],[12],[25],[15],[24],[8]
    // 0,   1,   1,  0,   0,  1
    public int q(int t) {
        if(t == 0 || t < times[0]) return 0;
        if(t > times[times.length -1 ]) {
            t = times[times.length-1];
        }
        int left = 0, right = times.length;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if(times[mid] < t){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        if(times[left] > t && left > 0) {
            return res[left -1];
        }
        return res[left];
    }


    public static void main(String[] args) {
        int[] aa = {0,1,1,0,0,1,0};
        int[] bb = {0,5,10,15,20,25,30};
        Leetcode911 obj = new Leetcode911(aa, bb);
        System.out.println(obj.q(3));
        System.out.println(obj.q(12));
        System.out.println(obj.q(25));
        System.out.println(obj.q(15));
        System.out.println(obj.q(24));
        System.out.println(obj.q(8));
        System.out.println(obj.q(100));
    }

}

class Inner{
    int id;
    int tickets;
    int isLast;
    public Inner(int id, int tickets, int isLast){
        this.id = id;
        this.tickets = tickets;
        this.isLast = isLast;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int isLast() {
        return isLast;
    }

    public void setLast(int last) {
        isLast = last;
    }
}
