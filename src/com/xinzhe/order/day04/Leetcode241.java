package com.xinzhe.order.day04;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/2/28 14:41
 * Title : 241. 为运算表达式设计优先级
 * Description : 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 *              你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *  输入: "2-1-1"
 *  输出: [0, 2]
 *  解释:
 *      ((2-1)-1) = 0
 *      (2-(1-1)) = 2
 * link : https://leetcode-cn.com/problems/different-ways-to-add-parentheses
 * Level : Medium
 */

//Todo need to review
public class Leetcode241 {
    public static void main(String[] args) {
        String s1 = "2-1-1";
        String s2 = "2*3-4*5";
        System.out.println(Arrays.toString(s2.split("[+\\-*]")));
        //System.out.println(diffWaysToCompute(s1).toString());
    }
    //记录已经计算出来的字符串对应的值，避免重复计算。
    private Map<String, List<Integer>> map = new HashMap<>();

    // 递归求解前一半的值和后一半的值，然后根据运算符号，计算两者构成的值。
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)){
           return map.get(input);
        }
        List<Integer> list = new ArrayList<>();
        if(input == null || input.length() ==0 ) return list;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c){
                            case '+':
                                list.add(l+r);
                                break;
                            case '-':
                                list.add(l-r);
                                break;
                            case '*' :
                                list.add(l*r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }

        }
        if(list.size() == 0) {
            list.add(Integer.valueOf(input));
        }
        map.put(input,list);
        return list;
    }
}
