package leetcode.lc;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 12/16/2020 11:07 PM.
 * <p>
 * <p>
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */

public class LC_392 {
    /**
     * 两个循环就搞定:
     * 目的是为了在满足顺序的情况下，在t中找出和s中每一个字符一样的字符
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < s.length()) {
            // 从前往后： 对于 s 中的字符：
            char c = s.charAt(i);
            //找到相同个字符
            while (j < t.length() && t.charAt(j) != c) {
                j++;
            }
            // 知道t的末尾没找到
            if (j >= t.length() || t.charAt(j) != c) {
                return false;
            }

            i++;
            j++;
        }
        return true;
    }

    /**
     * 上面 双指针的 优化写法
     */
    public boolean isSubsequenceTwoPointers(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    /**
     * 动态规划
     * https://leetcode-cn.com/problems/is-subsequence/solution/pan-duan-zi-xu-lie-by-leetcode-solution/
     *
     * 提供思路：
     * 时间复杂度、空间复杂度比上面的方法都高。不值得使用
     *
     */
    public boolean isSubsequenceByDp(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }


    public static void main(String[] args) {
        LC_392 lc_392 = new LC_392();
        System.out.println(lc_392.isSubsequence("abc", "ahbgdc"));
        System.out.println(lc_392.isSubsequence("axc", "ahbgdc"));
    }
}
