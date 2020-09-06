package company.meituan.exam20200906;

import java.util.Scanner;

/**
 * Created by Edwin Xu on 9/6/2020 10:19 AM
 *
 * 题记不得了，是一个数学运算：异或的组合运算
 *
 */
public class Main3 {
    public Main3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int ai = scanner.nextInt();

            int bi = ai;
            for (int j = 1; j <=n ; j++) {
                bi^=((i+1)%j);
            }
            res ^= bi;
        }
        System.out.println(res);


        //不是开数组的原因，还是45%超时，嗯时间复杂度过高，需要使用数学公式计算
        //减小计算量

    }


    public static void main(String[] args) {


        new Main3();
    }
}
