package leetcode.lc;

/**
 * Created by Edwin Xu on 9/17/2020 12:43 PM
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 */
public class LC_367 {
    public boolean isPerfectSquare(int num) {
        //牛顿迭代法
        if(num==1)return true;
        double res = num/2;
        for(int i =0 ;i<100;i++){
            res = res - (res*res-num)/(2*res);
        }
        res = (int )res;
        return res*res == num;
    }
}
