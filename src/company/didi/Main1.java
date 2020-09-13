package company.didi;

import java.util.Scanner;

/*
*
* 信息加密：
*   k 个一组反转，
*   知道反转结果和k，
*   求原来的字符串
* */



public class Main1 {
    public Main1(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        char [] chs = scanner.nextLine().toCharArray();
        scanner.close();

        StringBuilder sb = new StringBuilder();
        for (int i = n-1 ;i <chs.length;i+=n){
            for (int j = i; j >i-n ; j--) {
                sb.append(chs[j]);
            }
        }
        for (int i =chs.length-1; i>=(chs.length/n)*n;   i--) {
            sb.append(chs[i]);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        new Main1();
    }
}

/*
2
ogogoguot


* */