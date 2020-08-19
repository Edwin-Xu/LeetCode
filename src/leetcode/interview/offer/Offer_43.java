package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 7/5/2020 12:24 AM
 *
 * 剑指 Offer 43. 1～n整数中1出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 */


public class Offer_43 {
    /*
    * 一个一个数，超时
    * */
    public int countDigitOne(int n) {
        int res = 0;
        for (int j = 1; j <=n ; j++) {
            int i = j;
            while (i!=0){
                if ((i%10)==1)res++;
                i/=10;
            }
        }
        return res;
    }

    /*
    * 更好的方法：
    *
    * */
    public int countDigitOne_(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }


    /*
    * 我的其他思路分析：
    * 一个数，其所有位置上都可能是1：
    * 对于1位数：只有 1 ：个位一个1
    * 对于2位数：10、11：十位一个1:、个位十位2个1、仅个位是1:21 31 41 51 61 71 81 91:8个
    * 对于三位数：个十百3个1、仅个位1：
    *  三位数和两位数的关系：
    *  两位数和1位数的关系：知道1位数只有1个1，两位数只是十位不同，十位有8中可能。因此十位1总数=个位1数*8+个位+位数-1
    *
    *
    * 不对不对-------------------
    * */

    public int f(int digitsNum){
        if (digitsNum ==1)return 1;
        return (int)Math.pow(9,digitsNum-1)+9*f(digitsNum-1)
                +(int)Math.pow(10,digitsNum-1)-1-(int)Math.pow(9,digitsNum-1);
    }

    public static void main(String[] args) {
//        System.out.println(new Offer_43().countDigitOne_(824883294));
//        System.out.println(new Offer_43().countDigitOne(824883294));


        System.out.println(new Offer_43().countDigitOne_(99));
        System.out.println(new Offer_43().f(2));
    }
}
