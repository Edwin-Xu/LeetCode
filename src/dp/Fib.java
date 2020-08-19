package dp;

/**
 * Created by Edwin Xu on 4/27/2020 12:22 AM
 *fib数列
 */
public class Fib {
    private int N;
    private int[] memo;
    public Fib(int n){
        N= n;
        memo=new int[N+1];
        memo[1]=1;
        memo[2]=1;
    }


    //迭代解法-自底向上
    public int iteration(){
        int arr[] = new int[N+1];
        arr[1]=arr[2]=1;
        for (int i=3;i<=N;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[N];
    }

    //迭代解法-自底向上-优化空间复杂度为O(1)
    public int iteration_opt(){
        int a=1;
        int b=1;
        for (int i=3;i<=N;i++){
            b=a+b;
            a=b-a;
        }
        return b;
    }

    //递归解法
    public int recursion(int a){
        if (a==1||a==2)return 1;
        return recursion(a-1)+recursion(a-2);
    }

    //递归解法-优化重复计算部分-备忘录
    public int recursion_withMemo(int a){
        if (a==1||a==2)return 1;
        if (memo[a-1]==0)memo[a-1]=recursion(a-1);
        if (memo[a-2]==0)memo[a-2]=recursion(a-2);
        return memo[a-1]+memo[a-2];
    }


    public static void main(String[] args) {
        Fib f= new Fib(40);
        System.out.println(f.iteration());
        System.out.println(f.iteration_opt());
        System.out.println(f.recursion(f.N));
        System.out.println(f.recursion_withMemo(f.N));
    }
}
