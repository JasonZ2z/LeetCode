package com.xinzhe.categories.test;

public class testHashMap {
    public static void main(String[] args) {
        String s = "RLLLLRRRLR";
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        if("".equals(s) || s.length() == 1) return 0;
        int count = 1;
        int result = 0;
        char tmp = s.charAt(0);
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == tmp) {
                count++;
            } else {
                count -= 1;
            }
            if(count == 0){
                result++;
            }
        }
        return result;
    }

    public String toLowerCase(String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                c = (char) (c + 32);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
