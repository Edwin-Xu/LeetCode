package basicAlgorithm.greedyAlgorithm;

/**
 * 贪心算法-经典问题
 *
 * Created by Edwin Xu on 6/24/2020 7:08 PM
 * 【背包问题】有一个背包，容量是M=150，有7个物品，物品可以分割成任意大小。要求尽可能让装入背
 * 包中的物品总价值最大，但不能超过总容量。
 * 物品：A B C D E F G
 * 重量：35 30 60 50 40 10 25
 * 价值：10 40 30 50 35 40 30
 *
 * 作者：祐吢房_2c9a
 * 链接：https://www.jianshu.com/p/ab89df9759c8
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 *
 * 贪心策略适用的前提是：局部最优策略能导致产生全局最优解。
 *
 *
 *
 *
 * 首先我们用递归的方式来尝试解决这个问题
 * 我们用F(n,C)F(n,C)F(n,C)表示将前nnn个物品放进容量为CCC的背包里，得到的最大的价值。
 * 我们用自顶向下的角度来看，假如我们已经进行到了最后一步（即求解将nnn个物品放到背包里获得的最大价值），此时我们便有两种选择
 *
 * 不放第n个物品，此时总价值为F(n−1,C)F(n-1,C)F(n−1,C)
 * 放置第n个物品，此时总价值为vn+F(n−1,C−wn)v_n+F(n-1,C-w_n)vn+F(n−1,C−wn)
 * 两种选择中总价值最大的方案就是我们的最终方案，递推式（有时也称之为状态转移方程）如下
 * F(i,C)=max(F(i−1,C),v(i)+F(i−1,C−w(i)))F(i,C)=max(F(i-1,C),v(i)+F(i-1,C-w(i)))
 * F(i,C)=max(F(i−1,C),v(i)+F(i−1,C−w(i)))
 */
public class PackageProblem {
    public int greedy(int[]w,int v[],int C){
        return solve(w,v,w.length-1,C);
    }
    private int solve(int w[] ,int v[],int index,int C){
        if (index<0||C<=0)return 0;
        int res = solve(w,v,index-1,C);
        if (w[index]<C)res = Math.max(res,v[index]+solve(w,v,index-1,C-w[index]));
        return res;
    }

    public static void main(String[] args) {

    }
}
