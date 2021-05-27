package company.pingduoduo.test2020;


/*
* 题目描述
* ------------
* |  2 | 1
* |3   |   8
* |-----------
* |4   |   7
* |  5 | 6
* |-----------
* 有一个NxN的矩阵，把里面的(i,j)划分都上述8个区域，米字处(横竖中线、斜线)为0
*
* */

import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int [][] arr = new int[n][n];
        double mid = (n-1)/2.0;//中线
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //23
                if (i< mid && j<mid ){
                    if (i<j) arr[i][j] = 2;
                    else if (i>j)arr[i][j] = 3;
                }
                //45
                else if (i>mid && j<mid ){
                    if (n-1-i>j)arr[i][j]=4;
                    else if (n-1-i<j)arr[i][j]=5;
                }
                //18
                else if (i<mid && j>mid ){
                    if (n-1-i>j)arr[i][j]=1;
                    else if (n-1-i<j)arr[i][j]=8;
                }
                //67
                else if (i>mid && j>mid ){
                    if (i>j)arr[i][j]=6;
                    else if (i<j)arr[i][j]=7;
                }
            }
        }

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n-1 ; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println(arr[i][n-1]);
        }
    }
}

/*
10
0 2 2 2 2 1 1 1 1 0
3 0 2 2 2 1 1 1 0 8
3 3 0 2 2 1 1 0 8 8
3 3 3 0 2 1 0 8 8 8
3 3 3 3 0 0 8 8 8 8
4 4 4 4 0 0 7 7 7 7
4 4 4 0 5 6 0 7 7 7
4 4 0 5 5 6 6 0 7 7
4 0 5 5 5 6 6 6 0 7
0 5 5 5 5 6 6 6 6 0
* */