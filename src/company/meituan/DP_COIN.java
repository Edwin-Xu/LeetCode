package company.meituan;

/**
 * Created by Edwin Xu on 4/11/2020 2:40 PM
 *
 * 近期某商场由于周年庆，开启了“0元购”活动。活动中，消费者可以通过组合手中的代金券，实现0元购买指定商品。
 *
 * 聪明的小团想要用算法来帮助他快速计算：对于指定价格的商品，使用代金券凑出其价格即可，但所使用的代金券总面额不可超过商品价格。由于代金券数量有限，使用较少的代金券张数则可以实现价值最大化，即最佳优惠。
 *
 * 假设现有100元的商品，而代金券有50元、30元、20元、5元四种，则最佳优惠是两张50元面额的代金券；而如果现有65元的商品，则最佳优惠是两张30元代金券以及一张5元代金券。
 *
 * 请你帮助小团使用一段代码来实现代金券计算。
 *
 * 输入描述:
 * 多组输入输出，读到s=0时结束
 * 输入可以有多个测试样例，每个测试由两行组成。
 * 其中第一行包含一个整数P，表示商品的价格，1≤P≤10000；输入P为0时表示结束。
 *
 * 第二行包含若干整数，使用空格分割。其中第一个整数N（1≤N≤20）表示有多少种代金券，其后跟随M个整数，表示手中持有的代金券面额（1≤N≤1000），每种代金券数量不限。
 *
 *
 * 输出描述:
 * 找到最少张数的代金券，使其面额恰好等于商品价格。输出所使用的代金券数量；
 *
 * 如果有多个最优解，只输出其中一种即可；
 *
 * 如果无解，则需输出“Impossible”。
 */
import  java.util.Scanner;
public class DP_COIN {
    private int p ;
    private int n;
    private int [] m;
    private String [] inp;
    private Scanner sc;
    private int table[];

    public DP_COIN(){
        sc = new Scanner(System.in);
    }

    public void solution(){
        while(true){
            p = Integer.valueOf(sc.nextLine());
            if(p==0)break;
            inp = sc.nextLine().split(" ");
            m = new int[inp.length];
            table= new int[p+1];
            for(int i=0;i<inp.length;i++){
                m[i]=Integer.valueOf(inp[i]);
            }
            int res = coinChange(p);
            if(res==-1)
                System.out.println("Impossible");
            else
                System.out.println(res);
        }
    }

    private int coinChange(int n){
        if(n==0)return 0;
        if(n<0) return -1;
        int res = Integer.MAX_VALUE;
        for(int c: m){
            if(n-c<0)continue;
            if(table[n-c]==0)table[n-c]=coinChange(n-c);
            int sub = table[n-c];
            if(sub==-1)continue;
            res = res>1+sub?1+sub:res;

        }
        if(res!=Integer.MAX_VALUE)return res;
        return -1;
    }

    public static void main(String [] args){
        new DP_COIN().solution();
    }
}