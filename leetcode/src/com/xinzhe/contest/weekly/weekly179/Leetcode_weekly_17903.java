package com.xinzhe.contest.weekly.weekly179;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/17
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_weekly_17903 {
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

        //favoriteCompanies.sort((a, b) -> b.size() - a.size());

        for (int i = 0; i < n; ++i) {
            int alen = favoriteCompanies.get(i).size();
            for (int j = 0; j < n; ++j) {
                int blen = favoriteCompanies.get(j).size();
                if (alen < blen && favoriteCompanies.get(j).containsAll(favoriteCompanies.get(i))) {
                    res.add(i);
                    break;
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            list.add(i);
        }
        System.out.println(res);
        System.out.println(list);
        list.removeAll(res);
        return list;

    }
}
