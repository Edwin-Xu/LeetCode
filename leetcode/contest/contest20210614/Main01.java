package leetcode.contest.contest20210614;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Edwin Xu
 * @date 6/14/2021 3:17 PM.
 *
 *
 * 链接：https://ac.nowcoder.com/acm/contest/17624/A
 * 来源：牛客网
 *
 * 题目描述
 * {川牌}川牌 is a kind of traditional playing cards in Sichuan. Each card is marked with two integers {x}x and {y}y where 1 \le x \le y \le 61≤x≤y≤6.
 *
 * 链接：https://ac.nowcoder.com/acm/contest/17624/A
 * 来源：牛客网
 *
 * Some samples of Chuanpai.
 * The first one is marked with {3}3 and {4}4, while the second one is marked with {2}2 and {5}5.
 *
 * Given an integer {k}k, please count the number of different types of cards satisfying {x + y = k}x+y=k.
 * We say two cards with integers x_1x
 * 1
 * ​
 *  , y_1y
 * 1
 * ​
 *   and x_2x
 * 2
 * ​
 *  , y_2y
 * 2
 * ​
 *   are of different types if x_1 \ne y_1x
 * 1
 * ​
 *
 * 
 * ​
 *  =y
 * 1
 * ​
 *   or x_2 \ne y_2x
 * 2
 * ​
 *
 * 
 * ​
 *  =y
 * 2
 * ​
 *  .
 * 输入描述:
 * There are multiple test cases. The first line of the input contains an integer {T}T (1 \le T \le 1001≤T≤100) indicating the number of test cases. For each test case:
 * The first and only line contains an integer {k}k (1 \le k \le 1001≤k≤100).
 * 输出描述:
 * For each test case output one line containing one integer, indicating the number of types of cards satisfying {x + y = k}x+y=k.
 * 示例1
 * 输入
 * 复制
 * 4
 * 4
 * 5
 * 8
 * 100
 * 输出
 * 复制
 * 2
 * 2
 * 3
 * 0
 * 备注:
 * We use {(a, b)}(a,b) to indicate a type of card whose {x = a}x=a and {y = b}y=b.
 * For the first sample test case the valid types of cards are {(1, 3)}(1,3) and {(2, 2)}(2,2).
 * For the second sample test case the valid types of cards are {(1, 4)}(1,4) and {(2, 3)}(2,3).
 * For the third sample test case the valid types of cards are {(2, 6)}(2,6), {(3, 5)}(3,5) and {(4, 4)}(4,4).
 *
 */

public class Main01 {

    private static int count(int k){
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            int j = k-i;
            //(i, j)
            if (j>=1&&j<=6){
              if (map.get(j)==null || map.get(j)!=i){
                  map.put(i,j);
                  cnt++;
              }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int k = scanner.nextInt();
            System.out.println(count(k));
        }

        scanner.close();
    }
}
