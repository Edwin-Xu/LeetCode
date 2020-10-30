package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/25/2020 4:25 PM.
 *
 * 845. 数组中的最长山脉
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *
 */

public class LC_845 {
        /*
    相对暴力：遍历数组，遍历i时将i作为山峰，向两边找。
    122 ms

    */

    //把暴力的写出来
    public int longestMountain_v(int[] A) {
        int max = 0;
        int len  = A.length;
        for(int i = 1; i<len-1; i++){
            int left = 0;
            int right = 0;
            for(int j=i-1;j>=0 && A[j]<A[j+1] ;j-- )left++;
            for(int j=i+1;j<len && A[j]<A[j-1] ;j++ )right++;
            if(left>0 && right>0 && left+right>=2) { //需要保证左右都有，否则不是山峰。
                max = Math.max(max,left+right+1);
            }
        }
        return max;
    }

    /*
    怎么优化？
    对于i+1，如果知道i的山脉情况，可以减少判断。
     dp[N][2]： dp[N]:N:第i个，N0：左边半山脉，N1：右边半山脉
     如果A[i+1]=A[i]：左=i+1,右需要往前走
     如果A[i+1]<A[i]: 左=i+1，右=dp[i][1]
     如果A[i+1]>A[i]: 左=dp[i][0],右：自行判断

     性能还是不行：9 ms

     如果全是递增、递减、不变，时间复杂度是O(N)
     整体也是O(N)
     不太好理解

     关键在right()这里，当A[i]>=A[i-1]会执行，会走到后面第一个A[j]<A[j-1]处，
     然后i-j必然递减，中间不会执行right();
     所以整体上right()会走一遍数组，是O(N)
     加上外层遍历O(N )
     还是O(N)

    */
    public int longestMountain_edw_dp(int[] A) {
        if(A==null || A.length<3)return 0;
        int len = A.length;

        int max = 0;

        int dp[][]= new int[len][2];
        dp[0][1]=right(A,0);
        for(int i=1;i<len;i++){
            if(A[i]==A[i-1]){
                dp[i][0]=i;
                dp[i][1]=right(A,i);
            }else if(A[i]>A[i-1]){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = right(A,i);
            }else{
                dp[i][0]=i;
                dp[i][1] = dp[i-1][1];
            }
            if(dp[i][0]<i&& dp[i][1]>i && dp[i][1]-dp[i][0]+1>=3){
                max = Math.max(dp[i][1]-dp[i][0]+1,max);
            }
        }
        return max;
    }
    private int right(int arr[], int start){
        int res = 0;
        for(int i=start+1; i<arr.length && arr[i]<arr[i-1] ;i++)res++;
        return start+res;
    }

    /*
    上面这种思路的官方写法
    优化了不少
    上面是一次遍历，中间可能需要执行right
    下面是对于右边的，从右往左遍历。确实要好一些
    	3 ms
    */

    public int longestMountain_dp_official(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }





    /**
     还可以使用双指针：
     对于一个山的左山脚，用另一指针开始，找出其右山脚

     2 ms
     */
    public int longestMountain(int[] A) {
        int n = A.length;
        int ans = 0;
        int left = 0;
        while (left + 2 < n) {
            int right = left + 1;
            if (A[left] < A[left + 1]) {
                while (right + 1 < n && A[right] < A[right + 1]) {
                    ++right;
                }
                if (right < n - 1 && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        ++right;
                    }
                    ans = Math.max(ans, right - left + 1);
                } else {
                    ++right;
                }
            }
            left = right;
        }
        return ans;
    }

}
