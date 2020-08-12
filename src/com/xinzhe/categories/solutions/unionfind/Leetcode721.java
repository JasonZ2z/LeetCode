package com.xinzhe.categories.solutions.unionfind;

import java.util.*;

/**
 * @author Xin
 * @date 2020/4/17
 * Title : 721. 账户合并
 * Description : 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
 *      现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。
 *      请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
 *      合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
 * link : https://leetcode-cn.com/problems/accounts-merge
 * Level : Medium
 */

public class Leetcode721 {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> a = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> b = Arrays.asList("John", "johnnybravo@mail.com");
        List<String> c = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> d = Arrays.asList("Mary", "mary@mail.com");
        accounts.add(a);
        accounts.add(b);
        accounts.add(c);
        accounts.add(d);
        System.out.println(accountsMerge(accounts));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Set<String>> map2 = new HashMap<>();

        int n = accounts.size();
        UF uf = new UF(n);
        for (int i = 0; i < n; ++i) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); ++j) {
                String email = account.get(j);
                if(map.containsKey(email)){
                    int index = map.get(email);
                    uf.union(index, i);
                }
                map.put(email, i);
            }
        }
        for (int i = 0; i < n; ++i) {
            int index = uf.find(i);
            List<String> account = accounts.get(i);
            List<String> emails = account.subList(1, account.size());
            if(map2.containsKey(index)){
                map2.get(index).addAll(emails);
            }else{
                map2.put(index, new TreeSet<>(emails));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : map2.entrySet()) {
            LinkedList<String> tmp = new LinkedList<>();
            int index = entry.getKey();
            String name = accounts.get(index).get(0);
            tmp.add(name);
            tmp.addAll(entry.getValue());
            res.add(tmp);
        }
        return res;

    }
    static class UF{
        int[] parent;
        public UF(int n){
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int p){
            while (p != parent[p]){
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q){
            int fp = find(p);
            int fq = find(q);
            if(fp == fq) return;
            parent[fq] = fp;
        }
    }
}
