package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/19/2020 1:56 PM.
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 */

public class LC_844 {
    public boolean backspaceCompare(String S, String T) {
        char[] chs1 = S.toCharArray();
        char chs2[] = T.toCharArray();
        int len1 = handleInput(chs1);
        int len2 = handleInput(chs2);

        if (len1 != len2) return false;
        for (int i = 0; i < len1; i++) {
            if (chs1[i] != chs2[i]) return false;
        }

        return true;
    }

    //处理退格,然后把剩下的整理到数组左边，返回长度
    private int handleInput(char[] chs) {
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '#') {
                chs[i] = 0;
                int j = i - 1;
                while (j >= 0 && chs[j] == 0) j--;
                if (j >= 0) chs[j] = 0;
            }
        }

        int i = 0;
        for (int k = 0; k < chs.length; k++) {
            if (chs[k] != 0) chs[i++] = chs[k];
        }
        return i;
    }
}
