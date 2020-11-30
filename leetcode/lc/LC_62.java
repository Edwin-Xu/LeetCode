package leetcode.lc;

import java.util.Arrays;

/**
 * Created by Edwin Xu on 8/29/2020 10:39 PM
 *
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 */
public class LC_62 {
    /*
    * 动态规划
    * 左上角为1，其他的为左+上
    *
    * */
    public int uniquePaths(int col, int row) {//n:row, m:col
        int [][] map = new int[row+1][col+1];
        map[1][1]=1; //start位置，初始化为 1
        for (int i = 1; i <=row ; i++) {
            for (int j = 1; j <=col ; j++) {
                //+=：除了(1,1)位置外，其他都是加0，没效果
                map[i][j] += map[i][j-1]+map[i-1][j];
            }
        }
        return map[row][col];
    }
    /*
    * 上面的空间复杂度可以优化：循环中始终只使用了一行一列。
    * 而且上面没必要多开m+1,n+1 , 初始行列设置为1即可
    * */
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] cur = new int[n];
            Arrays.fill(cur,1);
            for (int i = 1; i < m;i++){
                for (int j = 1; j < n; j++){
                    cur[j] += cur[j-1] ; //
                }
            }
            return cur[n-1];
        }
    }




    /*
    * 直接数学：排列组合
    *
    * 因为机器到底右下角，向下几步，向右几步都是固定的，

比如，m=3, n=2，我们只要向下 1 步，向右 2 步就一定能到达终点。

所以有 C_{m+n-2}^{m-1}
​

    * */



}
