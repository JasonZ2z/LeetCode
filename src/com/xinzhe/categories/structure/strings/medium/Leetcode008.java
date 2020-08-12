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
        //System.out.println(strToInt(" -43"));
        System.out.println(myAtoi("18446744073709551617"));
        //System.out.println(strToInt(" -4300 0"));
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

    public static int myAtoi(String str) {
        int n = str.length();
        char[] arr = str.toCharArray();
        int start = -1;
        int flag = 1;
        for(int i=0; i<n; i++) {
            if(arr[i] >= '0' && arr[i] <= '9') {
                start = i;
                break;
            } else if(arr[i] == '-' || arr[i] == '+') {
                if(i < n-1 && (arr[i+1] >= '0' && arr[i+1] <= '9')) {
                    if(arr[i] == '-') {
                        flag = -1;
                    }
                    start = i+1;
                    break;
                }
            }
        }
        if(start == -1) return 0;
        int end = n;
        for(int i=start; i<n; i++) {
            if(arr[i] < '0' || arr[i] > '9') {
                end = i;
                break;
            }
        }
        long res = 0;
        for(int i=start; i<end; i++) {
            res = res * 10 + Integer.parseInt(String.valueOf(arr[i]));
        }
        if((int)res == res){
            return flag * (int)res;
        } else {
            return flag == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }

    }
}
