package com.xinzhe.contest.weekly.season05.weekly230;

import java.util.List;

/**
 * @author Xin
 * @date 2021/02/28
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23001 {
    public static void main(String[] args) {
        Leetcode_weekly_23001 lc = new Leetcode_weekly_23001();
    }
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        List<String> list = List.of("type","color" , "name");
        int index = list.indexOf(ruleKey);
        int count = 0;
        for (List<String> item : items) {
            if(item.get(index).equals(ruleValue)) count++;
        }
        return count;
    }
}
