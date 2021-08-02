package leetcode.contest.baidustar20210731;

import java.util.Scanner;

/**
 * 给定两个正整数 a,ba,b，求最小和最大的 cc 满足 a \bmod c=b \bmod camodc=bmodc，满足 c-1c−1 为正整数，且 c \le \max(a,b)c≤max(a,b)。
 *
 * 其中的 mod 表示取模运算。
 * @author Edwin Xu
 * @date 7/31/2021 2:00 PM.
 */

public class Main01 {
    static int[] gcd(int a, int b){
        int a_ = a;
        int b_=b;
        int c;
        while (b!=0) {
            c = a%b;
            a = b;
            b = c;
        }
        int diff = Math.abs(a_-b_);
        return new int[]{a, diff>=Math.min(a_,b_)? Math.max(diff, a):a};
    }

    static int[] func(int a,int b){
        int gcd[] = gcd(a, b);
        if (gcd[1] == 1){
            gcd[0] = -1;
            gcd[1] = -1;
            return gcd;
        }
        if (gcd[0] == 1){
            gcd[0] = gcd[1];
            return gcd;
        }
        for (int i = 2; i <=gcd[0] ; i++) {
            if (gcd[0]%i == 0){
                gcd[0] = i;
                return gcd;
            }
        }
        gcd[0] = -1;
        gcd[1] = -1;
        return gcd;
    }

    static StringBuilder sb =  new StringBuilder();



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[] func = func(a,b);
            sb.append(func[0]);
            sb.append(" ");
            sb.append(func[1]);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        sc.close();
    }
}
