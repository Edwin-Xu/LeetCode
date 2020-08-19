package leetcode.lc;

import java.util.Arrays;

/**
 * Created by Edwin Xu on 6/28/2020 10:32 PM
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *  
 *
 * 进阶：
 *
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_209 {
    /*暴力*/
    public int minSubArrayLen_v(int s, int[] nums) {
        int len = nums.length;
        int [] arr = new int[len+1];
        for (int i = 0; i < len; i++) {
            arr[i+1] = arr[i]+nums[i];
        }
        int max = Integer.MAX_VALUE;
        for (int i = 0; i <= len; i++) {
            for (int j=i+1;j<=len;j++){
                if (arr[j]-arr[i]>=s && j-i<max)max = j-i;
            }
        }
        if (max == Integer.MAX_VALUE)max=0;
        return max;
    }

    /*
    * 动态规划
    * 之前遇到：最大子序和、最大连续乘积
    * 都是使用动态规划算法解决的
    * 本题肯定可以使用动态规划
    *
    * 维护一个数组：a，
    * a[i]表示从i开始到达的第一个和大于s的下标
    * 知道a[0]后，a[1]就好求：用a[0]的和-nums[0]和s比较
    * 大于就往右缩短，小于就往右
    * 需要2维数组：往右达到的第一个合>=s的数下标，以及和
    *
    * 2 3 1 2 4 3
    *
    *
    *
    * 这不是动态规划
    *
    * 最好On，最坏O(N2)
    * */
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if(len==0)return 0;

        int[][] arr = new int[len][2];
        int i = 0;
        for (; i < len; i++) {
            arr[0][0]+=nums[i];
            if (arr[0][0]>=s){
                break;
            }
        }
        arr[0][1] = i;
        if (arr[0][0]<s)return 0;

        int min = Integer.MAX_VALUE;
        if (arr[0][1]+1<min)min = arr[0][1]+1;

        for (int j=1;j<len;j++){
            System.out.println(arr[j-1][0]+" "+arr[j-1][1]+" "+nums[j-1]);
            int tmp = arr[j-1][0]-nums[j-1];
            System.out.println(tmp);
            if (tmp>=s){
                //大了，往左，但是会小于s，说明当前就是最大的
                arr[j][0]=tmp;
                arr[j][1]=arr[j-1][1];
            }else{
                //要小，还得往右：
                int k=arr[j-1][1]+1;
                arr[j][0] = tmp;
                for (;k<len;k++){
                    arr[j][0]+=nums[k];
                    if (arr[j][0]>=s){
                        break;
                    }
                }
                arr[j][1]=k;
            }
            if (arr[j][1]-j+1<min)min = arr[j][1]-j+1;

        }

        return min;
    }


    /*
    * 前缀和+二分法
    * 由于本题元素所有都为正，所以前缀和为递增的，二分的基础。
    *
    * */
    static class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            int[] sums = new int[n + 1];
            // 为了方便计算，令 size = n + 1
            // sums[0] = 0 意味着前 0 个元素的前缀和为 0
            // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
            // 以此类推
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
            for (int i = 1; i <= n; i++) {
                int target = s + sums[i - 1];
                int bound = Arrays.binarySearch(sums, target);
                if (bound < 0) {
                    bound = -bound - 1;
                }
                if (bound <= n) {
                    ans = Math.min(ans, bound - (i - 1));
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }


    /*
    *
    * 双指针方式
    *
    * 在方法一和方法二中，都是每次确定子数组的开始下标，然后得到长度最小的子数组，因此时间复杂度较高。为了降低时间复杂度，可以使用双指针的方法。

定义两个指针 \textit{start}start 和 \textit{end}end 分别表示子数组的开始位置和结束位置，维护变量 \textit{sum}sum 存储子数组中的元素和（即从 \text{nums}[\textit{start}]nums[start] 到 \text{nums}[\textit{end}]nums[end] 的元素和）。

初始状态下，\textit{start}start 和 \textit{end}end 都指向下标 00，\textit{sum}sum 的值为 00。

每一轮迭代，将 \text{nums}[end]nums[end] 加到 \textit{sum}sum，如果 \textit{sum} \ge ssum≥s，则更新子数组的最小长度（此时子数组的长度是 \textit{end}-\textit{start}+1end−start+1），然后将 \text{nums}[start]nums[start] 从 \textit{sum}sum 中减去并将 \textit{start}start 右移，直到 \textit{sum} < ssum<s，在此过程中同样更新子数组的最小长度。在每一轮迭代的最后，将 \textit{end}end 右移。

    *
    * */
    public int minSubArrayLen_twopointers(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int twopointer_solution(int s,int []nums){
        int len = nums.length;
        if (len==0)return 0;
        int start=0;
        int end = 0 ;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (end<len){
            sum+=nums[end];
            while (sum>=s){
                res = Math.min(res,end-start+1);
                sum-=nums[start++];
            }
            end++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }


    public static void main(String[] args) {
        LC_209 lc_209 = new LC_209();
        int arr [] = {1,2,3,4,5};
        int s = 11;
        System.out.println(lc_209.minSubArrayLen(s,arr));

        System.out.println( new LC_209.Solution().minSubArrayLen(s,arr));

    }
}
