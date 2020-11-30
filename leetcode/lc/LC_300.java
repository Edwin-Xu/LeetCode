package leetcode.lc;

/**
 * Created by Edwin Xu on 9/29/2020 1:32 PM
 *
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 *
 * ================ 动态规划 典型题目============
 *
 * 定义 dp[i] 为考虑前 i 个元素，以第 i个数字结尾的最长上升子序列的长度，注意 nums[i] 必须被选取。
 *
 * 我们从小到大计算 dp[]dp[] 数组的值，在计算 dp[i]dp[i] 之前，我们已经计算出 dp[0 \ldots i-1]dp[0…i−1] 的值，则状态转移方程为：
 *
 * dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
 *
 */

public class LC_300 {
    private static int a = 0;

    /*
    * 动态规划经典解法
    *
    * */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int dp[] = new int[len]; //动态规划数组
        dp[0] = 1; // 第一个设置为0
        int res = 1; //最长递增子序列长度
        for (int i = 1; i < len; i++) { //填充dp: dp[i] = max(dp[j])+1  (nums[j] < nums[i])
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    max = Math.max(max, dp[j] + 1);
            }
            dp[i] = max;
            res = Math.max(res, max);
        }
        return res;
    }


    public static void main(String[] args) {
        LC_300 lc_300 = new LC_300();

    }

    /*
    * 二分+贪心
    * O(NlogN)
    *
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int len = 1, n = (int)nums.size();
        if (n == 0) return 0;
        vector<int> d(n + 1, 0);
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) d[++len] = nums[i];
            else{
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    }
                    else r = mid - 1;
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
};

    * */



}
