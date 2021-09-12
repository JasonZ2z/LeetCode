package com.xinzhe.contest.lccup.lc2021.solo.summer;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/9/11
 * Title :
 * Description : 
 * link :
 */
public class LCP_2102 {
    public static void main(String[] args) {
        LCP_2102 lcp_2102 = new LCP_2102();
//        int[] arr = {2,2,8,8,9};
//        int[] arr = {1,2,8,9,9};
//        int[] arr = {3,3,1};
        int[] arr = {3,3,1,1,4};
        System.out.println(lcp_2102.maxmiumScore(arr, 2));
        System.out.println(lcp_2102.maxmiumScore2(arr, 2));
    }

    int[] cards;
    Integer[][][] dp;
    public int maxmiumScore(int[] cards, int cnt) {
        int n = cards.length;
        Arrays.sort(cards);
        this.cards = cards;
        dp = new Integer[n + 1][cnt + 1][2];
        return score(n, cnt, 0);
    }

    public int score(int end, int cnt, int flag){
        if(end < cnt || end < 1 ||cnt == 0) return 0;
        if(dp[end][cnt][flag] != null) return dp[end][cnt][flag];
        int sum = 0;
        if(cnt == 1) {
            for (int i = end - 1; i >= 0; --i) {
                if(cards[i] % 2 == flag) {
                    sum = cards[i];
                    break;
                }
            }
            dp[end][1][flag] = sum;
            return sum;
        }
        if(cards[end - 1] % 2 == flag) {
            sum = Math.max(score(end-1, cnt-1, 0) + cards[end - 1], score(end-1, cnt, flag));
        } else {
            sum = Math.max(score(end-1, cnt-1, 1) + cards[end - 1], score(end-1, cnt, flag));
        }
        dp[end][cnt][flag] = sum;
        return sum;
    }


    public int maxmiumScore2(int[] cards, int cnt) {
        int n = cards.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        Arrays.sort(cards);
        int oddsum = 0, evensum = 0;
        for (int card : cards) {
            if(card % 2 == 1) {
                oddsum++;
            } else {
                evensum++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if(cards[i] % 2 == 1) {
                odd[i] = oddsum--;
                even[i] = evensum;
            } else {
                even[i] = evensum--;
                odd[i] = oddsum;
            }
        }
        int max = 0;
        for(int i = n-1; i + 1 >= cnt && cnt > 0; --i) {
            if(max % 2 == cards[i] % 2) {
                if(even[i] >= cnt || ((cnt - even[i]) % 2 == 0 && cnt - even[i] <= odd[i])){
                    max += cards[i];
                    cnt--;
                }
            } else {
                if(odd[i] > 1 && (1 + even[i] >= cnt || (cnt - even[i] - 1) % 2 == 1)){
                    max += cards[i];
                    cnt--;
                }
            }
        }
        return cnt == 0 ? max : 0;
    }
}
