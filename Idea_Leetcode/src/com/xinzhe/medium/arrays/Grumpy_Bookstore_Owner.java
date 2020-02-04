package com.xinzhe.medium.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class Grumpy_Bookstore_Owner {
    public static void main(String[] args) {
//        int[] customer = {1,0,1,2,1,1,7,5};
//        int[] grumpy = {0,1,0,1,0,1,0,1};
        int[] customer = {3,2,1};
        int[] grumpy={1,1,1};
        System.out.println(maxSatisfied(customer,grumpy,3));
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        if(X>=customers.length) return Arrays.stream(customers).sum();

        for (int i = 0; i < customers.length; i++) {
            if(grumpy.length > i && grumpy[i] == 0){
                sum += customers[i];
            }
        }

        if(X == 0) return sum;
        int max = 0;
        for(int i=0; i<=customers.length - X; i++){
            int tmp = 0;
            for (int j = 0; j < X; j++) {
                if(grumpy.length > i && grumpy[i+j] == 1){
                    tmp += customers[i+j];
                }
            }
            max = Math.max(max, tmp);
        }
        return sum+max;
    }
}
