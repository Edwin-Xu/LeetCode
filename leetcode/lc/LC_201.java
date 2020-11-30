package leetcode.lc;

/**
 * Created by Edwin Xu on 8/23/2020 5:33 PM
 * <p>
 * 201. 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数
 * 字的按位与（包含 m, n 两端点）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: [0,1]
 * 输出: 0
 */
public class LC_201 {
    /*
     * 暴力法
     * */
    public int rangeBitwiseAnd_1(int m, int n) {
        int res = n;
        for (int i = m; i < n; i++) {
            res &= i;
        }
        return res;
    }

    /*
     * 暴力法优化：提前退出
     * */
    public int rangeBitwiseAnd_2(int m, int n) {
        if (m == 0) return 0;
        int res = n;
        for (int i = m; i < n; i++) {
            if (res == 0) return 0;

            res &= i;
        }
        return res;
    }


    /*
     * 1与任何数&是1
     * 0和任何数&是0
     *
     * 看m:m的高位0全部不用考虑
     * 这样并不能减少计算
     *
     * 需要找出关系，减少一部分计算
     *
     * 从两边计算？
     * 可以更可能地遇到0
     * 还是超时
     *
     *
     * 怎么办呢？
     *
     *
     * */
    public int rangeBitwiseAnd_3(int m, int n) {
        if (m == n) return m;
        int res = Integer.MAX_VALUE;
        int tmp;
        while (m < n) {
            tmp = m & n;
            res &= tmp;
            if (tmp == 0 || res == 0) return 0;
            n--;
            m++;
            if (m == n) res &= m;
        }
        return res;
    }


    /*
     * ！！！对所有数字执行按位与运算的结果是所有对应二进制字符串的公共前缀再用零补上后面的剩余位。
     *进一步来说，所有这些二进制字符串的公共前缀也即指定范围的起始和结束数字 mm 和 nn 的公共前缀
     * */
    /*
     * 我们的想法是将两个数字不断向右移动，直到数字相等，即数字被缩减为它们
     * 的公共前缀。然后，通过将公共前缀向左移动，将零添加到公共前缀的右边
     * 以获得最终结果。
     * 时间复杂度：O(logn)
     * */

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }


    /*
    * 方法二：Brian Kernighan 算法
    思路与算法

    还有一个位移相关的算法叫做「Brian Kernighan 算法」，它用于清除二进制串中最右边的 11。

    Brian Kernighan 算法的关键在于我们每次对 \textit{number}number 和 \textit{number}-1number−1 之间进行按位与运算后，\textit{number}number 中最右边的 11 会被抹去变成 00。


    基于上述技巧，我们可以用它来计算两个二进制字符串的公共前缀。

    其思想是，对于给定的范围 [m,n][m,n]（m<nm<n），我们可以对数字 nn 迭代地应用上述技巧，清除最右边的 11，直到它小于或等于 mm，此时非公共前缀部分的 11 均被消去。因此最后我们返回 nn 即可。

    *
    * */
    public int rangeBitwiseAnd_bk(int m, int n) {
        while (m < n) {
            // 抹去最右边的 1
            n = n & (n - 1);
        }
        return n;
    }


    public static void main(String[] args) {
        LC_201 l = new LC_201();
        System.out.println(l.rangeBitwiseAnd_1(700000000, 2147483641));
        System.out.println(l.rangeBitwiseAnd(700000000, 2147483641));
    }
}
