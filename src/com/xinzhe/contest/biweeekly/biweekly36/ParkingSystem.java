package com.xinzhe.contest.biweeekly.biweekly36;

/**
 * @author Xin
 * @date 2020/10/3
 * Title : 1603. 设计停车系统
 * Description : 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 * link : https://leetcode-cn.com/problems/design-parking-system/
 * Level : Easy
 */
public class ParkingSystem {
    public static void main(String[] args) {
        ParkingSystem lc = new ParkingSystem(1,1,1);
        int[] arr = {1,4,2,5,3};
    }
    int b, m, s;
    public ParkingSystem(int big, int medium, int small) {
        this.b = big;
        this.m = medium;
        this.s = small;
    }

    public boolean addCar(int carType) {
        if(carType == 1) {
            if(b > 0) {
                b--;
                return true;
            }
        } else if(carType == 2) {
            if(m > 0) {
                m--;
                return true;
            }
        } else if(carType == 3) {
            if(s > 0) {
                s--;
                return true;
            }
        }
        return false;
    }
}
