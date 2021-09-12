package com.xinzhe.contest.lccup.lc2021.group.spring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xzheng
 * @create 2021/4/10
 */
public class Lcg_01 {
    public static void main(String[] args) {
        Lcg_01 lc = new Lcg_01();
//        int[] bucket = {1,3};
//        int[] vat = {6,8};
//        int[] bucket1 = {9,0,1};
//        int[] vat1 = {0,2,2};
        int[] bucket2 = {1,1,1};
        int[] vat2 = {1000,1000,1000};
//        System.out.println(lc.storeWater(bucket, vat));
//        System.out.println(lc.storeWater(bucket1, vat1));
        System.out.println(lc.storeWater(bucket2, vat2));
    }

    public int storeWater(int[] bucket, int[] vat) {
        List<Item> queue = new ArrayList<>();
        int count = 0, max = 0, min = 10000;
        for (int i = 0; i < bucket.length; i++) {
            if(vat[i] == 0) continue;
            if(bucket[i] == 0) {
                count++;
                queue.add(new Item(1, vat[i]));
            } else {
                min = Math.min(bucket[i], min);
                queue.add(new Item(bucket[i], vat[i]));
            }
            max = Math.max(vat[i], max);
        }
        if(queue.size() == 0) return 0;
        int res = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int tmp = check(mid, queue);
            if(min == max) return Math.min(res, tmp) + count;
            if(tmp > res) {
                min = mid + 1;
            } else {
                max = mid;
            }
            res = Math.min(res, tmp);
        }
        return res + count;
    }

    private int check(int mid, List<Item> list) {
        int count = 0, max = 0;
        for (Item item : list) {
            if(item.x < mid) {
                count += mid - item.x;
            }
            max = (int) Math.ceil(Math.max(item.y * 1.0 / (Math.max(item.x, mid)) , max));
        }
        return count + max;
    }

    class Item{
        int x;
        int y;
        public Item(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
