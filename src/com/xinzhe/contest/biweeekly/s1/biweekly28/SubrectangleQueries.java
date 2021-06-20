package com.xinzhe.contest.biweeekly.s1.biweekly28;

/**
 * @author Xin
 * @date 2020/6/13
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class SubrectangleQueries {
    public static void main(String[] args) {

    }
    int[][] arr;
    public SubrectangleQueries(int[][] rectangle) {
        this.arr = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2 ; ++i) {
            for (int j = col1; j <= col2 ; ++j) {
                arr[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return arr[row][col];
    }

}
