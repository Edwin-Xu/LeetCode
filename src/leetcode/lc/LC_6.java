package leetcode.lc;

import leetcode.util.Print;

import java.util.*;

/**
 * Created by Edwin Xu on 10/4/2020 2:30 PM.
 * <p>
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */

public class LC_6 {
    //最暴力的方法：开一个二维数组
    public String convert(String s, int numRows) {
        if(numRows<=1)return s;

        int len = s.length();
        char map[][] = new char[numRows][len / 2 + 1];
        int x = 0, y = 0;
        int cnt = 0;
        while (cnt < len) {
            while (cnt < len && x>=0 && x < numRows) {
                map[x++][y] = s.charAt(cnt++);
            }
            x=numRows-2;
            y++;
            while (cnt < len && x > 0 && x<numRows) {
                map[x--][y++] = s.charAt(cnt++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 0) sb.append(map[i][j]);
            }
        }
        return sb.toString();
    }



    //空间优化：只存储每一行的数据
    public String convert_(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    /*
    * 最优解：
    * 思路
        按照与逐行读取 Z 字形图案相同的顺序访问字符串。
        算法
        首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
        对于所有整数 kk，:
            行 00 中的字符位于索引 k(2⋅numRows−2) 处;
            行 numRows−1 中的字符位于索引  k(2⋅numRows−2)+numRows−1 处;
            内部的 行 i 中的字符位于索引 k(2⋅numRows−2)+i 以及(k+1)(2⋅numRows−2)−i 处;

*
    * */
    public String convert_best_solution(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        LC_6 lc_6 = new LC_6();
        Print.print( lc_6.convert("AB", 1) );

    }
}
