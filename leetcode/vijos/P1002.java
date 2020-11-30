package leetcode.vijos;


/*
*
过河
描述
在河上有一座独木桥，一只青蛙想沿着独木桥从河的一侧跳到另一侧。在桥上有一些石子，青蛙很讨厌踩在这些石子上。由于桥的长度和青蛙一次跳过的距离都是正整数，我们可以把独木桥上青蛙可能到达的点看成数轴上的一串整点：0，1，……，L（其中L是桥的长度）。坐标为0的点表示桥的起点，坐标为L的点表示桥的终点。青蛙从桥的起点开始，不停的向终点方向跳跃。一次跳跃的距离是S到T之间的任意正整数（包括S,T）。当青蛙跳到或跳过坐标为L的点时，就算青蛙已经跳出了独木桥。

题目给出独木桥的长度L，青蛙跳跃的距离范围S,T，桥上石子的位置。你的任务是确定青蛙要想过河，最少需要踩到的石子数。

对于30%的数据，L <= 10000；
对于全部的数据，L <= 10^9。

格式
输入格式
输入的第一行有一个正整数L（1 <= L <= 10^9），表示独木桥的长度。第二行有三个正整数S，T，M，分别表示青蛙一次跳跃的最小距离，最大距离，及桥上石子的个数，其中1 <= S <= T <= 10，1 <= M <= 100。第三行有M个不同的正整数分别表示这M个石子在数轴上的位置（数据保证桥的起点和终点处没有石子）。所有相邻的整数之间用一个空格隔开。

输出格式
输出只包括一个整数，表示青蛙过河最少需要踩到的石子数。
*
*
样例1
样例输入1
10
2 3 5
2 3 5 6 7
Copy
样例输出1
2
*
*
*
*
* */


import leetcode.util.Print;

import java.io.IOException;
import java.util.*;

public class P1002 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();

        int S = sc.nextInt();
        int T = sc.nextInt();
        int M = sc.nextInt();

//        int stones [] = new int[M];
        Set<Integer> set = new HashSet<>(M);
        for (int i = 0; i <M ; i++) {
//            stones[i] = sc.nextInt();
            set.add(sc.nextInt());
        }

        int dp[] = new int[L + T + 1];//dp[i] 表示走到i需要踩到的石头数，-1表示不可达，其需要踩到的石头数是其前第一个不为-1 的
        Arrays.fill(dp,-1); //-1表示不可达

        dp[0] = 0;
        dp[S] = 1;
        dp[T] = 1;
        for (int i = S+1; i < dp.length; i++) {
            if (i< T){
                if(dp[i-S]!=-1) dp[i] = dp[i-S] + (set.contains(i)?1:0);
            }else {
                if (dp[i-S]!=-1 && dp[i-T]!=-1){
                    dp[i] = Math.min( dp[i-S],dp[i-T] )+(set.contains(i)?1:0);
                }else if (dp[i-S]==-1){
                    dp[i] = dp[i-T] + (set.contains(i)?1:0);
                }else if (dp[i-T]==-1){
                    dp[i] = dp[i-S] + (set.contains(i)?1:0);
                }
            }
        }

//        for (int i = 0; i <dp.length ; i++) {
//            System.out.print(i+ "\t");
//        }
//        System.out.println();
//
//        Print.printArr(dp);

        System.out.println(dp[L]);

    }
}

/*
10
2 3 5
2 3 5 6 7


* */