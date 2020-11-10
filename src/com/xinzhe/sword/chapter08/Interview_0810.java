package com.xinzhe.sword.chapter08;

/**
 * @author Xin
 * @date 2020/7/14
 * Title : 08.10. 颜色填充
 * Description : 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的横坐标为 sr 纵坐标为 sc。需要填充的新颜色为 newColor 。
 *              「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * link : https://leetcode-cn.com/problems/color-fill-lcci
 * Level : Medium
 */
public class Interview_0810 {
    public static void main(String[] args) {
        Interview_0810 lc = new Interview_0810();
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int c = image[sr][sc];
        dfs(sr,sc,c,image, newColor);
        return image;
    }
    int[][] paths = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
    private void dfs(int sr, int sc, int c, int[][] image, int newColor) {
        image[sr][sc] = newColor;
        for(int[] path : paths) {
            int x = sr + path[0];
            int y = sc + path[1];
            if(x < 0 || x >= image.length || y < 0 || y>= image[0].length || image[x][y] == newColor || image[x][y] != c) continue;
            dfs(x, y, c, image, newColor);
        }
    }
}
