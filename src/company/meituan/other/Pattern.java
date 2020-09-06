package company.meituan.other;

import java.util.Scanner;

/**
 * Created by Edwin Xu on 4/3/2020 10:07 PM
 */
/*
给出两个字符串，分别是模式串P和目标串T，判断模式串和目标串是否匹配，匹配输出 1，
不匹配输出 0。模式串中‘？’可以匹配目标串中的任何字符，模式串中的 ’*’可以匹配目标
串中的任何长度的串，模式串的其它字符必须和目标串的字符匹配。例如P=a?b，T=acb，
则P 和 T 匹配。

分析：
模式串长度<=目标长度

*a*a*a*
ababab
 */
public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.nextLine();
        String t = sc.nextLine();
        sc.close();

        for (int i=0;i<t.length();i++){

        }

    }

}
