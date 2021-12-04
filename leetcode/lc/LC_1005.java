package leetcode.lc;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 * @author taoxu.xu
 * @date 12/4/2021 5:51 PM
 */
public class LC_1005 {

    public static int largestSumAfterKNegations_original(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < k && i < nums.length && nums[i] < 0; i++) {
            nums[i] = -nums[i];
        }
        // i个负数
        if (i > k) {
            // 负数的个数大于K，那就把最低的K个负数转正, 在上面的for中已经做过了
        } else {
            // 否则，把所有的负数转正，然后判断 k -i ， 如果是奇数，则把原来的第一个和其左边的最小者负数取负
            int left = k - i;
            if (left % 2 == 1) {
                if (i == nums.length || (i - 1 >= 0 && nums[i - 1] < nums[i])) {
                    nums[i - 1] = -nums[i - 1];
                } else {
                    nums[i] = -nums[i];
                }
            }
        }

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        return sum;
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < k && i < nums.length && nums[i] < 0; i++) {
            nums[i] = -nums[i];
        }
        if (i <= k && (k - i) % 2 == 1) {
            if (i == nums.length || (i - 1 >= 0 && nums[i - 1] < nums[i])) {
                nums[i - 1] = -nums[i - 1];
            } else {
                nums[i] = -nums[i];
            }
        }

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        return sum;
    }

}
