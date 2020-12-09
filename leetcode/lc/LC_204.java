package leetcode.lc;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 12/3/2020 9:35 PM.
 *
 * -----problem description------
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 *
 *
 *
 *
 *
 * --------- analysis -------
 * What's Prime number(质数)? ---as for n, besides 1 and n, it has no 因子
 * Notes: 1 is not a prime number.
 *
 * A prime number n must satisfy：n = 6*i+-1
 */

public class LC_204 {

    public int countPrimes(int n) {
        if(n<=1)return 0;
        if (n<=3){
            return n-2;
        }
        int count = 0;
        for (int i = 1; ; i++) {
            int a = 6*i-5;
            int b = 6*i-1;
            if (a>=n){
                break;
            }
            if (isPrime(a)){
                count++;
            }
            if (b>=n){
                break;
            }
            if (isPrime(b)){
                count++;
            }
        }
        return count+2;
    }



    public boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println( new LC_204().countPrimes(10));
    }
}
