package company.didi;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
* 64%
*
* why？
*
*
*
* 给出小岛
* 看是否可以修路
*
* 两个小岛之间 修路费<=k
*
* 是否可以全联通
*
*
* */
public class Main2 {
    public Main2(){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt(); //N个岛屿
            int m = scanner.nextInt();//M个路径
            int k = scanner.nextInt();//每个路径的修路费不能大于K

            //邻接矩阵
            int [][] arr =  new int[n+1][n+1];

            int first = 0;

            for (int j = 0; j < m; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int cost = scanner.nextInt();
                if (cost>k)cost = 0; // >k的不行
                arr[a][b] = cost;
                arr[b][a] = cost;

                first  =a ;
            }

            boolean checkLine = true;
            for (int j = 1; j <=n ; j++) {
                boolean can = false;
                for (int l = 1; l <=n ; l++) {
                    if (arr[j][l]>0){
                        can = true;
                        break;
                    }
                }
                if (!can){
                    checkLine = false;
                    break;
                }
            }
            if (!checkLine){ //排除不可达的孤岛。 (实际没必要)
                System.out.println("No");
            }else{


                //检查图是否是联通的
                dfs(arr,first);
//                Print.printArr(arr);

                for (int j = 1; j <=n ; j++) {
                    for (int l = 1; l <=n ; l++) {
                        if (arr[j][l]>0){
                            System.out.println("No");
                            return;
                        }
                    }
                }
                System.out.println("Yes");


            }


        }



        scanner.close();


    }

    private void dfs(int [][] arr,int begin){
        for (int i = 1; i <arr[0].length ; i++) {
            int a = arr[begin][i];
            if (a>0){
                //可达另一岛屿
                arr[begin][i] = -1;
                arr[i][begin] = -1;
                dfs(arr,i);
            }
        }
    }

    public static void main(String[] args) {
        new Main2();
    }
}

/*
2
3 3 400
1 2 200
1 3 300
2 3 500
3 3 400
1 2 500
1 3 600
2 3 700


1
5 5 500
1 2 1
1 3 1
2 3 1
4 5 1
5 4 1



* */