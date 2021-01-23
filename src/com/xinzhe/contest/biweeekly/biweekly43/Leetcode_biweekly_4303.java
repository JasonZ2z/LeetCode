package com.xinzhe.contest.biweeekly.biweekly43;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/01/09
 * Title : 1718. 构建字典序最大的可行序列
 * Description : 给你一个整数n，请你找到满足下面条件的一个序列：
 *              整数1在序列中只出现一次。
 *              2到n之间每个整数都恰好出现两次。
 *              对于每个2到n之间的整数i，两个i之间出现的距离恰好为i。
 *              序列里面两个数 a[i]和 a[j]之间的 距离，我们定义为它们下标绝对值之差|j - i|。请你返回满足上述条件中字典序最大的序列。题目保证在给定限制条件下，一定存在解。
 *              一个序列a被认为比序列b（两者长度相同）字典序更大的条件是：a 和b中第一个不一样的数字处，a序列的数字比b序列的数字大。比方说，[0,1,9,0]比[0,1,5,6]字典序更大，因为第一个不同的位置是第三个数字，且9比5大。
 * link :  https://leetcode-cn.com/problems/construct-the-lexicographically-largest-valid-sequence
 * Level : Medium
 */

//todo undo
public class Leetcode_biweekly_4303 {
    public static void main(String[] args) {
        Leetcode_biweekly_4303 lc = new Leetcode_biweekly_4303();
        System.out.println(Arrays.toString(lc.constructDistancedSequence(5)));
    }
    int[] res;
    public int[] constructDistancedSequence(int n) {
        if(n == 1) return new int[]{1};
        int len = 1 + (n - 1) * 2;
        this.res = new int[len];
        helper(n, new int[len]);
        return res;
    }

    private boolean helper(int n, int[] arr) {
        if(n == 1) {
            int index = 0;
            for (int i = 0; i < arr.length; ++i) {
                if(arr[i] == 0) {
                    index = i;
                    arr[index] = 1;
                }
            }
            for (int i = 0; i < arr.length; ++i) {
                if(arr[i] < res[i]) {
                    arr[index] = 0;
                    return false;
                } else if(arr[i] > res[i]){
                    System.arraycopy(arr, 0, res, 0, arr.length);
                    return true;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0 && i + n < arr.length && arr[i + n] == 0) {
                arr[i] = n;
                arr[i + n] = n;
                if(helper(n-1, arr)) {
                    return true;
                } else {
                    arr[i] = 0;
                    arr[i + n] = 0;
                }

            }
        }
        return false;
    }
}