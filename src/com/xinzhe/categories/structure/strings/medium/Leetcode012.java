package com.xinzhe.categories.structure.strings.medium;

/**
 * @Author Xin
 * @create 2020/4/16
 * Title : 12. 整数转罗马数字
 * Description : 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *      字符          数值
 *      I             1
 *      V             5
 *      X             10
 *      L             50
 *      C             100
 *      D             500
 *      M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *          I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 *          X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 *          C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *          给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * link : https://leetcode-cn.com/problems/integer-to-roman
 * Level : Medium
 */

public class Leetcode012 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }

    private static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num / Roman.M.getValue() > 0) {
                int m = num / Roman.M.getValue();
                sb.append("M".repeat(Math.max(0, m)));
                num -= m * Roman.M.getValue();
            }
            if (num / Roman.CM.getValue() > 0) {
                sb.append("CM");
                num -= Roman.CM.getValue();
            }
            if (num / Roman.D.getValue() > 0) {
                sb.append("D");
                num -= Roman.D.getValue();
            }
            if (num / Roman.CD.getValue() > 0) {
                sb.append("CD");
                num -= Roman.CD.getValue();
            }
            if (num / Roman.C.getValue() > 0) {
                int c = num / Roman.C.getValue();
                sb.append("C".repeat(Math.max(0, c)));
                num -= c * Roman.C.getValue();
            }
            if (num / Roman.XC.getValue() > 0) {
                sb.append("XC");
                num -= Roman.XC.getValue();
            }
            if (num / Roman.L.getValue() > 0) {
                sb.append("L");
                num -= Roman.L.getValue();
            }
            if (num / Roman.XL.getValue() > 0) {
                sb.append("XL");
                num -= Roman.XL.getValue();
            }
            if (num / Roman.X.getValue() > 0) {
                int x = num / Roman.X.getValue();
                sb.append("X".repeat(Math.max(0, x)));
                num -= x * Roman.X.getValue();

            }
            if (num / Roman.IX.getValue() > 0) {
                sb.append("IX");
                num -= Roman.IX.getValue();
            }
            if (num / Roman.V.getValue() > 0) {
                sb.append("V");
                num -= Roman.V.getValue();
            }
            if (num / Roman.IV.getValue() > 0) {
                sb.append("IV");
                num -= Roman.IV.getValue();
            }
            if (num / Roman.I.getValue() > 0) {
                int i = num / Roman.I.getValue();
                sb.append("I".repeat(Math.max(0, i)));
                num -= i * Roman.I.getValue();

            }

        }
        return sb.toString();

    }
}

enum Roman{
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000);

    private int value;
    Roman(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

