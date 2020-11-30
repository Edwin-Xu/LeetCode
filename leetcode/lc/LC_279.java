package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/11/2020 8:08 PM.
 *
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */

public class LC_279 {
    /*
如果知道 n-i^2 需要的 最小个数X，那么n需要X+1

*/
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int a = (int) (Math.sqrt(i));
            if (a * a == i) { //i就是一个完全平方数
                dp[i] = 1;
                continue;//跳过
            }
            //i不是一个完全平方数：从 dp [ n-j^2 ]中取最小的
            int j = 1;
            int min = Integer.MAX_VALUE;
            while (i - j * j >= 1) {
                min = Math.min(min, dp[i - j * j]);
                j++;
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    /*
    * 上面是一种方法，时间复杂度O( N * sqrt(N) )
    * 还有好多种方法：
    * https://leetcode-cn.com/problems/perfect-squares/solution/wan-quan-ping-fang-shu-by-leetcode/
    *
    * */
}
