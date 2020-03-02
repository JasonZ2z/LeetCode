package com.xinzhe.categories.slidingwindow;

import java.util.Arrays;
import java.util.List;
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
        List<Integer> list = Arrays.asList(1,2,3,5,7,8);
        List<Integer> list2 = Arrays.asList(7,8,5);
        int[] small = {7,8,5};
        Arrays.stream(small).boxed().collect(Collectors.toList()).forEach(System.out::print);
        System.out.println(list.containsAll(list2));
    }
    public int[] shortestSeq(int[] big, int[] small) {
        List<Integer> list = Arrays.stream(small).boxed().collect(Collectors.toList());
        for (int i = 0; i < big.length - small.length; i++) {
            if(list.contains(big[i])){

            }
        }
        return null;

    }
}
