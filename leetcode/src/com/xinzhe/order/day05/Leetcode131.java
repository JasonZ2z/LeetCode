package com.xinzhe.order.day05;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/10 18:15
 * Title : 131. 分割回文串
 * Description : 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 *      示例:
 *      输入: "aab"
 *  输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * link : https://leetcode-cn.com/problems/palindrome-partitioning
 * Level : Medium
 */
public class Leetcode131 {
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s){
        char[] arr = s.toCharArray();
        bfs(arr, new ArrayList<>(), 0);
        return result;
    }

    private void bfs(char[] arr, ArrayList<String> track, int start) {
        if(start == arr.length){
            result.add(new ArrayList<>(track));
            return;
        }
        if(start > arr.length) return;
        for (int i = start; i < arr.length; i++) {
            if(helper(arr, start,i)){
                track.add(generateString(arr, start,i));
                bfs(arr, track, i+1);
                track.remove(track.size()-1);
            }
        }
    }
    private String generateString(char[] arr, int left, int right){
        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right ; i++) {
            sb.append(arr[i]);

        }
        return sb.toString();
    }

    private boolean helper(char[] arr, int left, int right){
        while(left < right){
            if(arr[left++] != arr[right--]){
                return false;
            }
        }
        return true;
    }
}
