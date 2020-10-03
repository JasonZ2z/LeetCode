package com.xinzhe.categories.solutions.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/4/16
 * Title : 399. 除法求值
 * Description : 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 * 示例 :
 *      给定 a / b = 2.0, b / c = 3.0
 *      问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 *      返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)，
 * 其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。
 * 基于上述例子，输入如下：
 *      equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 *      values(方程式结果) = [2.0, 3.0],
 *      queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *      输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
 * link : https://leetcode-cn.com/problems/evaluate-division
 * Level : Medium
 */

public class Leetcode399 {
    Map<String, String> parent = new HashMap<>();
    Map<String, Double> quotient = new HashMap<>();

    public void init(String s){
        if(!parent.containsKey(s)){
            parent.put(s, s);
            quotient.put(s, 1.0);
        }
    }

    public String find(String p) {
        while (!parent.get(p).equals(p)) {
            p = parent.get(p);
        }
        return p;
    }

    //压缩路径
    public String find2(String p) {
        while (!parent.get(p).equals(p)) {
            //需要先保存父亲的值,因为后面压缩后树只有两层,后面*的就是根节点的权值1,是不对的
            //这里可以看看上面的并查集的方向和值来判断
            String f=parent.get(p);
            parent.put(p,find2(f));
            //这样压缩后的子节点才是正确的
            quotient.put(p,quotient.get(p)*quotient.get(f));
        }
        return parent.get(p);
    }
    //省略了cal 函数计算从当前节点到根节点的总权值积，因为这里路径压缩已经将树压缩到只有两层了，所以并不需要了.
    // 既然要压缩到只有两层，这里就只能使用递归来压缩，循环的版本没办法压到只有两层，这里需要注意压缩中值的变化。
    public double cal(String index) {
        double res = quotient.get(index);
        while (!parent.get(index).equals(index)){
            index = parent.get(index);
            res *= quotient.get(index);
        }
        return res;
    }
    public void merge(String a, String b, double value){
        init(a);
        init(b);
        String fa = find(a);
        String fb = find(b);
        if(fa.equals(fb)) return;
        parent.put(fa, fb);
        quotient.put(fa, value * cal(b) / cal(a));
    }

    public void merge2(String a,String b,Double value){
        init(a);init(b);
        String fa=find2(a); // fa/a=val[a], fb/b=val[b]
        String fb=find2(b);
        if (fa.equals(fb)) {
            return;
        }
        parent.put(fa,fb);
        quotient.put(fa,value*(quotient.get(b)/quotient.get(a)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); ++i) {
            merge(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        double[] res = new double[queries.size()];
        int index = 0;
        for (List<String> query : queries) {
            String a = query.get(0);
            String b = query.get(1);
            if(!parent.containsKey(a) || !parent.containsKey(b)){
                res[index++] = -1;
            } else {
                if(!find(a).equals(find(b))){
                    res[index++] = -1;
                } else {
                    res[index++] = cal(a)/cal(b);
                }
            }
        }
        return res;
    }
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); ++i) {
            merge2(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        double[] res = new double[queries.size()];
        int index = 0;
        for (List<String> query : queries) {
            String a = query.get(0);
            String b = query.get(1);
            if(!parent.containsKey(a) || !parent.containsKey(b)){
                res[index++] = -1;
            } else {
                if(!find2(a).equals(find2(b))){
                    res[index++] = -1;
                } else {
                    res[index++] = quotient.get(a)/quotient.get(b);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode399 s = new Leetcode399();
        List<List<String>> equations = new ArrayList<>();
        List<String> a = Arrays.asList("a" , "b");
        List<String> b = Arrays.asList("b" , "c");
        equations.add(a);
        equations.add(b);
        double[] values = {2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> c = Arrays.asList("a" , "c");
        List<String> d = Arrays.asList("b" , "a");
        List<String> e = Arrays.asList("a" , "e");
        List<String> f = Arrays.asList("a" , "a");
        List<String> g = Arrays.asList("x" , "x");
        queries.add(c);
        queries.add(d);
        queries.add(e);
        queries.add(f);
        queries.add(g);
        System.out.println(Arrays.toString(s.calcEquation2(equations, values, queries)));
    }
}
