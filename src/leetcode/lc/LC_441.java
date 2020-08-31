package leetcode.lc;

import company.alibaba.my_exam_20200828.Main;

/**
 * Created by Edwin Xu on 8/29/2020 1:19 AM
 *
 * 441. 排列硬币
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 *
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * 示例 1:
 *
 * n = 5
 *
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * 因为第三行不完整，所以返回2.
 */
public class LC_441 {
    /*
    * f(x) = 1+2++++x = x(x+1)/2
    *
    * 现知道f(x) = n;
    * 求x?
    *
    * 0.5(x2+x)=n的正解
    * x2+x=2n
    * x2+x-2n = 0
    * 根据一元二次方程求根公式直接得出答案：
    * */
    public static int arrangeCoins(int n) {
        long m = n; //这里n本身没问题，但是下面n*8就出现溢出了。所以使用long
        return (int)((Math.sqrt(1+8*m)-1)/2);
    }

    public static void main(String[] args) {
        System.out.println(LC_441.arrangeCoins(15));
    }
}
