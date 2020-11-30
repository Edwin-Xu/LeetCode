package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 6/27/2020 4:51 PM
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 考虑通过递归来降低复杂度：
 *
 * pow(x,n) = {
 *     (x*x)^(n/2), n is even
 *     x*(x*x)^(n/2), n is odd
 * }
 * be careful： consider n is negative
 *
 * 不用递归也行吧
 */
public class Offer_16 {
    /*
    * O（N）算法：一个个相乘
    * */
    public double myPow_1(double x, int n) {
       boolean isNeg = x<0;
       boolean isOdd = (n&1)==1;
        double res = x;
        for (int i = 1; i < Math.abs(n) ; i++) {
            res*=x;
        }

        return 0;
    }
    /*
    * 递归解法
    * O(logN)
    * */
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0)
            pow = pow * base;
        return isNegative ? 1 / pow : pow;
    }

    public static void main(String[] args) {
        System.out.println(new Offer_16().myPow(-2,-2) );

        System.out.println(Math.pow(2,    -2147483648));
    }

    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

}
