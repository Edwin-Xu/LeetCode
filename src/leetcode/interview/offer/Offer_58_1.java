package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 9/28/2020 9:37 PM
 *
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Offer_58_1 {
    public String reverseWords(String s) {
        String [] strs = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length-1;i>=0;i--){
            if(strs[i].length()>0){
                sb.append(strs[i]);
                if(i>0)sb.append(" ");
            }
        }

        return sb.toString().trim();
        /*
        * trim是重新创建一个对象，很不好
        * */


    }

    /*

    另外：

    方法一：双指针
算法解析：
倒序遍历字符串 ss ，记录单词左右索引边界 ii , jj ；
每确定一个单词的边界，则将其添加至单词列表 resres ；
最终，将单词列表拼接为字符串，并返回即可。

    **/
}
