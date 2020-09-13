package leetcode.nowcoder.nc;

/**
 * Created by Edwin Xu on 9/8/2020 4:55 PM
 * 矩阵的最小路径和
 * 题目描述
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 * 示例1
 * 输入
 * 复制
 * [[1,3,5,9],[8,1,3,4],[5,0,6,1],[8,8,4,0]]
 * 输出
 * 复制
 * 12
 * 备注:
 * 1 \leq n,m \leq 20001≤n,m≤2000
 * 1 \leq arr_{i,j} \leq 1001≤arr
 * i,j
 * ​
 *  ≤100
 */
public class NC_59 {
    /**
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        for (int i = 1; i <matrix.length ; i++) {
            matrix[i][0]+=matrix[i-1][0];
        }
        for (int i = 1; i <matrix[0].length ; i++) {
            matrix[0][i] += matrix[0][i-1];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j <matrix[0].length ; j++) {
                matrix[i][j]+=Math.min(matrix[i][j-1],matrix[i-1][j]);
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];

    }
}
