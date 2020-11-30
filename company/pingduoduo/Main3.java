package company.pingduoduo;


import java.util.Scanner;


/*
 * 题目描述
 * 背包问题：初始背包容量M
 * 有N个商品：
 *   每个商品：体积(正负，为负表示可以增加背包容量) 、利益(正负)
 * 现在选择商品装到背包，使总利益最大
 *
 * 这题是01背包问题的改编。
 * 01背包问题中商品的体积全部是正，这里可以是负数，表示增大背包空间
 *
 * 怎么改？？？
 *
 * */
public class Main3 {
    public Main3() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            weight[i] = scanner.nextInt(); //空间
            value[i] = scanner.nextInt(); //收益
        }
        scanner.close();
        System.out.println(knapsack(weight, value, M));
    }

    /*
     * w,v中第一位 设为0
     * */
    private int knapsack(int w[], int[] v, int cap) {
        int len = w.length;
        int dp[][] = new int[len + 1][cap + 1]; //dp[i][j]表示背包容量为j，前i件物品能够产生的最大价值
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j < w[i - 1] ) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[len][cap];
    }

    public static void main(String[] args) {
        new Main3();
    }
}


/*
*
*

3 2
2 1
-2 1
2 -1

3 2
2 1
2 1
2 -1

* */




/*


2020/9/2 阿里盒马笔试：
- 微服务：好处、坏处（Cap只能选择两个）
  最重要的地方：
  - 服务的划分？ DDD？
  - 容器？
- 平时的学习过程
- 自学过程
- 影院管理系统，特色，现在怎么改
   - 测试 mockite
   - devops 化
   - 前后端分离
- 红黑树，特点，自平衡的过程
  + 特点：
    - 节点分为红黑
    - 根节点黑色
    - 子节点黑色Nil
    - 任意节点到叶节点包含相同数量的红色节点
    - 红色节点的子节点一定是黑色节点
  + 自平衡：
    - 左旋
    - 右旋
    - 变色
- jvm 分代内存管理
  什么时候直接直接放入老年代？
   - 对象过大
   - 在一次安全Minor GC 中，仍然存活的对象不能在另一个Survivor 完全容纳，则会通过担保机制进入老年代。

   - 动态对象年龄判定:为了能更好地适应不同程度的内存状况,虚拟机并不是永远地要求对象的年龄必须达到
   了MaxTenuringThreshold才能晋升到老年代,如果在Survivor空间中相同年龄的所有对象大小的总和
   大于Survivor空间的一半,年龄大于或等于年龄的对象就可以直接进入老年代,无须等到MaxTenuringThreshold中要
   求的年龄。
   - 达到minor GC的次数：默认15


- 短期学习计划
- 为什么不选择前端
- 写博客，博客地址贴到简历
- 怎么找到垃圾？



* */