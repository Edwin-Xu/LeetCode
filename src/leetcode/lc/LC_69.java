package leetcode.lc;

/**
 * Created by Edwin Xu on 5/14/2020 1:19 PM
 *
 * X 的平方根
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 *
 *
 * x^2/4 = x
 * x = 4
 *
 *
 *
 *
 * 扩展思考：计算器上那些复杂的运算是怎么实现的？？？
 *
 */
public class LC_69 {

    public static int mySqrt(int x) {
        return binarySearch(x,0,x);
    }
    //二分法：使用递归
    private static int binarySearch(int x,int b,int e){
        System.out.println(b+" "+e);
        if (b>e)return e;
        int mid = (b+e)/2;
        long m = mid*mid;
        if (m==e)return mid;
        else if (m<x) return binarySearch(x,mid+1,e);
        else return binarySearch(x,b,mid-1);
    }

    //二分法：使用迭代
    public static int mySqrt_iter(int x) {
        int L=0;
        int R=x;
        int M;
        int M2;
        while (true){
            M=(L+R)/2;
            M2=M*M;
            if (M2==x)return M;
            else if(M2<x){
                L=M+1;
            }
            else R=M-1;
        }
    }


    /*
    * 牛顿迭代法
    *
    * x2=a
    * fx = x2-a
    *
    * */
    public int mySqrt_newton_iteration(int a){
        double x = a;
        for(int i =0;i<30;i++){
            x = x- (x*x-a)/(x*2);
        }
        return (int)x;
    }


    public static void main(String[] args) {
//        System.out.println(LC_69.mySqrt(0));
//        System.out.println(LC_69.mySqrt(1));
//        System.out.println(LC_69.mySqrt(2));
//        System.out.println(LC_69.mySqrt(3));
//        System.out.println(LC_69.mySqrt(4));
//        System.out.println(LC_69.mySqrt(5));
//        System.out.println(LC_69.mySqrt(9));
//        System.out.println(LC_69.mySqrt(10));
//        System.out.println(LC_69.mySqrt(101));
        System.out.println(LC_69.mySqrt(1010));
        System.out.println(LC_69.mySqrt(2147395599));

//        System.out.println(LC_69.mySqrt_iter(2147395599));
    }
}
