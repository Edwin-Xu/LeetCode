package leetcode.lc;

/**
 * @author Edwin Xu
 * @date 6/3/2021 1:17 PM.
 * <p>
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 * <p>
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 */

public class LC_525 {
    private int max = 0;
    private int[] sum;

    /**
     * 不对
     * */
    public int findMaxLength(int[] nums) {
        this.sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }

        findMax(0, nums.length - 1);
        return max;
    }

    /**
     * 01相同：返回0
     * 0多：返回-1
     * 1多：返回1
     */
    public int is01Equal(int left, int right) {
        // 总个数
        int sumTmp = right - left + 1;
        // 1的个数
        int oneNum = sum[right] - sum[left];
        int zeroNum = sumTmp - oneNum;
        if (zeroNum == oneNum) {
            return 0;
        }
        return zeroNum > oneNum ? -1 : 1;
    }

    public void findMax(int left, int right) {
        if (left > right || right>=sum.length)return;
        int check = is01Equal(left, right);
        if (check == 0) {
            int sub = right - left + 1;
            max = Math.max(max, sub);
        } else if (check == -1) {
            //需要去掉0
            findMax(left + 1, right);
            findMax(left, right - 1);
        } else {
            findMax(left + 1, right);
            findMax(left, right - 1);
        }
    }


    public static void main(String[] args) {
        LC_525 lc_525 = new LC_525();
        int [] nums = {0,1,0};
        System.out.println(lc_525.findMaxLength(nums));
    }


    /*
    *
    * https://leetcode-cn.com/problems/contiguous-array/solution/lian-xu-shu-zu-by-leetcode-solution-mvnm/
    * 
    * */
}
