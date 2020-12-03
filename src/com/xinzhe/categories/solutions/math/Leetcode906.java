package com.xinzhe.categories.solutions.math;

/**
 * @author Xin
 * @date 2020/12/03
 * Title : 906. 超级回文数
 * Description : 如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
 *              现在，给定两个正整数L 和R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
 *              L 和 R 是表示 [1, 10^18) 范围的整数的字符串。
 * link : https://leetcode-cn.com/problems/super-palindromes
 * Level : Hard
 */
//todo need to review
public class Leetcode906 {
    //时间复杂度：O(W^(1/4)∗logW)
    //空间复杂度：O(logW)
    public int superPalindromesInRange(String L, String R) {
        long l = Long.parseLong(L);
        long r = Long.parseLong(R);
        //P = R^2
        //P < 10^18 -> R < 10^9
        //R = k||k′ -> k < 10^5
        int max = (int)1e5;
        int cnt = 0;
        for (int i = 1; i < max; i++) {
            String cur = String.valueOf(i);
            StringBuilder sb = new StringBuilder(cur);
            for (int j = cur.length()-2; j >= 0; j--) {
                sb.append(cur.charAt(j));
            }
            long odd = Long.parseLong(sb.toString());
            odd *= odd;
            if(odd > r) break;
            if(odd >= l) cnt += check(odd) ? 1 : 0;
        }

        for (int i = 1; i < max; i++) {
            String cur = String.valueOf(i);
            StringBuilder sb = new StringBuilder(cur);
            for (int j = cur.length()-1; j >= 0; j--) {
                sb.append(cur.charAt(j));
            }
            long even = Long.parseLong(sb.toString());
            even *= even;
            if(even > r) break;
            if(even >= l) cnt += check(even) ? 1 : 0;
        }
        return cnt;
    }

    private boolean check(long cur) {
        long val = cur;
        long reverse = 0;
        while (val > 0) {
            reverse = reverse * 10 + val % 10;
            val /= 10;
        }
        return reverse == cur;
    }
}
