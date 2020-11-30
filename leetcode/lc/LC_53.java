package leetcode.lc;

/**
 * Created by Edwin Xu on 6/19/2020 2:59 PM
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 *
 * 话不多少： 动态规划算法
 * 状态转移方程：
 * dp[n]=max(dp[n-1]+a[n], a[n])
 * dp[n]是从0-n的最大子数组和
 *
 *
 */
public class LC_53 {
    public int maxSubArray_On_Space(int[] nums) {
        int len = nums.length;
        if (len==0)return -1;
        int dp[] = new int[len];
        dp[0]=nums[0];
        for (int i = 1; i < len; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max = dp[0];
        for(int n:dp){
            if (n>max)max = n;
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len==0)return -1;
        int sum=nums[0];
        int max = sum;
        for (int i = 1; i < len; i++) {
            sum=Math.max(sum+nums[i],nums[i]);
            if (sum>max)max=sum;
        }
        return max;
    }


    public static void main(String[] args) {

    }
}
