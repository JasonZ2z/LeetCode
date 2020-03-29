package com.xinzhe.categories.dp;

/**
 * @Author Xin
 * @create 2020/3/16 18:11
 * Title : 91. 解码方法
 * Description : 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * link : https://leetcode-cn.com/problems/decode-ways
 * Level : Medium
 */
public class Leetcode091 {
    public static void main(String[] args) {
        String s = "110";
        System.out.println(numDecodings(s));
        System.out.println(numDecodings2(s));
        System.out.println(numDecodings3(s));
    }

    public static int numDecodings4(String s) {
        int n = s.length();
        if(n == 0) return 0;
        if(s.startsWith("0")) return 0;
        if(n == 1) return 1;
        char[] arr = s.toCharArray();
        int pre = 1, cur =1;
        for (int i = 1; i < n; i++) {
            int tmp = cur;
            if(arr[i] == '0'){
                if(arr[i-1] == '1' || arr[i-1] == '2'){
                    cur = pre;
                }else {
                    return 0;
                }
            } else if(arr[i-1] == '1' || (arr[i-1] == '2' && arr[i] >= '1' && arr[i] <= '6')){
                cur = cur+ pre;
            }
            pre = tmp;
        }
        return cur;
    }
    public static int numDecodings3(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        if(n == 1) return 1;
        s = " " + s;
        char[] arr = s.toCharArray();
        int[] dp = new int[n+1];
        dp[0] = dp[1] =1;
        for (int i = 2; i <= n; i++) {
            if(arr[i] != '0'){
                dp[i] = dp[i-1];
            }
            int t = (arr[i-1] - 48) * 10 + (arr[i] - 48);
            if(t >= 10 && t<= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];

    }

    public static int numDecodings2(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        if(n == 1) return 1;
        char[] arr = s.toCharArray();
        int[] dp = new int[n];
        dp[0] = 1;
        if(arr[1] == '0'){
            dp[1] = 1;
        }else{
            if(((arr[0]- '0' )*10 + (arr[1]- '0')) > 26){
                dp[1] =1;
            }else{
                dp[1] =2;
            }
        }
        for(int i=2; i<n; i++){
            int tmp = (arr[i - 1] - '0') * 10 + (arr[i] - '0');
            if((tmp>0 && tmp<10)|| tmp > 26) dp[i] = dp[i-1];
            else if(tmp == 0){
                return 0;
            } else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n-1];
    }


    // 这道题用逆序最优
    public static int numDecodings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        if(s.startsWith("0")) return 0;
        if(n == 1) return 1;
        char[] chars = s.toCharArray();
        int[] dp = new int[n+1];
        dp[n] = 1;
        if(chars[n-1] == '0') {
            dp[n-1] = 0;
        } else {
            dp[n-1] = 1;
        }
        for (int i = n-2; i >= 0 ; i--) {
            if(chars[i] == '0') continue;
            if(((chars[i] - '0')* 10 + (chars[i+1]- '0') ) > 26) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = dp[i+1] + dp[i+2];
            }
        }
        return dp[0];
    }
}
