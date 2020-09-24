package com.xinzhe.contest.weekly.season03.weekly123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/9/24
 * Title : 989. 数组形式的整数加法
 * Description : 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *              给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * link : https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * Level : Easy
 */

public class Leetcode_weekly_12301 {
    public static void main(String[] args) {
        Leetcode_weekly_12301 lc = new Leetcode_weekly_12301();
        int[] arr = {2,-3,-1,5,-4};
    }
    public List<Integer> addToArrayForm(int[] arr, int k) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> res = new ArrayList<>();
        int carrier =  0;
        int i = list.size()-1;
        while(i >= 0 || k != 0) {
            int x = (i >= 0 ? list.get(i) : 0) + k % 10 + carrier;
            k /= 10;
            res.add(0, x%10);
            carrier = x/10;
            i--;
        }
        if(carrier != 0) res.add(0, carrier);
        return res;
    }
}
