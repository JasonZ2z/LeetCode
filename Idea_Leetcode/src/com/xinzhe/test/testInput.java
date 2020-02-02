package com.xinzhe.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
                    continue;
                }
            }
        }
        Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        for(Integer x: list){
            sb.append(x).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
