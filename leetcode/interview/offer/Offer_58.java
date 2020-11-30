package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 9/28/2020 1:44 PM
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 */
public class Offer_58 {
    public String reverseLeftWords(String s, int n) {
        //居然0ms
        return s.substring(n, s.length()) + s.substring(0, n);

        /*
        //3ms
        char[] chs = new char[s.length()];
        int i = 0;
        for(int j=n;j<chs.length;j++){
            chs[i++] = s.charAt(j);
        }
        for(int j = 0;j<n;j++){
            chs[i++] = s.charAt(j);
        }
        return String.valueOf(chs);

*/
    }

}
