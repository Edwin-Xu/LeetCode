package dp;


import java.util.HashMap;

/**
 * Created by Edwin Xu on 4/14/2020 12:50 AM
 *凑零钱问题
 *
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的
 * 数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金
 * 额，如果不可能凑出，算法返回 -1
 */
public class CoinChange {

    public void coinChange(int [] coins, int amount){
        System.out.println(dp(coins,amount));
    }
    private int dp(int[] coins,int n){
        if (n==0)return 0;
        if (n<0)return -1;
        int res = Integer.MAX_VALUE;
        for (int c: coins){
            int sub = dp(coins,n-c);
            if (sub==-1)continue;
            res = Math.min(res,1+sub);
        }
        if (res==-1)return -1;
        else  if (res!=Integer.MAX_VALUE)return res;
        return 0;
    }

    /*
    *
    * 最优子结构：arr[i]-k
    * 考虑子问题无解
    * */
    public int mydp(int k,int[] arr){
        if (k==0)return 0;
        if (k<0)return -1;
        int res = Integer.MAX_VALUE;
        for (int a: arr){
            int t = 1+mydp(k-a,arr);
            if (t==0)continue;
            res = res>t?t:res;
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    //为了解决重复的子问题，添加备忘录：
    private HashMap<Integer,Integer> memo = new HashMap<>();
    public int mydpWithMemo(int k,int[] arr){
        if (memo.containsKey(k))return memo.get(k);

        if (k==0)return 0;
        if (k<0)return -1;
        int res = Integer.MAX_VALUE;
        for (int a: arr){
            int t = 1+mydp(k-a,arr);
            if (t==0)continue;
            res = res>t?t:res;
        }
        res = res==Integer.MAX_VALUE?-1:res;
        memo.put(k,res);
        return res;
    }



    public static void main(String[] args) {
        int [] coins = {1,2,5,9};
        CoinChange cc =new CoinChange();
        cc.coinChange(coins,25);
        System.out.println(cc.mydp(25,coins));
        System.out.println(cc.mydpWithMemo(25,coins));


        String s="sd";
        s.indexOf("s");



    }
}
