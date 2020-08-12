package com.xinzhe.contest.weekly.season04.weekly183;

/**
 * @author Xin
 * @date 2020/4/5 10:28
 * Title : 1405. 最长快乐字符串
 * Description : 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 *              给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 *              s 是一个尽可能长的快乐字符串。
 *              s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 *              s 中只含有 'a'、'b' 、'c' 三种字母。
 *              如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 * link : https://leetcode-cn.com/problems/longest-happy-string
 * Level : Medium
 * Comment : 183周赛03
 */
public class Leetcode_weekly_18303 {
    static String sa = "a";
    static String sb = "b";
    static String sc = "c";

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1,4,5));
    }
    public static String longestDiverseString(int a, int b, int c) {
        int[] nums = {a, b, c};
        StringBuilder sb = new StringBuilder();
        int last = -1;
        int flag = -1;
        while (true){
            int max = 0;
            int index = -1;
            for (int i = 0; i < 3; ++i) {
                if(nums[i] > max && i != flag){
                    max = nums[i];
                    index = i;
                }
            }
            if(index == -1){
                break;
            }
            if(last == index){
                flag = last;
            } else {
                flag = -1;
            }
            nums[index]--;
            last = index;
            sb.append((char)('a' + index));
        }
        return sb.toString();
    }
}
