package com.xinzhe.categories.solutions.dp.matrix;

import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/26 19:55
 * Title : 638. 大礼包
 * Description : 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
 * 任意大礼包可无限次购买。
 *
 * 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
 * 输出: 14
 * 解释:
 * 有A和B两种物品，价格分别为¥2和¥5。
 * 大礼包1，你可以以¥5的价格购买3A和0B。
 * 大礼包2， 你可以以¥10的价格购买1A和2B。
 * 你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A
 *
 * 最多6种物品， 100种大礼包。
 * 每种物品，你最多只需要购买6个。
 * 你不可以购买超出待购清单的物品，即使更便宜。
 * link : https://leetcode-cn.com/problems/shopping-offers
 * Level : Medium
 */

public class Leetcode638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        //todo
        return 0;
    }
}
