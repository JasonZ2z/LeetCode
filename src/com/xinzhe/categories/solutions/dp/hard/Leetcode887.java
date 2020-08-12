package com.xinzhe.categories.solutions.dp.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/4/11 17:35
 * Title : 887. 鸡蛋掉落
 * Description : 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *              每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *              你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *              每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *              你的目标是确切地知道 F 的值是多少。
 *              无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * link : https://leetcode-cn.com/problems/super-egg-drop
 * Level : Hard
 */

//todo need to review
public class Leetcode887 {
    Map<Integer, Integer> cache = new HashMap<>();

    public int superEggDrop(int K, int N) {
        if (N == 0)
            return 0;
        else if (K == 1)
            return N;

        Integer key = N * 1000 + K; // K <= 100
        if (cache.containsKey(key))
            return cache.get(key);

        int low = 1, high = N;
        while (low + 1 < high) {
            int middle = (low + high) / 2;
            int lowVal = superEggDrop(K - 1, middle - 1);
            int highVal = superEggDrop(K, N - middle);

            if (lowVal < highVal)
                low = middle;
            else if (lowVal > highVal)
                high = middle;
            else
                low = high = middle;
        }
        int minimum = 1 + Math.min(
                Math.max(superEggDrop(K - 1, low - 1), superEggDrop(K, N - low)),
                Math.max(superEggDrop(K - 1, high - 1), superEggDrop(K, N - high))
        );

        cache.put(key, minimum);

        return cache.get(key);
    }
}
