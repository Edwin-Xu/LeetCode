package company.tencent.exam20200521;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Edwin Xu
 * @date 5/21/2021 2:11 PM.
 * <p>
 * 给定一棵包含个节点且以节点为根节点的树。
 * 你需要从中选出个不同的节点，使得其两两之间的最短距离之和最大，并求出这个最大和。
 * 定义树上两点之间的最短距离为这两点之间的简单路径所经过的边的数量。
 * <p>
 * 输入描述:
 * 第一行输入一个正整数。
 * 第二行输入个正整数。节点为节点的父节点。
 * <p>
 * 输出描述:
 * 输出一个整数代表最大和。
 */

public class Main02 {

    /**
     * 太难了
     * <p>
     * 两两之间的最短距离为节点到交点距离的两倍。
     * 使用递归解决，在遍历过程中：
     * 当前节点不是交点，返回子树中的两两之间的最短距离之和最大的三个点；
     * 当前节点为两个节点的交点，返回深度最深的两颗子树的深度以及两颗子树下最长的第三边
     * 当前节点为三个点的共同交点，返回深度最深的三颗子树的深度。
     * 分别计算出每个节点的三种情况的目标值，并选出其中最大的。
     */

    static Node[] tree;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        tree = new Node[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new Node();
        }
        for (int i = 1; i < n; i++) {
            int parent = scanner.nextInt();
            tree[parent - 1].addChild(tree[i]);
        }
        int[] max3 = calMaxLength(tree[0]);
        int sumOfMax3 = 0;
        for (int i = 0; i < 3; i++) {
            sumOfMax3 += max3[i];
        }
        System.out.println(sumOfMax3 * 2);
    }

    public static int[] calMaxLength(Node root) {
        int maxLsum = 0;
        int maxdeep = 0;
        int[] ret = new int[4];
        int[] c2MaxSum1 = new int[4];
        int[] c3MaxSum = new int[4];
        if (root.child.isEmpty() == false) {
            for (Node chi : root.child) {
                int[] temp = calMaxLength(chi);
                if (maxdeep < temp[3]) {
                    maxdeep = temp[3];
                }
                int c3minidex = -1;//该节点为三个节点的共同交点，计算并与已有最大值比较
                for (int i = 0; i < 3; i++) {
                    if (c3minidex == -1 || c3MaxSum[i] < c3MaxSum[c3minidex]) {
                        c3minidex = i;
                    }
                }
                if (c3MaxSum[c3minidex] < temp[3]) {
                    c3MaxSum[c3minidex] = temp[3];
                    int c3temp = 0;
                    for (int i = 0; i < 3; i++) {
                        c3temp += c3MaxSum[i];
                    }
                    if (c3temp > maxLsum) {
                        maxLsum = c3temp;
                        ret = c3MaxSum;
                    }
                }
                int c1temp = 0;//该节点不是共同交点，计算并与已有最大值比较
                for (int i = 0; i < 3; i++) {
                    c1temp += temp[i];
                }
                if (maxLsum < c1temp) {
                    maxLsum = c1temp;
                    ret = temp;
                }
                int[] templ = Arrays.copyOf(temp, 3);//该节点为两个节点的共同交点，计算并与已有最大值比较
                Arrays.sort(templ);
                int[] templmax = Arrays.copyOf(c2MaxSum1, 3);
                Arrays.sort(templmax);
                int maxoftwo = templ[1] > templmax[1] ? templ[1] : templmax[1];
                if (temp[3] + c2MaxSum1[3] + maxoftwo > maxLsum) {
                    maxLsum = temp[3] + c2MaxSum1[3] + maxoftwo;
                    ret = new int[4];
                    ret[0] = temp[3];
                    ret[1] = c2MaxSum1[3];
                    ret[2] = maxoftwo;
                }
                if (c2MaxSum1[3] < temp[3] || (c2MaxSum1[3] == temp[3] && templ[1] > templmax[1])) {
                    c2MaxSum1 = temp;
                }
            }
        }
        ret[3] = maxdeep + 1;
        return ret;
    }
}

class Node {
    List<Node> child = new ArrayList<>();

    public void addChild(Node child) {
        this.child.add(child);
    }

}
