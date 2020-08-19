package leetcode.lc;

/**
 * Created by Edwin Xu on 6/19/2020 11:55 PM
 *
 *  不同路径 II:
 *
 *  一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 动态规划
 *
 */
public class LC_63 {
    private int[][] grid;
    private int row,col;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid =obstacleGrid;
        row=obstacleGrid.length;
        col = obstacleGrid[0].length;
        return findPathNum(0,0);
    }
    /*
    *
    * 遇到边界、障碍都要处理
    *
    * 递归超时
    * */
    private int findPathNum(int x,int y){
//        Print.print(x,y);
        if (x>=row||y>=col)return 0;

        if (grid[x][y]==1 ){
//            System.out.println("rock");
            return 0;
        }else  if (x==row-1&&y==col-1){
//            System.out.println("ok");
            return 1;
        }else if (grid[x][y]!=1 &&grid[x][y]!=1){
             return findPathNum(x+1,y)+findPathNum(x,y+1);
         }else if (grid[x+1][y]!=1){
             return findPathNum(x,y+1);
         }else if (grid[x][y+1]!=1){
             return findPathNum(x+1,y);
         }
         else return 0;
    }

    public static void main(String[] args) {
        int [][] a = {
                {0,0,0},
                {0,1,0},
                {0,0,0}};
        System.out.println(new LC_63().uniquePathsWithObstacles(a));
    }


    /*
    * 动态规划：
    * 递归时间开销有点大，但是不需要开一个表
    * 迭代解法：dp表，比较快
    *
    * */

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            //dp表记录的是到i,j最多有几条路径
            int[][] dp = new int[m][n];
            int i = 0;
            //上边界在不遇到障碍物时只有唯一路径
            while (i < m && obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
                i++;
            }
            int j = 0;
            //左边界在不遇到障碍物时只有唯一路径
            while (j < n && obstacleGrid[0][j] != 1) {
                dp[0][j] = 1;
                j++;
            }
            for (int p = 1; p < m; p++) {
                for (int q = 1; q < n; q++) {
                    //保证当前位置不是障碍物
                    if (obstacleGrid[p][q] != 1) {
                        //动态方程
                        dp[p][q] = dp[p - 1][q] + dp[p][q - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }

}
