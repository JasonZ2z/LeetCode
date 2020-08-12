package com.xinzhe.categories.structure.design;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPackage {
    public static void main(String[] args) {
        List<Integer> amount = divideRedPackage(1000,3);
        for (Integer integer : amount) {
            System.out.println("Money:  " + new BigDecimal(integer).divide(new BigDecimal(100)));
        }
    }

    private static List<Integer> divideRedPackage(Integer total, Integer num) {
        List<Integer> amountList = new ArrayList<>();
        Integer rest = total;
        Integer restNum = num;
        Random  random = new Random();
        for (int i = 0; i < num - 1; i++) {
            int amount = random.nextInt(rest / restNum * 2 - 1) + 1;
            rest -= amount;
            restNum--;
            amountList.add(amount);
        }
        amountList.add(rest);
        return amountList;
    }
}
