package com.xinzhe.order.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/4/25 14:56
 * Title : LCP 14. 切分数组
 * Description : 给定一个整数数组 nums ，小李想将 nums 切割成若干个非空子数组，使得每个子数组最左边的数和最右边的数的最大公约数大于 1 。为
 *              了减少他的工作量，请求出最少可以切成多少个子数组。
 * link : https://leetcode-cn.com/problems/qie-fen-shu-zu
 * Level : Hard
 * Comment 2020-spring-group-03
 */

//todo undo
public class Leetcode_Group_02 {
    public static void main(String[] args) {
        Leetcode_Group_02 lt = new Leetcode_Group_02();
        int[] arr = {2,3,3,2,3,3};
        System.out.println(lt.splitArray(arr));
    }
    public int splitArray(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        if(n == 2) {
            if(gcd(nums[0], nums[1]) > 1) {
                return 1;
            }else return 2;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int i = n-1; i > 0; --i) {
            if(gcd(nums[0], nums[i]) > 1) {
                right.add(i);
            }
        }

        for (int i = 0; i < n-1; ++i) {
            if(gcd(nums[n-1], nums[i]) > 1) {
               left.add(i);
            }
        }
        int lsize = left.size();
        int rsize = right.size();
        if(lsize == 0 && rsize == 0) return n;
        if(lsize == 0) return n-right.get(0);
        if(rsize == 0) return left.get(0)+1;
        if(left.get(lsize-1) < right.get(rsize-1)) {
            int[] tmp = new int[right.get(rsize-1) - left.get(lsize-1) + 1];
            System.arraycopy(nums, left.get(lsize-1), tmp, 0, right.get(rsize-1) - left.get(lsize-1) + 1);
            return 2 + splitArray(tmp);
        }

        return Math.min(n-right.get(0), left.get(0)+1);
    }

    public int gcd(int m, int n) {
        int result;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }
}
