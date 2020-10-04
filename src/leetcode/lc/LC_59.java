package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/3/2020 1:27 PM.
 *
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */

public class LC_59 {
    public int[][] generateMatrix(int n) {
        int res [][] = new int[n][n];
        //一层一层
        int layer = (n+1)/2; // 层数
        int cnt = 1;
        for(int i=0;i<layer;i++){
            int x = i,y=i; //定义一个坐标<x,y>，顺时针走一圈
            while(y<n-i){
                res[x][y++] = cnt++;
            }
            y--;
            x++;
            while(x<n-i){
                res[x++][y]=cnt++;
            }
            x--;
            y--;
            while(y>=i){
                res[x][y--]=cnt++;
            }
            y++;
            x--;
            while(x>i){
                res[x--][y]=cnt++;
            }
            y++;
        }
        return res;
    }
}
