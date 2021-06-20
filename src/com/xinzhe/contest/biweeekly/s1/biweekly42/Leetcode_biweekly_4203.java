package com.xinzhe.contest.biweeekly.s1.biweekly42;

/**
 * @author Xin
 * @date 2020/12/26
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4203 {
    public static void main(String[] args) {
        Leetcode_biweekly_4203 lc = new Leetcode_biweekly_4203();
        int[] arr = {2, 4, 9, 3};
        System.out.println(lc.maximumBinaryString("101010111011001101000110010001100001111"));
    }
    public String maximumBinaryString(String binary) {
        if(binary.length() < 2) return binary;
        if(binary.startsWith("0")) {
            int x = 0, y = 0;
            for (char c : binary.toCharArray()) {
                if(c == '1') x++;
                else y++;
            }
            if(y < 2) return binary;

            return "1".repeat(y - 1) + "0" + "1".repeat(x);
        } else {
            int c = 0;
            for (int i = 0; i < binary.length(); ++i) {
                if(binary.charAt(i) == '1') {
                    c++;
                } else {
                    break;
                }
            }
            return "1".repeat(c)  + maximumBinaryString(binary.substring(c));
        }

    }
}