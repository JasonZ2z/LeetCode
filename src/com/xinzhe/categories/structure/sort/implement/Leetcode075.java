package com.xinzhe.categories.structure.sort.implement;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/10/7
 * Title : 75. 颜色分类
 * Description : 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *              此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * link : https://leetcode-cn.com/problems/sort-colors
 * Level : Medium
 */
//todo need to review
public class Leetcode075 {
    public static void main(String[] args) {
        Leetcode075 lc = new Leetcode075();
        int[] arr  = {2};
        lc.sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p=0, q = n-1, i = 0;
        while (i <= q) {
            if(nums[i] == 1) i++;
            else if(nums[i] == 0) {
                if(i == p) {
                    i++;
                } else {
                    swap(nums, i, p);
                }
                p++;
            } else {
                swap(nums, i, q);
                q--;
            }

        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
