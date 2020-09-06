package leetcode.nowcoder.nc;

import java.util.Stack;

/**
 * Created by Edwin Xu on 9/5/2020 1:01 PM
 *
 * 题目描述
 * 给出一个仅包含字符'('和')'的字符串，计算最长的格式正确的括号子串的长度。
 * 对于字符串"(()"来说，最长的格式正确的子串是"()"，长度为2.
 * 再举一个例子：对于字符串")()())",来说，最长的格式正确的子串是"()()"，长度为4.
 *
 *
 *
 */
public class NC_49 {
    /*
    *
    * 动态规划
dp[i]表示以i结尾最长合法字符串。如果s[i]=='('时该字符串一定不合法；当s[i]==')'时，
假设存在解，那么该右括号与其对应的左括号之间的字符串一定是合法的。因此对于i-1的位置，
以i-1结尾的合法字符串的开头下标为i - dp[i - 1]，当其前一个位置s[i - 1 - dp[i - 1]]
 == '('时，可以与s[i]进行匹配，dp[i]更新为dp[i - 1] + 2。此时还需要注意，如果在与当
 前右括号匹配的左括号的前一个位置(i - 1 - dp[i - 1]) - 1，以该处为结尾的最长合法字符
 串不为0，也需要加到结果上。例如()()。

    int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];//
        int maxValue = 0;
        for(int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {//
                int prev = i - 1 - dp[i - 1];
                if (prev >= 0 && s.charAt(prev) == '('){
                    dp[i] = dp[i - 1] + 2;
                    if (prev - 1 >= 0) dp[i] += dp[prev - 1];
                }
            }
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }
    * */

    //也算是动态规划的经典案例了

    public int longestValidParentheses_dp (String s) {
        //动态规划
        int [] dp = new int[s.length()]; // 以s[i]结尾的规范串长度
        int max = 0;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==')'){
                int prev = i-dp[i-1]-1; //以上一个字符结尾的规范串的开头的上一个，看这个字符是不是和当前字符匹配
                if(prev>=0 && s.charAt(prev)=='('){
                    dp[i]+=2+dp[i-1]; //匹配，前后两个字符组成一个(),包含中间的规范串
                    if(prev>=1) dp[i]+=dp[prev-1]; //如果整个规范串前面还是规范串，也需要加上，比如前面是()，需要加到当前规范串上
                }
            }else{
                //当前为(, 必然不能是某个规范串的末尾
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }



    /*
    * 使用栈
    * */
    public int longestValidParentheses (String s) {
        Stack<Integer> stack = new Stack<>();
        int start = -1; //当前规范串的起始位置, 只能是-1，不能是0,0就表示从0开始，但是并不一定，-1才表示不从任意出开始
        int max = 0;
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i)=='('){//对于(，无条件push进去
                stack.push(i);
            }else{ //是 )
                if(stack.isEmpty()){
                    start = i; //如果栈为空，表明一定不规范，更新start到i，重新开始
                }else{
                    //栈还不为空。栈顶是(
                    stack.pop();// 弹出栈顶的一个(, 形成一个()
                    //重新计算最大值
                    max = stack.isEmpty() ? Math.max(max,i-start) //栈为空：和start计算比较
                            :Math.max(max,i-stack.peek());//栈不为空，和top计算比较
                }
            }
        }
        return max;
    }




    public static void main(String[] args) {
        NC_49 nc_49 = new NC_49();
        System.out.println(nc_49.longestValidParentheses("((((()))))()()()"));


    }
}
