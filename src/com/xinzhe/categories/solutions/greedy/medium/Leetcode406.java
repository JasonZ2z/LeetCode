package com.xinzhe.categories.solutions.greedy.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/10/20
 * Title : 406. 根据身高重建队列
 * Description : 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。总人数少于1100人
 * link : https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * Level : Medium
 */
//todo need to review
public class Leetcode406 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,3,3};
    }
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[][] res = new int[n][2];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(i);
        }
        for (int[] person : people) {
            res[list.remove(person[1])] = person;
        }
        return res;

    }

    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] arr: people) {
            ans.add(arr[1], arr);
        }
        return ans.toArray(people);
    }
}
