package com.xinzhe.contest.weekly.season04.weekly183;

/**
 * @author Xin
 * @date 2020/4/5 10:27
 * Title : 1404. 将二进制表示减到 1 的步骤数
 * Description : 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 *              如果当前数字为偶数，则将其除以 2 。
 *              如果当前数字为奇数，则将其加上 1 。
 *              题目保证你总是可以按上述规则将测试用例变为 1 。
 * link : https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one
 * Level : Medium
 * Comment : 183周赛02
 */
public class Leetcode_weekly_18302 {
    public static void main(String[] args) {
        String s = "10";
        System.out.println(numSteps(s));
    }
    public static int numSteps(String s) {
        int n = s.length();
        if(n == 1) return 0;
        char[] arr = s.toCharArray();
        int count =0;
        boolean flag = false;
        for(int i = n-1; i >= 2; --i) {
          if(arr[i] == '1'){
              if(flag){
                  count +=1;
              } else {
                  count += 2;
                  flag = true;
              }
          } else {
              if(flag){
                  count += 2;
                  flag = true;
              } else {
                  count += 1;
              }
          }
        }
        if(arr[1] == '1' ){
            if(flag){
                 count +=2;
            }else {
                count += 3;
            }
        } else {
            if(flag){
                count += 3;
            }else {
                count += 1;
            }
        }
        return count;
    }
}
