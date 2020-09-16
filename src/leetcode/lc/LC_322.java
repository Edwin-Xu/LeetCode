package leetcode.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edwin Xu on 9/16/2020 8:21 PM
 */
public class LC_322 {
    private HashMap<Integer, Integer> memo = new HashMap<>();

    public int coinChange_(int[] coins, int amount) {
        return dp(coins, amount);
    }

    //这个效率也不高
    private int dp(int[] coins, int amount) {
        if (memo.containsKey(amount)) return memo.get(amount);
        if (amount == 0) return 0; //金额=0, 0个硬币即可
        if (amount < 0) return -1; //金额<0，无解，标记-1
        int res = Integer.MAX_VALUE;
        int temp; //存储子问题所需要的硬币+1
        for (int coin : coins) {
            temp = dp(coins, amount - coin);
            if (temp == -1) continue; //子问题返回-1，无解，跳过。
            res = Math.min(res, temp + 1);
        }
        res = (res == Integer.MAX_VALUE) ? -1 : res;
        memo.put(amount, res);
        return res;
    }


    /*
    * //美团二面算法题： 写得还有点问题。
    *
    * 现场写的：
    *  Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int target) {
        if (target < 0) return -1;
        if (target == 0) return 0;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int cnt = 0;
            if (map.containsKey(target - coin)) {
                cnt = map.get(target - coin);
            } else {
                int tmp = coinChange(coins, target - coin);
                if (tmp != -1) {
                    map.put(target - coin, tmp);
                    cnt = tmp;
                }
            }
            if (res > cnt + 1) res = cnt + 1;
        }
        if (res == Integer.MAX_VALUE) return -1;
        return res;

    }
    * 是有问题的
    *
    * 下面修改
    *
    * */
    Map<Integer, Integer> map = new HashMap<>();

    public int coinChange_1(int[] coins, int target) {
        if (target < 0) return -1; // 负数，返回特殊值 -1
        if (target == 0) return 0; // 0，需要0个

        int res = Integer.MAX_VALUE; //设置一个初始值
        for (int coin : coins) { //每次选择一个硬币
            int cnt = 0;
            if (map.containsKey(target - coin)) { //包含子问题
                cnt = map.get(target - coin); //
                if (cnt==-1)continue;
            } else {//不包含子问题
                //计算子问题
                int tmp = coinChange_1(coins, target - coin);
                map.put(target - coin, tmp);
                if (tmp==-1)continue;
                else cnt = tmp;
            }
            res = Math.min(res,cnt+1);
        }
        if (res == Integer.MAX_VALUE)return -1; //这是必要的
        return res;
    }



    // 官方：自上而下  41MS
    public int coinChange_2(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }



    // 官方：自下而上 15MS
    // 上面的顶多算个递归思路
    // 这里才是经典的动态规划
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }




    public static void main(String[] args) {
        LC_322 l = new LC_322();
        int arr[] = {186, 419, 83, 408};
        System.out.println(l.coinChange_(arr, 6249));
        System.out.println(l.coinChange(arr, 6249));
    }
}
