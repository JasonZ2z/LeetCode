package com.xinzhe.contest.nowcoder.s1.s106;

/**
 * @Author Xin
 * @create 2020/7/25
 * Title :
 * Description :
 * link :
 * Level :
 */
public class nowcoder_0602 {
    public static void main(String[] args) {
        nowcoder_0602 nc = new nowcoder_0602();
        System.out.println(nc.rotateRight("10110", 2));
    }

    public long rotateRight (String str, int k) {
        // write code here
        int n = str.length();
        String s = str.substring(n-k,n);
        String a = str.substring(0, n-k);
        String b = s + a;

        long total=0;
        char [] binCharArray=b.toCharArray();
        for (int i = 0; i < binCharArray.length; i++) {
            total=total+binCharArray[i]-48;
            if(i!=binCharArray.length-1){
                total=total<<1;
            }
        }
        return total;
    }
}
