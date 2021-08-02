package leetcode.nowcoder.nc;

/**
 * @author Edwin Xu
 * @date 6/28/2021 8:16 PM.
 * <p>
 * 描述
 * 给定一个double类型的数组arr，其中的元素可正可负可0，返回子数组累乘的最大乘积。
 * 示例1
 * 输入：
 * [-2.5,4,0,3,0.5,8,-1]
 * 返回值：
 * 12.00000
 */

public class NC_83 {

    /**
     * 解法一：暴力求解
     * 直接暴力遍历每一个子数组，求得最大的积。
     *
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */
    public double maxProduct01(double[] arr) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            double sum = 1;
            for (int j = i; j < arr.length; j++) {
                sum *= arr[j];
                // 求得子数组arr[i]~arr[j]的积，更新最大值
                max = Math.max(max, sum);
            }
        }
        return max;
    }


    /**
     * 解法二：动态规划
     * 本题要求最大子序积，是【最大子序和】的加强版，动态规划是经典解法(注意：子数组要求是连续的)。
     *
     * 在最大子序和中，状态转移方程为 f(i)=max{f(i−1)+arr[i], arr[i]}, f(i)数组的局部最大子序和，求出最大的f(i)即可
     *
     * 最大子序积中，需要考虑负数的问题，因为一个负数乘以一个负数可能会变为最大值。于是我们维护局部最大值fmax(i)和局部最小值fmin(i),状态转移方程如下：
     *  fmax(i) = max{fmax(i-1)*arr[i], fmin(i-1)*arr[i], arr[i]}
     *  fmin(i) = min{fmin(i-1)*arr[i], fmax(i-1)*arr[i], arr[i]}
     *
     *  时间复杂度：O(N)
     *  空间复杂度：O(1)
     */
    public double maxProduct(double[] arr) {
        double min = arr[0];
        double max = min;
        double res = min;
        for (int i = 1; i < arr.length; i++) {
            double t_max = max;
            //局部最大值可以从哪些地方产生：1. arr[i]  2. min*arr[i]  3. max*arr[i]
            max = Math.max(Math.max(arr[i], arr[i] * max), min * arr[i]);
            //局部最小值可以从哪些地方产生：1. arr[i]  2. max*arr[i]  3. min*arr[i]
            min = Math.min(Math.min(arr[i], arr[i] * min), t_max * arr[i]);
            //更新全局最大值
            res = Math.max(res, max);
        }
        return res;
    }
}
