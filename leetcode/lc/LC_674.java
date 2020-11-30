package leetcode.lc;

import java.util.Arrays;

/**
 * Created by Edwin Xu on 9/15/2020 8:07 PM
 *
 * 674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 */
public class LC_674 {
    /*
    * 动态规划
    * */
    public int findLengthOfLCIS(int[] nums) {
        if (nums==null || nums.length == 0)return 0;
        int len = nums.length;
        int dp [] = new int[len]; //动态规划数组。dp[i]表示以nums[i]结尾的最长序列个数
        int max = 1;

        //Arrays.fill(dp,1); //至少和自身形成递增序列。这个地方时间消耗太大。给结果+1效果一样的


        for (int i = 1; i <len ; i++) {
            if (nums[i] > nums[i-1]){
                dp[i]=dp[i-1]+1;
                max = Math.max(max , dp[i]);
            }
        }
        return max+1;
    }



    /*
    * f方法2：滑动窗口
    * */
    public int findLengthOfLCIS_2(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }

}
