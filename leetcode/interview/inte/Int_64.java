package leetcode.interview.inte;

/**
 * Created by Edwin Xu on 6/2/2020 7:48 PM
 *
 * 求 1+2+...+n ，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键
 * 字及条件判断语句（A?B:C）。
 *
 *
 *
 * 1+2= 1<<2+1
 *
 * 递归可以避免
 */
public class Int_64 {
    public int sumNums(int n) {
        return n*(n+1)/2;
    }

    public int sum(int n){
        if (n==1){
            return 1;
        }else{
            return sum(n-1) +n;
        }
    }

    public static int duanlu(int n){
        boolean flag=  n>0  && (n+=duanlu(n-1))>0;
        return n;
    }

    public static int f(int n){

        int ans = 0, A = n, B = n + 1;
        boolean flag;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;
        System.out.println(A+" "+B+" "+ans);

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;
        System.out.println(A+" "+B+" "+ans);

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;
        System.out.println(A+" "+B+" "+ans);

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;
        System.out.println(A+" "+B+" "+ans);

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        return ans >> 1;

    }


    public static int russiaMul(int a,int b){
        int res = 0;
        if (b==1)return a;
        while (b!=1){
            a <<=1;
            b>>>=1;
            if ((b&1)==1)res+=a;
        }return res;
    }

    public static void main(String[] args) {
        System.out.println(new Int_64().sum(1));
        System.out.println(new Int_64().sum(2));
        System.out.println(new Int_64().sum(3));

        System.out.println(Int_64.duanlu(100));
        System.out.println(Int_64.f(5));


        System.out.println(Int_64.russiaMul(12,12));
        System.out.println(Int_64.russiaMul(1,12));
        System.out.println(Int_64.russiaMul(12,1));

    }
}
