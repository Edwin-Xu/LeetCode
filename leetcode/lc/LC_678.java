package leetcode.lc;

import java.util.LinkedList;

/**
 * TODO
 * 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 * @author taoxu.xu
 * @date 9/12/2021 10:27 PM
 */
public class LC_678 {
    static char LEFT = '(';
    static char RIGHT = ')';
    static char STAR = '*';
    public boolean checkValidString_Wrong(String s) {
        int len = s ==null? 0 : s.length();
        if (len == 0 || s.equals(" ")){
            return true;
        }
        final char[] chs = s.toCharArray();
        final LinkedList<Character> stack = new LinkedList<>();
        int index = 0;
        while (index < len) {
            final char ch = chs[index];
            if (ch == LEFT || ch==STAR){
                // (\*, 加入栈
                stack.addLast(ch);
            }else if (ch == RIGHT) {
                // ) 找匹配
                if (stack.isEmpty()){
                    // 如果没有了，则不能匹配
                    return false;
                }
                final Character first = stack.removeFirst();
                if (first == LEFT){
                    // 遇到(，正常匹配
                }else if (first == STAR){
                    // TODO 遇到*，怎么办，当作空串还是(

                }else{
                    return false;
                }
            }else{
                return false;
            }
            // next
            index++;
        }
        return stack.isEmpty();
    }



    /**
     * 正反遍历
     * */
    boolean checkValidString(String str) {
        int n = str.length();
        // 记录遇到的(和*
        int l = 0, m = 0;
        final char[] s = str.toCharArray();
        for(int i = 0; i < n; ++i){
            // 遇到 ( , l+1
            if(s[i] == '('){
                l++;
            }
            // 遇到)，抵消
            // TODO 顺序不影响判断
            else if(s[i] == ')'){
                l--;
            }
            // 遇到*，m+1
            else{
                m++;
            }
            // 如果(数量为负数了，使用*抵消
            if(l < 0){
                m--;
                l++;
            }
            // 如果*不足，false
            if(m < 0){
                return false;
            }
        }
        //反向遍历，同理
        int r = 0;
        m = 0;
        for(int i = n-1; i >=0; --i){
            if(s[i] == ')'){
                r++;
            }
            else if(s[i] == '('){
                r--;
            }
            else{
                m++;
            }
            if(r < 0){
                m--;
                r++;
            }
            if(m < 0){
                return false;
            }
        }
        return true;
    }


    /**
     * 两个栈分别将"("和"*"的序号压入栈中，每次遇到右括号，首先检测左括号栈中是否为空，不为空则弹出元素，否则弹出star栈，最后考虑left和star栈可能存在元素，判断此时栈中元素的序号大小，如果left栈中的序号大于star中的则表明 存在"*("此种情况，直接false
     *
     * */

    public static void main(String[] args) {
        System.out.println(new LC_678().checkValidString("(())()(())("));
    }

}
