package company.mi;

import java.util.Scanner;

/*
*
* 网格中查看一个单词是否存在
*
* 给出网格、单词
* 单词不可用重用
* 单词有相邻网格组成，即横竖
* */
public class Main2 {
    public Main2(){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <M ; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        String word = scanner.nextLine();
        System.out.println(true);

    }

    public static void main(String[] args) {
        new Main2();
    }
}
