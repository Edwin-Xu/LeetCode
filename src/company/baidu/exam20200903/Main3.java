package company.baidu.exam20200903;

import leetcode.util.Print;

import java.util.Scanner;

/**
 *
 * 走楼梯：
 * N阶楼梯，每次1~M步，不走前两次走过的步数。
 * 求走法数量？
 *
 *
 *
 *
 * 如何不使用递归？
 * 递归超时
 *
 *
 * 可以使用 备忘录记下走过的路程吗？
 * 记录比较麻烦，四个变量： n,m,pre2,pre1， 而且对四个变量而言，子问题命中率不高。
 * 难以使用这种方式。
 *
 *
 *
 */
public class Main3 {
    public Main3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        fib(n, m, -1, -1);
        System.out.println(count % (1000000007));
    }

    private long count = 0;
    /**
     * @param pre1 前第二步
     * @param pre2 前一步
     * */
    void fib(int n, int m, int pre1, int pre2) {
        if (n == 0) {
            count++;
            return ;
        }
        if (n < 0 ) return ;
        for (int i = 1; i <= m; i++) {
            if (i == pre1 || i == pre2) continue;
            fib(n - i, m, pre2, i);
        }
    }
    public static void main(String[] args) {
        new Main3();
    }
}








/*
*
long fib(int n, int m, ArrayList<Integer>list) {
        if (n == 0) {
            System.out.println(list);
            count++;
            return 0;
        }
        if (n<0){
            return -1;
        }

        long res = 1;
        for (int i = 1; i <= m; i++) {
            int pre1 = -1;
            int pre2 = -1;
            if (list.size()==1){
                pre2=list.get(0);
            }else if (list.size()>=2){
                pre1 = list.get(list.size()-2);
                pre2 = list.get(list.size()-1);
            }
            if (i == pre1 || i == pre2) continue;
            list.add(i);
            res += fib(n - i, m, list);
            list.remove(list.size()-1);
        }
        return res;
    }


* */