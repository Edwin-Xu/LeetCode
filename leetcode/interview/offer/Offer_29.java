package leetcode.interview.offer;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 7/5/2020 12:01 PM
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_29 {
    //stupid办法，顺时针走，标记走过的。
    /*
    * 如果不能修改原数组：添加一个同样大小的辅助数组
    * */
    public int[] spiralOrder(int[][] matrix) {
        int index = 1;
        int row = matrix.length;
        int col = matrix[0].length;
        int res[] = new int[row*col];
        res[0]= matrix[0][0];
        matrix[0][0]=-1;
        int i =0 ,j=0;
        while (index<res.length){
            System.out.println("当前在："+i+" "+j);
            while (j+1<col && matrix[i][j+1]!=-1){
                Print.print("往右走到",i,j+1,index);
                res[index++] = matrix[i][++j];
                matrix[i][j] = -1;
            }

            System.out.println("当前在："+i+" "+j);
            while (i+1<row && matrix[i+1][j]!=-1){
                Print.print("往下走到",i+1,j,index);
                res[index++] = matrix[++i][j];
                matrix[i][j] = -1;
            }

            System.out.println("当前在："+i+" "+j);
            while (j-1>=0 && matrix[i][j-1]!=-1){
                Print.print("往左走到",i,j-1,index);
                res[index++] = matrix[i][--j];
                matrix[i][j] = -1;
            }

            System.out.println("当前在："+i+" "+j);
            while (i-1>=0 && matrix[i-1][j]!=-1){
                Print.print("往上走到",i-1,j,index);
                res[index++] = matrix[--i][j];
                matrix[i][j] = -1;
            }

        }
        return res;
    }

    /*
    * 解法2：转圈圈：看成一圈一圈的
    *
    *
    * */

    public static void main(String[] args) {
        int a[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int res[]  = new Offer_29().spiralOrder(a);
        for(int i:res) System.out.print(i+" ");


    }
}
