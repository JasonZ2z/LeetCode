package com.xinzhe.Charactors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertChars {
    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
        //char[] s = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> list = new ArrayList<>();
        List<char[]> chars = Arrays.asList(s);
        System.out.println(list);
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
    }


    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while(i<j){
            char tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
            i++;
            j--;
        }
    }
}
