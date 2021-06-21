package leetcode.contest.contest20210612;

/**
 * @author Edwin Xu
 * @date 6/12/2021 10:49 PM.
 *
 * 5202. 最大的幻方 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Medium
 * 一个 k x k 的 幻方 指的是一个 k x k 填满整数的方格阵，且每一行、每一列以及两条对角线的和 全部相等 。幻方中的整数 不需要互不相同 。显然，每个 1 x 1 的方格都是一个幻方。
 *
 * 给你一个 m x n 的整数矩阵 grid ，请你返回矩阵中 最大幻方 的 尺寸 （即边长 k）
 *
 *
 * 这个题花了不少时间，主要是细节问题，需要更多的练习
 */

public class Main02 {
    public int largestMagicSquare(int[][] grid) {
        int w = grid.length;
        int h = grid[0].length;
        if (w<=1 || h<=1){
            return 1;
        }
        /*
        * 从最大的正方形边长开始，遍历，找到一个合法的即返回
        * */
        for (int i = Math.min(w,h); i >=1 ; i--) {
            for (int j = 0; j <= w - i; j++) {
                for (int k = 0; k <= h - i; k++) {
                    // 计算好开始的坐标，然后判断是否是MagicSquare
                    boolean magicSquare = isMagicSquare(grid, j,k,i);
                    if (magicSquare) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * @param grid grid
     * @param i x
     * @param j y
     * @param size 大小/边长
     * 判断是否是MagicSquare
     * */
    private boolean isMagicSquare(int [][] grid, int i, int j, int size){
        // 先得到一个和作为标准，选择正对角线作为标准
        int sum = 0 ;
        //顺便计算下反对角线
        int tmp = 0;
        for (int k = 0 ; k <size ; k++) {
            sum+=grid[i+k][j+k];
            tmp+=grid[i+size-1-k][j+k];
        }
        if (tmp!=sum){
            return false;
        }

        // 计算每一行
        for (int k = i; k < i+size; k++) {
            tmp = 0;
            for (int l = j; l < j+size; l++) {
                tmp+=grid[k][l];
            }
            if (tmp!=sum) {
                return false;
            }
        }

        // 计算每一列，可以和上面for合并
        for (int k = j; k < j+size; k++) {
            tmp = 0;
            for (int l = i; l < i+size; l++) {
                tmp+=grid[l][k];
            }
            if (tmp!=sum) {

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][]grid = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
//        int[][]grid = {{8,1,6},{3,5,7},{4,9,2},{7,10,9}};
//        int[][]grid = {{5,1,3,1},{9,3,3,1},{1,3,3,8}};
        Main02 main02 = new Main02();

        System.out.println(main02.largestMagicSquare(grid));
    }
}
