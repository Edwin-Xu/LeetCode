package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 8/20/2020 4:51 PM
 *
 * 典型的动态规划题目
 *
 *
 *
 *
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 *
 *
 *
 */
public class Offer_47 {
    /*
    * 动态规划 递归版
    * 基本就是暴力枚举
    * 超时
    * */
    public int maxValue_recur(int[][] grid) {
        return dfs(grid,0,0);
    }
    private int dfs(int [][] grid,int i,int j){
        if (i==grid.length-1 && j==grid[0].length-1)return grid[i][j];
        if (i==grid.length-1 ){
            return grid[i][j]+dfs(grid,i,j+1);
        }
        else if (j==grid[0].length-1){
            return grid[i][j]+dfs(grid,i+1,j);
        }else{
            int down = dfs(grid,i+1,j);
            int right = dfs(grid,i,j+1);
            return grid[i][j]+Math.max(down,right);
        }
    }

    /*
    * 动态规划
    * 迭代版
    * */
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }
    public int maxValue_opti(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }



    /*
    * 动态规划再次改进：
    * 每个格子都有一个最大值
    * 一个一个计算出来就好：
    * [0,0]位置不变
    * [0,j]向右直接加
    * [i,0]向下加
    * [i,j]比较左边和上边大小，加大的
    *
    * */


}
