package com.xinzhe.Strings;

import java.util.HashSet;
import java.util.Set;

public class testMorseCode {
    public static void main(String[] args) {
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));

    }
    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i=0;i<words.length;i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : words[i].toCharArray()) {
                sb.append(MorseCode.encode(c));
            }
            set.add(sb.toString());
        }
        return set.size();

    }
}
