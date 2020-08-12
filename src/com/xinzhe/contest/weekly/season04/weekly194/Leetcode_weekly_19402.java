package com.xinzhe.contest.weekly.season04.weekly194;

import java.util.*;

/**
 * @Author Xin
 * @create 2020/6/21
 * Title : 1487. 保证文件名唯一
 * Description : 给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
 *              由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
 *              返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
 * link : https://leetcode-cn.com/problems/making-file-names-unique
 * Level : Medium
 * Comment 194周赛02
 */
public class Leetcode_weekly_19402 {
    public static void main(String[] args) {
        String[] arr = {"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
        System.out.println(Arrays.toString(getFolderNames(arr)));
    }
    public static String[] getFolderNames(String[] names) {
        int n = names.length;
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if(!set.contains(names[i])) {
                res[i] = names[i];
            } else {
                String prefix;
                if(map.containsKey(names[i])) {
                    prefix = names[i];
                } else {
                    if(!names[i].contains("(")) {
                        prefix = names[i];
                    } else {
                        int lastIndex = names[i].lastIndexOf("(");
                        prefix = names[i].substring(0, lastIndex);
                    }
                }
                int j = map.get(prefix);
                while (++j < n) {
                    if(j == 0) continue;
                    String tmp = names[i] + "(" + j + ")";
                    if(!set.contains(tmp)) {
                        res[i] = tmp;
                        map.put(prefix, j);
                        break;
                    }
                }
            }
            set.add(res[i]);
            map.put(res[i], -1);
        }
        return res;
    }
}
