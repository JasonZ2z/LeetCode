package com.xinzhe.categories.solutions.binarysearch.interval;

/**
 * @author Xin
 * @date 2020/4/13 18:37
 * Title : 374. 猜数字大小
 * Description : 我们正在玩一个猜数字游戏。 游戏规则如下：
 *      我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 *      每次你猜错了，我会告诉你这个数字是大了还是小了。
 *      你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * link : https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * Level : Easy
 */

public class Leetcode374 extends GuessGame{
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            int res = guess(mid);
            if(res == -1) {
                left = mid +1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Leetcode374 i = new Leetcode374();
        System.out.println(i.guessNumber(10));
    }
}
class GuessGame {
    int guess(int num){
        return Integer.compare(num, 6);
    }
}
