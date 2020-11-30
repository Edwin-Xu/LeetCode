package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/21/2020 12:44 AM.
 *
 * 925. 长按键入
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 *
 *
 * 示例 1：
 *
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 *
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 *
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 *
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 *
 *
 * 提示：
 *
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 */

public class LC_925 {
    /*
使用两个指针i,j
i指向name开始处
j指向typed开始处
然后i开始向后遍历，对于每一个字母：
    j往后移动，直到遇到和i相同的
*/
    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();
        if (len1 > len2 || len1 == 0 || len2 == 0) return false;//长度上不合法
        if (name.charAt(0) != typed.charAt(0)) return false; //第一个不一样，不可能匹配

        int i = 0;
        int j = 0;

        char pre = typed.charAt(0);//前一个检验的字符,往后的时候需要判断
        // eg: name = abc  typed = adbc   这时d不能直接跳过，应该返回false
        while (i < len1 && j < len2) {
            char c = name.charAt(i);//对于每一个name中的字符

            //j往后直到找到匹配的字符
            while (j < len2 && typed.charAt(j) != c) {
                if (typed.charAt(j) != pre) return false;//如果这个跳过的字符和前一个不一样，那违反了重复的特性，返回false
                j++;
            }
            if (j >= len2) return false; //如果找到末尾来时没找到，返回false
            i++;//找到匹配的，ij都往后移动
            j++;
            pre = c; //更新pre
        }

        if (i < len1) return false;// name没找完就退出来了
        while (j < len2) { //对于剩下的j，还得走完，判断是不是和pre一致。
            if (typed.charAt(j) != pre) return false;
            j++;
        }
        return true;
    }

    /*
    官方的：更好一些
    上面是以name为中心，比较复杂，
    下面以typed为中心，循环条件j < typed.length()
    如果退出是i!=name.length(),就是false，否则true。
    循环中，如果两个指针指向字符相同，ij前移
    否则：看盘j和j-1是否相同，不同的话违反“该字符串重复”的条件，返回false，否则j++;
    */
    public boolean isLongPressedName_office(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
