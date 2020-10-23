package com.xinzhe.contest.weekly.season03.weekly118;

/**
 * @author Xin
 * @date 2020/10/23
 * Title : 972. 相等的有理数
 * Description : 给定两个字符串 S 和 T，每个字符串代表一个非负有理数，只有当它们表示相同的数字时才返回 true；否则，返回 false。字符串中可以使用括号来表示有理数的重复部分。
 *              通常，有理数最多可以用三个部分来表示：整数部分 <IntegerPart>、小数非重复部分 <NonRepeatingPart> 和小数重复部分 <(><RepeatingPart><)>。数字可以用以下三种方法之一来表示：
 *              <IntegerPart>（例：0，12，123）
 *              <IntegerPart><.><NonRepeatingPart> （例：0.5，2.12，2.0001）
 *              <IntegerPart><.><NonRepeatingPart><(><RepeatingPart><)>（例：0.1(6)，0.9(9)，0.00(1212)）
 *              十进制展开的重复部分通常在一对圆括号内表示。例如： 1 / 6 = 0.16666666... = 0.1(6) = 0.1666(6) = 0.166(66) 0.1(6) 或 0.1666(6) 或 0.166(66) 都是 1 / 6 的正确表示形式。
 * link : https://leetcode-cn.com/problems/equal-rational-numbers
 * Level : Hard
 */
//todo too hard to solve
public class Leetcode_weekly_11804 {
    public static void main(String[] args) {
        Leetcode_weekly_11804 lc = new Leetcode_weekly_11804();
        int[][] arr = {{1,3}, {-2,2}};
    }

    public boolean isRationalEqual(String S, String T) {
        Fraction f1 = convert(S);
        Fraction f2 = convert(T);
        return f1.n == f2.n && f1.d == f2.d;
    }

    public Fraction convert(String S) {
        int state = 0; //whole, decimal, repeating
        Fraction ans = new Fraction(0, 1);
        int decimal_size = 0;

        for (String part: S.split("[.()]")) {
            state++;
            if (part.isEmpty()) continue;
            long x = Long.parseLong(part);
            int sz = part.length();

            if (state == 1) { // whole
                ans.iadd(new Fraction(x, 1));
            } else if (state == 2) { // decimal
                ans.iadd(new Fraction(x, (long) Math.pow(10, sz)));
                decimal_size = sz;
            } else { // repeating
                long denom = (long) Math.pow(10, decimal_size);
                denom *= (long) (Math.pow(10, sz) - 1);
                ans.iadd(new Fraction(x, denom));
            }
        }
        return ans;
    }
}

class Fraction {
    long n, d;
    Fraction(long n, long d) {
        long g = gcd(n, d);
        this.n = n / g;
        this.d = d / g;
    }

    public void iadd(Fraction other) {
        long numerator = this.n * other.d + this.d * other.n;
        long denominator = this.d * other.d;
        long g = Fraction.gcd(numerator, denominator);
        this.n = numerator / g;
        this.d = denominator / g;
    }

    static long gcd(long a, long b) {
        return a==0? b : gcd(b%a , a);
    }
}
