package com.xinzhe.top100.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/3/4 18:55
 * Title : 93. 复原IP地址
 * Description : 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * link : https://leetcode-cn.com/problems/restore-ip-addresses/
 * Level : Medium
 */

// todo
public class Leetcode093 {
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s).toString());
        System.out.println(restoreIpAddresses2(s).toString());
    }
    //暴力
    public static List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() < 4) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        StringBuilder sb;
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int l = 1; l < 4; l++) {
                        if(i+j+k+l == s.length()){
                            int a = Integer.parseInt(s.substring(0, i));
                            int b = Integer.parseInt(s.substring(i,i+j));
                            int c = Integer.parseInt(s.substring(i+j,i+k+j));
                            int d = Integer.parseInt(s.substring(i+k+j));
                            if(a<=255 && b<= 255 && c<=255 && d<= 255){
                                sb = new StringBuilder();
                                sb.append(a).append(".").append(b).append(".").append(c).append(".").append(d);
                                if(sb.length() == s.length() +3){
                                    list.add(sb.toString());
                                }
                            }

                        }
                    }
                }
            }
        }
        return list;
    }

    //回溯
    private static List<String> result = new ArrayList<>();
    public  static List<String> restoreIpAddresses2(String s){
        if(s == null || s.length() < 4 || s.length() > 12) return new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return result;
    }

    private static void dfs(String s, int start, ArrayList<String> track) {
        if(track.size() == 4) {
            int len = track.stream().mapToInt(String::length).sum();
            if(len == s.length()){
                result.add(String.join(".", new ArrayList<>(track)));
                return;
            }
        }
        if(track.size() > 4 ) return;

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '0'){
                track.add(String.valueOf(c));
                dfs(s, i+1, track);
                track.remove(track.size()-1);
            }else {
                for (int j = 1; j <= 3; j++) {
                    if(i+j > s.length()) return;
                    String tmp = s.substring(i, i+j);
                    if(Integer.parseInt(tmp) <= 255){
                        track.add(tmp);
                        dfs(s, i+j, track);
                        track.remove(track.size()-1);
                    }
                }
            }

        }
    }


}
