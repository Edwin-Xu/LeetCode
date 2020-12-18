package leetcode.lc;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 12/18/2020 10:08 PM.
 *
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 */

public class LC_389 {
    /**
     * 第一想法：使用两个Map<char, int>, 记录每个字符出现的次数，然后一对比即可。
     * 使用一个数组即可：计数法
     */
    public char findTheDifference(String s, String t) {
        int [] arr1 = countChar(s);
        int [] arr2 = countChar(t);
        for (int i = 0; i <26 ; i++) {
            if (arr1[i]!=arr2[i]){
                return (char) (i+'a');
            }
        }
        return 'a';
    }
    private int[] countChar(String s){
        int [] arr = new int[26];
        for (int i = 0; i <s.length() ; i++) {
            int index = s.charAt(i)-'a';
            arr[index]++;
        }
        return arr;
    }






    /**
     * 方法2: 求和
     * 分别求和，差不就是那个值吗
     * */
    public char findTheDifferenceBySum(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }


    /**
     * 方法2：位运算
     * 如果将两个字符串合并，那么插入的那个就是只会出现奇数次。
     * 然后当做整数，全部异或之后得到的值就是 那个数。
     * */
    public char findTheDifferenceByXor(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }




    public static void main(String[] args) {
        System.out.println('a'-0);
    }
}
