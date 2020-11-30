package leetcode.lc;

/**
 * Created by Edwin Xu on 9/17/2020 11:59 AM
 * 1015. 可被 K 整除的最小整数
 * 给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。
 *
 * 返回 N 的长度。如果不存在这样的 N，就返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：1
 * 输出：1
 * 解释：最小的答案是 N = 1，其长度为 1。
 * 示例 2：
 *
 * 输入：2
 * 输出：-1
 * 解释：不存在可被 2 整除的正整数 N 。
 */
public class LC_1015 {
    public int smallestRepunitDivByK(int K) {
        if((K&1)==0)return -1;
        long arr[][] = {
                {1,1},
                {11,2},
                {111,3},
                {1111,4},
                {11111,5},
                {111111,6},
                {1111111,7},
                {11111111,8},
                {111111111,9},
                {1111111111,10},
                {11111111111L,11},
                {111111111111L,12},
                {1111111111111L,13},
                {11111111111111L,14},
                {111111111111111L,15},
                {1111111111111111L,16},
                {11111111111111111L,17},
                {111111111111111111L,18},
                {1111111111111111111L,19},
        };
        for (long[] a: arr){
            if (a[0]%K==0)return (int)a[1];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(Integer.MAX_VALUE/2));
    }
}