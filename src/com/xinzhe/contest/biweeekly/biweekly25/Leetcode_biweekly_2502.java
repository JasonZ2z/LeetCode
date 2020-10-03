package com.xinzhe.contest.biweeekly.biweekly25;

/**
 * @author Xin
 * @date 2020/5/2
 * Title : 1432. 改变一个整数能得到的最大差值
 * Description : 给你一个整数 num 。你可以对它进行如下步骤恰好 两次 ：
 *              选择一个数字 x (0 <= x <= 9).
 *              选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
 *              将 num 中所有出现 x 的数位都用 y 替换。
 *              得到的新的整数 不能 有前导 0 ，得到的新整数也 不能 是 0 。
 *              令两次对 num 的操作得到的结果分别为 a 和 b 。
 *              请你返回 a 和 b 的 最大差值 。
 * link : https://leetcode-cn.com/problems/max-difference-you-can-get-from-changing-an-integer
 * Level : Medium
 */
public class Leetcode_biweekly_2502 {
    public static void main(String[] args) {
       // System.out.println(maxDiff(555));
        System.out.println(maxDiff(1101057));
        //System.out.println(maxDiff(1000));
        //System.out.println(maxDiff(9288));
    }
    public static int maxDiff(int num) {
        int copy = num;
        int n = String.valueOf(num).length();
        int[] arr = new int[n];
        for(int i = n-1; i >= 0; --i) {
            arr[i] = copy % 10;
            copy /= 10;
        }

        int[] min = new int[n];
        int[] max = new int[n];
        if(arr[0] == 1) {
            int tmp = 0;
            min[0] = 1;
            for (int i = 1; i < n; ++i) {
                if(arr[i] != 1 && arr[i] != 0) {
                    tmp = arr[i];
                    break;
                }
            }
            for (int i = 1; i < n; ++i) {
                if(arr[i] == tmp) {
                    min[i] = 0;
                } else {
                    min[i] = arr[i];
                }
            }
            for (int i = 0; i < n; ++i) {
                if(arr[i] == 1) {
                    max[i] = 9;
                }else {
                    max[i] = arr[i];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                sb.append(max[i] - min[i]);
            }
            return Integer.parseInt(sb.toString());
        } else if(arr[0] == 9){
            int tmp = 0;
            max[0] = 9;
            for (int i = 1; i < n; ++i) {
                if(arr[i] != 9) {
                    tmp = arr[i];
                    break;
                }
            }
            for (int i = 1; i < n; ++i) {
                if(arr[i] == tmp) {
                    max[i] = 9;
                }else {
                    max[i] = arr[i];
                }
            }
            for (int i = 0; i < n; ++i) {
                if(arr[i] == 9) {
                    min[i] = 1;
                }else {
                    min[i] = arr[i];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                sb.append(max[i] - min[i]);
            }
            return Integer.parseInt(sb.toString());


        } else {
            int tmp = arr[0];
            for (int i = 0; i < n; ++i) {
                if(arr[i] == tmp) {
                    max[i] = 9;
                }else {
                    max[i] = arr[i];
                }
            }
            for (int i = 0; i < n; ++i) {
                if(arr[i] == tmp) {
                    min[i] = 1;
                }else {
                    min[i] = arr[i];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                sb.append(max[i] - min[i]);
            }
            return Integer.parseInt(sb.toString());
        }


    }
}
