package leetcode.contest.contest20210625;

/**
 * @author Edwin Xu
 * @date 6/25/2021 7:01 PM.
 *
 *
 * 链接：https://ac.nowcoder.com/acm/contest/11175/D
 * 来源：牛客网
 *
 * 题目描述
 * 伟大的数学家费牛于自己的家中过世，桌上的纸笔记录着他生前研究的最后一个问题。
 *
 * 这个问题是这样的，首先给出nn个数字，第ii个数字为a[i]a[i]。接下来进行mm次操作，每次操作的类型如下：
 *
 * 1：将a[id]a[id]的值改为xx。
 *
 * 2：令t=a[l]\times a[l+1]\times ...\times a[r-1]\times a[r]t=a[l]×a[l+1]×...×a[r−1]×a[r]，求tt能被多少个不同的素数整除。
 *
 * 这种问题自然是难不倒费牛，可是他在草稿纸上写着：“我已经想到了一个绝妙的方法，可惜这儿空白太小写不下”。
 *
 * 没办法，现在只能请你代替费牛回答每个22类型问题的答案。
 *
 * 输入描述:
 * 第一行两个正整数nn,mm，其中n \leq 5\times 10^{4}n≤5×10
 * 4
 *  ,m\leq 5 \times 10^{4}m≤5×10
 * 4
 *  。
 *
 * 第二行nn个正整数a[i]a[i]，a[i] \leq 10^{5}a[i]≤10
 * 5
 *  。
 *
 * 接下来mm行，每行第一个数字opop表示操作类型，1\leq op \leq 21≤op≤2。
 *
 * 若opop为11，输入正整数idid与xx，其中id\leq nid≤n,x\leq 10^{5}x≤10
 * 5
 *  。
 *
 * 若opop为22，输入正整数ll与rr，其中l\leq r\leq nl≤r≤n。
 *
 * 输出描述:
 * 输出每个22类型问题的答案。
 *
 * 示例1
 * 输入
 * 复制
 * 5 3
 * 2 3 6 6 6
 * 2 1 4
 * 1 4 5
 * 2 1 4
 * 输出
 * 复制
 * 2
 * 3
 */


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main04 {

    public static void prime(Set<Integer> set, int a, int b) {
        //先将给定范围内的数值进行循环遍历
        for (int i = a; i <= b; i++) {
            //定义当前数值默认为素数
            boolean flag = true;
            //判断当当前数字能否整除前面的数字
            for (int j = a; j < i; j++) {
                //可以整除之前数字，说明它不是素数
                if (i % j == 0) {
                    flag = false;
                    //判定为负数后，循环终止
                    break;
                }
            }
            //如果不可以整除，说明是素数，则flag依旧为true
            if (flag && b%i ==0) {
                //对符合条件的数值个数进行统计
//                System.out.print(i+" ");
                set.add(i);
            }
        }
//        System.out.println();
    }



    public static void main(String[] args) {
//        prime(new HashSet<>(), 2,6);

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int op = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (op == 1){
                nums[a] = b;
            }else{
                HashSet<Integer> set = new HashSet<>();
                for (int j = a; j <=b ; j++) {
                    //boolean prime = isPrime(nums[j]);


                    prime(set,2,nums[j]);
                }

                System.out.println(set.size());

            }
        }


        scanner.close();
    }

}
