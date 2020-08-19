package leetcode.lc;

import leetcode.util.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Edwin Xu on 7/1/2020 5:27 PM
 *
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class LC_718 {
    public int findLength_hash(int[] A, int[] B) {
        /*
         * 方法1：
         *
         * 借助于HaspMap，存放B的元素索引：问题：重复的怎么办，value对应数组即可；
         *
         * 类似滑动窗口： 先将B元素加入map：<元素，索引>
         *     遍历A，在map中找元素，如果有，就对齐窗口，进行匹配。
         *
         *     问题：超时
         * */

        if (A.length > B.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(1024, 1.0f);
        for (int i = 0; i < B.length; i++) {
            ArrayList<Integer> a = map.get(B[i]);
            if (a == null) a = new ArrayList<>();
            a.add(i);
            map.put(B[i], a);
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            ArrayList<Integer> list = map.get(A[i]);
            if (list != null) {
                for (int n : list) {
                    int cnt = 1;
                    for (; cnt + i < A.length && cnt + n < B.length; cnt++) {
                        if (A[cnt + i] != B[cnt + n]) break;
                    }
                    max = Math.max(max, cnt);
                }
            }
        }
        return max;

    }

    /*
     * 方法2： 滑动窗口
     *  A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 用一个指针X指向A，Y指向B
     * A[X]!=B[Y] : X++
     *
     * nonono --这个复杂度比较高了
     *
     * 不不不，这不就是滑动窗口 吗
     *
     * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/wu-li-jie-fa-by-stg-2/
     * https://pic.leetcode-cn.com/9ed48b9b51214a8bafffcad17356d438b4c969b4999623247278d23f1e43977f-%E9%94%99%E5%BC%80%E6%AF%94%E8%BE%83.gif
     *
     * */
    class Solution {
        public int findLength(int[] A, int[] B) {
            int n = A.length, m = B.length;
            int ret = 0;
            for (int i = 0; i < n; i++) {
                int len = Math.min(m, n - i);
                int maxlen = maxLength(A, B, i, 0, len);
                ret = Math.max(ret, maxlen);
            }
            for (int i = 0; i < m; i++) {
                int len = Math.min(n, m - i);
                int maxlen = maxLength(A, B, 0, i, len);
                ret = Math.max(ret, maxlen);
            }
            return ret;
        }

        public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
            int ret = 0, k = 0;
            for (int i = 0; i < len; i++) {
                if (A[addA + i] == B[addB + i]) {
                    k++;
                } else {
                    k = 0;
                }
                ret = Math.max(ret, k);
            }
            return ret;
        }
    }


    /*
    * 动态规划-  动态规划算法真的是太过于牛逼
    *
    * 令 dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀，那么答案即为所有 dp[i][j] 中的最大值。
    * 如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0。
    考虑到这里 dp[i][j] 的值从 dp[i + 1][j + 1] 转移得到，所以我们需要倒过来，首先计算
    dp[len(A) - 1][len(B) - 1]，最后计算 dp[0][0]。

    * */
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        LC_718 l = new LC_718();
        int a[] = {1, 2, 3, 2, 1};
        int b[] = {3, 2, 1, 4, 7};
        Print.print(l.findLength(a, b));
    }
}