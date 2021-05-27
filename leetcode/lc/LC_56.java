package leetcode.lc;

import leetcode.util.Print;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Edwin Xu
 * @date 5/20/2021 2:02 PM.
 * <p>
 * <p>
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */

public class LC_56 {
    /**
     * 先按start由小到大、end由大到小排序，
     * 然后遍历并合并
     */
    public int[][] merge(int[][] intervals) {
        // 先排序
        Arrays.sort(intervals, 0, intervals.length, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            }
            return o2[1] - o1[1];
        });

        ArrayList<Integer[]> res = new ArrayList<>();

        // 遍历中记录参考的区间
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i <= intervals.length; i++) {
            // 处理最后一项
            if (i == intervals.length){
                res.add(new Integer[]{start, end});
                break;
            }
            // 取当前区间，和参考区间对比，有三种情况：
            // ---------
            //            ------  情况一：没有公共区间
            //   ----             情况二，参考区间是当前区间的父区间
            //   ---------------  情况三：两个区间有交集，且不是包含关系

            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            // 这是情况二：不用处理，跳过
            if (curEnd <= end){
                continue;
            }

            // 这是情况一，得到一个独立区间，
            if (curStart > end) {
                res.add(new Integer[]{start, end});
                start = curStart;
                end = curEnd;
            } else {
                // 这是情况三，更新参考区间即可
                end = curEnd;
            }
        }

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = new int[]{res.get(i)[0], res.get(i)[1]};
        }
        return ans;
    }


    public static void main(String[] args) {
        LC_56 lc_56 = new LC_56();
        int[][] arr = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] merge = lc_56.merge(arr);
        Print.printArr(arr);
        System.out.println("---------");
        Print.printArr(merge);
    }
}
