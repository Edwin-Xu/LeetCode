package leetcode.lc;

import java.util.Arrays;

/**
 * @author Edwin Xu
 * @date 7/2/2021 1:41 PM.
 */

public class LC_1833 {
    /**
     * 01背包问题：f[i,j]表示cost=i，从0-j中选择雪糕的最大雪糕数
     * f[i,j] = max{f[i, j-1], 1 + f[i-costs[j]][j-1]}
     * <p>
     * 空间复杂度过高
     */
    public int maxIceCreamByDp01(int[] costs, int coins) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] dp = new int[coins + 1][costs.length + 1];

        for (int i = 1; i <= coins; i++) {
            for (int j = 1; j <= costs.length; j++) {
                dp[i][j] = i >= costs[j - 1] ? Math.max(dp[i][j - 1], 1 + dp[i - costs[j - 1]][j - 1])
                        : dp[i][j - 1];
            }
        }
        return dp[coins][costs.length];
    }

    /**
     * 排序
     * <p>
     * 傻逼了，DP不适合做这道题，选择前X个最小的不就行了吗，只要满足和比coins小
     */
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0;
        int i = 0;
        for (; i < costs.length; i++) {
            sum += costs[i];
            if (sum > coins) {
                break;
            }
        }
        return i;
    }

    /**
     * 计数排序
     */
    public int maxIceCreamSort(int[] costs, int coins) {
        int[] freq = new int[100001];
        for (int cost : costs) {
            freq[cost]++;
        }
        int count = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                int curCount = Math.min(freq[i], coins / i);
                count += curCount;
                coins -= i * curCount;
            } else {
                break;
            }
        }
        return count;
    }


    /**
     * 用递归: 时间复杂度过高
     */
    public int maxIceCreamByRecur(int[] costs, int coins) {
        return maxIC(costs, coins, costs.length - 1);
    }

    private int maxIC(int[] costs, int coins, int cur) {
        if (cur < 0) {
            return 0;
        }
        if (costs[cur] <= coins) {
            return Math.max(maxIC(costs, coins, cur - 1), 1 + maxIC(costs, coins - costs[cur], cur - 1));
        } else {
            return maxIC(costs, coins, cur - 1);
        }
    }

}
