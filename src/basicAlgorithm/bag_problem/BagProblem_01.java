package basicAlgorithm.bag_problem;

import leetcode.util.Print;

/**
 * 01背包问题：动态规划
 * <p>
 * 有n个物品，它们有各自的重量和价值，现有给定容量的背包，如何让背包里装入的物品具有最大的价值总和？
 * <p>
 * 建模：
 * a) 把背包问题抽象化（X1，X2，…，Xn，其中 Xi 取0或1，表示第 i 个物品选或不选），Vi表示第 i 个物品
 * 的价值，Wi表示第 i 个物品的体积（重量）；
 * <p>
 * 　b) 建立模型，即求max(V1X1+V2X2+…+VnXn)；
 * <p>
 * 　c) 约束条件，W1X1+W2X2+…+WnXn<capacity；
 * d) 定义V(i,j)：***当前背包容量 j，前 i 个物品最佳组合对应的价值；*************
 * <p>
 * e) 最优性原理是动态规划的基础，最优性原理是指“多阶段决策过程的最优决策序列具有这样的性质：不论初始状态和初始决策如何，对于前面决策所造成的某一状态而言，其后各阶段的决策序列必须构成最优策略”。判断该问题是否满足最优性原理，采用反证法证明：
 * f) 寻找递推关系式，面对当前商品有两种可能性：
 * <p>
 * 　　　　第一，包的容量比该商品体积小，装不下，此时的价值与前i-1个的价值是一样的，即V(i,j)=V(i-1,j)；
 * <p>
 * 　　　　第二，还有足够的容量可以装该商品，但装了也不一定达到当前最优价值，所以在装与不装之间选择最优的一个，即V(i,j)=max｛ V(i-1,j)，V(i-1,j-w(i))+v(i) ｝
 * <p>
 * 　　　　　　　其中V(i-1,j)表示不装，V(i-1,j-w(i))+v(i) 表示装了第i个商品，背包容量减少w(i)但价值增加了v(i)；
 * <p>
 * 　　　　由此可以得出递推关系式：
 * <p>
 * 　　　　1) j<w(i)      V(i,j)=V(i-1,j)
 * <p>
 * 　　　　2) j>=w(i)     V(i,j)=max｛ V(i-1,j)，V(i-1,j-w(i))+v(i) ｝
 *
 *
 *
 *
 * 具体选择哪几样物品能获得最大价值。
 *
 * 另起一个 x[ ] 数组，x[i]=0表示不拿，x[i]=1表示拿。
 *
 * m[n][c]为最优值，如果m[n][c]=m[n-1][c] ,说明有没有第n件物品都一样，则x[n]=0 ; 否则 x[n]=1。
 * 当x[n]=0时，由x[n-1][c]继续构造最优解；当x[n]=1时，则由x[n-1][c-w[i]]继续构造最优解。以此类推，
 * 可构造出所有的最优解。
 *
 */
public class BagProblem_01 {
    /*
     * V[i][j]表示:背包容量为j，前i件物品能够产生的最大价值
     * */
    public static int knapsack(int[] weight,int[] val, int cap) {
        int N = weight.length;   //记录所有的物品数
        int[][] V = new int[N + 1][cap + 1];  //创建背包矩阵
        for (int item = 1; item <= N; item++) {  //一行一行填充值
            for (int wt = 1; wt <= cap; wt++) {  //一列一列填充值
                if (weight[item - 1] <= wt) {  //如果当前物品重量小于等于背包中的当前重量 item为1是，weight[0]是第一个物品的重量
                    //比较不加入该物品时该重量的最大价值（前一行）与当前物品的价值+可以容纳的剩余重量的价值
                    V[item][wt] = Math.max(val[item - 1] + V[item - 1][wt - weight[item - 1]], V[item - 1][wt]);
                } else { //如果当前物品重量大于背包中的当前重量
                    V[item][wt] = V[item - 1][wt];  //直接使用前一行的最优解
                }
            }
        }
        Print.printArr(V);
        return V[N][cap];
    }

    public static void main(String[] args) {
        int w[] = {0, 8, 10, 6, 3, 7, 2};
        int v[] = {0, 4, 6, 2, 2, 5, 1};
        int cap = 12;
        System.out.println(BagProblem_01.knapsack(w, v, cap));
    }

}














