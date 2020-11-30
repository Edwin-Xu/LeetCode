package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 6/26/2020 10:48 PM
 *
 * 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 *
 * 分析：
 * 动态规划可以解吧
 * 不行，这不是最优子问题
 *  * f(4) != f(3)*1
 *  不对，这是可以的，需要多加一个比较，就是比较i(n-i)
 *
 *  这个方法耗时太长
 *
 *  改为迭代，好不了多少
 *
 *
 *
 *  --------------------------
 *  光是考虑动态规划解决是不行的，这是暴力
 *  需要数学思维：
 *  拆分的值要尽量相同
 *  拆分为m份： 积=(n/m)^m
 *  这样才会保证积最大，就像长+宽固定的矩形，正方形面积最大
 *
 *
 *
 */
public class Offer_14 {

    /*
    *
    * 解法1：动态规范*/
    public int cuttingRope(int n) {
       int [] mem = new int[n+1];
       mem[0]=mem[1]=1;
       return cut(mem,n);
    }

    private int cut(int [] mem,int n){
        if (n<2)return 1;
        int max=0;
        for (int i = 1; i < n; i++) {
            if (mem[n-i]==0)mem[n-i] = cuttingRope(n-i);
            max = Math.max(Math.max(max,mem[n-i]*i),(n-i)*i);
        }
        return max;
    }


    /*
    *
    * 解法2：平均化分割
    *
    * 问题来了，分为几份
    * 函数 f = (n/m)^m   m^m*f  =  n^m
    *
    * 先取根号n份, 然后向上下扩展几个，以得到最优解
    * */
    public int cuttingRope_2(int n){
        int num = (int)Math.sqrt(n);
        int max =0 ;
        for (int i = num-2;  i<=n && i<num+2 ; i++) {
            if (i<=1)continue;
            System.out.println(i);
            int a = n/i;
            int b = n%i;
            max =Math.max (max,(int)(Math.pow (a+1,b)*Math.pow(a,i-b)));
        }
        return max;
    }

    /*
    * 解法3：数学推导最佳分割3
    * 关于为什么切分为3的优先级最高 可以利用均值不等式求出乘积最
    * 大值 L(m)=(n/m)^m 对此式求导（可利用对数法），可以证明当 m=n/e 时，
    * 乘积取最大，此时每段绳子的长度为 n/(n/e)=e，自然对数e的值为2.718，
    * 显然接近3，所以总体来讲3最好
    *
    * log f = mlog(n/m)
    * 怎么证明？？
    * */

    public int cuttingRope_best(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }


    public static void main(String[] args) {
        System.out.println(new Offer_14().cuttingRope(10));
        System.out.println(new Offer_14().cuttingRope_2(2));

    }
}
