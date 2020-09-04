package company.baidu.exam20200903;

import java.util.Scanner;

/**
 * Created by Edwin Xu on 9/3/2020 6:55 PM
 */
public class Main1 {

    public Main1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int zeroNum = 0;
        int fiveNum = 0;
//        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
            if (scanner.nextInt() == 0) zeroNum++;
            else fiveNum++;
        }
        scanner.close();

        long a = 5555555550L; // 整除18的第一个数


        StringBuilder sb = new StringBuilder();
        if (fiveNum<9||zeroNum<1) System.out.println(-1);
        else{
            while (fiveNum>=9 && zeroNum >=1){
                sb.append(a);
                fiveNum-=9;
                zeroNum-=0;
            }
            for (int i = 0; i < zeroNum; i++) {
                sb.append(0);

            }

        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {

        new Main1();
    }
}
