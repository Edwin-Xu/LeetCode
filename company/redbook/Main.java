package company.redbook;

/**
 * Created by Edwin Xu on 9/5/2020 11:43 PM
 *
 * 薯队长写了一篇笔记草稿，请你帮忙输出最后内容。
 *  1.输入字符包括，"("    ,    ")"    和    "<"和其他字符。
 * 2.其他字符表示笔记内容。
 *  3.()之间表示注释内容，任何字符都无效。    括号保证成对出现。
 *  4."<"表示退格,    删去前面一个笔记内容字符。括号不受"<"影响    。
 *
 * 输入描述:
 * 输入一行字符串。长度<=10000.
 *
 * 输出描述:
 * 输出一行字符串，表示最终的笔记内容。
 *
 * 输入例子1:
 * Corona(Trump)USA<<<Virus
 *
 * 输出例子1:
 * CoronaVirus
 */


import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.nextLine());

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index<sb.length()){
            if (sb.charAt(index)=='<'){
                sb.deleteCharAt(index);
                if (index-1>=0)sb.deleteCharAt(index-1);
                index = Math.max(index-2,0);
            }

            if (sb.charAt(index)=='('){
                stack.push(index);
            }
            if (sb.charAt(index)==')'){
                int pre = stack.pop();
                sb.delete(pre,index+1);
                index = pre-1;
            }



            index++;

        }


        System.out.println(sb.toString());

    }
}

/*
*
*

Corona(Trump)USA<<<Virus
*/
