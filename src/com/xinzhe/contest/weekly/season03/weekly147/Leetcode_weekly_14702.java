package com.xinzhe.contest.weekly.season03.weekly147;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/9/28
 * Title :
 * Description :
 * link :
 * Level : Easy
 */

public class Leetcode_weekly_14702 {
    private Map<Character, int[]> map = new HashMap<Character, int[]>(){
        {
            put('a', new int[]{0,0});
            put('b', new int[]{0,1});
            put('c', new int[]{0,2});
            put('d', new int[]{0,3});
            put('e', new int[]{0,4});
            put('f', new int[]{1,0});
            put('g', new int[]{1,1});
            put('h', new int[]{1,2});
            put('i', new int[]{1,3});
            put('j', new int[]{1,4});
            put('k', new int[]{2,0});
            put('l', new int[]{2,1});
            put('m', new int[]{2,2});
            put('n', new int[]{2,3});
            put('o', new int[]{2,4});
            put('p', new int[]{3,0});
            put('q', new int[]{3,1});
            put('r', new int[]{3,2});
            put('s', new int[]{3,3});
            put('t', new int[]{3,4});
            put('u', new int[]{4,0});
            put('v', new int[]{4,1});
            put('w', new int[]{4,2});
            put('x', new int[]{4,3});
            put('y', new int[]{4,4});
            put('z', new int[]{5,0});
        }
    };
    StringBuilder sb = new StringBuilder();
    public String alphabetBoardPath(String target) {

        char[] arr = target.toCharArray();
        int[] before = new int[]{0,0};
        int[] after;
        for (char c : arr) {
            after = map.get(c);
            getPath(before, after);
            before = after;
        }
        return sb.toString();
    }

    private void getPath(int[] before, int[] after) {
        int yNum = after[0] - before[0];
        int xNum = after[1] - before[1];
        if (yNum < 0) {
            getYPath(yNum);
            getXPath(xNum);
        } else {
            getXPath(xNum);
            getYPath(yNum);
        }
        sb.append('!');
    }

    private void getXPath(int num) {
        char str;
        if (num > 0) {
            str = 'R';
        } else {
            num = 0 - num;
            str = 'L';
        }
        sb.append(String.valueOf(str).repeat(Math.max(0, num)));
    }

    private void getYPath(int num) {
        char str;
        if (num > 0) {
            str = 'D';
        } else {
            num = 0 - num;
            str = 'U';
        }
        sb.append(String.valueOf(str).repeat(Math.max(0, num)));
    }
}
