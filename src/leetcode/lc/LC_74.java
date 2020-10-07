package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/5/2020 1:26 PM.
 * <p>
 * <p>
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */

public class LC_74 {
    /*
   纵横二分:
   先对所有行的第一个进行二分，找到目标行。
   */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false; //保证源数据正确

        int row = 0;//目标行
        int i = 0;//二分
        int j = matrix.length - 1;
        while (i <= j) {//找行
            row = (i + j) / 2;
            int val = matrix[row][0];
            if (val == target) {
                return true;//该行的第一个就是，直接返回
            } else if (val < target) {
                i = row + 1;
            } else {
                j = row - 1;
            }
        }

        //现在找遍了行的第一个值，如果只有一列，就直接返回false了
        if (matrix[0].length == 1) return false;

        //调整row，上面得到的行可能有偏差，可能是目标值所在行的下一行
        if (row > 0 && matrix[row][0] > target) row--;

        //对目标行进行二分
        i = 0;
        j = matrix[0].length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int val = matrix[row][mid];
            if (val == target) return true;//行中找到了
            else if (val < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;//找遍了该行，还是没有。
    }
}
