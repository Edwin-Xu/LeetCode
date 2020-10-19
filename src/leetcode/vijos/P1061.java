package leetcode.vijos;

/*
* / Vijos / 题库 /
迎春舞会之三人组舞
背景
HNSDFZ的同学们为了庆祝春节，准备排练一场舞

描述
n个人选出3*m人，排成m组，每组3人。

站的队形——较矮的2个人站两侧，最高的站中间。

从对称学角度来欣赏，左右两个人的身高越接近，则这一组的“残疾程度”越低。

计算公式为 h=(a-b)^2 (a、b为较矮的2人的身高)
那么问题来了。

现在候选人有n个人，要从他们当中选出3*m个人排舞蹈，要求总体的“残疾程度”最低。

格式
输入格式
第一排为m，n。

第二排n个数字，保证升序排列。

输出格式
输出最小“残疾程度”。

样例1
样例输入1
9 40
1 8 10 16 19 22 27 33 36 40 47 52 56 61 63 71 72 75 81 81 84 88 96 98 103 110 113 118 124 128 129 134 134 139 148 157 157 160 162 164
Copy
样例输出1
23
* */

import java.util.Scanner;

public class P1061 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();



    }
}
