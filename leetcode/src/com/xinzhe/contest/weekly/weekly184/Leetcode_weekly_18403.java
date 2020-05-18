package com.xinzhe.contest.weekly.weekly184;

/**
 * @Author Xin
 * @create 2020/4/12 10:10
 * Title : 1410. HTML 实体解析器
 * Description : 「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。
 *               HTML 里这些特殊字符和它们对应的字符实体包括：
 *              双引号：字符实体为 &quot; ，对应的字符是 " 。
 *              单引号：字符实体为 &apos; ，对应的字符是 ' 。
 *               与符号：字符实体为 &amp; ，对应对的字符是 & 。
 *               大于号：字符实体为 &gt; ，对应的字符是 > 。
 *               小于号：字符实体为 &lt; ，对应的字符是 < 。
 *               斜线号：字符实体为 &frasl; ，对应的字符是 / 。
 *               给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。
 * link : https://leetcode-cn.com/problems/html-entity-parser
 * Level : Medium
 */
public class Leetcode_weekly_18403 {
    public static void main(String[] args) {
        String s = "and I quote: &quot;...&quot;";
        //String s = "&amp; is an HTML entity but &ambassador; is not.";
        System.out.println(entityParser(s));
    }
    public static String entityParser(String text) {
        if(text == null || text.length() == 0) return "";
        String[] split = text.split("&");
        StringBuilder sb = new StringBuilder(split[0]);
        for (int i = 1; i < split.length; i++) {
            String tmp = "&" + split[i];
            if(tmp.startsWith(Code.A.getCharacter())){ sb.append(Code.A.getCode()).append(tmp.substring(6));}
            else if(tmp.startsWith(Code.B.getCharacter())){ sb.append(Code.B.getCode()).append(tmp.substring(6));}
            else if(tmp.startsWith(Code.C.getCharacter())){ sb.append(Code.C.getCode()).append(tmp.substring(5));}
            else if(tmp.startsWith(Code.D.getCharacter())){ sb.append(Code.D.getCode()).append(tmp.substring(4));}
            else if(tmp.startsWith(Code.E.getCharacter())){ sb.append(Code.E.getCode()).append(tmp.substring(4));}
            else if(tmp.startsWith(Code.F.getCharacter())){ sb.append(Code.F.getCode()).append(tmp.substring(7));}
            else {
                sb.append(tmp);
            }

        }
        return sb.toString();
    }
}

enum Code {

    A("&quot;", "\""),
    B("&apos;", "'"),
    C("&amp;", "&"),
    D("&gt;", ">"),
    E("&lt;", "<"),
    F("&frasl;", "/");
    private String character;
    private String code;

    Code(String s, String code) {
        this.character = s;
        this.code = code;
    }

    public String getCharacter() {
        return character;
    }

    public String getCode() {
        return code;
    }
}