package com.xinzhe.contest.biweeekly.biweekly41;

/**
 * @author Xin
 * @date 2020/12/12
 * Title : 1687. 从仓库到码头运输箱子
 * Description : 你有一辆货运卡车，你需要用这一辆车把一些箱子从仓库运送到码头。这辆卡车每次运输有箱子数目的限制和 总重量的限制。
 *              给你一个箱子数组boxes和三个整数 portsCount, maxBoxes和maxWeight，其中boxes[i] = [portsi, weighti]。
 *              portsi表示第i个箱子需要送达的码头，weightsi是第i个箱子的重量。portsCount是码头的数目。maxBoxes 和maxWeight分别是卡车每趟运输箱子数目和重量的限制。
 *              箱子需要按照 数组顺序运输，同时每次运输需要遵循以下步骤：
 *                  卡车从boxes队列中按顺序取出若干个箱子，但不能违反maxBoxes 和maxWeight限制。
 *                  对于在卡车上的箱子，我们需要 按顺序处理它们，卡车会通过 一趟行程将最前面的箱子送到目的地码头并卸货。如果卡车已经在对应的码头，那么不需要 额外行程，箱子也会立马被卸货。
 *                  卡车上所有箱子都被卸货后，卡车需要 一趟行程回到仓库，从箱子队列里再取出一些箱子。
 *                  卡车在将所有箱子运输并卸货后，最后必须回到仓库.请你返回将所有箱子送到相应码头的最少行程次数。
 * link : https://leetcode-cn.com/problems/delivering-boxes-from-storage-to-ports
 * Level : Hard
 */
//todo too hard to solve
public class Leetcode_biweekly_41014 {
    public static void main(String[] args) {
        Leetcode_biweekly_41014 lc = new Leetcode_biweekly_41014();
        int[] arr = {2, 4, 9, 3};
        System.out.println("abc".repeat(0));
    }
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        return 0;
    }

}