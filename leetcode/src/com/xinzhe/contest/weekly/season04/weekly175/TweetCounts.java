package com.xinzhe.contest.weekly.season04.weekly175;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/19
 * Title : 1348. 推文计数
 * Description : 请你实现一个能够支持以下两种方法的推文计数类 TweetCounts：
 *          1. recordTweet(string tweetName, int time)  记录推文发布情况：用户 tweetName 在 time（以 秒 为单位）时刻发布了一条推文。
 *          2. getTweetCountsPerFrequency(string freq, string tweetName, int startTime, int endTime)
 *              返回从开始时间 startTime（以 秒 为单位）到结束时间 endTime（以 秒 为单位）内，每 分 minute，时 hour 或者 日 day （取决于 freq）内指定用户 tweetName 发布的推文总数。
 *              freq 的值始终为 分 minute，时 hour 或者 日 day 之一，表示获取指定用户 tweetName 发布推文次数的时间间隔。
 *              第一个时间间隔始终从 startTime 开始，因此时间间隔为 [startTime, startTime + delta*1>,  [startTime + delta*1, startTime + delta*2>, [startTime + delta*2, startTime + delta*3>, ... , [startTime + delta*i, min(startTime + delta*(i+1), endTime + 1)>，其中 i 和 delta（取决于 freq）都是非负整数。
 * link : https://leetcode-cn.com/problems/tweet-counts-per-frequency
 * Level : Medium
 * Comment 175周赛03
 */
//todo undo
public class TweetCounts {
    public TweetCounts() {

    }

    public void recordTweet(String tweetName, int time) {

    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        return new ArrayList<>();
    }

}
