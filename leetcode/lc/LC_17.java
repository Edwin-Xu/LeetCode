package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/3/2020 1:41 PM.
 * <p>
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class LC_17 {
    List<String> res = new LinkedList<>();
    char[][] chs = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return res;
        combine(digits, 0, new StringBuilder());
        return res;
    }

    private void combine(String digits, int index, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c : chs[digits.charAt(index) - '2']) {
            sb.append(c);
            combine(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        LC_17 lc_17 = new LC_17();
        List<String> res = lc_17.letterCombinations("23");
        for (String s : res) {
            System.out.print(s + " ");
        }


    }
}
