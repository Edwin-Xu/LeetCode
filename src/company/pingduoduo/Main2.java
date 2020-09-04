package company.pingduoduo;

import java.util.Scanner;

/**
 * 题目描述
 * <p>
 * 有一个NxM矩阵，矩阵有值只有0和1, 1代表一个人，相邻的人(只包含上下左右相邻)为一组。
 * 现在请移动其中一个人，移动后使一个团队的人数尽可能大，求这个最大的值。
 * 如：
 * 4 4
 * 1 0 1 1
 * 1 1 0 1
 * 0 0 0 0
 * 1 1 1 1
 *
 * 可以把(0,2)移动到(2,0)：
 * 4 4
 * 1 0 0 1
 * 1 1 0 1
 * 1 0 0 0
 * 1 1 1 1
 * 形成一个8人的组，是所有移动方案中最大的。
 *
 * 我的思路：
 * 先把所有的组算出来，得到最大的组人数Max。（其实没必要求，后面直接把0改为1进行更新最大值）
 * 然后一个个尝试把值为0的位置改为1，即相当于从其他地方(本组/其他组)移动一个人过来，看该位置所在的组
 * 总人数是否比Max大，大则更新Max。 所有的0都尝试后，会得到一个新的Max。
 * 这个Max并不是最终结果，如果把0改为1后只有一个组，那说明这个人还是从本组(移动后的本组)移过来的
 * 返回Max-1；
 *
 * 所以解题思路是：
 *   设置一个最大组人数值max，对于每一个0位置，尝试将该位置置1，然后以该位置为入口dfs进入改组，计算人数，更新max，dfs遍历的同时会将该组全部置-1。
 *   再次dfs把-1还原为1。
 *   尝试将所有0变为1后，会得到更新后的max，这个max可能需要-1：如果移动后只有一组，那个这个移动的元素是内部移动，不能从其他组来，所以需要-1
 *   判断方式： dfs把最大组置-1，然后访问整个数组，如果还存在1，说明多个组，返回max；否则，返回max-1
 *
 *
 *
 *
 */

public class Main2 {
    private int[][] arr;
    private int row;
    private int col;

    public Main2() {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        int max = 0; //最大组人数
        int maxi = 0, maxj = 0; //记录最大组的一个元素下标
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1; //尝试把0的地方填1
                    int num = dfs(i, j,arr); //dfs遍历得到该组的人数，同时会将改组全部变为-1
                    if (num > max) {
                        max = num; //更新最大值
                        maxi = i; //更新最大组入口元素下标
                        maxj = j;
                    }
                    recover(i, j,arr); //把该组从-1还原为1
                    arr[i][j] = 0; //还原该位置的0
                }
            }
        }

        dfs(maxi, maxj,arr); //从入口访问最大组，将该组全部置-1

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j]==1){  //还有其他元素是1，表明现在不止一个组，那么那个填充1的0位置，可以是其他组移动过来的
                    System.out.println(max);
                    return;
                }
            }
        }
        //上面没有返回，说明移动后只有一个组，移动的这个元素也属于本组，于是需要减出来。
        System.out.println(max-1);
    }


    //从[i,j]处进入一个组，统计其人员数，并在访问过程中全部置-1；
    int dfs(int i, int j, int[][]arr) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 0 || arr[i][j] == -1) return 0;
        arr[i][j] = -1;
        return 1 +
                dfs(i, j + 1,arr) +
                dfs(i, j - 1,arr) +
                dfs(i - 1, j,arr) +
                dfs(i + 1, j,arr);
    }
    //从[i,j]处进入一个组, 访问全组，将dfs改变的-1还原为1
    void recover(int i, int j,int arr[][]) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] !=-1) return;
        arr[i][j] = 1;
        recover(i, j + 1,arr);
        recover(i, j - 1,arr);
        recover(i - 1, j,arr);
        recover(i + 1, j,arr);
    }


    public static void main(String[] args) {
        Main2 main = new Main2();
    }
}

/*

4 4
1 0 1 1
1 1 0 1
0 0 0 0
1 1 1 1

4 4
1 0 1 1
1 0 1 1
0 1 0 0
1 1 1 1


4 4
1 0 1 1
1 0 1 1
0 1 0 0
1 1 1 1
12
*/



/*
*
*
*
原始版本

import java.util.Scanner;


public class Main2 {

    int [][]arr;
    int row;
    int col;
    public  Main2(){
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();

        arr = new int[row][col];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        scanner.close();



        int max = 0;

        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                if(arr[i][j]!=0 && arr[i][j]!=cur+1) {
                    int num = dfs(i,j);
                    if (num>max) max = num;
                }
            }
        }
        cur++;


        int maxi=0;
        int maxj=0;

        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                if(arr[i][j]==0 ) {
                    //尝试把0的地方填1
                    arr[i][j] = cur;

                    int num = dfs(i,j);
                    cur++;
                    if (num>max){
                        max = num;

                        maxi =i;
                        maxj = j;

                    }


                    arr[i][j] = 0; //还原
                }
            }
        }


        dfs(maxi,maxj);

        boolean isok = false;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                if (arr[i][j]==cur){
                    isok = true;
                    break;
                }
            }}

        //if (!isok)max--;

        System.out.println(max);

    }

    private int cur = 1; //每次将所有1改为cur
    int dfs(int i,int j){
        if (i<0 || i>=row || j<0|| j>=col|| arr[i][j]==0 || arr[i][j]==cur+1){
            return 0;
        }
        arr[i][j] = cur+1;
        return 1+
                dfs(i,j+1)+
                dfs(i,j-1)+
                dfs(i-1,j)+
                dfs(i+1,j);
    }


    public static void main(String[] args) {
        Main2 main = new Main2();
    }
}

*/