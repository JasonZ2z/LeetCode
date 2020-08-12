package com.xinzhe.order.day06;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/3/22 9:10
 * Title : 945. 使数组唯一的最小增量
 * Description : 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *              返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * link : https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 * Level : Medium
 */

    // 3 3 4 4 5 5 7
    // 3 4 5 6 7 8 9
    // 0 1 1 2 2 3 2 = 11
    // 3 6 4 8 5 9 7
    // 0 3 0 4 0 4 0 = 11



public class Leetcode945 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4,5,6,6,7,8,2,7,8,4,7,3,6,6,3,5,7,10,22,13};
        //System.out.println(minIncrementForUnique(arr));
        System.out.println(minIncrementForUnique2(arr));
    }
    static int[] pos = new int[80000];
    public static int minIncrementForUnique2(int[] A){
        Arrays.fill(pos, -1);
        int count = 0;
        for (int i : A) {
            int dest = findPos(i);
            count += dest - i;
        }
        return count;
    }

    private static int findPos(int i) {
        int dest = pos[i];
        if(dest == -1){
            pos[i] = i;
            return i;

        }
        dest = findPos(dest + 1);
        pos[i] = dest;
        return dest;
    }

    //排序+计数
    public static int minIncrementForUnique(int[] A) {
        if (A.length <= 1) return 0;
        Arrays.sort(A);
        int count = 0;
        for (int i=1; i<A.length; i++) {
            if(A[i] <= A[i-1]){
                int tmp = A[i];
                A[i] = A[i-1] +1;
                count += A[i] - tmp;
            }
        }
        return count;
    }
}
