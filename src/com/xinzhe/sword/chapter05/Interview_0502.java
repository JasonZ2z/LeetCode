package com.xinzhe.sword.chapter05;

/**
 * @author Xin
 * @date 2020/11/03
 * Title : 面试题 05.02. 二进制数转字符串
 * Description : 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。
 * link : https://leetcode-cn.com/problems/bianry-number-to-string-lcci
 * Level : Medium
 */
//todo need to review
public class Interview_0502 {
    public static void main(String[] args) {
        Interview_0502 lc = new Interview_0502();
        System.out.println(lc.printBin(0.625));
    }
    public String printBin(double num) {
        if(num <= 0 || num >= 1){
            return "ERROR";
        }
        //不是 5 结尾的不能准确转换
        // String temp = String.valueOf(num);
        // if(temp.charAt(temp.length() - 1) != '5'){
        //     return "ERROR";
        // }
        StringBuilder sb = new StringBuilder("0.");
        for (int i = 1; i < 31 && num > 0; i++) {
            if (num >= Math.pow(0.5, i)) {
                num -= Math.pow(0.5, i);
                sb.append(1);
            } else sb.append(0);
        }
        return num == 0 ? sb.toString() : "ERROR";
    }
}
