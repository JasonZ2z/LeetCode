package com.xinzhe.categories.structure.arrays.medium;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/12/03
 * Title : 950. 按递增顺序显示卡牌
 * Description : 牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。现在，重复执行以下步骤，直到显示所有卡牌为止：
 *                  从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
 *                  如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
 *                  如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
 *              返回能以递增顺序显示卡牌的牌组顺序。答案中的第一张牌被认为处于牌堆顶部。
 * link : https://leetcode-cn.com/problems/reveal-cards-in-increasing-order
 * Level : Medium
 */
public class Leetcode950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        LinkedList<Integer> list =  new LinkedList<>();
        for(int i=deck.length-1; i>=0; i--) {
            if(list.size() == 0) list.addLast(deck[i]);
            else {
                list.addFirst(list.pollLast());
                list.addFirst(deck[i]);
            }
        }
        int[] res = new int[deck.length];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
