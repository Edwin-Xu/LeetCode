package leetcode.lc;

/**
 * Created by Edwin Xu on 6/3/2020 12:12 AM
 *
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 *
 *
 * 分析：
 * 对于每一个元素：小的左上边，大的右下
 * 两个区域画一个分界线；左下到右上。
 * 从右上开始，对于一个元素X :
 *   T>X: 往下移动1个
 *   T<X: 往左移动1个
 *   T=X: Bingo
 *
 * O(M+N)
 *
 */
public class LC_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0)return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0;
        int y = col-1;
        int tmp;
        while (x<row&&y>=0){
            tmp = matrix[x][y];
            if (target==tmp)return true;
            else if (target>tmp)x++;
            else y--;
        }
        return false;
    }
}
