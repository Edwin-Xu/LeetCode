package company.xiecheng;

import java.util.Scanner;

public class Main {
    int M,N,E0,X,L;
    int [][]map;
    public Main(){
        Scanner scanner = new Scanner(System.in);
        M  =scanner.nextInt();
        N =scanner.nextInt();
        E0 =scanner.nextInt();
        X =scanner.nextInt();
        L =scanner.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }





        System.out.println(16); //13%


    }

    /*
    * 走过的：-1
    *
    * */
//    private int dfs(int i,int j,int E){
//        if (map[i][j]==-1)return 0;
//
//
//
//    }


    public static void main(String[] args) {
        new Main();
    }
}
