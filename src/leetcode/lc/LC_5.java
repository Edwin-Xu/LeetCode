package leetcode.lc;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 5/10/2020 1:20 AM
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 * <p>
 * <p>
 * <p>
 * x是回文-->yxy是回文
 * 反之：
 * yxy是回文，x是回文，但是不适合找回文
 * <p>
 * 必须是自底向上的
 * <p>
 * <p>
 * 思路1：
 * 遍历：找出以a[i]为中心的回文串长度，取最长的。
 */
public class LC_5 {
    /*
     * 思路1-中心扩展
     * 遍历：找出以a[i]为中心的回文串长度，取最长的。
     * 需要对奇数长度和偶数长度的回文串分别判断：
     *   奇数长度的回文串判断：从中间一位向两边展开，如abcbd,c向外展开即可得到最长回文子串
     *   偶数长度的回文串判断：将当前和下一个字符视为中间串，向外展开，如aabbcc,bb向外展开
     * 算法缺点：
     *   时间复杂度：最坏情况下(相同字符构成的串如aaaa),内层循环会向外判断到最近的边界，
     *   2*(1+2+3+···+n/2+···+3+2+1)
     *   = 2*[2*(((n-1)/2)*((n+1)/2)/2)+n/2]
     *   = (n^2+2n-1)/2
     *   => O(n^2)
     *
     *   时间上击败90%的用户
     * 为了避免计算偶数的回文串，可以填充特殊字符，使任意相邻两个字符不同。
     * */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        char[] c = s.toCharArray();
        int begin = 0;//起始下标
        int max = 1;//回文串长度

        //注意：len-i-1>=max/2。表示如果余下为遍历的位数(len-i-1)不足max的一半时就
        // 断定不会有更长回文串。
        for (int i = 0; i < len && len - i - 1 >= max / 2; i++) {
            //奇数长度回文串判断
            for (int j = 1; i - j >= 0 && i + j < len; j++) {
                if (c[i - j] == c[i + j]) {
                    if (2 * j + 1 > max) {
                        begin = i - j;
                        max = 2 * j + 1;
                    }
                } else break;
            }
            //偶数长度回文串判断：
            for (int j = 0; i - j >= 0 && i + j + 1 < len; j++) {
                if (c[i - j] == c[i + j + 1]) {
                    if (2 * j + 2 > max) {
                        begin = i - j;
                        max = j * 2 + 2;
                    }
                } else break;
            }
        }
        return s.substring(begin, max + begin);
    }

    /*
    思路2：
    中心扩展改进：
    为了避免计算偶数的回文串，可以填充特殊字符，使任意相邻两个字符不同。
    aaa--> ^a^a^a^

    结论：改进不好，为了将内循环复杂度减半，外循环加倍是不值得的
     */
    public String longestPalindrome_optimize(String s) {
        int len = s.length();
        if (len < 2) return s;
        char[] chars = s.toCharArray();
        Character[] c = new Character[2 * len + 1];
        for (int i = 0; i < len; i++) {
            c[i * 2] = '^';
            c[i * 2 + 1] = chars[i];
        }
        c[2 * len] = '^';

        len = c.length;
        int begin = 0;//起始下标
        int max = 1;//回文串长度

        //注意：len-i-1>=max/2。表示如果余下为遍历的位数(len-i-1)不足max的一半时就
        // 断定不会有更长回文串。
        for (int i = 0; i < len && len - i - 1 >= max / 2; i++) {
            for (int j = 1; i - j >= 0 && i + j < len; j++) {
                if (c[i - j] == c[i + j]) {
                    if (2 * j + 1 > max) {
                        begin = i - j;
                        max = 2 * j + 1;
                    }
                } else break;
            }
        }
        begin = (begin + 1) / 2;
        max = max / 2;
        return s.substring(begin, max + begin);
    }


    /*
     * 最优解：马拉车算法
     * 本质是对中心扩展的改进
     *   中心扩展：
     *       - 没有利用已经知道的回文信息
     *       - 没有利用回文本身的对称性
     *   如何改进？
     *   例子：cabadabae
     *   第1位为中心：[c]abadabae
     *   第2位为中心：c[a]badabae
     *   第3位为中心：c[aba]dabae
     *   第4位为中心：由于我们知道以第3位为中心的信息[aba]，第4位和第2位是
     *    对称的，第二位为中心的回文没有超出[aba]，所以第4位和第2位一样。
     *   第5位为中心：c[abadaba]e
     *   第6位为中心：第5位a和第3位a关于第4位对称，且以第三位为中心的回文没有
     *     超出以第5位中心的回文，故第为6位和第4位一样
     *     这里没有按部就班地以中心扩展判断，而是利用前面的信息，节省了步骤。
     *  那么马拉车就是按这个思路
     * */


    /*
    * 解体步骤：
    * 1. 处理字符串
    * 2. 利用对称计算当前i的回文半径
    * 3. 超出对称范围的中心扩展
    * 4. 更新回文半径
    * */
    public String longestPalindrome_manacher(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("$#"); //这里可以在前后添加字符防止后面越界，不加的话while中心扩展时需要判断越界
        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        sb.append('&');
        char[] chars = sb.toString().toCharArray();

        int p[] = new int[chars.length]; //存储第i位的回文半径(不包含自己的一边长度)
        int C = 0; //中心
        int R = 0; //最右边界
        int C_max = 0;//最大回文中心
        int R_max = 0;//最大回文半径
        for (int i = 1; i < chars.length - 1; i++) {
            int i_mirror = 2 * C - i; //i关于C的对称点
            if (i<R) { //保证i还在最右边界内
                p[i] = Math.min(R - i, p[i_mirror]); //这里画图理解
                /*
                 *   -----RM----iM-----C-----i-------R------
                 *   RM~R是关于C对称的，里面的IM也和i对称，
                 *   如果iM的回文半径小于R-i, i的回文半径等于iM的回文
                 *   否则就是iM的回文半径取R-i，超出的无法判断。
                 * */
            }

            //其他情况，利用中心扩展
            while ( chars[i + 1 + p[i]] == chars[i - 1 - p[i]]) p[i]++;

            //更新回文半径
            if (i + p[i] > R) {
                C = i;
                R = i + p[i];
            }
            //更新最大回文
            if (R_max < p[i]){
                C_max = i;
                R_max = p[i];
            }
        }
        return s.substring((C_max - R_max )/2,(C_max + R_max )/2);
    }

    //动态规划
    public static void main(String[] args) {
        LC_5 lc5 = new LC_5();
        String s = "xabay";
        System.out.println(lc5.longestPalindrome_manacher(s));
        Print.print("By LS:", LC_5.longestPalindrome_ByLS(s));
    }


    /*
    * Li Suai解法
    * */
    public static String longestPalindrome_ByLS(String str) {
        char[] chs = new char[str.length() * 2 + 1];
        //处理原始字符串
        for (int i = 0; i < chs.length; i++) {
            if (i % 2 == 0) chs[i] = '#';
            else chs[i] = str.charAt(i / 2);
        }
        int[] P = new int[chs.length]; //回文半径数组
        int right = 0; // 最右边界
        int r_mid = 0; //最右边界中心
        int max = 0; //最长回文半径
        int m_mid = 0; //最长回文中心
        for (int i = 0; i < P.length; i++) {
            if (i < right) { // i在边界内
                P[i] = Math.min(P[2 * r_mid - i], right - i);
            }
            //中心扩展
            if (P[i] + i >= right) {
                r_mid = i;
                while (i + P[i] < chs.length && i - P[i] >= 0 && chs[i + P[i]] == chs[i - P[i]]) {
                    P[i]++ ;
                    right++;
                }
            }
            //更新最长回文
            if (P[i] > max) {
                max = P[i];
                m_mid = i;
            }
        }
        return str.substring((m_mid - max + 1) / 2, (m_mid + max) / 2);
    }

}
