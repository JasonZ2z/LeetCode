package com.xinzhe.categories.structure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/12 16:54
 * Title : 969. 煎饼排序
 * Description : 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
 *
 * 返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
 * link : https://leetcode-cn.com/problems/pancake-sorting
 * Level : Medium
 */
public class PancakeSort {
    public static void main(String[] args) {
        int[] arr = {3,2,4,1};
        System.out.println(pancakeSort(arr));
    }
    //Origin:   2 4 1 5 3
    //Sorted:   1 2 3 4 5
    //1:        5 1 4 2 3 -> 3 2 4 1 5      [4, 5]
    //2:        4 2 3 1 5 -> 1 3 2 4 5      [3, 4]
    //3:        3 1 2 4 5 -> 2 1 3 4 5      [2, 3]
    //4:        1 2 3 4 5                   [2]
    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();
        int[] arr = Arrays.stream(A).boxed().sorted().mapToInt(Integer::intValue).toArray();
        int n = A.length;
        while (n > 0){
            for (int i = 0; i < n; i++) {
                int value = arr[n-1];
                if(A[i] == value){
                    if(i != 0){
                        flip(A, i+1);
                        list.add(i+1);
                        flip(A, n);
                        list.add(n);
                        break;
                    } else {
                        if(A[i] == arr[0]){
                            break;
                        }
                        flip(A, n);
                        list.add(n);
                        break;
                    }
                }
            }
            n--;
        }
        return list;
    }
    // Origin:  3 2 4 1
    // 1:       4 2 3 1 -> 1 3 2 4
    //          3 1 2 4 -> 2 1 3 4
    // 2:       1 2 3 4
    //3 4 2 3 2
    private static void flip (int[] arr, int k){
        for (int i = 0; i < k / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[k-i-1];
            arr[k-i-1] = tmp;
        }
    }
}
