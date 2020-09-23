package leetcode.lc;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 9/22/2020 6:59 PM
 * <p>
 * 407. 接雨水 II
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给出如下 3x6 的高度图:
 * [
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]
 * ]
 * <p>
 * 返回 4 。
 */
public class LC_407 {
    /*
     * 动态规划
     *
     * 和LC_42-接雨水一样的
     * 不过是三维
     *
     * 对于每一个柱子：
     *   - 求其左边、右边、上边、下边的最高柱子
     *
     *
     *
     * 动态规划有问题的：
     *          {12,13,1,12},
                {13,4,13,12},
                {13,8,10,12},
                {12,13,12,12},
                {13,13,13,13}
         对于4：4的上下左右都是13，但是最低不是13，而是12:8-10-12
         所以4能装的水是12-4=8，而不是13-4=9
     * */
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        int row = heightMap.length;
        int col = heightMap[0].length;
        int map[][][] = new int[4][row][col];

        //上
        for (int i = 0; i < col; i++) { //对于每一列
            map[0][0][i] = heightMap[0][i];//该列的第一个高度
            for (int j = 1; j < row; j++) { //往下，计算每一个上边柱子的最大高度
                map[0][j][i] = Math.max(heightMap[j][i], map[0][j - 1][i]);
            }
        }
        Print.printArr(map[0]);
        System.out.println();

        //下
        for (int i = 0; i < col; i++) { //对于每一列
            map[1][row - 1][i] = heightMap[row - 1][i];//该列的最后一个高度
            for (int j = row - 2; j >= 0; j--) { //往下，计算每一个上边柱子的最大高度
                map[1][j][i] = Math.max(heightMap[j][i], map[1][j + 1][i]);
            }
        }
        Print.printArr(map[1]);
        System.out.println();

        //左
        for (int i = 0; i < row; i++) { //对于每一行
            map[2][i][0] = heightMap[i][0];//该行的第一个高度
            for (int j = 1; j < col; j++) { //往下，计算每一个上边柱子的最大高度
                map[2][i][j] = Math.max(heightMap[i][j], map[2][i][j - 1]);
            }
        }
        Print.printArr(map[2]);
        System.out.println();

        //右
        for (int i = 0; i < row; i++) { //对于每一行
            map[3][i][col - 1] = heightMap[i][col - 1];//该行的第一个高度
            for (int j = col - 2; j >= 0; j--) { //往下，计算每一个上边柱子的最大高度
                map[3][i][j] = Math.max(heightMap[i][j], map[3][i][j + 1]);
            }
        }
        Print.printArr(map[3]);
        System.out.println();


        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(Math.min(map[0][i][j], Math.min(map[1][i][j], Math.min(map[2][i][j], map[3][i][j]))));
                System.out.print("_"+heightMap[i][j]+"  ");

                res += Math.min(map[0][i][j], Math.min(map[1][i][j], Math.min(map[2][i][j], map[3][i][j]))) - heightMap[i][j];
            }
            System.out.println();
        }

        System.out.println(res);

        return res;

    }

    private int getMin(int i,int j,int [][][]map){
        if (i<0 || i>=map[0].length || j<0 || j>=map[0][0].length)return Integer.MAX_VALUE;
        return Math.min(map[0][i][j], Math.min(map[1][i][j], Math.min(map[2][i][j], map[3][i][j])));
    }

    public static void main(String[] args) {
        int[][] arr
//                = {
//                {1, 4, 3, 1, 3, 2},
//                {3, 2, 1, 3, 2, 4},
//                {2, 3, 3, 2, 3, 1}
//        };

        = {
                {12,13,1,12},
                {13,4,13,12},
                {13,8,10,12},
                {12,13,12,12},
                {13,13,13,13}
        };
        LC_407 lc_407 = new LC_407();
        lc_407.trapRainWater(arr);
    }
}
