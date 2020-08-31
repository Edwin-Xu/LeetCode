package company.alibaba.my_exam_20200828;

import java.util.Scanner;

/**
 * Created by Edwin Xu on 8/28/2020 6:52 PM
 *
 * 两个01串：A B
 * 从A--》B
 * 可以交换A中两个位置的字符、改变A中一个字符、翻转整个串。
 * 最少需要多少步到B
 *
 *
 *
7
1111000
0010011
 *
 * 3
 */
public class Main {

    public void input(){
        Scanner scanner = new Scanner(System.in);
//        int n =Integer.valueOf(scanner.nextLine());
        scanner.nextInt();
        scanner.next();
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        System.out.println(B);
        scanner.close();

        f(A,B);
    }

    public void f(String A, String B){
        char []a ;
        char b[] ;

        int res = 0;

        a =A.toCharArray();
        b = B.toCharArray();
        int l =0 ,r= a.length-1;
        while (l<r){
            if (b[l]!=a[l] && b[r]!=a[r] && a[l]!=a[r]){
                res++;
                char tmp = a[l];
                a[l]=  a[r];
                a[r]=  tmp;
                l++;
                r--;
            }else{
                l++;
            }
        }

        for (int i = 0; i <a.length ; i++) {
            if (a[i]!=b[i]){
                res++;
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {

        Main main  = new Main();
        main.input();
    }

}
