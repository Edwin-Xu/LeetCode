package leetcode.lc;

import leetcode.util.Print;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 1/31/2021 10:59 PM.
 * <p>
 * 验证外星语词典
 * <p>
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 * <p>
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 * <p>
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 */

public class LC_953 {
    /**
     * 从前往后，比较相邻的即可
     */
    public boolean isAlienSortedByEdw(String[] words, String order) {
        if (order == null || words == null) {
            return false;
        }
        // 先记录字符下标 : <字符，下标>
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        // 遍历形式，一对一对校验。
        for (int i = 1; i < words.length; i++) {
            String a = words[i - 1];
            String b = words[i];

            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                int indexA = map.get(a.charAt(j));
                int indexB = map.get(b.charAt(j));
                if (indexA > indexB) {
                    return false;
                } else if (indexA < indexB) {
                    break;
                } else {
                    // 相同，需要判断前面一个是不是已经结束了且长度不一样。
                    if (j == b.length() - 1 && j < a.length() - 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    /**
     * 相同的思路，使用数组而不是map存储< char,index>
     */
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            index[order.charAt(i) - 'a'] = i;
        }

        search:
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a']) {
                        return false;
                    }
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        LC_953 lc_953 = new LC_953();
        String[] strArr = {
                "hello",
                "hello kitty",
                "hi"
        };
        boolean res = lc_953.isAlienSorted(strArr, "hlabcdefgijkmnopqrstuvwxyz");
        System.out.println(res);

        /*
         * for的高级特性1：为每一个for添加标注
         * */
        a:
        for (int i = 0; i < 5; i++) {
            b:
            for (int j = 0; j < 5; j++) {
                c:
                for (int k = 0; k < 5; k++) {
                    if (i == 1) {
                        continue a;
                    }
                    if (j == 1) {
                        break b;
                    }
                    Print.print(i, j, k);
                }
            }
        }

    }

}
