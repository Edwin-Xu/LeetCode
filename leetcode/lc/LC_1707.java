package leetcode.lc;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Edwin Xu
 * @date 5/23/2021 3:21 PM.
 * <p>
 * 1707. 与数组中元素的最大异或值
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * <p>
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * <p>
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 * <p>
 * https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array/
 */

public class LC_1707 {
    /**
     * 朴素做法
     * 时间复杂度 O(N*M)
     */
    public int[] maximizeXor01(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int maxXor = Integer.MIN_VALUE;
            int[] query = queries[i];
            for (int num : nums) {
                if (num <= query[1]) {
                    maxXor = Math.max(maxXor, num ^ query[0]);
                }
            }
            if (maxXor == Integer.MIN_VALUE) {
                maxXor = -1;
            }
            ans[i] = maxXor;
        }
        return ans;
    }

    /**
     * 需要对内循环做优化
     * 一种方法是 对nums排序，然后二分查找
     * 还是超时
     */
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int maxXor = Integer.MIN_VALUE;
            int[] query = queries[i];

            // 二分法找到第一个比query[1]大的索引(没有的话取最大)
            int firstLargerIndex = firstLargerIndex(nums, query[1]);

            for (int j = 0; j <firstLargerIndex ;j++) {
                int num = nums[j];
                if (num <= query[1]) {
                    maxXor = Math.max(maxXor, num ^ query[0]);
                }
            }
            if (maxXor == Integer.MIN_VALUE) {
                maxXor = -1;
            }
            ans[i] = maxXor;
        }
        return ans;
    }

    public int firstLargerIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }



    /**
     * 需要字典树 、 离线查询
     *
     * https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array/solution/yu-shu-zu-zhong-yuan-su-de-zui-da-yi-huo-7erc/
     *
     *
     *
     * */

    public static void main(String[] args) {
        LC_1707 lc1707 = new LC_1707();
        int nums[] = {1,2,3,4,6,7};
        System.out.println(nums[lc1707.firstLargerIndex(nums,3)]);

    }
}
