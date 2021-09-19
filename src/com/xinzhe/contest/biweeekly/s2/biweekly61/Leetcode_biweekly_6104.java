package com.xinzhe.contest.biweeekly.s2.biweekly61;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/09/18
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6104 {
    public static void main(String[] args) {
        Leetcode_biweekly_6104 lc = new Leetcode_biweekly_6104();

    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int st=  0;
        int r = n;

        int dis = 0;
        Map<Integer,Integer> mp = new HashMap<>();

        for(int j=0;j<nums.length;++j){
            int fst = nums[j] - (n-1);

            int u = mp.getOrDefault(nums[j],0);
            if(u==0){
                mp.put(nums[j],1);
                dis++;
            }else{
                mp.put(nums[j],1+u);
            }

            while(st<j&&nums[st]<fst){

                int u1 = mp.getOrDefault(nums[st],0);
                if(u1==1){
                    mp.remove(nums[st]);
                    dis--;
                }else{
                    mp.put(nums[st],u1-1);
                }

                st++;
            }

            r = Math.min(r, n-dis);
        }
        return r;
    }

}