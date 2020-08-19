package leetcode.nowcoder;

/**
 * Created by Edwin Xu on 6/24/2020 6:44 PM
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 *
 * 动态规划：
 *  分析出递归条件：    我们用f(n)来表示跳n级台阶的跳法数量，
*
*                                                     f(1)=1表示跳1级台阶的跳法数量;
*
*                                                     f(2)=2表示跳2级台阶的跳法数量;
*
*                                                     f(3)=f(2)+f(1)+1  我们可以递推出  f(n)=f(n-1)+f(n-2)+ *** +f(1)+1 ,
*
*                                                    而f(n-1)=f(n-2)+ *** +f(1)+1。
*
 *                 将两式想减可以求出递推公式，也即是 f(n)-f(n-1)=f(n-1)，即f(n)=2*f(n-1); 所以自底向上的动态规划方法浮出眼前。
 *
 * 贪心算法：
 *
 */
public class Offer_StempJump {
    public int JumpFloorII(int target) {
        if (target<0)return 0;
        if(target<=1)return 1;//是0也得返回1，表示前面的已经刚好走完，算一种解法
        int sum = 0;
        for (int i = 1; i <= target; i++) {
            sum+=JumpFloorII(target-i);
        }
        return sum;


        /*
        * 由于f(n)=2*f(N-1):
        *
        * 一行代码搞定：
        *  return target<=1?1:1<<(target-1);
        *
        * */
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Offer_StempJump().JumpFloorII(i));

        }
    }
}


















