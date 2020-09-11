package com.xinzhe.contest.weekly.season03.weekly133;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 20209/10
 * Title : 1032. 字符流
 * Description : 按下述要求实现 StreamChecker 类：StreamChecker(words)：构造函数，用给定的字词初始化数据结构。
 *              query(letter)：如果存在某些 k >= 1，可以用查询的最后 k个字符（按从旧到新顺序，包括刚刚查询的字母）拼写出给定字词表中的某一字词时，返回 true。否则，返回 false。
 * link : https://leetcode-cn.com/problems/stream-of-characters
 * Level : Hard
 */
//todo undo
public class StreamChecker {

    Map<Character, Tried> map = new HashMap<>(300);
    List<Character> visitList = new LinkedList<>();  //访问记录
    public StreamChecker(String[] words) {
        Character character;
        for (String word : words) {
            Tried tried;
            character = word.charAt(word.length() - 1);
            //最后一个字符
            if (map.containsKey(character)) {
                tried = map.get(character);
            } else {
                tried = new Tried(character);
                map.put(character, tried);
            }
            if (word.length() == 1) {
                //添加一个字符，用于标识它是结尾
                tried.nextCharMap.put(null, null);
                continue;
            }
            for(int i = word.length() -2;i>=0;i--){
                character = word.charAt(i);
                if(tried.nextCharMap.containsKey(character)){
                    tried = tried.nextCharMap.get(character);
                }else{
                    Tried node = new Tried(character);
                    tried.nextCharMap.put(character,node);
                    tried = node;
                }
            }
            //添加一个字符，用于标识它是结尾
            tried.nextCharMap.put(null,null);
        }
    }
    StringBuilder  sb = new StringBuilder();
    public boolean query ( char ch){
        Map<Character,Tried> temp = map;
        sb.append(ch);
        Character curChar;
        for(int i = sb.length()-1;i>=0;i--){
            curChar = sb.charAt(i);
            if(!temp.containsKey(curChar)){
                return false;
            }else{
                temp = temp.get(curChar).nextCharMap;
                if(temp.containsKey(null)){
                    return true;
                }
            }
        }
        return false;
    }
    class Tried {
        public Character ch; //当前节点的单词
        public Map<Character, Tried> nextCharMap = new HashMap<>(26); //连接到下一个节点的字符
        public Tried(Character ch) {
            this.ch = ch;
        }
    }
}
