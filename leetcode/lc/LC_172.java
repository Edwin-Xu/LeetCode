package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/8/2020 4:50 PM.
 *
 * 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */

public class LC_172 {
    /**
     * 方式1：java使用BigInteger算阶乘
     * 方式2：找规律
     * 怎样才能产生0：
     * - 10
     * - 2/4/6/8 x 5
     * 逐步乘，遇到0拿出来
     * O(N)
     */
    public int trailingZeroes_edwinxu(int n) {
        int zeroNum = 0;
        long num = 1;
        for (int i = 2; i <= n; i++) {
            num *= i;
            while (num >= 10 && num % 10 == 0) {//把找到的0提取出来
                num /= 10;
                zeroNum++;
            }
            num %= 1000000000000L; //防止越界，取后半段就行了,为了适应所有数：使用 BigInteger
        }
        return zeroNum;
    }

    /*
    * 高效的计算因子 5
    * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/jie-cheng-hou-de-ling-by-leetcode/
    *
     * 还没看懂
    * */
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
