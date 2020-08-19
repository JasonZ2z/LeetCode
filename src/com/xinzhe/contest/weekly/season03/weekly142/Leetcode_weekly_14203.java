package com.xinzhe.contest.weekly.season03.weekly142;

/**
 * @author Xin
 * @date 2020/8/19
 * Title : 1095. 山脉数组中查找目标值
 * Description : 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。如果不存在这样的下标 index，就请返回 -1。
 * link : https://leetcode-cn.com/problems/find-in-mountain-array
 * Level : Hard
 */

public class Leetcode_weekly_14203 {
    public static void main(String[] args) {
        Leetcode_weekly_14203 lc = new Leetcode_weekly_14203();
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if(mountainArr.get(0) == target) return 0;
        int n = mountainArr.length();
        int top = getTop(mountainArr, 0, n-1);
        int topValue = mountainArr.get(top);
        if(target > topValue) return -1;
        if(target == topValue) return top;
        int left = getLeft(target, mountainArr, 0, top-1);
        if(left >= 0) return left;
        return getRight(target, mountainArr, top + 1, n-1);
    }

    private int getRight(int target, MountainArray mountainArr, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) >> 1;
            if(mountainArr.get(mid) > target) {
                l = mid  + 1;
            } else {
                r = mid;
            }
        }
        return mountainArr.get(l) == target ? l : -1;
    }

    private int getTop(MountainArray mountainArr, int l, int r) {
        while(l < r) {
            int mid = l + (r - l) >> 1;
            if(mountainArr.get(mid + 1) > mountainArr.get(mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int getLeft(int target, MountainArray mountainArr, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) >> 1;
            if(mountainArr.get(mid) > target) {
                r = mid-1;
            } else {
                l = mid;
            }
        }
        return mountainArr.get(l) == target ? l : -1;
    }


    interface MountainArray {
        int get(int index);
        int length();
    }

}


