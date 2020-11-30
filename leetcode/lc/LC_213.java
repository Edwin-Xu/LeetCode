package leetcode.lc;

/**
 * Created by Edwin Xu on 9/23/2020 1:47 PM
 *
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 通过次数57,449提交次数145,697
 */
public class LC_213 {

    /*
  和打家劫舍不一样的地方在于： 房子是绕成一圈的
  最后一个房子偷不偷还得考虑第一个。
  那记录第一个房子是否偷，没有偷着最后一个偷，否则最后一个不偷
  这样似乎不行。

  环状的房子：第一个和最后一个不能同时取。
  于是可以分为两个单排：
    - 没有最后一个房子
    - 没有第一个房子。
    - 取其中大的结果
  */
    public int rob(int[] nums){
        if(nums==null || nums.length==0)return 0;
        int len = nums.length;
        if(len==1) return nums[0];
        if(len==2)return Math.max(nums[0],nums[1]);

        int nums1[] = new int[len-1];
        for(int i = 0;i<len-1;i++)nums1[i] = nums[i];
        int nums2[] = new int[len-1];
        for(int i = 1;i<len;i++)nums2[i-1] = nums[i];

        return Math.max(rob2(nums1),rob2(nums2));
    }

    /*
    * 对于：排状的房子
    * */
    public int rob2(int[] nums)
    {
        if(nums==null || nums.length==0)return 0;
        int len = nums.length;
        int [] dp = new int[len];
        dp[0] = nums[0];
        if(len>1) dp[1] = Math.max(nums[0],nums[1]);
        for(int i =2 ; i <len ;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[len-1];
    }
}
