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
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        char[][] chs = {
                {'a', 'b', 'c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        char [] digitChs = digits.toCharArray();
        //接下来需要计算组合数了

        return res;

    }

//    private void combine()

    public static void main(String[] args) {
        char [] chs = new char[2];
        System.out.println(chs[0]+"--"+(int)chs[0]);
    }
}
