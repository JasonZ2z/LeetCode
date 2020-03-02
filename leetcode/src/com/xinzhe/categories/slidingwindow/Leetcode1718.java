package com.xinzhe.categories.slidingwindow;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author Xin
 * @create 2020/3/1 22:11
 * Title : 面试题 17.18. 最短超串
 * Description : 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 *                  返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 *
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 * link : https://leetcode-cn.com/problems/shortest-supersequence-lcci
 * Level : medium
 */
public class Leetcode1718 {
    public static void main(String[] args) {
        int[] big = {1,1,5,9};
        int[] small = {1,5,9};
        System.out.println(Arrays.toString(shortestSeq(big, small)));
    }

    public static int[] shortestSeq(int[] big, int[] small) {
        if(big.length < small.length) return new int[0];
        List<Integer> smallList = Arrays.stream(small).boxed().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int match = 0;
        while(right < big.length){
            if(smallList.contains(big[right])){
                match++;
            }
            right++;
            while(match == smallList.size()){

                if(smallList.contains(big[left])){
                    match--;
                }
                left++;
            }

        }
        Integer integer = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).map(Map.Entry::getKey)
                .collect(Collectors.toList()).get(0);
        return new int[]{map.get(integer),  map.get(integer) + integer};
    }
}
