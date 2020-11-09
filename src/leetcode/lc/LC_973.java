package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 11/9/2020 4:23 PM.
 *
 * 973. 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */

public class LC_973 {
    //堆
    public int[][] kClosest(int[][] points, int K) {
        int [][] ret = new int[K][2];
        //最大堆
        PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point a,Point b){
                return (int)(b.distance - a.distance);
            }
        });
        for(int[] p:points){
            if(q.size()<K){
                q.add(new Point(p[0],p[1]));
            }else{
                int dist = p[0]*p[0] + p[1]*p[1];
                if(dist < q.peek().distance){
                    q.poll();
                    q.add(new Point(p[0],p[1]));
                }
            }
        }

        int index =0;
        for(Point p: q){
            ret[index][0] = p.x;
            ret[index][1] = p.y;
            index++;
        }

        return ret;
    }
    class Point{
        int x;
        int y;
        double distance;
        public Point(int x_, int y_){
            x = x_;
            y = y_;
            distance = x*x + y*y;
        }
    }



    //排序： 先全部排序，再选择。
    //








    //快排改造： O(N)       <<算法导论>>
    Random rand = new Random();

    public int[][] kClosest_qs(int[][] points, int K) {
        int n = points.length;
        random_select(points, 0, n - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void random_select(int[][] points, int left, int right, int K) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        ++i;
        swap(points, i, right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (K < i - left + 1) {
            random_select(points, left, i - 1, K);
        } else if (K > i - left + 1) {
            random_select(points, i + 1, right, K - (i - left + 1));
        }
    }

    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }

}
