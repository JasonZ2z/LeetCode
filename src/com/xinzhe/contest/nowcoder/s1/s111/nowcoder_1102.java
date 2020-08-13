package com.xinzhe.contest.nowcoder.s1.s111;

/**
 * @author Xin
 * @date 2020/8/13
 * Title :
 * Description :
 * link :
 */
public class nowcoder_1102 {
    public int solve (int n, int m, Point[] limit) {
        // write code here

        int res = 1 << n;

//        Set<Integer>[] set  = new HashSet[n+1];
//        for (int i = 1; i <= n; ++i) {
//            set[i] = new HashSet<>();
//        }
//
//        for (Point point : limit) {
//            set[point.x].add(point.y);
//            set[point.y].add(point.x);
//        }
        int count = 0;
        for (int i = 0; i < 1 << n; ++i) {
            boolean flag = true;
            for (Point point : limit) {
                if((i&(1<<(point.x-1))) > 0  && (i&(1<<(point.y-1))) > 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        return count;
    }


      public static class Point {
        int x;
        int y;

          public Point(int x, int y) {
              this.x = x;
              this.y = y;
          }
      }

    public static void main(String[] args) {
        nowcoder_1102 nc = new nowcoder_1102();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 3);
        Point[] arr = new Point[]{p1, p2};
        System.out.println(nc.solve(3, 2, arr));
    }

}
