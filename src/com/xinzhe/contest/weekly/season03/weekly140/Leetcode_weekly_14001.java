package com.xinzhe.contest.weekly.season03.weekly140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/21
 * Title : 1078. Bigram 分词
 * Description : 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 *              对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 * link : https://leetcode-cn.com/problems/occurrences-after-bigram
 * Level :
 */

public class Leetcode_weekly_14001 {
    public static void main(String[] args) {
        Leetcode_weekly_14001 lc = new Leetcode_weekly_14001();
        System.out.println(Arrays.toString(lc.findOcurrences("alice is a good girl she is a good student", "a", "good")));
    }
    public String[] findOcurrences(String text, String first, String second) {
        String[] arr = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < arr.length-2; ++i) {
            if(arr[i].equals(first) && arr[i + 1].equals(second)) {
                res.add(arr[i+2]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
