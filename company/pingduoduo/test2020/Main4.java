package company.pingduoduo.test2020;

import java.util.Scanner;

/*
* 题目描述：
* 输入一个数N，大小为M的数组Arr。
* 对于一个数X，如果X能被Arr中的某个数整除，则成X是‘特殊的’
* 对于1~N，判断其中有多少数是‘特殊的’
*
* */
public class Main4 {
    private int M;
    private int N;
    private int[] arr;

    public Main4() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new int[N];
        for (int i = 0; i < M; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int a : arr) {
                if (i % a == 0) {
                    res++;
                    break;
                }
            }
        }

        System.out.println(res);
    }


    //素数？？？不用判断


    public static boolean isPrime(int num) {
        if (num <= 3) return num > 1;
        if (num % 6 != 1 && num % 6 != 5) return false;// 不在6的倍数两侧的一定不是质数
        for (int i = 5; i <= (int) Math.sqrt(num); i += 6)
            if (num % i == 0 || num % (i + 2) == 0)  return false;
        return true;
    }

    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a==b); //false

        Integer a1 = 127;
        Integer b1 = 127;
        System.out.println(a1==b1); //true

        int c = 128;
        int d = 128;
        System.out.println(c==d);//true


        new Main4();
    }
}
