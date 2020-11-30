package datastructure.graph.graph_storage;

import java.util.Scanner;

/**
 * 邻接矩阵
 *
 *
 */
public class AdjacencyMatrix {
    public int[] vexs;//顶点： 标识为0~N-1
    public int[][] matrix; //顶点间边的权值矩阵，0标识不相连

    public AdjacencyMatrix(boolean isDirectedGraph){
        Scanner scanner = new Scanner(System.in);
        System.out.println("顶点数:");
        int N = scanner.nextInt();

        vexs = new int[N];
        matrix = new int[N][N];
        for (int i = 0; i <N ; i++) {
            vexs[i] = i;
        }

        System.out.println("边数:");
        int M = scanner.nextInt();

        System.out.println("输入边数行, 每行<起始顶点 到达顶点 权值>   (顶点标号从0计数)");

        for (int i = 0; i <M ; i++) {
            int begin = scanner.nextInt();
            int end = scanner.nextInt();
            int value = scanner.nextInt();

            if (begin==end){
                System.out.println("起始到到达顶点权值应为0");
            }else{
                if (isDirectedGraph){ //有向图
                    matrix[begin][end] = value;
                }else{//无向图
                    matrix[begin][end] = value;
                    matrix[end][begin] = value;
                }
            }
        }
        scanner.close();
    }
}




