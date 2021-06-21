package leetcode.contest.contest20210612;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Edwin Xu
 * @date 6/12/2021 10:41 PM.
 *
 *
 * 5767. 检查是否区域内所有整数都被覆盖 显示英文描述
 * 题目难度Easy
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 *
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 *
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * 示例 2：
 *
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 */

public class Main01 {
    /**
     * 利用set，反问所有区间，并将每个值从set中移除，知道set为空
     *
     * 空间复杂度过大，O(right-left)
     *
     * 另一方面，每个区间的每个值都需要访问，时间复杂度过大
     * */
    public boolean isCovered01(int[][] ranges, int left, int right) {
        Set<Integer> set = new HashSet<>();
        for (int i = left; i <=right ; i++) {
            set.add(i);
        }
        for (int[] range : ranges) {
            for (int i = range[0]; i <=range[1] ; i++) {
                set.remove(i);
                if (set.isEmpty()){
                    return true;
                }
            }
        }
        return set.isEmpty();
    }

    /**
     * 不用set，同时利用好区间的边界值特点，减小时间、空间复杂度
     *
     * */
    public boolean isCovered(int[][] ranges, int left, int right) {
        // 对[left, right]区间的每一个数进行判断
        outer:
        for (int i = left; i <=right ; i++) {
            for (int[] range : ranges) {
                if (range[0]<=i && i<=range[1]){
                    // 如果有一个区间包含这个数，就判断下一个
                    continue outer;
                }
            }
            // 所有区间都不包含i，那么返回false
            return false;
        }
        // 遍历完毕，返回true
        return true;
    }


    /**
     * 差分数组
     * 应该是最优解
     *
     * https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/solution/jian-cha-shi-fou-qu-yu-nei-suo-you-zheng-5hib/
     *
     * */












        public static void main(String[] args) {
        int[][] ints = {
                {
                        1, 50
                }
        };
        System.out.println(new Main01().isCovered(ints, 1,50));
    }
}
