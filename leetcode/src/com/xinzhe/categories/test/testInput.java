package com.xinzhe.categories.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xzheng
 * @date 2020-01-07 13:25
 */
public class testInput {
    public static String getResult(long ulDataInput){
        List<Integer> list = new ArrayList<>();
        while(ulDataInput > 1){
            for(int i=2; i<= ulDataInput; i++){
                if(ulDataInput % i == 0){
                    list.add(i);
                    ulDataInput /= i;
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(Integer x: list){
            sb.append(x).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
