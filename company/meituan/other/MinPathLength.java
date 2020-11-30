package company.meituan.other;

import java.util.Scanner;

/**
 * Created by Edwin Xu on 4/11/2020 2:58 PM
 *
 * 给定一个包含非负整数的 M x N 迷宫，请找出一
 * 条从左上角到右下角的路径，
 * 使得路径上的数字总和最小。每次只能向下或者向右移动一步。
 *
 *
 *
 * 输入描述:
 * 第一行包含两个整数M和N，以空格隔开，1≤N≤10，1≤N≤10。
 *
 * 接下来的M行中，每行包含N个数字 。
 *
 *3 3
 * 1 3 1
 * 1 5 1
 * 4 2 1
 *
 *
 * 输出描述:
 * 找出总和最小的路径，输出路径上的数字总和。
 * 7
 */
public class MinPathLength {
    private Scanner sc ;
    private int M,N;
    private int [][] table;
    public MinPathLength(){
        sc= new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();
        table = new int[M][N];
        String [] inp;
        for (int i=0;i<M;i++){
            inp = sc.nextLine().split(" ");
            for (int j=0;j<N;j++){
                table[i][j] = Integer.valueOf(inp[j]);
            }
        }
        sc.close();
        System.out.println(f(0,0));
    }

    private int f(int i ,int j){
        int tmp =table[i][j];
        if (i==M-1&&j==N-1)return tmp;
        if (i<M-1 &&j==N-1) return tmp+ f(i+1,j);
        if (i==M-1&&j<N-1) return tmp+f(i,j+1);
        return Math.min(tmp+f(i+1,j),tmp+f(i,j+1));
    }

    public static void main(String[] args) {
        MinPathLength m = new MinPathLength();
    }
}

/*
3 3
1 3 1
1 5 1
4 2 1

 */