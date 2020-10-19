package basic_algorithm.basic;

/**
 * Created by Edwin Xu on 4/27/2020 12:24 PM
 *
 * 最大公约数
 * 最小公倍数
 *
 * 注意
 * 最小公倍数是没法直接求的
 * 使用两个数的积/最大公因数即可
 *
 *
 * 最大公倍数有迭代和递归两种解法
 */
public class GCD_LCM {
    public static int gcd_recursion(int a,int b){
        if (a%b==0)return b;
        return gcd_recursion(b,a%b);
    }
    /*
      辗转相除法
      如15，12
      15/12 = 1...3
      12/3=4...0
      余数=0 ， 除数即为GCD
    */
    public static int gcd_iteration(int a,int b){
        int c ;
        while (b!=0){
            c=a;
            a=b;
            b=c%b;
        }
        return a;
    }

    public int lcm(int a,int b){
        return a*b/gcd_iteration(a,b);
    }






    /*
    15/12 = 1...3
    12/3 = 4..0
     */

    public  static int gcd_review(int a,int b){
        if (a%b==0)return b;
        return gcd_review(b,a%b);
    }









    public static void main(String[] args) {
        System.out.println(GCD_LCM.gcd_recursion(150*177*3,122321*177));
        System.out.println(GCD_LCM.gcd_iteration(17*15,17*256*15));
        System.out.println(GCD_LCM.gcd_review(17*15,17*256*15));
    }

}
