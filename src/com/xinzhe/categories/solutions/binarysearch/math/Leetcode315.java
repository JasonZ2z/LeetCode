package com.xinzhe.categories.solutions.binarysearch.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/4/24
 * Title : 面试题51. 数组中的逆序对
 * Description : 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * link : https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * Level : Hard
 */
//todo need to review
public class Leetcode315 {
    int[] count;
    int[] indexes;
    int[] tmp;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if(n == 0) return res;
        count = new int[n];
        indexes = new int[n];
        tmp = new int[n];

        for (int i = 0; i < n; ++i) {
            indexes[i] = i;
        }
        merge(nums, 0, n-1);
        for (int i = 0; i < n; ++i) {
            res.add(count[i]);
        }
        return res;
    }

    private void merge(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            merge(nums, left, mid);
            merge(nums, mid+1, right);
            if(nums[indexes[mid]] > nums[indexes[mid+1]]) {
                combine(nums, left, mid, right);
            }
        }
    }

    private void combine(int[] nums, int left, int mid, int right) {
        if (right + 1 - left >= 0) System.arraycopy(indexes, left, tmp, left, right + 1 - left);
        int i = left, j = mid+1;
        for (int index = left; index <= right; ++index) {
            if (j > right) {
                indexes[index] = tmp[i++];
                count[indexes[index]] += right - mid;
            } else if (i > mid) {
                indexes[index] = tmp[j++];
            }else if(nums[tmp[i]] <= nums[tmp[j]] ) {
                indexes[index] = tmp[i++];
                count[indexes[index]] += j - mid - 1;
            } else {
                indexes[index] = tmp[j++];
            }
        }
    }

    public static void main(String[] args) {
        Leetcode315 lc = new Leetcode315();
        int[] arr = {1,9,7,8,5};
        System.out.println(lc.countSmaller(arr));
    }
}
