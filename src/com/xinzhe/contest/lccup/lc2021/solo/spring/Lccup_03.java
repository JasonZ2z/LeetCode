package com.xinzhe.contest.lccup.lc2021.solo.spring;

/**
 * @author xzheng
 * @create 2021/4/5
 */
public class Lccup_03 {
    public static void main(String[] args) {
        Lccup_03 lc = new Lccup_03();
        int[] arr = {100,100,100,-250,-60,-140,-50,-50,100,150};
        System.out.println(lc.magicTower(arr));
    }
    public int magicTower(int[] nums) {
        int n = nums.length;
        long x = 0, y = 0;
        for (int num : nums) {
            if(num > 0) x += num;
            else y += num;
        }
        if(y == 0) return 0;
        if(x + y < 0) return -1;

        //List<Integer> list = new LinkedList<>();
        long cur = 0;
        int count = 0;
        for (int num : nums) {
            if(num >= 0) cur += num;
            else {
                if(num + cur < 0) {
                    count++;
                } else if((num * -1.0 / (x - cur)) >= ((num - y) * 1.0 / x)) {
                    //list.add(num);
                    count++;
                } else {
                    cur += num;
                }
                y -= num;
            }
        }
        return count;
    }
}
