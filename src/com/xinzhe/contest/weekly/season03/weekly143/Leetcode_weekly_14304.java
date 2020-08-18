package com.xinzhe.contest.weekly.season03.weekly143;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/18
 * Title : 1106. 解析布尔表达式
 * Description : 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。有效的表达式需遵循以下约定：
 *          "t"，运算结果为 True  "f"，运算结果为 False
 *          "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 *          "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 *          "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 * link : https://leetcode-cn.com/problems/parsing-a-boolean-expression
 * Level : Hard
 */

public class Leetcode_weekly_14304 {
    public static void main(String[] args) {
        Leetcode_weekly_14304 lc = new Leetcode_weekly_14304();
        String s = "!(&(!(t),&(f),|(f)))";
        System.out.println(lc.parseBoolExpr(s));
    }
    public boolean parseBoolExpr(String s) {
        if(s.length() == 1) return "t".equals(s);
        if(s.charAt(0) == '!')  return !parseBoolExpr(s.substring(2, s.length()-1));
        boolean flag = s.charAt(0) == '&';
        List<String> params = helper(s.substring(2, s.length()-1));
        if(flag){
            for (String param : params) {
                if(!parseBoolExpr(param)) return false;
            }
        } else {
            for (String param : params) {
                if(parseBoolExpr(param)) return true;
            }
        }
        return flag;
    }

    private List<String> helper(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        int count = 0, start = 0, i= 0;
        while (i < s.length()) {
            if(Character.isLetter(arr[i]) && count == 0) {
                res.add(String.valueOf(arr[i]));
                start = i+2;
            }
            else if(arr[i] == '(') count++;
            else if(arr[i] == ')') {
                count--;
                if(count == 0 && (i+1 == s.length() || arr[i+1] == ',')) {
                    res.add(s.substring(start, i+1));
                    start = i+2;
                }
            }
            i++;
        }
        return res;
    }
}
