package com.xinzhe.sword.chapter03;

import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/10/23
 * Title : 03.06. 动物收容所
 * Description : 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * link : https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * Level : Medium
 */
public class AnimalShelf {
    LinkedList<int[]> list;
    public AnimalShelf() {
        list=new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        list.add(animal);
    }

    public int[] dequeueAny() {
        if(list.size()==0) return new int[]{-1,-1};
        int[] deq = list.get(0);
        list.remove(0);
        return deq;
    }

    public int[] dequeueDog() {
        for(int i=0;i<list.size();++i){
            int[] k=list.get(i);
            if(k[1]==1){
                list.remove(i);
                return k;
            }
        }
        return new int[]{-1,-1};
    }

    public int[] dequeueCat() {
        for(int i=0;i<list.size();++i){
            int[] k=list.get(i);
            if(k[1]==0){
                list.remove(i);
                return k;
            }
        }
        return new int[]{-1,-1};
    }
}
