package leetcode.lc;

import leetcode.util.Print;

import java.util.Arrays;

/**
 * Created by Edwin Xu on 9/25/2020 4:23 PM
 * <p>
 * <p>
 * 1288. 删除被覆盖区间
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * <p>
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * <p>
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 * <p>
 * <p>
 * 提示：​​​​​​
 * <p>
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * 对于所有的 i != j：intervals[i] != intervals[j]
 */
public class LC_1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        /*
        [i, j)
        先按i排序， 如果i相同，就按j 降序.

        对于两两相邻的区间：
            看前面的能不能覆盖后面的。
            三种情况：
            1. ------
                ---
            2. ------
                 -----
            3. ------
                       ------
            4. ------ (1的一种，起点相同)
               ----

        */
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[b.length - 1] - a[a.length - 1];
            }
            return a[0] - b[0];
        });

        int res = intervals.length;
        for (int i = 1; i <intervals.length ; i++) {
            int a_begin = intervals[i-1][0];
            int a_end = intervals[i-1][intervals[i-1].length-1];
            int b_begin = intervals[i][0];
            int b_end = intervals[i][intervals[i].length-1];
            if (a_begin<=b_begin && a_end>=b_end){
                res--;
                //合并掉 两个覆盖区间
                intervals[i] = intervals[i-1];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int arr[][] = {
                {1, 4},
                {3, 6},
                {2, 8},
                {1,2}
        };
        LC_1288 lc_1288 = new LC_1288();
        System.out.println(  lc_1288.removeCoveredIntervals(arr));


    }
}
