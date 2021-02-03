package leetcode.lc;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 2/3/2021 10:28 PM.
 *
 * 1221. 分割平衡字符串
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的最大数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 2：
 *
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 3：
 *
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 */

public class LC_1221 {
    /**
     * 常规解法
     * */
    public int balancedStringSplitByEdw(String s) {
        int index = 0;
        int cnt = 0;
        while (index<s.length()){
            int L = 0;
            int R = 0;
            do {
                if (s.charAt(index+L+R)=='L'){
                    L++;
                }else {
                    R++;
                }
            }while (L!=R);
            cnt++;

            index+=(L+R);
        }
        return cnt;
    }



    /**
     * 奇特思路：
     *
     * 题目是对两个字符进行操作,那么自然会考虑到字符的ascii码
     * L和R的中间字符O,即L-O=-3;R-O=3,
     * 原串就可以转化为3和-3的序列,这么看思路就很清晰了,
     * 题目要求子串中ΣL=ΣR,并未要求L和R结构对称,再加上所有分割出的子串都必须为平衡串
     * 那么其实就是求±3序列的前缀和为0的次数
     *
     * */
    public int balancedStringSplit(String s) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((sum += (s.charAt(i)-'O'))==0){
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LC_1221 lc_1221 = new LC_1221();
        System.out.println(lc_1221.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(lc_1221.balancedStringSplit("RLLLLRRRLR"));


    }
}
