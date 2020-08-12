package com.xinzhe.contest.weekly.season04.weekly188;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/10
 * Title : 1442. 形成两个异或相等数组的三元组数目
 * Description : 给你一个整数数组 arr 。现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *      a 和 b 定义如下：
 *          a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 *          b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 *      注意：^ 表示 按位异或 操作。请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 * link : https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_18802 {
    public static void main(String[] args) {
        int[] a = {1,3,5,7,9};
        System.out.println(countTriplets(a));
    }
    public static int countTriplets(int[] arr) {
        int n = arr.length;
        if(n < 3) return 0;
        int count = 0;
        for (int i = 1; i < n; ++i) {
            List<Integer> alist = helperleft(arr, 0, i-1);
            List<Integer> blist = helperright(arr, i, n-1);
            for (int a : alist) {
                for (int b : blist) {
                    if(a == b) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static List<Integer> helperleft(int[] arr, int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        int res = arr[r];
        list.add(res);
        for (int i = r-1; i >= l; --i) {
            res = res^arr[i];
            list.add(res);
        }
        return list;
    }

    private static List<Integer> helperright(int[] arr, int l, int r) {

        ArrayList<Integer> list = new ArrayList<>();
        int res = arr[l];
        list.add(res);
        for (int i = l+1; i <= r; ++i) {
            res = res^arr[i];
            list.add(res);
        }
        return list;
    }


    public int countTriplets2(int[] arr) {
        int[] xor = new int[arr.length + 1];
        xor[0] = 0;
        for(int i = 1; i <= arr.length; i++) xor[i] = (xor[i - 1] ^ arr[i - 1]);
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                for(int k = j; k < arr.length; k++) {
                    if((xor[j] ^ xor[i]) == (xor[k + 1] ^ xor[j])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * a == b  ==>  a ^ b == 0
     * if(arr[i] ^ ... ^ arr[j] == 0) ==> 对于 i -> j 中所有的 k 都符合
     * @param arr
     * @return
     */
    public int countTriplets3(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            int temp = arr[i];
            for(int k = i + 1; k < arr.length; k++){
                temp ^= arr[k];
                if(temp == 0)
                    count += k - i;
            }
        }
        return count;
    }
}
