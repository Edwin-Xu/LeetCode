package leetcode.contest.contest20210614;

/**
 * @author Edwin Xu
 * @date 6/14/2021 3:17 PM.
 *
 * 链接：https://ac.nowcoder.com/acm/contest/17624/B
 * 来源：牛客网
 *
 * Sichuan hotpot is one of the most famous dishes around the world. People love its spicy taste.
 *
 * There are {n}n tourists, numbered from {0}0 to {(n-1)}(n−1), sitting around a hotpot. There are {k}k types of ingredients for the hotpot in total and the i-th tourist favors ingredient {a_i}a
 * i
 * ​
 *   most. Initially, every tourist has a happiness value of {0}0 and the pot is empty.
 *
 * The tourists will perform m moves one after another, where the {i}i-th (numbered from {0}0 to (m - 1)) move is performed by tourist {(i \% n)}(i%n). When tourist {t}t moves:
 * If ingredient a_ta
 * t
 * ​
 *   exists in the pot, he will eat them all and gain {1}1 happiness value.
 * Otherwise, he will put one unit of ingredient a_ta
 * t
 * ​
 *   into the pot. His happiness value remains unchanged.
 * Your task is to calculate the happiness value for each tourist after {m}m moves.
 * 输入描述:
 * There are multiple test cases. The first line of the input contains an integer {T}T (1 \le T \le 10^31≤T≤10
 * 3
 *  ) indicating the number of test cases. For each test case:
 *
 * The first line contains three integers {n}n, {k}k and {m}m (1 \le n \le 10^51≤n≤10
 * 5
 *  , 1 \le k \le 10^51≤k≤10
 * 5
 *  , 1 \le m \le 10^91≤m≤10
 * 9
 *  ) indicating the number of tourists, the number of types of ingredients and the number of moves.
 *
 * The second line contains {n}n integers a_0, a_1, \cdots, a_{n-1}a
 * 0
 * ​
 *  ,a
 * 1
 * ​
 *  ,⋯,a
 * n−1
 * ​
 *   (1 \le a_i \le k1≤a
 * i
 * ​
 *  ≤k) where a_ia
 * i
 * ​
 *   indicates the favorite ingredient of tourist {i}i.
 *
 * It's guaranteed that neither the sum of {n}n nor the sum of {k}k of all the test cases will exceed 2 \times 10^52×10
 * 5
 *  .
 * 输出描述:
 * For each test case output {n}n integers h_0, h_1, \cdots, h_{n-1}h
 * 0
 * ​
 *  ,h
 * 1
 * ​
 *  ,⋯,h
 * n−1
 * ​
 *   in one line separated by a space, where h_ih
 * i
 * ​
 *   indicates the happiness value of tourist i after m moves.
 *
 * Please, DO NOT output extra spaces at the end of each line, or your answer might be considered incorrect!
 * 示例1
 * 输入
 * 复制
 * 4
 * 3 2 6
 * 1 1 2
 * 1 1 5
 * 1
 * 2 2 10
 * 1 2
 * 2 2 10
 * 1 1
 * 输出
 * 复制
 * 0 2 1
 * 2
 * 2 2
 * 0 5
 *
 *
 *
 * 分析： m个move，不能直接轮询，时间复杂度过大
 * 可以发现 每两轮为一个循环。
 */

import java.util.*;
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int m = scanner.nextInt();
            int a[] = new int[n];

            // 食材：对应的喜欢的人，按顺序
            HashMap<Integer, List<Integer>> map = new HashMap<>();

            for (int i1 = 0; i1 < n; i1++) {
                a[i1] = scanner.nextInt();

                map.computeIfAbsent(a[i1], k1 -> new ArrayList<>());
                map.get(a[i1]).add(i1);

            }
            int[] happiness = new int[n];


            /*
             * 计算每个食材喜欢的人数，判断是奇数还是偶数
             * 没2个循环中：
             * 如果是偶数： 奇数号人没加，偶数号人+2
             * 如果是奇数，每两轮循环各自+1
             * */

            int loopUnit = n*2;
            int loop = m/loopUnit;
            int left = m%loopUnit;

            for (int i1 = 1; i1 <= k; i1++) {
                List<Integer> list = map.get(i1);
                if (list!=null){
                    int size = list.size();
                    if (size%2 == 0){
                        for (int j = 0; j <size ; j++) {
                            if (j%2==1){
                                happiness[list.get(j)]+=2;
                            }
                        }
                    }else{
                        for (Integer integer : list) {
                            happiness[integer]++;
                        }
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                happiness[j]*=loop;
            }

            // 剩余的轮询
            HashSet<Integer> set = new HashSet<>();
            for (int i1 = 0; i1 < left; i1++) {
                int tourist = i1%n;
                int ingredient = a[tourist];
                if (set.contains(ingredient)){
                    happiness[tourist]++;
                    set.remove(ingredient);
                }else{
                    set.add(ingredient);
                }
            }

            for (int j = 0; j < n-1; j++) {
                sb.append(happiness[j]);
                sb.append(" ");
            }
            sb.append(happiness[n-1]);
            sb.append("\n");
        }
        System.out.println(sb.toString());


        scanner.close();
    }
}

/**
 1
 3 2 6
 1 1 2


 * */