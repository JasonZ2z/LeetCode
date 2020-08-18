package com.xinzhe.contest.weekly.season03.weekly143;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/8/18
 * Title : 1104. 二叉树寻路
 * Description : 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 *               如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 *              而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * link : https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
 * Level : Medium
 */

public class Leetcode_weekly_14302 {
    public static void main(String[] args) {
        Leetcode_weekly_14302 lc = new Leetcode_weekly_14302();
        System.out.println(lc.pathInZigZagTree(12423325));
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        int i = 1;
        for (; i < 1000; ++i) {
            if(1 << i > label) break;
        }
        int index;
        if(i % 2 == 0) {
            index = (1 << i) - 1 - label;
        } else {
            index = label - (1 << (i-1));
        }

        for (int j = i; j > 0; j--) {
            if(j % 2 == 0) {
                res.add(0, (1 << j) - 1 - index);
            } else {
                res.add(0, index + (1 << (j-1)));
            }
            index /= 2;
        }
        return res;
    }
}
