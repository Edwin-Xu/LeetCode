package leetcode.contest.contest20210614;


/**
 * @author Edwin Xu
 * @date 6/14/2021 3:17 PM.
 *
 * 链接：https://ac.nowcoder.com/acm/contest/17624/K
 * 来源：牛客网
 *
 * For a permutation P = p_1, p_2, \cdots, p_nP=p
 * 1
 * ​
 *  ,p
 * 2
 * ​
 *  ,⋯,p
 * n
 * ​
 *   of {n}n, let {f(P, k)}f(P,k) be the number of {i}i satisfying 1 \le i < n1≤i<n and p_i + k = p_{i+1}p
 * i
 * ​
 *  +k=p
 * i+1
 * ​
 *  .
 * Given two integers {n}n and {k}k, your task is to find a permutation {P}P of {n}n such that {f(P, k)}f(P,k) is maximized.
 * Recall that in a permutation of {n}n, each integer from {1}1 to {n}n (both inclusive) appears exactly once.
 * 输入描述:
 * There is only one test case in each test file.
 * The first and only line contains two integers {n}n and {k}k (1 \le n, k \le 10^61≤n,k≤10
 * 6
 *  ).
 * 输出描述:
 * Output one line containing {n}n integers indicating a permutation {P}P of {n}n that maximizes {f(P, k)}f(P,k). If there are multiple valid answers you can output any of them.
 * Please, DO NOT output extra spaces at the end of the line, or your answer may be considered incorrect!
 * 示例1
 * 输入
 * 复制
 * 3 1
 * 输出
 * 复制
 * 1 2 3
 * 示例2
 * 输入
 * 复制
 * 7 3
 * 输出
 * 复制
 * 2 5 1 4 7 3 6
 *
 *
 *
 * 不知道为什么提交是程序执行总是出错
 */
import java.util.*;
public class Main03 {

    private static void f(int n ,int k){
        StringBuilder sb = new StringBuilder();
        if (k>=n){
            for (int i = 1; i <= n; i++) {
                sb.append(i);
                sb.append(" ");
            }
        }else{
            for (int i = 1; i <= n/k + (n%k==0?0:1); i++) {
                int x = i;
                while (x<=n){
                    sb.append(x);
                    sb.append(" ");
                    x+=k;
                }
            }
        }
        int length = sb.length();
        if (length>0 && sb.charAt(length-1)==' '){
            sb.deleteCharAt(length-1);
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int k = scanner.nextInt();

        f(n,k);

        scanner.close();
    }
}
