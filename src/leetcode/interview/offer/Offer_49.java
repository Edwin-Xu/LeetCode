package leetcode.interview.offer;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 8/5/2020 5:09 PM
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到
 * 大的顺序的第 n 个丑数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * <p>
 * 因子只包含2,3,5：
 * 1,2,3,4,5都是
 * - 必须是偶数，奇数不包含因子2，nonono
 * <p>
 * <p>
 * <p>
 * g = k1*2+k2*3+k3*5
 * 从k入手
 * 1 0 0
 * 0 1 0
 * 2 0 0
 * 0 0 1
 * <p>
 * 0 2 0
 * <p>
 * 1 0 1
 * <p>
 * <p>
 * <p>
 * 用这样找规律分配太麻烦，直接使用动态规划，每次尝试是k123中一个加一，实际给加后最小的加一
 * 也不行：不能在原来的基础上加1
 * 那就把上一次加的k减去，本次k加两个
 * 注意：只有2*2<5，意思是除了
 * <p>
 * 不不不，这都不好
 * <p>
 * <p>
 * <p>
 * 从1开始：用cnt计数
 * 每次+2、+3、+5如果是丑，cnt++，重复
 * 还是不行，需要回溯
 */
public class Offer_49 {
    public int nthUglyNumber_wrong(int n) {
        int k1 = 1;
        int k2 = 0;
        int k3 = 0;
        int pre235 = 2;
        int min = 2;
        for (int i = 1; i < n; i++) {
            System.out.println("last: " + pre235);
            if (pre235 == 2) {
                k1--; //上次加2，减出来
                int t1 = getMul(k1 + 2, k2, k3);//加两个
                int t2 = getMul(k1, k2 + 1, k3);
                int t3 = getMul(k1, k2, k3 + 1);
                min = Math.min(t1, Math.min(t2, t3));
                if (min == t1) k1 += 2;
                else if (min == t2) {
                    k2++;
                    pre235 = 3;
                } else {
                    k3++;
                    pre235 = 5;
                }
            } else if (pre235 == 3) {
                k2--;
                int t1 = getMul(k1 + 1, k2, k3);//加两个
                int t2 = getMul(k1, k2 + 2, k3);
                int t3 = getMul(k1, k2, k3 + 1);
                min = Math.min(t1, Math.min(t2, t3));
                if (min == t1) {
                    k1++;
                    pre235 = 2;
                } else if (min == t2) k2 += 2;
                else {
                    k3++;
                    pre235 = 3;
                }
            } else {
                k3--;
                int t1 = getMul(k1 + 1, k2, k3);//加两个
                int t2 = getMul(k1, k2 + 1, k3);
                int t3 = getMul(k1, k2, k3 + 2);
                min = Math.min(t1, Math.min(t2, t3));
                if (min == t1) {
                    k1++;
                    pre235 = 2;
                } else if (min == t2) {
                    k2++;
                    pre235 = 3;
                } else k3 += 2;
            }
            Print.print(min, k1, k2, k3);

        }
        return min;
    }

    private int getMul(int k1, int k2, int k3) {
        return 2 * k1 + 3 * k2 + 5 * k3;
    }


    public int nthUglyNumber_still_wrong(int n) {
        int cnt = 0;
        int res = 0;
        while (cnt <= n) {
            if (isUglyNum(res + 2)) {
                res += 2;
                cnt++;
                continue;
            }
            if (isUglyNum(res + 3)) {
                res += 3;
                cnt++;
                continue;
            }
            res += 5;
            cnt++;
        }
        System.out.println(res);
        return res;
    }
    private boolean isUglyNum(int n) {
        if (n <= 0) return false;
        if (n < 7) return true;
        while (n != 1) {
            if (n % 2 == 0) n /= 2;
            else if (n % 3 == 0) n /= 3;
            else if (n % 5 == 0) n /= 5;
            else return false;
        }
        return true;
    }



/*
* 丑数的递推性质： 丑数只包含因子 2, 3, 52,3,5 ，因此有 “丑数 == 某较小丑数 \times× 某因子” （例如：10 = 5 \times 210=5×2）。


设已知长度为 nn 的丑数序列 x_1, x_2, \cdots , x_nx
1
​
 ,x
2
​
 ,⋯,x
n
​
  ，求第 n+1n+1 个丑数 x_{n+1}x
n+1
​
  。根根据递推性质，丑数 x_{n+1}x
n+1
​
  只可能是以下三种情况其中之一（索引 a, b, ca,b,c 为未知数）：

x_{n+1} = \begin{cases} x_{a} \times 2 & ,a \in [1, n] \\ x_{b} \times 3 & ,b \in [1, n] \\ x_{c} \times 5 & ,c \in [1, n] \end{cases}
x
n+1
​
 =
⎩
⎪
⎪
⎨
⎪
⎪
⎧
​

x
a
​
 ×2
x
b
​
 ×3
x
c
​
 ×5
​

,a∈[1,n]
,b∈[1,n]
,c∈[1,n]
​


由于 x_{n+1}x
n+1
​
  是 最接近 x_nx
n
​
  的丑数，因此索引 a, b, ca,b,c 需满足以下条件：

\begin{cases} x_{a} \times 2 > x_n \geq x_{a-1} \times 2 & ，即 x_a 为首个乘以 2 后大于 x_n 的丑数 \\ x_{b} \times 3 > x_n \geq x_{b-1} \times 3 & ，即 x_b 为首个乘以 3 后大于 x_n 的丑数 \\ x_{c} \times 5 > x_n \geq x_{c-1} \times 5 & ，即 x_c 为首个乘以 5 后大于 x_n 的丑数 \\ \end{cases}
⎩
⎪
⎪
⎨
⎪
⎪
⎧
​

x
a
​
 ×2>x
n
​
 ≥x
a−1
​
 ×2
x
b
​
 ×3>x
n
​
 ≥x
b−1
​
 ×3
x
c
​
 ×5>x
n
​
 ≥x
c−1
​
 ×5
​

，即x
a
​
 为首个乘以2后大于x
n
​
 的丑数
，即x
b
​
 为首个乘以3后大于x
n
​
 的丑数
，即x
c
​
 为首个乘以5后大于x
n
​
 的丑数
​


若索引 a,b,ca,b,c 满足以上条件，则可使用递推公式计算下个丑数 x_{n+1}x
n+1
​
  ，其为三种情况中的最小值，即：

x_{n+1} = \min(x_{a} \times 2, x_{b} \times 3, x_{c} \times 5)
x
n+1
​
 =min(x
a
​
 ×2,x
b
​
 ×3,x
c
​
 ×5)

因此，可设置指针 a,b,ca,b,c 指向首个丑数（即 11 ），循环根据递推公式得到下个丑数，并每轮将对应指针执行 +1+1 即可。


* */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
//            System.out.println(dp[i]);
        }
        return dp[n - 1];
    }



    /*
    * 其他解法：
    *
利用小根堆，完美解决
燕少江湖
发布于 2020-07-10
751
解题思路
跟面试题 17.09. 第k个数一样的做法，任何丑数乘以2、3、5，其结果也是丑数（证
明略），我们可以利用小根堆，然后1作为第一个丑数，每次从小根堆弹出最小的丑
数，然后记录已弹出丑数的个数，如果count>=n,返回当前弹出的元素，否则继续乘
以2、3、5，（注意：放入堆里的元素需要排除重复值）。

    * */

    public static void main(String[] args) {
        Offer_49 offer_49 = new Offer_49();
        Print.print( offer_49.nthUglyNumber(10));
        offer_49.f(10);
    }




    /*
    * 自己写一下那个动态规划，不是很理解
    * 其实也很好理解：
    * 每一个丑数 = 一个丑数*2 || 一个丑数*3 ||一个丑数*5
    * 第一个丑数是1，所以第二个是1*2,1*3,1*5中最小的一个
    * 第二个丑数是2，第三个是2*2,2*1,5*1中的一个
    * 第三个是 -----
    * 用a,b,c来存储X2，X3，X5的倍数
    * */

    public int f(int n){
        int a=0,b=0,c=0;
        int [] dp = new int[n];
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            int t2=  dp[a]*2;
            int t3 = dp[b]*3;
            int t5 = dp[c]*5;
            dp[i] = Math.min(t2,Math.min(t3,t5));
            if (dp[i]==t2)a++;
            if (dp[i]==t3)b++;
            if (dp[i]==t5)c++;
        }
        System.out.println("---------");
        System.out.println(dp[n-1]);
        return dp[n-1];
    }

}
