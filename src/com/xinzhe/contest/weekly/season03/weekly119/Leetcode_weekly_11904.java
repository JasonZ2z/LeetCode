package com.xinzhe.contest.weekly.season03.weekly119;

/**
 * @author Xin
 * @date 2020/10/21
 * Title : 975. 奇偶跳
 * Description : 给定一个整数数组 A，你可以从某一起始索引出发，跳跃一定次数。在你跳跃的过程中，第 1、3、5... 次跳跃称为奇数跳跃，而第 2、4、6... 次跳跃称为偶数跳跃。
 *              你可以按以下方式从索引 i  向后跳转到索引 j（其中 i < j）：
 *              在进行奇数跳跃时（如，第  1，3，5... 次跳跃），你将会跳到索引 j，使得 A[i] <=  A[j]，A[j] 是可能的最小值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
 *              在进行偶数跳跃时（如，第  2，4，6... 次跳跃），你将会跳到索引  j，使得 A[i] >= A[j]，A[j] 是可能的最大值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j  上。
 *              （对于某些索引 i，可能无法进行合乎要求的跳跃。）
 *              如果从某一索引开始跳跃一定次数（可能是 0 次或多次），就可以到达数组的末尾（索引 A.length - 1），那么该索引就会被认为是好的起始索引。返回好的起始索引的数量。
 * link : https://leetcode-cn.com/problems/odd-even-jump
 * Level : Hard
 */
//todo undo
public class Leetcode_weekly_11904 {
    public static void main(String[] args) {
        Leetcode_weekly_11904 lc = new Leetcode_weekly_11904();
    }
}
