package leetcode.contest.contest20210619;

/**
 * @author Edwin Xu
 * @date 6/19/2021 6:56 PM.
 *
 *
 *
 */

import java.util.*;

public class Main01 {
    /**
     * #include <bits/stdc++.h>
     * using namespace std;
     * long long gcd(int a,int b)
     * {
     *     if(b==0) return a;
     *     else return gcd(b,a%b);
     * }
     * int main()
     * {
     *     int a,b,c,d;
     *     cin>>a>>b>>c>>d;
     *     int x=a*c/gcd(a,c);
     *      if(x==a||x==c) x=x*2;
     *      if(x>=b||x>=d) cout<<-1<<endl;
     *      else{
     *          if(b%x==0&&d%x==0) cout<<x<<endl;
     *          else cout<<-1<<endl;
     *      }
     *
     *     return 0;
     * }
     *
     *
     *
     *
     * #include<bits/stdc++.h>
     * #define LL long long
     * using namespace std;
     * int gcd(int a,int b)
     * {
     *     if (b==0) return a;
     *         else return gcd(b,a%b);
     * }
     * int main()
     * {
     *     int a,b,c,d;
     *     cin>>a>>b>>c>>d;
     *     int x=gcd(b,d);
     *     if (x==b||x==d) {x--;}
     *     for (int i=x; i>max(a,c); i--)
     *     {
     *         if (i%a==0 && i%c==0 && b%i==0 && d%i==0)
     *         {
     *             cout<<i;
     *             return 0;
     *         }
     *     }
     *     cout<<-1;
     *     return 0;
     * }
     * */
    public static int gcd(int a_, int b_) {
        int a = Math.max(a_,b_);
        int b = Math.min(a_,b_);
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a,int b){
        long c = a*b;
        return (int)(c/gcd(a, b));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
         * x = k1a
         * x = k2c
         * x是a\c的公倍数
         * b = k3x
         * d = k4x
         * x是b\d的公因数
         * */
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int x = gcd(b, d);
        int acLCM = lcm(a,c);
        while (x >= acLCM ) {
            if (b % x == 0 && d % x == 0 && x % a == 0 && x % c == 0) {
                System.out.println(x);
                return;
            }
            x--;
        }
        System.out.println(-1);

        scanner.close();
    }

}

