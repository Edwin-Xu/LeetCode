package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/3/2020 1:36 PM.
 *
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 */

public class LC_73 {
    //同：https://leetcode-cn.com/problems/zero-matrix-lcci/

    //找出所有的0，然后删除之
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for(int i = 0;i< matrix.length;i++){
            for(int j = 0;j< matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int i = 0;i<col.size();i++){
            int x = row.get(i);
            int y = col.get(i);

            //删除X行
            for(int j=0;j< matrix[0].length;j++){
                matrix[x][j]=0;
            }
            //删除Y列
            for(int j=0;j< matrix.length;j++){
                matrix[j][y]=0;
            }
        }
    }
    //空间优化：
    //先记录第一行第一列是否有0，然后利用第一行第一列作为标记，先清除非第一行或非第一列的数据，最后根据第一列第一列是否有0来清除第一行第一列。

}
