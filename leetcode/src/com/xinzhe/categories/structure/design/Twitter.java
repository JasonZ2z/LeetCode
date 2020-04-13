package com.xinzhe.categories.structure.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @create 2020/4/13 11:37
 * Title : 355. 设计推特
 * Description : 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *              postTweet(userId, tweetId): 创建一条新的推文
 *              getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 *              follow(followerId, followeeId): 关注一个用户
 *              unfollow(followerId, followeeId): 取消关注一个用户
 * link : https://leetcode-cn.com/problems/design-twitter
 * Level : Medium
 */

public class Twitter {
    // <userId, followers>
    Map<Integer, ArrayList<Integer>> followerIds;
    // <userId, <twitterId, timestamp>>
    Map<Integer, Map<Integer, Integer>> twitterLists ;
    int count;
    public Twitter() {
        followerIds = new HashMap<>();
        twitterLists = new HashMap<>();
        count = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!followerIds.containsKey(userId)){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(userId);
            followerIds.put(userId, list);
        }
        if(twitterLists.containsKey(userId)){
            twitterLists.get(userId).put(tweetId, count++);
        } else {
            Map<Integer, Integer> twitters = new HashMap<>();
            twitters.put(tweetId, count++);
            twitterLists.put(userId, twitters);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> follows = followerIds.get(userId);
        Map<Integer, Integer>  twitterList = new HashMap<>();
        if(follows == null) return new ArrayList<>();
        for (Integer follow : follows) {
            Map<Integer, Integer> map = twitterLists.get(follow);
            if(map != null){
                twitterList.putAll(map);
            }
        }
        return twitterList.entrySet().stream()
                        .sorted(Map.Entry.<Integer, Integer>comparingByValue()
                        .reversed()).limit(10).map(Map.Entry::getKey)
                        .collect(Collectors.toList());
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerIds.containsKey(followerId)){
            followerIds.get(followerId).add(followeeId);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(followerId);
            list.add(followeeId);
            followerIds.put(followerId, list);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(followerIds.containsKey(followerId)){
            followerIds.get(followerId).removeIf(s -> followeeId == s);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1,2);
        System.out.println(twitter.getNewsFeed(1));
    }
}
