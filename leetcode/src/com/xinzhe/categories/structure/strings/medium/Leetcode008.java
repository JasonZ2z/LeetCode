package com.xinzhe.categories.structure.strings.medium;

/**
 * @Author Xin
 * @create 2020/6/16
 * Title : 8. 字符串转换整数 (atoi)
 * Description : 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * link : https://leetcode-cn.com/problems/string-to-integer-atoi/
 * Level : Medium
 */
public class Leetcode008 {
    public static void main(String[] args) {
        //System.out.println(strToInt("43"));
        //System.out.println(strToInt(" 43"));
        System.out.println(strToInt(" -43"));
        System.out.println(strToInt(" -4300 0"));
    }
    public static int strToInt(String str) {
        if(str == null || str.length() == 0) return 0;
        int n = str.length();
        int start = -1, count = 1;
        char[] arr = str.toCharArray();

        for(int i=0; i<n; ++i){
            if(start > -1) {
                if(Character.isDigit(arr[i])) {
                    count++;
                } else {
                    break;
                }
            } else {
                if(arr[i] != ' '){
                    if(Character.isDigit(arr[i]) || arr[i] == '-' || arr[i] == '+') {
                        start = i;
                    } else {
                        return 0;
                    }
                }
            }
        }
        if(start == -1) return 0;
        if(count == 1) {
            if(arr[start] == '-' || arr[start] == '+') return 0;
            return arr[start] - '0';
        }
        String s = "";
        int flag = 1;
        if(arr[start] == '-' || arr[start] == '+') {
            s = str.substring(start+1, start+count);
        } else {
            s = str.substring(start, start+count);
        }
        if(arr[start] == '-') flag = -1;
        char[] myarr = s.toCharArray();
        long res = 0;
        for(int i=0; i<s.length(); ++i) {
            if(((int)res) != res) {
                return flag > 0 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
            } else {
                res = myarr[i] - '0' + res * 10;
            }
        }
        if(((int)res) != res) {
            return flag > 0 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }
        return flag * ((int)res);

    }
}
