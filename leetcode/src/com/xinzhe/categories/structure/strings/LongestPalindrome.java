package com.xinzhe.categories.structure.strings;

import java.util.*;

public class LongestPalindrome {
    private static int[] table = new int[100000000];
    public static void main(String[] args) {

        System.out.println(table.length);
    }

    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1) ) return "";
        if(str1.length() > str2.length()){
            String tmp = str2;
            str2= str1;
            str1 = tmp;
        }
        boolean flag = false;
        for(int i=str1.length(); i>0; i--){
            String substring = str1.substring(0,i);
            StringBuilder sb1= new StringBuilder(substring);
            StringBuilder sb2= new StringBuilder(substring);
            while(sb2.length() < str2.length()){
                sb2.append(substring);
                if(str2.equals(sb2.toString())){
                    flag= true;
                    break;
                }

            }
            while(sb1.length() <= str1.length()){
                if(str1.equals(sb1.toString())){
                    if(flag){
                        return substring;
                    }
                }
                sb1.append(substring);
            }

        }
        return  "";
    }

    private static List<Set<String>> result = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        Set<String> list;
        for (int i = 0; i <= n; i++) {
            list = new HashSet<>();
            if (i == 0) {
                result.add(list);
            } else if (i == 1) {
                list.add("()");
                result.add(list);
            } else if (i >= 2) {
                Set<String> pre = result.get(i - 1);
                for (String s : pre) {
                    s = "(" + s;
                    for (int j = 1; j < s.length(); j++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(s, 0, j).append(")").append(s.substring(j));
                        list.add(sb.toString());
                    }
                }
                result.add(list);
            }

        }
        return new ArrayList<>(result.get(n));
    }
    public static int countBinarySubstrings(String s) {
        int len = s.length();
        int result = 0;
        List<Integer> list= new ArrayList<>();
        int count = 1;
        char pre = s.charAt(0);
        for(int i=1; i<len; i++){
            if(s.charAt(i) == pre){
                count++;
            } else {
                list.add(count);
                count =1;
                pre = s.charAt(i);
            }
        }
        System.out.println(list.toString());
        int start = list.get(0);
        for(int i=1; i<list.size(); i++){
            result += Math.min(start, list.get(i));
            start = list.get(i);
        }
        return result;
    }

    public static String reverseOnlyLetters(String S) {
        if(S == null) return S;
        int len = S.length();
        char[] result = new char[len];
        if(len == 0 || len == 1) return S;
        int i = 0;
        int j = len-1;
       do{
            if(!fun2(S.charAt(i))){
                result[i] = S.charAt(i);
                i++;
                continue;
            }
            if(!fun2(S.charAt(j))){
                result[j] = S.charAt(j);
                j--;
                continue;
            }
            result[i] = S.charAt(j);
            result[j] = S.charAt(i);
            i++;
            j--;
        } while(i<=j);
        return new String(result);
    }
    public static boolean fun2(char c){
        return (c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A');
    }

    public static int fun(String s){
        char cur = s.charAt(0);
        int count = 1;
        for(int i=1; i< s.length(); i++){
            if(s.charAt(i) - cur < 0){
                cur = s.charAt(i);
                count = 1;
            } else if(s.charAt(i) - cur == 0){
                count++;
            }
        }
        return count;
    }
    public static int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0) return 0;
        Set<String> set = new HashSet<>();
        for(String email : emails){
            String[] prefixArray = email.split("@");
            if(prefixArray.length < 2) continue;
            String prefix = prefixArray[0];
            String subString = prefixArray[1];
            String[] addArray = prefix.split("\\+");
            if(addArray.length == 0 || addArray[0] == null || "".equals(addArray[0])) continue;
            String addPrefix = addArray[0];
            String[] dotArray = addArray[0].split("\\.");
            if(dotArray.length == 0) continue;
            StringBuilder sb = new StringBuilder();
            for(String s : dotArray){
                sb.append(s);
            }
            sb.append("@").append(subString);
            set.add(sb.toString());
        }
        return set.size();
    }
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        if(s.length() == 1) return s;
        if(s.length() == 2 ) return s.substring(0,1);
        int len = s.length();
        int[][] dp = new int[len][len];
        int max = 0;
        String result = "";
        for(int i=len-2; i>=0; i--){
            dp[i][i] =1;
            for(int j=i+1; j<len; j++){
                if(isPalind(s.substring(i,j+1))){
                    dp[i][j] = j-i+1;
                    if(dp[i][j] > max){
                        max = dp[i][j];
                        result = s.substring(i,j+1);
                    }
                } else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return result;
    }

    public boolean isPalind(String s){
        if(s == null || s.length() == 0) return false;
        if(s.length() == 1) return true;
        int len = s.length();
        for(int i=0; i< len/2; i++){
            if(s.charAt(i) != s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }

    public static int magicalString(int n) {
        if(n <= 0) return 0;
        if(n <=2) return 1;
        int count = 0;
        StringBuilder sb = new StringBuilder("122");
        for(int i = 2; i<n; i++){
            int k = sb.charAt(i) == '1' ? 2 : 1;
            sb.append((k + "").repeat(Math.max(0, sb.charAt(i) - '0')));
        }
        System.out.println(sb.toString());
        for(int i = 0; i < n; i++){
            if(sb.charAt(i) == '1')
                count++;
        }
        return count;
    }
}
