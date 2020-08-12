package com.xinzhe.categories.solutions.slidingwindow.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author Xin
 * @create 2020/3/1 22:11
 * Title : 面试题 17.18. 最短超串
 * Description : 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 * <p>
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 * link : https://leetcode-cn.com/problems/shortest-supersequence-lcci
 * Level : medium
 */
public class Leetcode1718 {
    public static void main(String[] args) {
        int[] big = {1, 2, 3, 1, 2, 3, 1};
        int[] small = {2, 3};
        Map<Integer, Long> map = Arrays.stream(big).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.forEach((x, y) -> System.out.println(x + " " + y));

    }

    public static int[] shortestSeq(int[] big, int[] small) {
        if (big.length < small.length) return new int[0];
        Map<Integer, Long> smallMap = Arrays.stream(small).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> bigMap = new HashMap<>(small.length);
        int left = 0, right = 0, match = 0;
        int min = Integer.MAX_VALUE;
        int l = -1, r = -1;
        while (right < big.length) {
            int rightValue = big[right++];
            if (smallMap.containsKey(rightValue)) {
                bigMap.put(rightValue, bigMap.getOrDefault(rightValue, 0L) + 1);
                if (smallMap.get(rightValue).equals(bigMap.get(rightValue))) {
                    match++;
                }

            }
            while (match == smallMap.size()) {
                if (right - left < min) {
                    l = left;
                    r = right;
                    min = right - left;
                }
                int leftValue = big[left++];
                if (smallMap.containsKey(leftValue)) {
                    bigMap.put(leftValue, bigMap.get(leftValue) - 1);
                    if (bigMap.get(leftValue) < smallMap.get(leftValue)) {
                        match--;
                    }
                }
            }
        }
        if (r - 1 < l) {
            return new int[0];
        } else {
            return new int[]{l, r - 1};
        }
    }
}
