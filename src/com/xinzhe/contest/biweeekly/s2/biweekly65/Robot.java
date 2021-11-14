package com.xinzhe.contest.biweeekly.s2.biweekly65;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/11/13
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Robot {
    public static void main(String[] args) {
        Robot lc = new Robot(8,11);
        lc.move(18);
        System.out.println(Arrays.toString(lc.getPos()));
        System.out.println(lc.getDir());
        lc.move(24);
        System.out.println(Arrays.toString(lc.getPos()));
        System.out.println(lc.getDir());
        lc.move(44);
        lc.move(36);
        System.out.println(Arrays.toString(lc.getPos()));
        System.out.println(lc.getDir());

    }
    int x = 0, y = 0, dir = 0;
    int[][] arr = {{1, 0}, {0,1}, {-1, 0}, {0, -1}};
    int width, height;
    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void move(int num) {
        num %= (width + height - 2) * 2;
        if(width == 1 && height == 1) {
            dir %= num;
            return;
        }
        while(num > 0) {
            int a = x + arr[dir][0] * num;
            int b = y + arr[dir][1] * num;
            if(a < 0) {
                num -= x;
                x = 0;
                if(num > 0 ) dir = (dir + 1) % 4;
                continue;
            }
            if(a >= width) {
                num -= width - x - 1;
                x = width - 1;
                if(num > 0 ) dir = (dir + 1) % 4;
                continue;
            }
            if(b < 0) {
                num -= y;
                y = 0;
                if(num > 0 ) dir = (dir + 1) % 4;
                continue;
            }
            if(b >= height) {
                num -= height - y - 1;
                y = height - 1;
                if(num > 0 ) dir = (dir + 1) % 4;
                continue;
            }
            x = a;
            y = b;
            break;
        }
    }

    public int[] getPos() {
        return  new int[]{x, y};
    }

    public String getDir() {
        if(dir == 0) return "East";
        if(dir == 1) return "North";
        if(dir == 2) return "West";
        return "South";
    }
}