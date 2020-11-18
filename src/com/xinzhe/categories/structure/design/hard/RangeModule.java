package com.xinzhe.categories.structure.design.hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Xin
 * @date 2020/11/18
 * Title : 715. Range Module
 * Description : Range 模块是跟踪数字范围的模块。你的任务是以一种有效的方式设计和实现以下接口。
 *              addRange(int left, int right) 添加半开区间[left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间[left, right)中尚未跟踪的任何数字到该区间中。
 *              queryRange(int left, int right)只有在当前正在跟踪区间[left, right)中的每一个实数时，才返回 true。
 *              removeRange(int left, int right)停止跟踪区间[left, right)中当前正在跟踪的每个实数。
 * link : https://leetcode-cn.com/problems/range-module
 * Level : Hard
 */
public class RangeModule {
    //map.floorEntry() : 包含且向下取值
    //map.lowerEntry() : 不包含向下取值
    //map.ceilingEntry() : 包含且向上取值
    //map.higherEntry() ： 不包含向上取值
    //map.subMap(left, right) : 左右默认包含 区间取值
    //map.subMap(left, false, right, false) : 左右可选，区间取值

    public static void main(String[] args) {
        RangeModule m = new RangeModule();
        m.addRange(6,8);
        m.removeRange(7,8);
        m.removeRange(8,9);
        m.addRange(8,9);
        m.removeRange(1,3);
        m.addRange(1, 8);
        System.out.println(m.queryRange(2, 4));
    }
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public RangeModule() { }

    public void addRange(int left, int right) {
        Map.Entry<Integer, Integer> leftFloorEntry = map.floorEntry(left);
        Map.Entry<Integer, Integer> rightFloorEntry = map.floorEntry(right);
        if(rightFloorEntry != null && rightFloorEntry.getValue() >= right) {
            right = rightFloorEntry.getValue();
        }
        if(leftFloorEntry != null && leftFloorEntry.getValue() >= left) {
            left = leftFloorEntry.getKey();
        }
        map.subMap(left, right).clear();   //todo need to review
        map.put(left, right);
    }

    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> leftFloorEntry = map.floorEntry(left);
        Map.Entry<Integer, Integer> rightFloorEntry = map.floorEntry(right);
        int ol = left, or =  right;
        if(leftFloorEntry != null && leftFloorEntry.getValue() > left) {
            left = leftFloorEntry.getKey();
        }
        if(rightFloorEntry != null && rightFloorEntry.getKey() < right && rightFloorEntry.getValue() > right) {
            right = rightFloorEntry.getValue();
        }
        map.subMap(left, right).clear();
        if(ol > left) map.put(left, ol);
        if(or < right) map.put(or, right);
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> leftFloorEntry = map.floorEntry(left);
        return leftFloorEntry != null && leftFloorEntry.getValue() >= right;
    }

}
