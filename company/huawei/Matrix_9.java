package company.huawei;

import java.util.Scanner;

/**
 * 数独是一个我们都非常熟悉的经典游戏，运用计算机我们可以很快地解开数独难题，现在有一些简单的数独题目，请编写一个程序求解。
 *
 * 输入描述:
 * 输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。
 *
 * 输出描述:
 * 输出九行，每行九个空格隔开的数字，为解出的答案。
 */
public class Matrix_9 {

    private Scanner sc ;
    private int matrix[][];

    public Matrix_9(){
        sc = new Scanner(System.in);
        matrix = new  int[9][9];
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                matrix[i][j]=sc.nextInt();
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        sc.close();

        /*
        行、列、斜
        需要从只有一个空的地方开始
         */
        //计算空
        int row[] = new int[9];
        int col[] = new int[9];
        int x=0,y=0;

        int total = 0;
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (matrix[i][j]==0){
                    row[i]++;
                    total++;
                }
                if (matrix[j][i]==0){
                    col[i]++;
                    total++;
                }
            }
        }
        for (int i=0;i<9;i++){
            if (matrix[i][i]==0)x++;
            if (matrix[i][8-i]==0)y++;
        }
        total+=x;
        total+=y;


        while (total>0){
            if (x==1){
                int index=0;
                int sum=0;
                for (int i=0;i<9;i++){
                    if (matrix[i][i]==0)index=i;
                    sum+=matrix[i][i];
                }
                matrix[index][index]=45-sum;
                x=0;
                total--;
            }
            if (y==1){
                int index=0;
                int sum=0;
                for (int i=0;i<9;i++){
                    if (matrix[i][8-i]==0)index=i;
                    sum+=matrix[i][8-i];
                }
                matrix[index][8-index]=45-sum;
                y=0;
                total--;
            }
        }




    }



    public static void main(String[] args) {
        new Matrix_9();
    }
}

/*
1 1 1 0 3 3 3 3 3
1 1 1 0 3 3 3 3 3
1 1 1 0 3 3 3 3 3
1 1 1 0 3 3 3 3 3
1 1 1 0 0 3 3 3 3
1 1 1 0 3 3 0 3 3
1 1 1 0 3 3 3 3 3
1 1 1 0 3 3 3 3 3
1 1 1 0 3 3 3 3 3

 */