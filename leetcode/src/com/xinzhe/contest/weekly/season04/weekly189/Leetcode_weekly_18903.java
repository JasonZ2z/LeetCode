package com.xinzhe.contest.weekly.season04.weekly189;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/17
 * Title : 1452. 收藏清单
 * Description : 给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
 * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
 * link : https://leetcode-cn.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list
 * Level : Medium
 */
public class Leetcode_weekly_18903 {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> a = Arrays.asList("arrtztkotazhufrsfczr", "knzgidixqgtnahamebxf", "zibvccaoayyihidztflj");
        List<String> b = Arrays.asList("cffiqfviuwjowkppdajm", "owqvnrhuzwqohquamvsz");
        List<String> c = Arrays.asList("knzgidixqgtnahamebxf", "owqvnrhuzwqohquamvsz", "qzeqyrgnbplsrgqnplnl");
        List<String> d = Arrays.asList("arrtztkotazhufrsfczr", "cffiqfviuwjowkppdajm");
        List<String> e = Arrays.asList("arrtztkotazhufrsfczr", "knzgidixqgtnahamebxf", "owqvnrhuzwqohquamvsz", "qzeqyrgnbplsrgqnplnl", "zibvccaoayyihidztflj");
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        System.out.println(peopleIndexes(list));

    }

    public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        List<Integer> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int alen = favoriteCompanies.get(i).size();
            for (List<String> favoriteCompany : favoriteCompanies) {
                int blen = favoriteCompany.size();
                if (alen < blen && favoriteCompany.containsAll(favoriteCompanies.get(i))) {
                    res.add(i);
                    break;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            list.add(i);
        }
        list.removeAll(res);
        return list;

    }
}
