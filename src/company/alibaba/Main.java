package company.alibaba;

import java.util.Arrays;

/**
 * Created by Edwin Xu on 7/21/2020 8:14 PM
 * 给定N和K，求互不相同的正整数x,y,z使得x+y+z=N，且gcd(x,y)=gcd(x,z)=gcd(y,z)=K。
 * 条件：1 ≤N, K≤ 1e18
 *
 * analysis:
 *  x+y+z = N
 *
 *  x=n1*K
 *  y=n2*K
 *  z=n3*K
 *
 *
 *  分析：
 *
 *  同时除以k，得到三个互质的数，然后看N/K是奇数还是偶数
 */
public class Main {
    /*
    * 辗转相除法
    *  15 12
    *  15/12 = 1--3
    *  12/3 = 4--0 ==>  3 is ok
    * */
    public int gcd(int a,int b){
        if (b==0)return a;
        return gcd(b,a%b);
    }



    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.gcd(120,15));
    }

}
