package com.xinzhe.categories.solutions.binarysearch.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Xin
 * @create 2020/4/13 18:38
 * Title : 658. 找到 K 个最接近的元素
 * Description : 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 * link : https://leetcode-cn.com/problems/find-k-closest-elements
 * Level : Medium
 */

public class Leetcode658 {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3,4,5,6,7,8,9,12,14,56,67,100,177777};
        System.out.println(findClosestElements(arr, 10,32));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        if(n == 1) return Arrays.asList(arr[0]);
        List<Integer> res = new ArrayList<>();
        Arrays.sort(arr);

        if(x <= arr[0]) {
            for (int i = 0; i < k; ++i) {
                res.add(arr[i]);
            }
            return res;
        }
        if(x >= arr[n-1]){
            for (int i = n-k; i < n; ++i) {
                res.add(arr[i]);
            }
            return res;
        }

        int pre = 0, cur = 0, post = 0;
        for (int i = 0; i < n; ++i) {
            if(arr[i] < x){
                pre = i;
            }else if(arr[i] == x){
                cur = i;
                break;
            } else {
                post = i;
                break;
            }
        }
        if(cur != 0){
            int left = cur-1, right = cur+1;
            k -= 1;
            res.add(arr[cur]);
            while ( k > 0){
                int leftTmp = Integer.MAX_VALUE, rightTmp = Integer.MAX_VALUE;
                if(left >= 0 )  leftTmp = arr[cur] - arr[left];
                if(right < n)  rightTmp = arr[right] - arr[cur];
                if(leftTmp <=  rightTmp){
                    res.add(arr[left]);
                    left--;
                } else {
                    res.add(arr[right]);
                    right++;
                }
                k--;
            }
        } else {
            int left = pre, right = post;
            while ( k > 0){
                int leftTmp = Integer.MAX_VALUE, rightTmp = Integer.MAX_VALUE;
                if(left >= 0 )  leftTmp = x - arr[left];
                if(right < n)  rightTmp = arr[right] - x;
                if(leftTmp <=  rightTmp){
                    res.add(arr[left]);
                    left--;
                } else {
                    res.add(arr[right]);
                    right++;
                }
                k--;
            }
        }
        res.sort(Integer::compareTo);
        return res;

    }

    public List<Integer> findClosestElements2(int[] nums, int k, int target) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        if(target <= nums[0]){
            for(int i =0; i<k; ++i){
                res.add(nums[i]);
            }
            return res;
        }
        if(target >= nums[n-1]){
            for(int i = n-k; i<n; ++i){
                res.add(nums[i]);
            }
            return res;
        }
        // 1,2,4,5,6,7
        int left = 0, right = n-1;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(nums[left] == target){
            res.add(target);
            k -= 1;
            int p = left -1, q = left + 1;
            while(k > 0){
                if(p >= 0 && q < n){
                    if(target - nums[p] <= nums[q] - target){
                        res.add(nums[p--]);
                    } else {
                        res.add(nums[q++]);
                    }
                } else if(p >= 0){
                    res.add(nums[p--]);
                } else {
                    res.add(nums[q++]);
                }
                k--;
            }
        } else {
            int p = left -1, q = left;
            while(k > 0){
                if(p >= 0 && q < n){
                    if(target - nums[p] <= nums[q] - target){
                        res.add(nums[p--]);
                    } else {
                        res.add(nums[q++]);
                    }
                } else if(p >= 0){
                    res.add(nums[p--]);
                } else {
                    res.add(nums[q++]);
                }
                k--;
            }
        }
        Collections.sort(res);
        return res;

    }
}
