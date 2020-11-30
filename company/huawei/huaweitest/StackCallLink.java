package company.huawei.huaweitest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Edwin Xu on 4/15/2020 8:19 PM
 *
 *
 * 本次华为机考：
 * 100%  75%  60%
 *
 * 1.选举：找到最多投票的人
 * 2.字符串处理：addr \mask \val
 * 3.函数调用栈：找到函数调用栈中开销最大的函数调用链
 */
public class StackCallLink {
    private Scanner sc ;
    private int n;
    private int callTable[];

    class FuncCall{
//        int id;
        int size;
        ArrayList<Integer> callee = new ArrayList<>();
    }

    private FuncCall[] funcCalls;

    public StackCallLink() {
        sc = new Scanner(System.in);

        n = sc.nextInt();

//        System.out.println(n);

        callTable = new int[n];

        funcCalls = new FuncCall[n];

        for (int i=0;i<n;i++){
            callTable[i] = sc.nextInt();
        }

        String inp[];

        sc.next();
        for (int i=0;i<n;i++){
            inp = sc.nextLine().split(" ");
//            System.out.println(i+":"+inp.length);

            if (inp.length-2!=callTable[i]){
                System.out.println("NA");
                return;
            }

            funcCalls[i] = new FuncCall();
            funcCalls[i].size = Integer.valueOf(inp[1]);
            for (int j= 2;j<inp.length;j++){
                funcCalls[i].callee.add(Integer.valueOf(inp[j])-1); //调用全-1
            }
        }


        int max = 0;
        for (FuncCall f: funcCalls){
            max = Math.max(max,dp(f,""));
        }

        System.out.println(max);

        sc.close();


    }

    int dp(FuncCall f,String s){
        int res = Integer.MIN_VALUE;

        if (f.callee.size()==0)return f.size;

        for (int i:f.callee){
            if (s.indexOf(String.valueOf(i))>=0){
                System.out.println("R");
                System.exit(0);
            }
            res =  Math.max(res,f.size+dp(funcCalls[i],s+i));
        }



        return res;
    }


    public static void main(String[] args) {

        new StackCallLink();
    }
}

/*
5 2 3 1 0 0
1 20 2 3
2 30 3 4 5
3 50 4
4 60
5 80


 */
