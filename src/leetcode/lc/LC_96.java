package leetcode.lc;

import leetcode.util.Print;

import java.util.Set;

/**
 * Created by Edwin Xu on 10/2/2020 7:52 PM.
 * <p>
 * <p>
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * <p>
 * <p>
 * 可以使用动态规划吗？
 * n=1：dp[1] = 1, f(1)=dp[1]
 * n=2：f(2) = dp[1]+dp[2]; dp[2] = 1+dp[1]
 */

public class LC_96 {
    /*
    * Edwinxu
    * 递归写法
    *
    * 时间复杂度大
    * 另外20好像会就超出Int范围
    *
    * */
    public int numTrees(int n) {
        return numTreeBetweenM_N(1, n);
    }
    /*
    * 对于m~n的数
    * 取其中一个i作为根，然后m~i-1作为左子树，i+1~n作为
    * */
    private int numTreeBetweenM_N(int m, int n) {
        if (m >= n) return 1;//叶子节点。
        int res = 0;
        for (int i = m; i <= n; i++) {
            int left = numTreeBetweenM_N(m, i-1);
            int right = numTreeBetweenM_N(i + 1, n);
            res +=  Math.abs(left*right); //左边种数X右边种数
        }
        return res;
    }

    /*
    * 上面不就是子问题吗？
    * 动态规划：
    *
    * */

    public int numTrees_offic(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }



    public static void main(String[] args) {
        LC_96 lc_96 = new LC_96();
        for (int i =1; i <25 ; i++) {
            if (lc_96.numTrees(i)!=lc_96.numTrees_offic(i)){
                Print.print(i,"不正常");
                break;
            }else{
                Print.print(i,"正常");
            }
        }
    }
}
