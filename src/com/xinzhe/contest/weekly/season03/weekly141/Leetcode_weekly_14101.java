package com.xinzhe.contest.weekly.season03.weekly141;

/**
 * @author Xin
 * @date 2020/8/20
 * Title : 1089. 复写零
 * Description : 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *              注意：请不要在超过该数组长度的位置写入元素。 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * link : https://leetcode-cn.com/problems/duplicate-zeros
 * Level :
 */

public class Leetcode_weekly_14101 {
    public static void main(String[] args) {
        Leetcode_weekly_14101 lc = new Leetcode_weekly_14101();
    }
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++) {
            if(arr[i] == 0) {
                for(int j = n-1; j> i; j--) {
                    arr[j] = arr[j-1];
                }
                i++;
            }

        }
    }
}
