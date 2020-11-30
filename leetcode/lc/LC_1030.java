package leetcode.lc;

import leetcode.util.Print;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 11/17/2020 12:21 AM.
 *
 * 1030. 距离顺序排列矩阵单元格
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 *
 *
 * 示例 1：
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 *
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 *
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *
 *
 * 提示：
 *
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 */

public class LC_1030 {
    /**
     * simple method:
     *   save all the index(i, j) to an array, then use Arrays.sort to
     *   sort the array.
     *
     * time: O((R*C)*log(R*C))
     * space: O(R*C)
     * */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int [][] res = new int[R*C][2];
        int index = 0;
        for (int i = 0; i <R ; i++) {
            for (int j = 0; j <C ; j++) {
                res[index][0] = i;
                res[index][1] = j;
                index++;
            }
        }
        Arrays.sort(res, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                return (Math.abs(o1[0]-r0) +Math.abs(o1[1]-c0))
                        - (Math.abs(o2[0]-r0) +Math.abs(o2[1]-c0)) ;
            }
        });
        return res;
    }



    /**
     * 方法二：桶排序
     * 方法一中排序的时间复杂度太高。实际在枚举所有点时，我们可以直接按照哈曼顿距
     * 离分桶。这样我们就可以实现线性的桶排序。
     *
     * */

    public int[][] allCellsDistOrderByBucket(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<List<int[]>>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i, j, r0, c0);
                bucket.get(d).add(new int[]{i, j});
            }
        }
        int[][] ret = new int[R * C][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                ret[index++] = it;
            }
        }
        return ret;
    }

    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }



    /**
     * 方法三：几何法
     * 我们也可以直接变换枚举矩阵的顺序，直接按照曼哈顿距离遍历该矩形即可。
     *
     * 注意到曼哈顿距离相同的位置恰好构成一个斜着的正方形边框，因此我们可以从小到大枚举曼哈顿距离，并使用循环来直接枚举该距离对应的边框。我们每次从该正方形边框的上顶点出发，依次经过右顶点、下顶点和左顶点，最后回到上顶点。这样即可完成当前层的遍历。
     *
     * */
    int[] dr = {1, 1, -1, -1};
    int[] dc = {1, -1, -1, 1};

    public int[][] allCellsDistOrderByGeometry(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        int[][] ret = new int[R * C][];
        int row = r0, col = c0;
        int index = 0;
        ret[index++] = new int[]{row, col};
        for (int dist = 1; dist <= maxDist; dist++) {
            row--;
            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != r0) || (i % 2 != 0 && col != c0)) {
                    if (row >= 0 && row < R && col >= 0 && col < C) {
                        ret[index++] = new int[]{row, col};
                    }
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return ret;
    }




    public static void main(String[] args) {
        LC_1030 lc1030 = new LC_1030();
        int[][] res = lc1030.allCellsDistOrder(2,3,1,2);
        Print.printArr(res);

    }
}
