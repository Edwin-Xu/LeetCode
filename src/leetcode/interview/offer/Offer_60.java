package leetcode.interview.offer;

import java.text.DecimalFormat;

/**
 * Created by Edwin Xu on 7/3/2020 11:36 AM
 *
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 *
 *
 *
 *
 * 看似是数学题，但是按数学方式很难解决
 * 还是要回到动态规划方式
 */
public class Offer_60 {
    private  double combination(int n, int k) {
        int a=1,b=1;
        if(k>n/2) {
            k=n-k;
        }
        for(int i=1;i<=k;i++) {
            a*=(n+1-i);
            b*=i;
        }
        return b/(a+0.0);
    }



    /*
    * 动态规划:
    *
    * 求m出现的次数，除以总的数量就是概率
    * */
    public double[] twoSum(int n) {
        double [] res = new double[5*n+1];
        final double T = Math.pow(6,n);
        for (int i = 0; i <= 5*n; i++) {
            res[i] = getPro(n,i+n)/T;
        }
        return res;
    }

    /*
     * n个骰子，和为m的可能 数量
     * */
    private int getPro(int n,int m){
        if (n<0||m<0 || m<n || m>6*n)return 0;
        if (n==1)return 1;
        int res = 0;
        for (int i = 1; i < 7; i++) {
            res+=getPro(n-1,m-i);
        }
        return res;
    }


    /*
    * ook，上面的逻辑正确了，现在优化。
    * 首先：对称的，只需要计算一半
    *
    * */
    public double[] twoSum_optimize_1(int n) {
        double [] res = new double[5*n+1];
        final double T = Math.pow(6,n);
        for (int i = 0; i <= 3*n; i++) {
            res[i] = getPro(n,i+n)/T;
        }
        for (int i=0,j=5*n;i<j;i++,j--){
            res[j] = res[i];
        }
        return res;
    }

    /*
    * 再次优化： 子重复去掉
    * 先判断(n,m)是否被计算过
    * 这个存储比较麻烦
    * 开一个大的二维数组？
    * */
    public double[] twoSum_optimize_2(int n) {
        int [][] mem = new int[n+1][6*n+1];

        double [] res = new double[5*n+1];
        final double T = Math.pow(6,n);
        for (int i = 0; i <= 3*n; i++) {
            res[i] = getPro_optimize_1(n,i+n,mem)/T;
        }
        for (int i=0,j=5*n;i<j;i++,j--){
            res[j] = res[i];
        }
        return res;
    }
    private int getPro_optimize_1(int n,int m,int[][] mem){
        if (n<0||m<0 || m<n || m>6*n)return 0;
        if (mem[n][m]!=0)return mem[n][m];
        if (n==1)return 1;
        int res = 0;
        for (int i = 1; i < 7 && n-1>=0 && m-i>=0; i++) {
            if(mem[n-1][m-i]==0) mem[n-1][m-i]= getPro_optimize_1(n-1,m-i,mem);
            res+=mem[n-1][m-i];
        }
        return res;
    }



    public static void main(String[] args) {
        double [] res = new Offer_60().twoSum_optimize_2(2);
        DecimalFormat df = new DecimalFormat("0.######");
        for (double i: res){
            System.out.print(df.format(i)+" ");
        }
    }
}
