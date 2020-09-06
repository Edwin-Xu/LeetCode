package company.bilibili;

import java.util.Scanner;

/**
 * Created by Edwin Xu on 9/5/2020 10:41 PM
 *
 * [编程题]连续整数求和
 * 时间限制：C/C++ 1秒，其他语言2秒
 * 空间限制：C/C++ 32M，其他语言64M
 *
 * 给定一个正整数N，试求有多少组连续正整数满足所有数字之和为N? (1 <= N <= 10 ^ 9)
 *
 * 输入描述:
 * 5
 *
 * 输出描述:
 * 2
 */
public class Main {

    public int findNum(int n){
        int cnt = 1; //n
        int L = 1;
        int R = 2;
        while (R<=n-1 && L<R){
            double sum = (L+R)*(R-L+1)/2.0;
            if (sum==n){
                cnt++;
                R++;
            }
            else if (sum<n){
                R++;
            }else{
                L++;
            }
        }
        return cnt;
    }

    /*
    *
    *  int N=sqrt(2*n);
        int cnt=0;
        for(int i=1;i<=N;i++)
        {
            int tmp=n-(i-1)*i/2.0;
            if(tmp%i==0)
                cnt++;
        }
        cout<<cnt<<endl;


         int sqrtN = (int)Math.sqrt((double)N*2);//项数 < sqrt(2 * N) + 1
        for(int i = 2;i < sqrtN + 1;i++){
           if(i%2==1) {
               if (N % i == 0) ans++; //1. 当 项数 为奇数时，N % 项数 = 0
           }else {
               if (N % i == i/2) ans++;//2. 当 项数 为偶数时，N % 项数 = 项数 / 2
           }
        }
    * */

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        Main is = new Main();
        System.out.println(is.findNum(in.nextInt()));


    }
}


