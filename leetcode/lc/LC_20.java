package leetcode.lc;

import java.util.Stack;

/**
 * Created by Edwin Xu on 3/11/2020 4:23 PM
 */

/*
20. 有效的括号

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

 */
public class LC_20{
    private String str;
    private char [] strArr;
    Stack<Character> stack = new Stack<>();

    public LC_20(String str){
        this.str=str;
        strArr = str.toCharArray();
    }

    private boolean match(char c){
        if (stack.empty())return false;
        int tmp = c-stack.peek();
        if (tmp==1||tmp==2)return true;
        return false;
    }

    public boolean method_1(){
        for (char c: strArr){
            //如果栈顶char和当前char相同，匹配，弹出栈顶，处理下一个
            if (match(c)) stack.pop();
            else stack.push(c);
        }
        if (stack.empty()) return true;
        return false;
    }
}
